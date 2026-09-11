package com.skolka.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.repository.ChildRepository
import com.skolka.expensetracker.data.repository.ExpenseRepository
import com.skolka.expensetracker.data.repository.FeeConfigurationRepository
import com.skolka.expensetracker.data.repository.PaymentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

data class ReportData(
    val children: List<Child> = emptyList(),
    val allChildren: List<Child> = emptyList(),
    val payments: List<Payment> = emptyList(),
    val expenses: List<Expense> = emptyList(),
    val feeConfig: FeeConfiguration? = null,
    val totalExpected: Double = 0.0,
    val totalCollected: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val balance: Double = 0.0,
    val expensesByCategory: Map<String, Double> = emptyMap()
)

data class ReportUiState(
    val reportData: ReportData = ReportData(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val exportInProgress: Boolean = false,
    val exportSuccess: Boolean = false
)

class ReportViewModel(
    private val childRepository: ChildRepository,
    private val paymentRepository: PaymentRepository,
    private val expenseRepository: ExpenseRepository,
    private val feeConfigRepository: FeeConfigurationRepository
) : ViewModel() {
    
    private val _reportUiState = MutableStateFlow(ReportUiState())
    val reportUiState: StateFlow<ReportUiState> = _reportUiState
    
    init {
        loadReportData()
    }
    
    private fun loadReportData() {
        viewModelScope.launch {
            try {
                _reportUiState.value = _reportUiState.value.copy(isLoading = true)
                
                val feeConfig = feeConfigRepository.getLatestFeeConfig()
                
                combine(
                    childRepository.getAllChildren(),
                    paymentRepository.getAllPayments(),
                    expenseRepository.getAllExpenses()
                ) { allChildren, payments, expenses ->
                            val children = allChildren.filter { it.status == "active" }
                            val totalExpected = if (feeConfig != null) {
                                children.size * feeConfig.yearlyFeeAmount
                            } else {
                                0.0
                            }
                            
                            val totalCollected = payments.sumOf { it.amount }
                            val totalExpensesAmount = expenses.sumOf { it.amount }
                            val balance = totalCollected - totalExpensesAmount
                            
                            val expensesByCategory = expenses
                                .groupBy { it.category }
                                .mapValues { (_, categoryExpenses) ->
                                    categoryExpenses.sumOf { it.amount }
                                }
                            
                            val reportData = ReportData(
                                children = children,
                                allChildren = allChildren,
                                payments = payments,
                                expenses = expenses,
                                feeConfig = feeConfig,
                                totalExpected = totalExpected,
                                totalCollected = totalCollected,
                                totalExpenses = totalExpensesAmount,
                                balance = balance,
                                expensesByCategory = expensesByCategory
                            )

                            reportData
                }.collect { reportData ->
                            _reportUiState.value = _reportUiState.value.copy(
                                reportData = reportData,
                                isLoading = false
                            )
                }
            } catch (e: Exception) {
                _reportUiState.value = _reportUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load report data"
                )
            }
        }
    }
    
    fun getPaymentStatusSummary(): Map<String, Int> {
        val reportData = _reportUiState.value.reportData
        val feeConfig = reportData.feeConfig ?: return emptyMap()
        
        val statusMap = mutableMapOf(
            "paid_full" to 0,
            "paid_partial" to 0,
            "not_paid" to 0
        )
        
        reportData.children.forEach { child ->
            val totalPaid = reportData.payments
                .filter { it.childId == child.id }
                .sumOf { it.amount }
            
            when {
                totalPaid >= feeConfig.yearlyFeeAmount -> statusMap["paid_full"] = statusMap["paid_full"]!! + 1
                totalPaid > 0 -> statusMap["paid_partial"] = statusMap["paid_partial"]!! + 1
                else -> statusMap["not_paid"] = statusMap["not_paid"]!! + 1
            }
        }
        
        return statusMap
    }
    
    fun getChildPaymentDetails(): List<ChildPaymentDetail> {
        val reportData = _reportUiState.value.reportData
        val feeConfig = reportData.feeConfig ?: return emptyList()
        
        return reportData.children.map { child ->
            val totalPaid = reportData.payments
                .filter { it.childId == child.id }
                .sumOf { it.amount }
            
            val remaining = feeConfig.yearlyFeeAmount - totalPaid
            
            ChildPaymentDetail(
                childName = child.name,
                expectedAmount = feeConfig.yearlyFeeAmount,
                paidAmount = totalPaid,
                remainingAmount = if (remaining > 0) remaining else 0.0,
                isPaid = totalPaid >= feeConfig.yearlyFeeAmount,
                isPartiallyPaid = totalPaid > 0 && totalPaid < feeConfig.yearlyFeeAmount
            )
        }
    }
    
    fun refreshReport() {
        loadReportData()
    }
    
    fun setExportInProgress(inProgress: Boolean) {
        _reportUiState.value = _reportUiState.value.copy(exportInProgress = inProgress)
    }
    
    fun setExportSuccess(success: Boolean) {
        _reportUiState.value = _reportUiState.value.copy(exportSuccess = success)
    }
}

data class ChildPaymentDetail(
    val childName: String,
    val expectedAmount: Double,
    val paidAmount: Double,
    val remainingAmount: Double,
    val isPaid: Boolean,
    val isPartiallyPaid: Boolean
)

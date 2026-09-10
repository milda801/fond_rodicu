package com.skolka.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.repository.ChildRepository
import com.skolka.expensetracker.data.repository.ExpenseRepository
import com.skolka.expensetracker.data.repository.FeeConfigurationRepository
import com.skolka.expensetracker.data.repository.PaymentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

data class DashboardState(
    val children: List<Child> = emptyList(),
    val payments: List<Payment> = emptyList(),
    val totalExpenses: Double = 0.0,
    val totalCollected: Double = 0.0,
    val totalExpected: Double = 0.0,
    val balance: Double = 0.0,
    val feeConfig: FeeConfiguration? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

data class ChildPaymentSummary(
    val paid: Double,
    val remaining: Double,
    val status: PaymentStatus,
    val secondHalfOverdue: Boolean
)

class DashboardViewModel(
    private val childRepository: ChildRepository,
    private val paymentRepository: PaymentRepository,
    private val expenseRepository: ExpenseRepository,
    private val feeConfigRepository: FeeConfigurationRepository
) : ViewModel() {
    
    private val _dashboardState = MutableStateFlow(DashboardState())
    val dashboardState: StateFlow<DashboardState> = _dashboardState
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            try {
                _dashboardState.value = _dashboardState.value.copy(isLoading = true)
                
                // Get latest fee configuration
                val feeConfig = feeConfigRepository.getLatestFeeConfig()
                
                // Combine all data streams
                combine(
                    childRepository.getAllActiveChildren(),
                    paymentRepository.getAllPayments(),
                    expenseRepository.getAllExpenses()
                ) { children, payments, expenses ->
                    val totalExpected = if (feeConfig != null) {
                        children.size * feeConfig.yearlyFeeAmount
                    } else {
                        0.0
                    }
                    
                    val totalCollected = payments.sumOf { it.amount }
                    val totalExpensesAmount = expenses.sumOf { it.amount }
                    val balance = totalCollected - totalExpensesAmount
                    
                    DashboardState(
                        children = children,
                        payments = payments,
                        totalExpenses = totalExpensesAmount,
                        totalCollected = totalCollected,
                        totalExpected = totalExpected,
                        balance = balance,
                        feeConfig = feeConfig,
                        isLoading = false
                    )
                }.collect { state ->
                    _dashboardState.value = state
                }
            } catch (e: Exception) {
                _dashboardState.value = _dashboardState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }
    
    fun getPaymentStatusForChild(childId: String): PaymentStatus {
        val feeConfig = _dashboardState.value.feeConfig
        
        if (feeConfig == null) {
            return PaymentStatus.NO_FEE_CONFIG
        }

        val payments = _dashboardState.value.payments.filter {
            it.childId == childId && it.feeConfigId == feeConfig.id
        }
        
        val totalPaid = payments.sumOf { it.amount }
        val expectedAmount = feeConfig.yearlyFeeAmount
        
        return when {
            totalPaid >= expectedAmount -> PaymentStatus.PAID_FULL
            totalPaid > 0 && totalPaid < expectedAmount -> PaymentStatus.PAID_PARTIAL
            else -> PaymentStatus.NOT_PAID
        }
    }

    fun getPaymentSummaryForChild(childId: String): ChildPaymentSummary {
        val state = _dashboardState.value
        val fee = state.feeConfig
        if (fee == null) return ChildPaymentSummary(0.0, 0.0, PaymentStatus.NO_FEE_CONFIG, false)
        val paid = state.payments.filter { it.childId == childId && it.feeConfigId == fee.id }.sumOf { it.amount }
        val remaining = (fee.yearlyFeeAmount - paid).coerceAtLeast(0.0)
        val status = when {
            remaining <= 0.0 -> PaymentStatus.PAID_FULL
            paid > 0.0 -> PaymentStatus.PAID_PARTIAL
            else -> PaymentStatus.NOT_PAID
        }
        val overdue = fee.splitOption == "two_halves" && status == PaymentStatus.PAID_PARTIAL && fee.secondHalfDueDate?.let {
            runCatching { java.time.LocalDate.now().isAfter(java.time.LocalDate.parse(it)) }.getOrDefault(false)
        } == true
        return ChildPaymentSummary(paid, remaining, status, overdue)
    }
    
    fun refreshData() {
        loadDashboardData()
    }
}

enum class PaymentStatus {
    PAID_FULL,
    PAID_PARTIAL,
    NOT_PAID,
    NO_FEE_CONFIG
}

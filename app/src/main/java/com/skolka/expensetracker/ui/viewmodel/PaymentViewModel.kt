package com.skolka.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.repository.ChildRepository
import com.skolka.expensetracker.data.repository.PaymentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class PaymentUiState(
    val payments: List<Payment> = emptyList(),
    val children: List<Child> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null
)

class PaymentViewModel(
    private val paymentRepository: PaymentRepository,
    private val childRepository: ChildRepository
) : ViewModel() {
    
    private val _paymentUiState = MutableStateFlow(PaymentUiState())
    val paymentUiState: StateFlow<PaymentUiState> = _paymentUiState
    
    init {
        loadPayments()
        loadChildren()
    }
    
    private fun loadPayments() {
        viewModelScope.launch {
            try {
                paymentRepository.getAllPayments().collect { payments ->
                    _paymentUiState.value = _paymentUiState.value.copy(
                        payments = payments.sortedByDescending { it.paymentDate }
                    )
                }
            } catch (e: Exception) {
                _paymentUiState.value = _paymentUiState.value.copy(
                    error = e.message ?: "Failed to load payments"
                )
            }
        }
    }
    
    private fun loadChildren() {
        viewModelScope.launch {
            try {
                childRepository.getAllActiveChildren().collect { children ->
                    _paymentUiState.value = _paymentUiState.value.copy(
                        children = children.sortedBy { it.name }
                    )
                }
            } catch (e: Exception) {
                _paymentUiState.value = _paymentUiState.value.copy(
                    error = e.message ?: "Failed to load children"
                )
            }
        }
    }
    
    fun addPayment(payment: Payment) {
        viewModelScope.launch {
            try {
                _paymentUiState.value = _paymentUiState.value.copy(isLoading = true)
                paymentRepository.insertPayment(payment)
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    successMessage = "Payment added successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to add payment"
                )
            }
        }
    }
    
    fun updatePayment(payment: Payment) {
        viewModelScope.launch {
            try {
                _paymentUiState.value = _paymentUiState.value.copy(isLoading = true)
                paymentRepository.updatePayment(payment)
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    successMessage = "Payment updated successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to update payment"
                )
            }
        }
    }
    
    fun deletePayment(payment: Payment) {
        viewModelScope.launch {
            try {
                _paymentUiState.value = _paymentUiState.value.copy(isLoading = true)
                paymentRepository.deletePayment(payment)
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    successMessage = "Payment deleted successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _paymentUiState.value = _paymentUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to delete payment"
                )
            }
        }
    }
    
    fun getPaymentsByChild(childId: String): List<Payment> {
        return _paymentUiState.value.payments.filter { it.childId == childId }
    }
    
    fun clearMessages() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(3000)
            _paymentUiState.value = _paymentUiState.value.copy(
                successMessage = null,
                error = null
            )
        }
    }
}

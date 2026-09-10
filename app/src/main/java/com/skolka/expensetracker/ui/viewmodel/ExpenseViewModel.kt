package com.skolka.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.data.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ExpenseUiState(
    val expenses: List<Expense> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String? = null,
    val totalExpenses: Double = 0.0,
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null
)

class ExpenseViewModel(
    private val expenseRepository: ExpenseRepository
) : ViewModel() {
    
    private val _expenseUiState = MutableStateFlow(ExpenseUiState())
    val expenseUiState: StateFlow<ExpenseUiState> = _expenseUiState
    
    init {
        loadExpenses()
        loadCategories()
        loadTotalExpenses()
    }
    
    private fun loadExpenses() {
        viewModelScope.launch {
            try {
                expenseRepository.getAllExpenses().collect { expenses ->
                    _expenseUiState.value = _expenseUiState.value.copy(
                        expenses = expenses.sortedByDescending { it.expenseDate }
                    )
                }
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    error = e.message ?: "Failed to load expenses"
                )
            }
        }
    }
    
    private fun loadCategories() {
        viewModelScope.launch {
            try {
                expenseRepository.getAllCategories().collect { categories ->
                    _expenseUiState.value = _expenseUiState.value.copy(
                        categories = categories
                    )
                }
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    error = e.message ?: "Failed to load categories"
                )
            }
        }
    }
    
    private fun loadTotalExpenses() {
        viewModelScope.launch {
            try {
                val total = expenseRepository.getTotalExpenses()
                _expenseUiState.value = _expenseUiState.value.copy(
                    totalExpenses = total
                )
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    error = e.message ?: "Failed to load total expenses"
                )
            }
        }
    }
    
    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _expenseUiState.value = _expenseUiState.value.copy(isLoading = true)
                expenseRepository.insertExpense(expense)
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    successMessage = "Expense added successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to add expense"
                )
            }
        }
    }
    
    fun updateExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _expenseUiState.value = _expenseUiState.value.copy(isLoading = true)
                expenseRepository.updateExpense(expense)
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    successMessage = "Expense updated successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to update expense"
                )
            }
        }
    }
    
    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _expenseUiState.value = _expenseUiState.value.copy(isLoading = true)
                expenseRepository.deleteExpense(expense)
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    successMessage = "Expense deleted successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _expenseUiState.value = _expenseUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to delete expense"
                )
            }
        }
    }
    
    fun filterByCategory(category: String) {
        _expenseUiState.value = _expenseUiState.value.copy(selectedCategory = category)
    }
    
    fun clearCategoryFilter() {
        _expenseUiState.value = _expenseUiState.value.copy(selectedCategory = null)
    }
    
    fun getFilteredExpenses(): List<Expense> {
        val selectedCategory = _expenseUiState.value.selectedCategory
        return if (selectedCategory != null) {
            _expenseUiState.value.expenses.filter { it.category == selectedCategory }
        } else {
            _expenseUiState.value.expenses
        }
    }
    
    fun getTotalByCategory(category: String): Double {
        return _expenseUiState.value.expenses
            .filter { it.category == category }
            .sumOf { it.amount }
    }
    
    fun clearMessages() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(3000)
            _expenseUiState.value = _expenseUiState.value.copy(
                successMessage = null,
                error = null
            )
        }
    }
}

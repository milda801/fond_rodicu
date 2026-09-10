package com.skolka.expensetracker.data.repository

import com.skolka.expensetracker.data.dao.ExpenseDao
import com.skolka.expensetracker.data.models.Expense
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    
    suspend fun insertExpense(expense: Expense) {
        expenseDao.insert(expense)
    }
    
    suspend fun updateExpense(expense: Expense) {
        expenseDao.update(expense)
    }
    
    suspend fun deleteExpense(expense: Expense) {
        expenseDao.delete(expense)
    }
    
    suspend fun getExpenseById(id: String): Expense? {
        return expenseDao.getExpenseById(id)
    }
    
    fun getExpensesByCategory(category: String): Flow<List<Expense>> {
        return expenseDao.getExpensesByCategory(category)
    }
    
    fun getAllExpenses(): Flow<List<Expense>> {
        return expenseDao.getAllExpenses()
    }
    
    fun getExpensesByDateRange(startDate: String, endDate: String): Flow<List<Expense>> {
        return expenseDao.getExpensesByDateRange(startDate, endDate)
    }
    
    suspend fun getTotalExpenses(): Double {
        return expenseDao.getTotalExpenses() ?: 0.0
    }
    
    suspend fun getTotalExpensesByCategory(category: String): Double {
        return expenseDao.getTotalExpensesByCategory(category) ?: 0.0
    }
    
    suspend fun getTotalExpensesByDateRange(startDate: String, endDate: String): Double {
        return expenseDao.getTotalExpensesByDateRange(startDate, endDate) ?: 0.0
    }
    
    fun getAllCategories(): Flow<List<String>> {
        return expenseDao.getAllCategories()
    }
    
    suspend fun deleteExpenseById(id: String) {
        expenseDao.deleteExpenseById(id)
    }
}

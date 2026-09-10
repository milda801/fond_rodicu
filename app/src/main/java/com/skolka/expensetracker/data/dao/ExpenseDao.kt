package com.skolka.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.skolka.expensetracker.data.models.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense): Long
    
    @Update
    suspend fun update(expense: Expense)
    
    @Delete
    suspend fun delete(expense: Expense)
    
    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: String): Expense?
    
    @Query("SELECT * FROM expenses WHERE category = :category ORDER BY expenseDate DESC")
    fun getExpensesByCategory(category: String): Flow<List<Expense>>
    
    @Query("SELECT * FROM expenses ORDER BY expenseDate DESC")
    fun getAllExpenses(): Flow<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE expenseDate BETWEEN :startDate AND :endDate ORDER BY expenseDate DESC")
    fun getExpensesByDateRange(startDate: String, endDate: String): Flow<List<Expense>>
    
    @Query("SELECT SUM(amount) FROM expenses")
    suspend fun getTotalExpenses(): Double?
    
    @Query("SELECT SUM(amount) FROM expenses WHERE category = :category")
    suspend fun getTotalExpensesByCategory(category: String): Double?
    
    @Query("SELECT SUM(amount) FROM expenses WHERE expenseDate BETWEEN :startDate AND :endDate")
    suspend fun getTotalExpensesByDateRange(startDate: String, endDate: String): Double?
    
    @Query("SELECT DISTINCT category FROM expenses ORDER BY category ASC")
    fun getAllCategories(): Flow<List<String>>
    
    @Query("DELETE FROM expenses WHERE id = :id")
    suspend fun deleteExpenseById(id: String)
}

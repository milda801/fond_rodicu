package com.skolka.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.skolka.expensetracker.data.models.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(payment: Payment): Long
    
    @Update
    suspend fun update(payment: Payment)
    
    @Delete
    suspend fun delete(payment: Payment)
    
    @Query("SELECT * FROM payments WHERE id = :id")
    suspend fun getPaymentById(id: String): Payment?
    
    @Query("SELECT * FROM payments WHERE childId = :childId ORDER BY paymentDate DESC")
    fun getPaymentsByChild(childId: String): Flow<List<Payment>>
    
    @Query("SELECT * FROM payments WHERE feeConfigId = :feeConfigId ORDER BY paymentDate DESC")
    fun getPaymentsByFeeConfig(feeConfigId: String): Flow<List<Payment>>
    
    @Query("SELECT * FROM payments ORDER BY paymentDate DESC")
    fun getAllPayments(): Flow<List<Payment>>
    
    @Query("SELECT SUM(amount) FROM payments WHERE feeConfigId = :feeConfigId")
    suspend fun getTotalPaymentsByFeeConfig(feeConfigId: String): Double?
    
    @Query("SELECT SUM(amount) FROM payments WHERE childId = :childId AND feeConfigId = :feeConfigId")
    suspend fun getTotalPaymentsByChildAndFeeConfig(childId: String, feeConfigId: String): Double?
    
    @Query("SELECT COUNT(*) FROM payments WHERE childId = :childId AND feeConfigId = :feeConfigId")
    suspend fun getPaymentCountByChildAndFeeConfig(childId: String, feeConfigId: String): Int
    
    @Query("DELETE FROM payments WHERE id = :id")
    suspend fun deletePaymentById(id: String)
}

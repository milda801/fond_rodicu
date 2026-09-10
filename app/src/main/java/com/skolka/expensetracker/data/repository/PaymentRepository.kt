package com.skolka.expensetracker.data.repository

import com.skolka.expensetracker.data.dao.PaymentDao
import com.skolka.expensetracker.data.models.Payment
import kotlinx.coroutines.flow.Flow

class PaymentRepository(private val paymentDao: PaymentDao) {
    
    suspend fun insertPayment(payment: Payment) {
        paymentDao.insert(payment)
    }
    
    suspend fun updatePayment(payment: Payment) {
        paymentDao.update(payment)
    }
    
    suspend fun deletePayment(payment: Payment) {
        paymentDao.delete(payment)
    }
    
    suspend fun getPaymentById(id: String): Payment? {
        return paymentDao.getPaymentById(id)
    }
    
    fun getPaymentsByChild(childId: String): Flow<List<Payment>> {
        return paymentDao.getPaymentsByChild(childId)
    }
    
    fun getPaymentsByFeeConfig(feeConfigId: String): Flow<List<Payment>> {
        return paymentDao.getPaymentsByFeeConfig(feeConfigId)
    }
    
    fun getAllPayments(): Flow<List<Payment>> {
        return paymentDao.getAllPayments()
    }
    
    suspend fun getTotalPaymentsByFeeConfig(feeConfigId: String): Double {
        return paymentDao.getTotalPaymentsByFeeConfig(feeConfigId) ?: 0.0
    }
    
    suspend fun getTotalPaymentsByChildAndFeeConfig(childId: String, feeConfigId: String): Double {
        return paymentDao.getTotalPaymentsByChildAndFeeConfig(childId, feeConfigId) ?: 0.0
    }
    
    suspend fun getPaymentCountByChildAndFeeConfig(childId: String, feeConfigId: String): Int {
        return paymentDao.getPaymentCountByChildAndFeeConfig(childId, feeConfigId)
    }
    
    suspend fun deletePaymentById(id: String) {
        paymentDao.deletePaymentById(id)
    }
}

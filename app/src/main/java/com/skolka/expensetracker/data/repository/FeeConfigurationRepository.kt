package com.skolka.expensetracker.data.repository

import com.skolka.expensetracker.data.dao.FeeConfigurationDao
import com.skolka.expensetracker.data.models.FeeConfiguration
import kotlinx.coroutines.flow.Flow

class FeeConfigurationRepository(private val feeConfigurationDao: FeeConfigurationDao) {
    
    suspend fun insertFeeConfiguration(feeConfiguration: FeeConfiguration) {
        feeConfigurationDao.insert(feeConfiguration)
    }
    
    suspend fun updateFeeConfiguration(feeConfiguration: FeeConfiguration) {
        feeConfigurationDao.update(feeConfiguration)
    }
    
    suspend fun deleteFeeConfiguration(feeConfiguration: FeeConfiguration) {
        feeConfigurationDao.delete(feeConfiguration)
    }
    
    suspend fun getFeeConfigById(id: String): FeeConfiguration? {
        return feeConfigurationDao.getFeeConfigById(id)
    }
    
    suspend fun getFeeConfigByAcademicYear(academicYear: String): FeeConfiguration? {
        return feeConfigurationDao.getFeeConfigByAcademicYear(academicYear)
    }
    
    fun getAllFeeConfigs(): Flow<List<FeeConfiguration>> {
        return feeConfigurationDao.getAllFeeConfigs()
    }
    
    suspend fun getLatestFeeConfig(): FeeConfiguration? {
        return feeConfigurationDao.getLatestFeeConfig()
    }
    
    suspend fun deleteFeeConfigById(id: String) {
        feeConfigurationDao.deleteFeeConfigById(id)
    }
}

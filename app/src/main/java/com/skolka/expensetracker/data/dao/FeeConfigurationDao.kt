package com.skolka.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.skolka.expensetracker.data.models.FeeConfiguration
import kotlinx.coroutines.flow.Flow

@Dao
interface FeeConfigurationDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(feeConfiguration: FeeConfiguration): Long
    
    @Update
    suspend fun update(feeConfiguration: FeeConfiguration)
    
    @Delete
    suspend fun delete(feeConfiguration: FeeConfiguration)
    
    @Query("SELECT * FROM fee_configurations WHERE id = :id")
    suspend fun getFeeConfigById(id: String): FeeConfiguration?
    
    @Query("SELECT * FROM fee_configurations WHERE academicYear = :academicYear")
    suspend fun getFeeConfigByAcademicYear(academicYear: String): FeeConfiguration?
    
    @Query("SELECT * FROM fee_configurations ORDER BY academicYear DESC")
    fun getAllFeeConfigs(): Flow<List<FeeConfiguration>>
    
    @Query("SELECT * FROM fee_configurations ORDER BY academicYear DESC LIMIT 1")
    suspend fun getLatestFeeConfig(): FeeConfiguration?
    
    @Query("DELETE FROM fee_configurations WHERE id = :id")
    suspend fun deleteFeeConfigById(id: String)
}

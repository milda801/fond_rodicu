package com.skolka.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.skolka.expensetracker.data.models.Child
import kotlinx.coroutines.flow.Flow

@Dao
interface ChildDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(child: Child): Long
    
    @Update
    suspend fun update(child: Child)
    
    @Delete
    suspend fun delete(child: Child)
    
    @Query("SELECT * FROM children WHERE id = :id")
    suspend fun getChildById(id: String): Child?
    
    @Query("SELECT * FROM children WHERE status = 'active' ORDER BY name ASC")
    fun getAllActiveChildren(): Flow<List<Child>>
    
    @Query("SELECT * FROM children ORDER BY name ASC")
    fun getAllChildren(): Flow<List<Child>>
    
    @Query("SELECT COUNT(*) FROM children WHERE status = 'active'")
    fun getActiveChildrenCount(): Flow<Int>
    
    @Query("DELETE FROM children WHERE id = :id")
    suspend fun deleteChildById(id: String)
}

package com.skolka.expensetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.skolka.expensetracker.data.models.SyncMetadata
import kotlinx.coroutines.flow.Flow

@Dao
interface SyncMetadataDao {
    
    @Insert
    suspend fun insert(syncMetadata: SyncMetadata): Long
    
    @Update
    suspend fun update(syncMetadata: SyncMetadata)
    
    @Delete
    suspend fun delete(syncMetadata: SyncMetadata)
    
    @Query("SELECT * FROM sync_metadata WHERE id = :id")
    suspend fun getSyncMetadataById(id: String): SyncMetadata?
    
    @Query("SELECT * FROM sync_metadata LIMIT 1")
    fun getSyncMetadata(): Flow<SyncMetadata?>
    
    @Query("UPDATE sync_metadata SET lastSyncTime = :timestamp, syncStatus = 'idle'")
    suspend fun updateLastSyncTime(timestamp: String)
    
    @Query("UPDATE sync_metadata SET lastBackupTime = :timestamp")
    suspend fun updateLastBackupTime(timestamp: String)
    
    @Query("UPDATE sync_metadata SET syncStatus = :status")
    suspend fun updateSyncStatus(status: String)
    
    @Query("UPDATE sync_metadata SET cloudProvider = :provider")
    suspend fun updateCloudProvider(provider: String)
    
    @Query("DELETE FROM sync_metadata")
    suspend fun deleteAll()
}

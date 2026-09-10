package com.skolka.expensetracker.data.repository

import com.skolka.expensetracker.data.dao.SyncMetadataDao
import com.skolka.expensetracker.data.models.SyncMetadata
import kotlinx.coroutines.flow.Flow

class SyncMetadataRepository(private val syncMetadataDao: SyncMetadataDao) {
    
    suspend fun insertSyncMetadata(syncMetadata: SyncMetadata) {
        syncMetadataDao.insert(syncMetadata)
    }
    
    suspend fun updateSyncMetadata(syncMetadata: SyncMetadata) {
        syncMetadataDao.update(syncMetadata)
    }
    
    suspend fun deleteSyncMetadata(syncMetadata: SyncMetadata) {
        syncMetadataDao.delete(syncMetadata)
    }
    
    suspend fun getSyncMetadataById(id: String): SyncMetadata? {
        return syncMetadataDao.getSyncMetadataById(id)
    }
    
    fun getSyncMetadata(): Flow<SyncMetadata?> {
        return syncMetadataDao.getSyncMetadata()
    }
    
    suspend fun updateLastSyncTime(timestamp: String) {
        syncMetadataDao.updateLastSyncTime(timestamp)
    }
    
    suspend fun updateLastBackupTime(timestamp: String) {
        syncMetadataDao.updateLastBackupTime(timestamp)
    }
    
    suspend fun updateSyncStatus(status: String) {
        syncMetadataDao.updateSyncStatus(status)
    }
    
    suspend fun updateCloudProvider(provider: String) {
        syncMetadataDao.updateCloudProvider(provider)
    }
    
    suspend fun deleteAll() {
        syncMetadataDao.deleteAll()
    }
}

package com.skolka.expensetracker.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "sync_metadata")
data class SyncMetadata(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val lastSyncTime: String? = null,
    val lastBackupTime: String? = null,
    val cloudProvider: String? = null, // google_drive, dropbox
    val syncStatus: String = "idle" // idle, syncing, error
)

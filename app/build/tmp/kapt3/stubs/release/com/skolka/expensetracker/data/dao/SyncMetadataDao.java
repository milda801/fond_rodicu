package com.skolka.expensetracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nH\'J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/skolka/expensetracker/data/dao/SyncMetadataDao;", "", "delete", "", "syncMetadata", "Lcom/skolka/expensetracker/data/models/SyncMetadata;", "(Lcom/skolka/expensetracker/data/models/SyncMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncMetadata", "Lkotlinx/coroutines/flow/Flow;", "getSyncMetadataById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "update", "updateCloudProvider", "provider", "updateLastBackupTime", "timestamp", "updateLastSyncTime", "updateSyncStatus", "status", "app_release"})
@androidx.room.Dao
public abstract interface SyncMetadataDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.SyncMetadata syncMetadata, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.SyncMetadata syncMetadata, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.SyncMetadata syncMetadata, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sync_metadata WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSyncMetadataById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.SyncMetadata> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sync_metadata LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.skolka.expensetracker.data.models.SyncMetadata> getSyncMetadata();
    
    @androidx.room.Query(value = "UPDATE sync_metadata SET lastSyncTime = :timestamp, syncStatus = \'idle\'")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLastSyncTime(@org.jetbrains.annotations.NotNull
    java.lang.String timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE sync_metadata SET lastBackupTime = :timestamp")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLastBackupTime(@org.jetbrains.annotations.NotNull
    java.lang.String timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE sync_metadata SET syncStatus = :status")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateSyncStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE sync_metadata SET cloudProvider = :provider")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateCloudProvider(@org.jetbrains.annotations.NotNull
    java.lang.String provider, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM sync_metadata")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
package com.skolka.expensetracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/skolka/expensetracker/data/dao/FeeConfigurationDao;", "", "delete", "", "feeConfiguration", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "(Lcom/skolka/expensetracker/data/models/FeeConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFeeConfigById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFeeConfigs", "Lkotlinx/coroutines/flow/Flow;", "", "getFeeConfigByAcademicYear", "academicYear", "getFeeConfigById", "getLatestFeeConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "update", "app_release"})
@androidx.room.Dao
public abstract interface FeeConfigurationDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fee_configurations WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeConfigById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.FeeConfiguration> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fee_configurations WHERE academicYear = :academicYear")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFeeConfigByAcademicYear(@org.jetbrains.annotations.NotNull
    java.lang.String academicYear, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.FeeConfiguration> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM fee_configurations ORDER BY academicYear DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration>> getAllFeeConfigs();
    
    @androidx.room.Query(value = "SELECT * FROM fee_configurations ORDER BY academicYear DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLatestFeeConfig(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.FeeConfiguration> $completion);
    
    @androidx.room.Query(value = "DELETE FROM fee_configurations WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFeeConfigById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
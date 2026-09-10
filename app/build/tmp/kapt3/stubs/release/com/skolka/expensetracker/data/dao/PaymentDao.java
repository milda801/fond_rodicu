package com.skolka.expensetracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0011\u001a\u00020\tH\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0012\u001a\u00020\tH\'J#\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/skolka/expensetracker/data/dao/PaymentDao;", "", "delete", "", "payment", "Lcom/skolka/expensetracker/data/models/Payment;", "(Lcom/skolka/expensetracker/data/models/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePaymentById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayments", "Lkotlinx/coroutines/flow/Flow;", "", "getPaymentById", "getPaymentCountByChildAndFeeConfig", "", "childId", "feeConfigId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentsByChild", "getPaymentsByFeeConfig", "getTotalPaymentsByChildAndFeeConfig", "", "getTotalPaymentsByFeeConfig", "insert", "", "update", "app_release"})
@androidx.room.Dao
public abstract interface PaymentDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM payments WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPaymentById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.Payment> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM payments WHERE childId = :childId ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getPaymentsByChild(@org.jetbrains.annotations.NotNull
    java.lang.String childId);
    
    @androidx.room.Query(value = "SELECT * FROM payments WHERE feeConfigId = :feeConfigId ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getPaymentsByFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId);
    
    @androidx.room.Query(value = "SELECT * FROM payments ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getAllPayments();
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM payments WHERE feeConfigId = :feeConfigId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalPaymentsByFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM payments WHERE childId = :childId AND feeConfigId = :feeConfigId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalPaymentsByChildAndFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM payments WHERE childId = :childId AND feeConfigId = :feeConfigId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPaymentCountByChildAndFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "DELETE FROM payments WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deletePaymentById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
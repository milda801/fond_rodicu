package com.skolka.expensetracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\fJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\fJ!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "", "paymentDao", "Lcom/skolka/expensetracker/data/dao/PaymentDao;", "(Lcom/skolka/expensetracker/data/dao/PaymentDao;)V", "deletePayment", "", "payment", "Lcom/skolka/expensetracker/data/models/Payment;", "(Lcom/skolka/expensetracker/data/models/Payment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePaymentById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPayments", "Lkotlinx/coroutines/flow/Flow;", "", "getPaymentById", "getPaymentCountByChildAndFeeConfig", "", "childId", "feeConfigId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentsByChild", "getPaymentsByFeeConfig", "getTotalPaymentsByChildAndFeeConfig", "", "getTotalPaymentsByFeeConfig", "insertPayment", "updatePayment", "app_debug"})
public final class PaymentRepository {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.dao.PaymentDao paymentDao = null;
    
    public PaymentRepository(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.dao.PaymentDao paymentDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertPayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updatePayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deletePayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPaymentById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.Payment> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getPaymentsByChild(@org.jetbrains.annotations.NotNull
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getPaymentsByFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Payment>> getAllPayments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalPaymentsByFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalPaymentsByChildAndFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPaymentCountByChildAndFeeConfig(@org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deletePaymentById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
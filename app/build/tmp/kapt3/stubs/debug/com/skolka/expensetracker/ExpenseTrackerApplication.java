package com.skolka.expensetracker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lcom/skolka/expensetracker/ExpenseTrackerApplication;", "Landroid/app/Application;", "()V", "childRepository", "Lcom/skolka/expensetracker/data/repository/ChildRepository;", "getChildRepository", "()Lcom/skolka/expensetracker/data/repository/ChildRepository;", "childRepository$delegate", "Lkotlin/Lazy;", "database", "Lcom/skolka/expensetracker/data/database/AppDatabase;", "getDatabase", "()Lcom/skolka/expensetracker/data/database/AppDatabase;", "database$delegate", "expenseRepository", "Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "getExpenseRepository", "()Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "expenseRepository$delegate", "feeRepository", "Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "getFeeRepository", "()Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "feeRepository$delegate", "paymentRepository", "Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "getPaymentRepository", "()Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "paymentRepository$delegate", "syncRepository", "Lcom/skolka/expensetracker/data/repository/SyncMetadataRepository;", "getSyncRepository", "()Lcom/skolka/expensetracker/data/repository/SyncMetadataRepository;", "syncRepository$delegate", "app_debug"})
public final class ExpenseTrackerApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy childRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy paymentRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy expenseRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy feeRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy syncRepository$delegate = null;
    
    public ExpenseTrackerApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.database.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.repository.ChildRepository getChildRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.repository.PaymentRepository getPaymentRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.repository.ExpenseRepository getExpenseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.repository.FeeConfigurationRepository getFeeRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.repository.SyncMetadataRepository getSyncRepository() {
        return null;
    }
}
package com.skolka.expensetracker.services.backup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/skolka/expensetracker/services/backup/BackupService;", "", "children", "Lcom/skolka/expensetracker/data/repository/ChildRepository;", "fees", "Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "payments", "Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "expenses", "Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "(Lcom/skolka/expensetracker/data/repository/ChildRepository;Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;Lcom/skolka/expensetracker/data/repository/PaymentRepository;Lcom/skolka/expensetracker/data/repository/ExpenseRepository;)V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "createJson", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreJson", "Lcom/skolka/expensetracker/services/backup/AppBackup;", "json", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BackupService {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ChildRepository children = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.FeeConfigurationRepository fees = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.PaymentRepository payments = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ExpenseRepository expenses = null;
    private final com.google.gson.Gson gson = null;
    
    public BackupService(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ChildRepository children, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.FeeConfigurationRepository fees, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.PaymentRepository payments, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ExpenseRepository expenses) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createJson(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object restoreJson(@org.jetbrains.annotations.NotNull
    java.lang.String json, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.services.backup.AppBackup> $completion) {
        return null;
    }
}
package com.skolka.expensetracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\fJ\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "", "expenseDao", "Lcom/skolka/expensetracker/data/dao/ExpenseDao;", "(Lcom/skolka/expensetracker/data/dao/ExpenseDao;)V", "deleteExpense", "", "expense", "Lcom/skolka/expensetracker/data/models/Expense;", "(Lcom/skolka/expensetracker/data/models/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpenseById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "getAllExpenses", "getExpenseById", "getExpensesByCategory", "category", "getExpensesByDateRange", "startDate", "endDate", "getTotalExpenses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalExpensesByCategory", "getTotalExpensesByDateRange", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExpense", "updateExpense", "app_release"})
public final class ExpenseRepository {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.dao.ExpenseDao expenseDao = null;
    
    public ExpenseRepository(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.dao.ExpenseDao expenseDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getExpenseById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.Expense> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getExpensesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getExpensesByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalExpenses(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalExpensesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalExpensesByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getAllCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteExpenseById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
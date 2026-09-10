package com.skolka.expensetracker.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\fH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0011\u001a\u00020\tH\'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\'J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ#\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/skolka/expensetracker/data/dao/ExpenseDao;", "", "delete", "", "expense", "Lcom/skolka/expensetracker/data/models/Expense;", "(Lcom/skolka/expensetracker/data/models/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpenseById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "getAllExpenses", "getExpenseById", "getExpensesByCategory", "category", "getExpensesByDateRange", "startDate", "endDate", "getTotalExpenses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalExpensesByCategory", "getTotalExpensesByDateRange", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "update", "app_debug"})
@androidx.room.Dao
public abstract interface ExpenseDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExpenseById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.Expense> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE category = :category ORDER BY expenseDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getExpensesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM expenses ORDER BY expenseDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getAllExpenses();
    
    @androidx.room.Query(value = "SELECT * FROM expenses WHERE expenseDate BETWEEN :startDate AND :endDate ORDER BY expenseDate DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Expense>> getExpensesByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM expenses")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalExpenses(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM expenses WHERE category = :category")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalExpensesByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM expenses WHERE expenseDate BETWEEN :startDate AND :endDate")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalExpensesByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT category FROM expenses ORDER BY category ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getAllCategories();
    
    @androidx.room.Query(value = "DELETE FROM expenses WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExpenseById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
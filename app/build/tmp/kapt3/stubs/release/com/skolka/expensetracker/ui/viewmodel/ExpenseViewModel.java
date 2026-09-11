package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u001e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/ExpenseViewModel;", "Landroidx/lifecycle/ViewModel;", "expenseRepository", "Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "(Lcom/skolka/expensetracker/data/repository/ExpenseRepository;)V", "_expenseUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/skolka/expensetracker/ui/viewmodel/ExpenseUiState;", "expenseUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getExpenseUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addExpense", "", "expense", "Lcom/skolka/expensetracker/data/models/Expense;", "clearCategoryFilter", "clearMessages", "deleteExpense", "filterByCategory", "category", "", "getFilteredExpenses", "", "getTotalByCategory", "", "loadCategories", "loadExpenses", "loadTotalExpenses", "updateExpense", "onSuccess", "Lkotlin/Function0;", "app_release"})
public final class ExpenseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.skolka.expensetracker.ui.viewmodel.ExpenseUiState> _expenseUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.ExpenseUiState> expenseUiState = null;
    
    public ExpenseViewModel(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.ExpenseUiState> getExpenseUiState() {
        return null;
    }
    
    private final void loadExpenses() {
    }
    
    private final void loadCategories() {
    }
    
    private final void loadTotalExpenses() {
    }
    
    public final void addExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense) {
    }
    
    public final void updateExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void deleteExpense(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Expense expense) {
    }
    
    public final void filterByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    public final void clearCategoryFilter() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Expense> getFilteredExpenses() {
        return null;
    }
    
    public final double getTotalByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
        return 0.0;
    }
    
    public final void clearMessages() {
    }
}
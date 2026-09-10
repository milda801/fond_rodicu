package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "childRepository", "Lcom/skolka/expensetracker/data/repository/ChildRepository;", "paymentRepository", "Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "expenseRepository", "Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "feeConfigRepository", "Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "(Lcom/skolka/expensetracker/data/repository/ChildRepository;Lcom/skolka/expensetracker/data/repository/PaymentRepository;Lcom/skolka/expensetracker/data/repository/ExpenseRepository;Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;)V", "_dashboardState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/skolka/expensetracker/ui/viewmodel/DashboardState;", "dashboardState", "Lkotlinx/coroutines/flow/StateFlow;", "getDashboardState", "()Lkotlinx/coroutines/flow/StateFlow;", "getPaymentStatusForChild", "Lcom/skolka/expensetracker/ui/viewmodel/PaymentStatus;", "childId", "", "getPaymentSummaryForChild", "Lcom/skolka/expensetracker/ui/viewmodel/ChildPaymentSummary;", "loadDashboardData", "", "refreshData", "app_release"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ChildRepository childRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.skolka.expensetracker.ui.viewmodel.DashboardState> _dashboardState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.DashboardState> dashboardState = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ChildRepository childRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.DashboardState> getDashboardState() {
        return null;
    }
    
    private final void loadDashboardData() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.ui.viewmodel.PaymentStatus getPaymentStatusForChild(@org.jetbrains.annotations.NotNull
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.ui.viewmodel.ChildPaymentSummary getPaymentSummaryForChild(@org.jetbrains.annotations.NotNull
    java.lang.String childId) {
        return null;
    }
    
    public final void refreshData() {
    }
}
package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001eR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/ReportViewModel;", "Landroidx/lifecycle/ViewModel;", "childRepository", "Lcom/skolka/expensetracker/data/repository/ChildRepository;", "paymentRepository", "Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "expenseRepository", "Lcom/skolka/expensetracker/data/repository/ExpenseRepository;", "feeConfigRepository", "Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "(Lcom/skolka/expensetracker/data/repository/ChildRepository;Lcom/skolka/expensetracker/data/repository/PaymentRepository;Lcom/skolka/expensetracker/data/repository/ExpenseRepository;Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;)V", "_reportUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/skolka/expensetracker/ui/viewmodel/ReportUiState;", "reportUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getReportUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getChildPaymentDetails", "", "Lcom/skolka/expensetracker/ui/viewmodel/ChildPaymentDetail;", "getPaymentStatusSummary", "", "", "", "loadReportData", "", "refreshReport", "setExportInProgress", "inProgress", "", "setExportSuccess", "success", "app_debug"})
public final class ReportViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ChildRepository childRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.skolka.expensetracker.ui.viewmodel.ReportUiState> _reportUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.ReportUiState> reportUiState = null;
    
    public ReportViewModel(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ChildRepository childRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.ReportUiState> getReportUiState() {
        return null;
    }
    
    private final void loadReportData() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Integer> getPaymentStatusSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.ui.viewmodel.ChildPaymentDetail> getChildPaymentDetails() {
        return null;
    }
    
    public final void refreshReport() {
    }
    
    public final void setExportInProgress(boolean inProgress) {
    }
    
    public final void setExportSuccess(boolean success) {
    }
}
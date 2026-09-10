package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/PaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentRepository", "Lcom/skolka/expensetracker/data/repository/PaymentRepository;", "childRepository", "Lcom/skolka/expensetracker/data/repository/ChildRepository;", "(Lcom/skolka/expensetracker/data/repository/PaymentRepository;Lcom/skolka/expensetracker/data/repository/ChildRepository;)V", "_paymentUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/skolka/expensetracker/ui/viewmodel/PaymentUiState;", "paymentUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getPaymentUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addPayment", "", "payment", "Lcom/skolka/expensetracker/data/models/Payment;", "clearMessages", "deletePayment", "getPaymentsByChild", "", "childId", "", "loadChildren", "loadPayments", "updatePayment", "app_debug"})
public final class PaymentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.ChildRepository childRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.skolka.expensetracker.ui.viewmodel.PaymentUiState> _paymentUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.PaymentUiState> paymentUiState = null;
    
    public PaymentViewModel(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.ChildRepository childRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.PaymentUiState> getPaymentUiState() {
        return null;
    }
    
    private final void loadPayments() {
    }
    
    private final void loadChildren() {
    }
    
    public final void addPayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment) {
    }
    
    public final void updatePayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment) {
    }
    
    public final void deletePayment(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Payment payment) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Payment> getPaymentsByChild(@org.jetbrains.annotations.NotNull
    java.lang.String childId) {
        return null;
    }
    
    public final void clearMessages() {
    }
}
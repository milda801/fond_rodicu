package com.skolka.expensetracker.ui.expenses;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J,\u0010\"\u001a\n \n*\u0004\u0018\u00010\u00040\u00042\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00042\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000eH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00063"}, d2 = {"Lcom/skolka/expensetracker/ui/expenses/ExpensesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activeExpenseForm", "Landroid/view/View;", "activeReceiptPath", "", "cameraCapture", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "editingExpense", "Lcom/skolka/expensetracker/data/models/Expense;", "ocrInProgress", "", "ocrService", "Lcom/skolka/expensetracker/services/ocr/OcrService;", "getOcrService", "()Lcom/skolka/expensetracker/services/ocr/OcrService;", "ocrService$delegate", "Lkotlin/Lazy;", "originalReceiptPath", "pendingCameraFile", "Ljava/io/File;", "pendingCameraUri", "viewModel", "Lcom/skolka/expensetracker/ui/viewmodel/ExpenseViewModel;", "getViewModel", "()Lcom/skolka/expensetracker/ui/viewmodel/ExpenseViewModel;", "viewModel$delegate", "clearActiveForm", "", "deleteUnsavedReplacementReceipt", "launchCamera", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "state", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "readExpenseReceipt", "uri", "showExpenseForm", "runOcr", "showExpenseFormAfterPhoto", "startEditingExpense", "expense", "app_debug"})
public final class ExpensesFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy ocrService$delegate = null;
    @org.jetbrains.annotations.Nullable
    private android.view.View activeExpenseForm;
    @org.jetbrains.annotations.Nullable
    private java.lang.String activeReceiptPath;
    @org.jetbrains.annotations.Nullable
    private java.io.File pendingCameraFile;
    @org.jetbrains.annotations.Nullable
    private android.net.Uri pendingCameraUri;
    private boolean ocrInProgress = false;
    @org.jetbrains.annotations.Nullable
    private com.skolka.expensetracker.data.models.Expense editingExpense;
    @org.jetbrains.annotations.Nullable
    private java.lang.String originalReceiptPath;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> cameraCapture = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public ExpensesFragment() {
        super();
    }
    
    private final com.skolka.expensetracker.services.ocr.OcrService getOcrService() {
        return null;
    }
    
    private final void readExpenseReceipt(android.net.Uri uri) {
    }
    
    private final com.skolka.expensetracker.ui.viewmodel.ExpenseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle state) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle state) {
    }
    
    private final void showExpenseFormAfterPhoto() {
    }
    
    private final void startEditingExpense(com.skolka.expensetracker.data.models.Expense expense) {
    }
    
    private final void showExpenseForm(boolean runOcr) {
    }
    
    private final void launchCamera() {
    }
    
    private final void clearActiveForm() {
    }
    
    private final void deleteUnsavedReplacementReceipt() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}
package com.skolka.expensetracker.ui.payments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00060\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/skolka/expensetracker/ui/payments/PaymentsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "activePaymentForm", "Landroid/view/View;", "activeReceiptPath", "", "cameraCapture", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "ocrService", "Lcom/skolka/expensetracker/services/ocr/OcrService;", "pendingCameraFile", "Ljava/io/File;", "pendingCameraUri", "receiptPicker", "viewModel", "Lcom/skolka/expensetracker/ui/viewmodel/PaymentViewModel;", "getViewModel", "()Lcom/skolka/expensetracker/ui/viewmodel/PaymentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "state", "Landroid/os/Bundle;", "onDestroy", "", "onViewCreated", "view", "readPaymentReceipt", "uri", "showAddPaymentDialog", "showReceiptSource", "app_release"})
public final class PaymentsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.services.ocr.OcrService ocrService = null;
    @org.jetbrains.annotations.Nullable
    private android.view.View activePaymentForm;
    @org.jetbrains.annotations.Nullable
    private java.lang.String activeReceiptPath;
    @org.jetbrains.annotations.Nullable
    private java.io.File pendingCameraFile;
    @org.jetbrains.annotations.Nullable
    private android.net.Uri pendingCameraUri;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> cameraCapture = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> receiptPicker = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public PaymentsFragment() {
        super();
    }
    
    private final void readPaymentReceipt(android.net.Uri uri) {
    }
    
    private final com.skolka.expensetracker.ui.viewmodel.PaymentViewModel getViewModel() {
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
    
    private final void showAddPaymentDialog() {
    }
    
    private final void showReceiptSource() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}
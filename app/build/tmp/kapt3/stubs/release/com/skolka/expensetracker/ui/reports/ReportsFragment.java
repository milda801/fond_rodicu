package com.skolka.expensetracker.ui.reports;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J,\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\""}, d2 = {"Lcom/skolka/expensetracker/ui/reports/ReportsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "exporter", "Lcom/skolka/expensetracker/services/export/ReportExporter;", "reportData", "Lcom/skolka/expensetracker/ui/viewmodel/ReportData;", "viewModel", "Lcom/skolka/expensetracker/ui/viewmodel/ReportViewModel;", "getViewModel", "()Lcom/skolka/expensetracker/ui/viewmodel/ReportViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "exportPdf", "", "emailOnly", "", "exportSpreadsheet", "onCreateView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "state", "Landroid/os/Bundle;", "onViewCreated", "view", "share", "file", "Ljava/io/File;", "mimeType", "", "app_release"})
public final class ReportsFragment extends androidx.fragment.app.Fragment {
    private com.skolka.expensetracker.services.export.ReportExporter exporter;
    @org.jetbrains.annotations.NotNull
    private com.skolka.expensetracker.ui.viewmodel.ReportData reportData;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public ReportsFragment() {
        super();
    }
    
    private final com.skolka.expensetracker.ui.viewmodel.ReportViewModel getViewModel() {
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
    
    private final void exportSpreadsheet() {
    }
    
    private final void exportPdf(boolean emailOnly) {
    }
    
    private final void share(java.io.File file, java.lang.String mimeType, boolean emailOnly) {
    }
}
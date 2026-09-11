package com.skolka.expensetracker.services.export;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/skolka/expensetracker/services/export/ReportExporter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "czechLocale", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "exportContext", "reportDirectory", "Ljava/io/File;", "createPdf", "data", "Lcom/skolka/expensetracker/ui/viewmodel/ReportData;", "createSpreadsheet", "decodeSampledBitmap", "Landroid/graphics/Bitmap;", "path", "", "targetWidth", "", "targetHeight", "string", "resourceId", "app_release"})
public final class ReportExporter {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.io.File reportDirectory = null;
    private final java.util.Locale czechLocale = null;
    private final android.content.Context exportContext = null;
    
    public ReportExporter(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.io.File createSpreadsheet(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.ui.viewmodel.ReportData data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.io.File createPdf(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.ui.viewmodel.ReportData data) {
        return null;
    }
    
    private final android.graphics.Bitmap decodeSampledBitmap(java.lang.String path, int targetWidth, int targetHeight) {
        return null;
    }
    
    private final java.lang.String string(int resourceId) {
        return null;
    }
}
package com.skolka.expensetracker.services.ocr;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/skolka/expensetracker/services/ocr/ReceiptParser;", "", "()V", "amountPattern", "Lkotlin/text/Regex;", "datePatterns", "", "normalizeAmount", "", "value", "", "(Ljava/lang/String;)Ljava/lang/Double;", "parse", "Lcom/skolka/expensetracker/services/ocr/ReceiptOcrResult;", "text", "parseDate", "app_release"})
public final class ReceiptParser {
    @org.jetbrains.annotations.NotNull
    private static final kotlin.text.Regex amountPattern = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<kotlin.text.Regex> datePatterns = null;
    @org.jetbrains.annotations.NotNull
    public static final com.skolka.expensetracker.services.ocr.ReceiptParser INSTANCE = null;
    
    private ReceiptParser() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.services.ocr.ReceiptOcrResult parse(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
        return null;
    }
    
    private final java.lang.Double normalizeAmount(java.lang.String value) {
        return null;
    }
    
    private final java.lang.String parseDate(java.lang.String text) {
        return null;
    }
}
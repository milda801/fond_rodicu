package com.skolka.expensetracker.services.ocr;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010 \u001a\u00020\bH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\bH\u0002J\u001d\u0010#\u001a\u0004\u0018\u00010\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u00a2\u0006\u0002\u0010%J\u0018\u0010&\u001a\u0004\u0018\u00010\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002JV\u0010\'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004J\u0018\u0010.\u001a\u0004\u0018\u00010\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\bH\u0002J\u001d\u00100\u001a\u0004\u0018\u00010\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u0004H\u0002\u00a2\u0006\u0002\u0010%J\u0018\u00101\u001a\u0004\u0018\u00010\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u0004H\u0002J\u0018\u00102\u001a\u0004\u0018\u00010\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u0004H\u0002J)\u00103\u001a\u0004\u0018\u00010\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004\u00a2\u0006\u0002\u00104R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/skolka/expensetracker/services/ocr/ReceiptParser;", "", "()V", "datePatterns", "", "Lkotlin/text/Regex;", "decimalAmountPattern", "formLabels", "", "standaloneReceiptNumberPattern", "totalAmountPattern", "bestMatchingNameIndex", "", "extractedName", "candidates", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/Integer;", "containsDigitsInOrder", "", "value", "expected", "extractShortNumber", "line", "isProbableGenericName", "isProbablePersonName", "normalizeAmount", "", "(Ljava/lang/String;)Ljava/lang/Double;", "normalizeForMatching", "normalized", "normalized$app_release", "parse", "Lcom/skolka/expensetracker/services/ocr/ReceiptOcrResult;", "text", "parseAmountCandidates", "parseDate", "parseLabeledTotal", "lines", "(Ljava/util/List;)Ljava/lang/Double;", "parsePayerName", "parsePayment", "positionedLines", "Lcom/skolka/expensetracker/services/ocr/ReceiptTextLine;", "receiptNumberRegionTexts", "payerRegionTexts", "amountRegionTexts", "expectedAmounts", "parseReceiptNumber", "parseReceiptNumberRegion", "parseSpatialAmount", "parseSpatialPayerName", "parseSpatialReceiptNumber", "selectPaymentAmount", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Double;", "app_release"})
public final class ReceiptParser {
    @org.jetbrains.annotations.NotNull
    private static final kotlin.text.Regex decimalAmountPattern = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.text.Regex totalAmountPattern = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<kotlin.text.Regex> datePatterns = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.text.Regex standaloneReceiptNumberPattern = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> formLabels = null;
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
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.services.ocr.ReceiptOcrResult parsePayment(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.services.ocr.ReceiptTextLine> positionedLines, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> receiptNumberRegionTexts, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> payerRegionTexts, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> amountRegionTexts, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Double> expectedAmounts) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer bestMatchingNameIndex(@org.jetbrains.annotations.Nullable
    java.lang.String extractedName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> candidates) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String normalized$app_release(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    private final java.lang.String parseReceiptNumberRegion(java.lang.String text) {
        return null;
    }
    
    private final java.util.List<java.lang.Double> parseAmountCandidates(java.lang.String text) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double selectPaymentAmount(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Double> candidates, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Double> expectedAmounts) {
        return null;
    }
    
    private final boolean containsDigitsInOrder(java.lang.String value, java.lang.String expected) {
        return false;
    }
    
    private final java.lang.String parseSpatialReceiptNumber(java.util.List<com.skolka.expensetracker.services.ocr.ReceiptTextLine> lines) {
        return null;
    }
    
    private final java.lang.String parseSpatialPayerName(java.util.List<com.skolka.expensetracker.services.ocr.ReceiptTextLine> lines) {
        return null;
    }
    
    private final java.lang.Double parseSpatialAmount(java.util.List<com.skolka.expensetracker.services.ocr.ReceiptTextLine> lines) {
        return null;
    }
    
    private final java.lang.Double parseLabeledTotal(java.util.List<java.lang.String> lines) {
        return null;
    }
    
    private final java.lang.String parsePayerName(java.util.List<java.lang.String> lines) {
        return null;
    }
    
    private final java.lang.String parseReceiptNumber(java.util.List<java.lang.String> lines) {
        return null;
    }
    
    private final java.lang.String extractShortNumber(java.lang.String line) {
        return null;
    }
    
    private final boolean isProbablePersonName(java.lang.String line) {
        return false;
    }
    
    private final boolean isProbableGenericName(java.lang.String line) {
        return false;
    }
    
    private final java.lang.String normalizeForMatching(java.lang.String value) {
        return null;
    }
    
    private final java.lang.Double normalizeAmount(java.lang.String value) {
        return null;
    }
    
    private final java.lang.String parseDate(java.lang.String text) {
        return null;
    }
}
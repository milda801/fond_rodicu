package com.skolka.expensetracker.services.ocr;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J)\u0010$\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\'\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00172\u0006\u0010*\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/skolka/expensetracker/services/ocr/OcrService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "close", "", "cropAndEnhance", "Landroid/graphics/Bitmap;", "source", "region", "Landroid/graphics/Rect;", "contrast", "", "isolateBlueInk", "loadOrientedBitmap", "uri", "Landroid/net/Uri;", "paymentRegions", "Lcom/skolka/expensetracker/services/ocr/OcrService$PaymentRegions;", "lines", "", "Lcom/skolka/expensetracker/services/ocr/ReceiptTextLine;", "width", "", "height", "process", "Lcom/google/mlkit/vision/text/Text;", "image", "Lcom/google/mlkit/vision/common/InputImage;", "(Lcom/google/mlkit/vision/common/InputImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognize", "Lcom/skolka/expensetracker/services/ocr/ReceiptOcrResult;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizePayment", "expectedAmounts", "", "(Landroid/net/Uri;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeRegionVariants", "", "bitmap", "(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PaymentRegions", "app_release"})
public final class OcrService {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.mlkit.vision.text.TextRecognizer recognizer = null;
    
    public OcrService(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recognize(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.services.ocr.ReceiptOcrResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recognizePayment(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Double> expectedAmounts, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.services.ocr.ReceiptOcrResult> $completion) {
        return null;
    }
    
    private final java.lang.Object process(com.google.mlkit.vision.common.InputImage image, kotlin.coroutines.Continuation<? super com.google.mlkit.vision.text.Text> $completion) {
        return null;
    }
    
    private final java.lang.Object recognizeRegionVariants(android.graphics.Bitmap bitmap, android.graphics.Rect region, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    private final android.graphics.Bitmap loadOrientedBitmap(android.net.Uri uri) {
        return null;
    }
    
    private final com.skolka.expensetracker.services.ocr.OcrService.PaymentRegions paymentRegions(java.util.List<com.skolka.expensetracker.services.ocr.ReceiptTextLine> lines, int width, int height) {
        return null;
    }
    
    private final android.graphics.Bitmap cropAndEnhance(android.graphics.Bitmap source, android.graphics.Rect region, float contrast) {
        return null;
    }
    
    private final android.graphics.Bitmap isolateBlueInk(android.graphics.Bitmap source, android.graphics.Rect region) {
        return null;
    }
    
    public final void close() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/skolka/expensetracker/services/ocr/OcrService$PaymentRegions;", "", "number", "Landroid/graphics/Rect;", "payer", "amount", "(Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Rect;)V", "getAmount", "()Landroid/graphics/Rect;", "getNumber", "getPayer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"})
    static final class PaymentRegions {
        @org.jetbrains.annotations.NotNull
        private final android.graphics.Rect number = null;
        @org.jetbrains.annotations.NotNull
        private final android.graphics.Rect payer = null;
        @org.jetbrains.annotations.NotNull
        private final android.graphics.Rect amount = null;
        
        public PaymentRegions(@org.jetbrains.annotations.NotNull
        android.graphics.Rect number, @org.jetbrains.annotations.NotNull
        android.graphics.Rect payer, @org.jetbrains.annotations.NotNull
        android.graphics.Rect amount) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect getNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect getPayer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect getAmount() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.graphics.Rect component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.skolka.expensetracker.services.ocr.OcrService.PaymentRegions copy(@org.jetbrains.annotations.NotNull
        android.graphics.Rect number, @org.jetbrains.annotations.NotNull
        android.graphics.Rect payer, @org.jetbrains.annotations.NotNull
        android.graphics.Rect amount) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}
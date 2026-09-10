package com.skolka.expensetracker.services.ocr;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/skolka/expensetracker/services/ocr/OcrService;", "", "()V", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "close", "", "recognize", "Lcom/skolka/expensetracker/services/ocr/ReceiptOcrResult;", "uri", "Landroid/net/Uri;", "imageFactory", "Lkotlin/Function1;", "Lcom/google/mlkit/vision/common/InputImage;", "(Landroid/net/Uri;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class OcrService {
    @org.jetbrains.annotations.NotNull
    private final com.google.mlkit.vision.text.TextRecognizer recognizer = null;
    
    public OcrService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recognize(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, ? extends com.google.mlkit.vision.common.InputImage> imageFactory, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.services.ocr.ReceiptOcrResult> $completion) {
        return null;
    }
    
    public final void close() {
    }
}
package com.skolka.expensetracker.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\t\u0010)\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00a2\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020:H\u00d6\u0001J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/skolka/expensetracker/data/models/Payment;", "", "id", "", "childId", "feeConfigId", "amount", "", "paymentDate", "paymentType", "receiptPath", "receiptNumber", "ocrExtractedName", "ocrExtractedAmount", "manualEntry", "", "notes", "createdAt", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()D", "getChildId", "()Ljava/lang/String;", "getCreatedAt", "getFeeConfigId", "getId", "getManualEntry", "()Z", "getNotes", "getOcrExtractedAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getOcrExtractedName", "getPaymentDate", "getPaymentType", "getReceiptNumber", "getReceiptPath", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/skolka/expensetracker/data/models/Payment;", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "payments", foreignKeys = {@androidx.room.ForeignKey(entity = com.skolka.expensetracker.data.models.Child.class, parentColumns = {"id"}, childColumns = {"childId"}, onDelete = 5), @androidx.room.ForeignKey(entity = com.skolka.expensetracker.data.models.FeeConfiguration.class, parentColumns = {"id"}, childColumns = {"feeConfigId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"childId"}), @androidx.room.Index(value = {"feeConfigId"})})
public final class Payment {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String childId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String feeConfigId = null;
    private final double amount = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String paymentDate = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String paymentType = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String receiptPath = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String receiptNumber = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ocrExtractedName = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double ocrExtractedAmount = null;
    private final boolean manualEntry = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String notes = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String updatedAt = null;
    
    public Payment(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, double amount, @org.jetbrains.annotations.NotNull
    java.lang.String paymentDate, @org.jetbrains.annotations.NotNull
    java.lang.String paymentType, @org.jetbrains.annotations.Nullable
    java.lang.String receiptPath, @org.jetbrains.annotations.NotNull
    java.lang.String receiptNumber, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedName, @org.jetbrains.annotations.Nullable
    java.lang.Double ocrExtractedAmount, boolean manualEntry, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull
    java.lang.String updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChildId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFeeConfigId() {
        return null;
    }
    
    public final double getAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPaymentDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPaymentType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReceiptPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReceiptNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOcrExtractedName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getOcrExtractedAmount() {
        return null;
    }
    
    public final boolean getManualEntry() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.models.Payment copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String childId, @org.jetbrains.annotations.NotNull
    java.lang.String feeConfigId, double amount, @org.jetbrains.annotations.NotNull
    java.lang.String paymentDate, @org.jetbrains.annotations.NotNull
    java.lang.String paymentType, @org.jetbrains.annotations.Nullable
    java.lang.String receiptPath, @org.jetbrains.annotations.NotNull
    java.lang.String receiptNumber, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedName, @org.jetbrains.annotations.Nullable
    java.lang.Double ocrExtractedAmount, boolean manualEntry, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull
    java.lang.String updatedAt) {
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
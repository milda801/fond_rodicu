package com.skolka.expensetracker.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u009a\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u000207H\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016\u00a8\u00069"}, d2 = {"Lcom/skolka/expensetracker/data/models/Expense;", "", "id", "", "expenseDate", "category", "description", "amount", "", "receiptPath", "ocrExtractedVendor", "ocrExtractedAmount", "ocrExtractedDate", "manualEntry", "", "notes", "createdAt", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()D", "getCategory", "()Ljava/lang/String;", "getCreatedAt", "getDescription", "getExpenseDate", "getId", "getManualEntry", "()Z", "getNotes", "getOcrExtractedAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getOcrExtractedDate", "getOcrExtractedVendor", "getReceiptPath", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/skolka/expensetracker/data/models/Expense;", "equals", "other", "hashCode", "", "toString", "app_release"})
@androidx.room.Entity(tableName = "expenses")
public final class Expense {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String expenseDate = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final double amount = 0.0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String receiptPath = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ocrExtractedVendor = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Double ocrExtractedAmount = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String ocrExtractedDate = null;
    private final boolean manualEntry = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String notes = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String updatedAt = null;
    
    public Expense(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String expenseDate, @org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    java.lang.String description, double amount, @org.jetbrains.annotations.Nullable
    java.lang.String receiptPath, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedVendor, @org.jetbrains.annotations.Nullable
    java.lang.Double ocrExtractedAmount, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedDate, boolean manualEntry, @org.jetbrains.annotations.Nullable
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
    public final java.lang.String getExpenseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final double getAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReceiptPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOcrExtractedVendor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double getOcrExtractedAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOcrExtractedDate() {
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
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.data.models.Expense copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String expenseDate, @org.jetbrains.annotations.NotNull
    java.lang.String category, @org.jetbrains.annotations.NotNull
    java.lang.String description, double amount, @org.jetbrains.annotations.Nullable
    java.lang.String receiptPath, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedVendor, @org.jetbrains.annotations.Nullable
    java.lang.Double ocrExtractedAmount, @org.jetbrains.annotations.Nullable
    java.lang.String ocrExtractedDate, boolean manualEntry, @org.jetbrains.annotations.Nullable
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
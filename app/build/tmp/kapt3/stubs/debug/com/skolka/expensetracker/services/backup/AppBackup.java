package com.skolka.expensetracker.services.backup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u00c6\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001J\t\u0010(\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006)"}, d2 = {"Lcom/skolka/expensetracker/services/backup/AppBackup;", "", "formatVersion", "", "createdAt", "", "children", "", "Lcom/skolka/expensetracker/data/models/Child;", "feeConfigurations", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "payments", "Lcom/skolka/expensetracker/data/models/Payment;", "expenses", "Lcom/skolka/expensetracker/data/models/Expense;", "receipts", "Lcom/skolka/expensetracker/services/backup/ReceiptBackup;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getCreatedAt", "()Ljava/lang/String;", "getExpenses", "getFeeConfigurations", "getFormatVersion", "()I", "getPayments", "getReceipts", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AppBackup {
    private final int formatVersion = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Child> children = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration> feeConfigurations = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Payment> payments = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Expense> expenses = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.services.backup.ReceiptBackup> receipts = null;
    
    public AppBackup(int formatVersion, @org.jetbrains.annotations.NotNull
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration> feeConfigurations, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Expense> expenses, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.services.backup.ReceiptBackup> receipts) {
        super();
    }
    
    public final int getFormatVersion() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Child> getChildren() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration> getFeeConfigurations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Payment> getPayments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Expense> getExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.services.backup.ReceiptBackup> getReceipts() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Child> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Payment> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Expense> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.services.backup.ReceiptBackup> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.services.backup.AppBackup copy(int formatVersion, @org.jetbrains.annotations.NotNull
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.FeeConfiguration> feeConfigurations, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Expense> expenses, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.services.backup.ReceiptBackup> receipts) {
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
package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\u0002\u0010\u0013J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010%\u001a\u00020\fH\u00c6\u0003J\t\u0010&\u001a\u00020\fH\u00c6\u0003J\t\u0010\'\u001a\u00020\fH\u00c6\u0003J\t\u0010(\u001a\u00020\fH\u00c6\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011H\u00c6\u0003J\u0083\u0001\u0010*\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011H\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/ReportData;", "", "children", "", "Lcom/skolka/expensetracker/data/models/Child;", "payments", "Lcom/skolka/expensetracker/data/models/Payment;", "expenses", "Lcom/skolka/expensetracker/data/models/Expense;", "feeConfig", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "totalExpected", "", "totalCollected", "totalExpenses", "balance", "expensesByCategory", "", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/skolka/expensetracker/data/models/FeeConfiguration;DDDDLjava/util/Map;)V", "getBalance", "()D", "getChildren", "()Ljava/util/List;", "getExpenses", "getExpensesByCategory", "()Ljava/util/Map;", "getFeeConfig", "()Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "getPayments", "getTotalCollected", "getTotalExpected", "getTotalExpenses", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class ReportData {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Child> children = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Payment> payments = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Expense> expenses = null;
    @org.jetbrains.annotations.Nullable
    private final com.skolka.expensetracker.data.models.FeeConfiguration feeConfig = null;
    private final double totalExpected = 0.0;
    private final double totalCollected = 0.0;
    private final double totalExpenses = 0.0;
    private final double balance = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.Double> expensesByCategory = null;
    
    public ReportData(@org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Expense> expenses, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfig, double totalExpected, double totalCollected, double totalExpenses, double balance, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Double> expensesByCategory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Child> getChildren() {
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
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration getFeeConfig() {
        return null;
    }
    
    public final double getTotalExpected() {
        return 0.0;
    }
    
    public final double getTotalCollected() {
        return 0.0;
    }
    
    public final double getTotalExpenses() {
        return 0.0;
    }
    
    public final double getBalance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Double> getExpensesByCategory() {
        return null;
    }
    
    public ReportData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Child> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Payment> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.skolka.expensetracker.data.models.Expense> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Double> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.ui.viewmodel.ReportData copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Expense> expenses, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfig, double totalExpected, double totalCollected, double totalExpenses, double balance, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Double> expensesByCategory) {
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
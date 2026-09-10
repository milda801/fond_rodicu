package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\t\u0010#\u001a\u00020\bH\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\t\u0010\'\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003Js\u0010)\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00c6\u0001J\u0013\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014\u00a8\u0006/"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/DashboardState;", "", "children", "", "Lcom/skolka/expensetracker/data/models/Child;", "payments", "Lcom/skolka/expensetracker/data/models/Payment;", "totalExpenses", "", "totalCollected", "totalExpected", "balance", "feeConfig", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "isLoading", "", "error", "", "(Ljava/util/List;Ljava/util/List;DDDDLcom/skolka/expensetracker/data/models/FeeConfiguration;ZLjava/lang/String;)V", "getBalance", "()D", "getChildren", "()Ljava/util/List;", "getError", "()Ljava/lang/String;", "getFeeConfig", "()Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "()Z", "getPayments", "getTotalCollected", "getTotalExpected", "getTotalExpenses", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class DashboardState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Child> children = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.skolka.expensetracker.data.models.Payment> payments = null;
    private final double totalExpenses = 0.0;
    private final double totalCollected = 0.0;
    private final double totalExpected = 0.0;
    private final double balance = 0.0;
    @org.jetbrains.annotations.Nullable
    private final com.skolka.expensetracker.data.models.FeeConfiguration feeConfig = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    
    public DashboardState(@org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, double totalExpenses, double totalCollected, double totalExpected, double balance, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfig, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
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
    
    public final double getTotalExpenses() {
        return 0.0;
    }
    
    public final double getTotalCollected() {
        return 0.0;
    }
    
    public final double getTotalExpected() {
        return 0.0;
    }
    
    public final double getBalance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration getFeeConfig() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    public DashboardState() {
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
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.ui.viewmodel.DashboardState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Child> children, @org.jetbrains.annotations.NotNull
    java.util.List<com.skolka.expensetracker.data.models.Payment> payments, double totalExpenses, double totalCollected, double totalExpected, double balance, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfig, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
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
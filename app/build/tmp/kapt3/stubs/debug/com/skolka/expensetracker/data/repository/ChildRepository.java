package com.skolka.expensetracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000fJ\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000fJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/skolka/expensetracker/data/repository/ChildRepository;", "", "childDao", "Lcom/skolka/expensetracker/data/dao/ChildDao;", "(Lcom/skolka/expensetracker/data/dao/ChildDao;)V", "deleteChild", "", "child", "Lcom/skolka/expensetracker/data/models/Child;", "(Lcom/skolka/expensetracker/data/models/Child;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChildById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveChildrenCount", "Lkotlinx/coroutines/flow/Flow;", "", "getAllActiveChildren", "", "getAllChildren", "getChildById", "insertChild", "updateChild", "app_debug"})
public final class ChildRepository {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.dao.ChildDao childDao = null;
    
    public ChildRepository(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.dao.ChildDao childDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertChild(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateChild(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteChild(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getChildById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.skolka.expensetracker.data.models.Child> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Child>> getAllActiveChildren() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.skolka.expensetracker.data.models.Child>> getAllChildren() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getActiveChildrenCount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteChildById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
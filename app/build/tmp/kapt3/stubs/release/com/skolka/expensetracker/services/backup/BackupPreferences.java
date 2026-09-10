package com.skolka.expensetracker.services.backup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/skolka/expensetracker/services/backup/BackupPreferences;", "", "()V", "FILE", "", "LAST_ERROR", "LAST_SUCCESS", "URI", "clear", "", "context", "Landroid/content/Context;", "getUri", "Landroid/net/Uri;", "lastError", "lastSuccess", "saveError", "message", "saveSuccess", "timestamp", "saveUri", "uri", "app_release"})
public final class BackupPreferences {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FILE = "backup_preferences";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String URI = "automatic_backup_uri";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String LAST_SUCCESS = "last_backup_success";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String LAST_ERROR = "last_backup_error";
    @org.jetbrains.annotations.NotNull
    public static final com.skolka.expensetracker.services.backup.BackupPreferences INSTANCE = null;
    
    private BackupPreferences() {
        super();
    }
    
    public final void saveUri(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getUri(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void saveSuccess(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String timestamp) {
    }
    
    public final void saveError(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String lastSuccess(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String lastError(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}
package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\fH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\fH\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0083\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\fH\u00c6\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00061"}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/SettingsUiState;", "", "feeConfiguration", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "syncMetadata", "Lcom/skolka/expensetracker/data/models/SyncMetadata;", "cloudProvider", "", "lastBackupTime", "emailRecipients", "emailFrequency", "autoEmailEnabled", "", "isLoading", "error", "successMessage", "backupInProgress", "(Lcom/skolka/expensetracker/data/models/FeeConfiguration;Lcom/skolka/expensetracker/data/models/SyncMetadata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Z)V", "getAutoEmailEnabled", "()Z", "getBackupInProgress", "getCloudProvider", "()Ljava/lang/String;", "getEmailFrequency", "getEmailRecipients", "getError", "getFeeConfiguration", "()Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "getLastBackupTime", "getSuccessMessage", "getSyncMetadata", "()Lcom/skolka/expensetracker/data/models/SyncMetadata;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SettingsUiState {
    @org.jetbrains.annotations.Nullable
    private final com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration = null;
    @org.jetbrains.annotations.Nullable
    private final com.skolka.expensetracker.data.models.SyncMetadata syncMetadata = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String cloudProvider = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String lastBackupTime = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String emailRecipients = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String emailFrequency = null;
    private final boolean autoEmailEnabled = false;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String successMessage = null;
    private final boolean backupInProgress = false;
    
    public SettingsUiState(@org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.SyncMetadata syncMetadata, @org.jetbrains.annotations.Nullable
    java.lang.String cloudProvider, @org.jetbrains.annotations.Nullable
    java.lang.String lastBackupTime, @org.jetbrains.annotations.NotNull
    java.lang.String emailRecipients, @org.jetbrains.annotations.NotNull
    java.lang.String emailFrequency, boolean autoEmailEnabled, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.String successMessage, boolean backupInProgress) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration getFeeConfiguration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.SyncMetadata getSyncMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCloudProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLastBackupTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmailRecipients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmailFrequency() {
        return null;
    }
    
    public final boolean getAutoEmailEnabled() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSuccessMessage() {
        return null;
    }
    
    public final boolean getBackupInProgress() {
        return false;
    }
    
    public SettingsUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.FeeConfiguration component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.skolka.expensetracker.data.models.SyncMetadata component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.skolka.expensetracker.ui.viewmodel.SettingsUiState copy(@org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration, @org.jetbrains.annotations.Nullable
    com.skolka.expensetracker.data.models.SyncMetadata syncMetadata, @org.jetbrains.annotations.Nullable
    java.lang.String cloudProvider, @org.jetbrains.annotations.Nullable
    java.lang.String lastBackupTime, @org.jetbrains.annotations.NotNull
    java.lang.String emailRecipients, @org.jetbrains.annotations.NotNull
    java.lang.String emailFrequency, boolean autoEmailEnabled, boolean isLoading, @org.jetbrains.annotations.Nullable
    java.lang.String error, @org.jetbrains.annotations.Nullable
    java.lang.String successMessage, boolean backupInProgress) {
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
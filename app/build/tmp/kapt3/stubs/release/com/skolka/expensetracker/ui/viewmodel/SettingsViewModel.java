package com.skolka.expensetracker.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/skolka/expensetracker/ui/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "feeConfigRepository", "Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;", "syncMetadataRepository", "Lcom/skolka/expensetracker/data/repository/SyncMetadataRepository;", "(Lcom/skolka/expensetracker/data/repository/FeeConfigurationRepository;Lcom/skolka/expensetracker/data/repository/SyncMetadataRepository;)V", "_settingsUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/skolka/expensetracker/ui/viewmodel/SettingsUiState;", "settingsUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getSettingsUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearMessages", "", "loadSettings", "performManualBackup", "saveEmailSettings", "setAutoEmailEnabled", "enabled", "", "setCloudProvider", "provider", "", "setEmailFrequency", "frequency", "setEmailRecipients", "recipients", "updateFeeConfiguration", "feeConfiguration", "Lcom/skolka/expensetracker/data/models/FeeConfiguration;", "app_release"})
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.skolka.expensetracker.data.repository.SyncMetadataRepository syncMetadataRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.skolka.expensetracker.ui.viewmodel.SettingsUiState> _settingsUiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.SettingsUiState> settingsUiState = null;
    
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.FeeConfigurationRepository feeConfigRepository, @org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.repository.SyncMetadataRepository syncMetadataRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.skolka.expensetracker.ui.viewmodel.SettingsUiState> getSettingsUiState() {
        return null;
    }
    
    private final void loadSettings() {
    }
    
    public final void updateFeeConfiguration(@org.jetbrains.annotations.NotNull
    com.skolka.expensetracker.data.models.FeeConfiguration feeConfiguration) {
    }
    
    public final void setCloudProvider(@org.jetbrains.annotations.NotNull
    java.lang.String provider) {
    }
    
    public final void setEmailRecipients(@org.jetbrains.annotations.NotNull
    java.lang.String recipients) {
    }
    
    public final void setEmailFrequency(@org.jetbrains.annotations.NotNull
    java.lang.String frequency) {
    }
    
    public final void setAutoEmailEnabled(boolean enabled) {
    }
    
    public final void performManualBackup() {
    }
    
    public final void saveEmailSettings() {
    }
    
    public final void clearMessages() {
    }
}
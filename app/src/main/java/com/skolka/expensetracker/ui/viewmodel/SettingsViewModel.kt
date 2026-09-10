package com.skolka.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.SyncMetadata
import com.skolka.expensetracker.data.repository.FeeConfigurationRepository
import com.skolka.expensetracker.data.repository.SyncMetadataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class SettingsUiState(
    val feeConfiguration: FeeConfiguration? = null,
    val syncMetadata: SyncMetadata? = null,
    val cloudProvider: String? = null,
    val lastBackupTime: String? = null,
    val emailRecipients: String = "",
    val emailFrequency: String = "weekly", // weekly, monthly
    val autoEmailEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null,
    val backupInProgress: Boolean = false
)

class SettingsViewModel(
    private val feeConfigRepository: FeeConfigurationRepository,
    private val syncMetadataRepository: SyncMetadataRepository
) : ViewModel() {
    
    private val _settingsUiState = MutableStateFlow(SettingsUiState())
    val settingsUiState: StateFlow<SettingsUiState> = _settingsUiState
    
    init {
        loadSettings()
    }
    
    private fun loadSettings() {
        viewModelScope.launch {
            try {
                _settingsUiState.value = _settingsUiState.value.copy(isLoading = true)
                
                val feeConfig = feeConfigRepository.getLatestFeeConfig()
                
                syncMetadataRepository.getSyncMetadata().collect { syncMetadata ->
                    _settingsUiState.value = _settingsUiState.value.copy(
                        feeConfiguration = feeConfig,
                        syncMetadata = syncMetadata,
                        cloudProvider = syncMetadata?.cloudProvider,
                        lastBackupTime = syncMetadata?.lastBackupTime,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _settingsUiState.value = _settingsUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load settings"
                )
            }
        }
    }
    
    fun updateFeeConfiguration(feeConfiguration: FeeConfiguration) {
        viewModelScope.launch {
            try {
                _settingsUiState.value = _settingsUiState.value.copy(isLoading = true)
                feeConfigRepository.insertFeeConfiguration(feeConfiguration)
                _settingsUiState.value = _settingsUiState.value.copy(
                    feeConfiguration = feeConfiguration,
                    isLoading = false,
                    successMessage = "Fee configuration updated successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _settingsUiState.value = _settingsUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to update fee configuration"
                )
            }
        }
    }
    
    fun setCloudProvider(provider: String) {
        viewModelScope.launch {
            try {
                syncMetadataRepository.updateCloudProvider(provider)
                _settingsUiState.value = _settingsUiState.value.copy(
                    cloudProvider = provider,
                    successMessage = "Cloud provider updated to $provider"
                )
                clearMessages()
            } catch (e: Exception) {
                _settingsUiState.value = _settingsUiState.value.copy(
                    error = e.message ?: "Failed to update cloud provider"
                )
            }
        }
    }
    
    fun setEmailRecipients(recipients: String) {
        _settingsUiState.value = _settingsUiState.value.copy(emailRecipients = recipients)
    }
    
    fun setEmailFrequency(frequency: String) {
        _settingsUiState.value = _settingsUiState.value.copy(emailFrequency = frequency)
    }
    
    fun setAutoEmailEnabled(enabled: Boolean) {
        _settingsUiState.value = _settingsUiState.value.copy(autoEmailEnabled = enabled)
    }
    
    fun performManualBackup() {
        viewModelScope.launch {
            try {
                _settingsUiState.value = _settingsUiState.value.copy(backupInProgress = true)
                
                // Simulate backup operation
                kotlinx.coroutines.delay(2000)
                
                val currentTime = System.currentTimeMillis().toString()
                syncMetadataRepository.updateLastBackupTime(currentTime)
                
                _settingsUiState.value = _settingsUiState.value.copy(
                    backupInProgress = false,
                    lastBackupTime = currentTime,
                    successMessage = "Backup completed successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _settingsUiState.value = _settingsUiState.value.copy(
                    backupInProgress = false,
                    error = e.message ?: "Backup failed"
                )
            }
        }
    }
    
    fun saveEmailSettings() {
        viewModelScope.launch {
            try {
                _settingsUiState.value = _settingsUiState.value.copy(isLoading = true)
                
                // Save email settings (would be persisted in SharedPreferences or database)
                _settingsUiState.value = _settingsUiState.value.copy(
                    isLoading = false,
                    successMessage = "Email settings saved successfully"
                )
                clearMessages()
            } catch (e: Exception) {
                _settingsUiState.value = _settingsUiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to save email settings"
                )
            }
        }
    }
    
    fun clearMessages() {
        viewModelScope.launch {
            kotlinx.coroutines.delay(3000)
            _settingsUiState.value = _settingsUiState.value.copy(
                successMessage = null,
                error = null
            )
        }
    }
}

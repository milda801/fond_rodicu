package com.skolka.expensetracker.ui.settings

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.R
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.services.backup.BackupService
import com.skolka.expensetracker.services.backup.BackupPreferences
import com.skolka.expensetracker.services.backup.BackupScheduler
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.io.File
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class SettingsFragment : Fragment() {
    private var pendingBackupJson: String? = null
    private val createBackupDocument = registerForActivityResult(
        ActivityResultContracts.CreateDocument("application/json")
    ) { uri: Uri? ->
        val json = pendingBackupJson
        if (uri != null && json != null) {
            requireContext().contentResolver.openOutputStream(uri)?.bufferedWriter()?.use { it.write(json) }
            runCatching {
                requireContext().contentResolver.takePersistableUriPermission(
                    uri,
                    android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION or android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
            }
            BackupPreferences.saveUri(requireContext(), uri)
            BackupPreferences.saveSuccess(requireContext(), java.time.Instant.now().toString())
            BackupScheduler.schedule(requireContext())
            updateBackupStatus(requireView())
            Toast.makeText(requireContext(), R.string.backup_saved, Toast.LENGTH_SHORT).show()
        }
        pendingBackupJson = null
    }
    private val openBackupDocument = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri ?: return@registerForActivityResult
        val app = requireActivity().application as ExpenseTrackerApplication
        viewLifecycleOwner.lifecycleScope.launch {
            val result = runCatching {
                val json = requireContext().contentResolver.openInputStream(uri)?.bufferedReader()?.use { it.readText() }
                    ?: error(getString(R.string.backup_read_error))
                BackupService(app.childRepository, app.feeRepository, app.paymentRepository, app.expenseRepository, File(requireContext().filesDir, "receipts")).restoreJson(json)
            }
            Toast.makeText(
                requireContext(),
                if (result.isSuccess) getString(R.string.backup_restored) else result.exceptionOrNull()?.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        configureLanguageSelector(view)
        view.findViewById<View>(R.id.saveFeeButton).setOnClickListener {
            val year = view.findViewById<EditText>(R.id.academicYearInput).text.toString().trim()
            val amount = view.findViewById<EditText>(R.id.yearlyFeeInput).text.toString().toDoubleOrNull()
            val splitEnabled = view.findViewById<MaterialSwitch>(R.id.splitFeeSwitch).isChecked
            val firstDue = view.findViewById<EditText>(R.id.firstHalfDueDateInput).text.toString().trim()
            val secondDue = view.findViewById<EditText>(R.id.secondHalfDueDateInput).text.toString().trim()
            val validAcademicYear = Regex("\\d{4}-\\d{4}").matches(year) && runCatching {
                year.substring(5).toInt() == year.substring(0, 4).toInt() + 1
            }.getOrDefault(false)
            val validDates = !splitEnabled || runCatching {
                val first = LocalDate.parse(firstDue)
                val second = LocalDate.parse(secondDue)
                !second.isBefore(first)
            }.getOrDefault(false)
            if (!validAcademicYear || amount == null || amount <= 0 || !validDates) {
                Toast.makeText(requireContext(), if (!validAcademicYear) R.string.invalid_academic_year else R.string.invalid_fee_settings, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val app = requireActivity().application as ExpenseTrackerApplication
            viewLifecycleOwner.lifecycleScope.launch {
                app.feeRepository.insertFeeConfiguration(
                    FeeConfiguration(
                        academicYear = year,
                        yearlyFeeAmount = amount,
                        splitOption = if (splitEnabled) "two_halves" else "full_year",
                        firstHalfDueDate = firstDue.takeIf { splitEnabled },
                        secondHalfDueDate = secondDue.takeIf { splitEnabled }
                    )
                )
                Toast.makeText(requireContext(), R.string.save, Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<View>(R.id.backupButton).setOnClickListener {
            val app = requireActivity().application as ExpenseTrackerApplication
            viewLifecycleOwner.lifecycleScope.launch {
                pendingBackupJson = BackupService(app.childRepository, app.feeRepository, app.paymentRepository, app.expenseRepository, File(requireContext().filesDir, "receipts")).createJson()
                createBackupDocument.launch("kindergarten-backup-${LocalDate.now()}.json")
            }
        }
        view.findViewById<View>(R.id.restoreButton).setOnClickListener {
            openBackupDocument.launch(arrayOf("application/json", "text/plain"))
        }
        view.findViewById<View>(R.id.disableBackupButton).setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.disable_automatic_backup)
                .setMessage(R.string.disable_backup_confirmation)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(R.string.disable_automatic_backup) { _, _ ->
                    BackupPreferences.getUri(requireContext())?.let { uri ->
                        runCatching {
                            requireContext().contentResolver.releasePersistableUriPermission(
                                uri,
                                android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION or android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                            )
                        }
                    }
                    BackupScheduler.cancel(requireContext())
                    BackupPreferences.clear(requireContext())
                    updateBackupStatus(view)
                }.show()
        }
        val app = requireActivity().application as ExpenseTrackerApplication
        viewLifecycleOwner.lifecycleScope.launch {
            app.feeRepository.getLatestFeeConfig()?.let { fee ->
                view.findViewById<EditText>(R.id.academicYearInput).setText(fee.academicYear)
                view.findViewById<EditText>(R.id.yearlyFeeInput).setText(fee.yearlyFeeAmount.toString())
                view.findViewById<MaterialSwitch>(R.id.splitFeeSwitch).isChecked = fee.splitOption == "two_halves"
                view.findViewById<EditText>(R.id.firstHalfDueDateInput).setText(fee.firstHalfDueDate.orEmpty())
                view.findViewById<EditText>(R.id.secondHalfDueDateInput).setText(fee.secondHalfDueDate.orEmpty())
            }
        }
        val splitSwitch = view.findViewById<MaterialSwitch>(R.id.splitFeeSwitch)
        fun updateDueDateAvailability() {
            view.findViewById<EditText>(R.id.firstHalfDueDateInput).isEnabled = splitSwitch.isChecked
            view.findViewById<EditText>(R.id.secondHalfDueDateInput).isEnabled = splitSwitch.isChecked
        }
        splitSwitch.setOnCheckedChangeListener { _, _ -> updateDueDateAvailability() }
        updateDueDateAvailability()
        updateBackupStatus(view)
    }

    private fun configureLanguageSelector(view: View) {
        val languageInput = view.findViewById<MaterialAutoCompleteTextView>(R.id.languageInput)
        val languageLabels = resources.getStringArray(R.array.language_options)
        languageInput.setSimpleItems(languageLabels)

        val currentTag = AppCompatDelegate.getApplicationLocales().toLanguageTags()
            .substringBefore(',')
            .ifBlank { resources.configuration.locales[0].language }
        languageInput.setText(
            languageLabels[if (currentTag.startsWith("cs")) 1 else 0],
            false
        )
        languageInput.setOnItemClickListener { _, _, position, _ ->
            val selectedTag = if (position == 1) "cs" else "en"
            if (!currentTag.startsWith(selectedTag)) {
                AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(selectedTag))
            }
        }
    }

    private fun updateBackupStatus(view: View) {
        val uri = BackupPreferences.getUri(requireContext())
        val success = BackupPreferences.lastSuccess(requireContext())
        val error = BackupPreferences.lastError(requireContext())
        view.findViewById<TextView>(R.id.backupStatusText).text = buildString {
            append(if (uri == null) getString(R.string.automatic_backup_not_configured) else getString(R.string.automatic_backup_configured, uri.toString()))
            success?.let { append("\n").append(getString(R.string.last_backup_success, it)) }
            error?.let { append("\n").append(getString(R.string.last_backup_error, it)) }
        }
        view.findViewById<View>(R.id.disableBackupButton).isEnabled = uri != null
    }
}

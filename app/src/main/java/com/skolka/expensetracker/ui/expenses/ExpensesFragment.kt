package com.skolka.expensetracker.ui.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.R
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.ui.viewmodel.ExpenseViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.text.NumberFormat
import com.skolka.expensetracker.services.ocr.OcrService
import com.skolka.expensetracker.services.ocr.ReceiptStorage
import android.net.Uri
import java.io.File
import android.content.DialogInterface

class ExpensesFragment : Fragment() {
    private val ocrService by lazy { OcrService(requireContext().applicationContext) }
    private var activeExpenseForm: View? = null
    private var activeReceiptPath: String? = null
    private var pendingCameraFile: File? = null
    private var pendingCameraUri: Uri? = null
    private var ocrInProgress = false
    private var editingExpense: Expense? = null
    private var originalReceiptPath: String? = null
    private val cameraCapture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            val file = pendingCameraFile
            val uri = pendingCameraUri
            if (file != null && uri != null && file.isFile && file.length() > 0L) {
                activeReceiptPath?.takeIf { it != file.absolutePath && it != originalReceiptPath }?.let { File(it).delete() }
                activeReceiptPath = file.absolutePath
                if (activeExpenseForm == null) showExpenseFormAfterPhoto() else readExpenseReceipt(uri)
            } else {
                file?.delete()
                android.widget.Toast.makeText(requireContext(), R.string.receipt_photo_required, android.widget.Toast.LENGTH_LONG).show()
            }
        } else {
            pendingCameraFile?.delete()
        }
        pendingCameraFile = null
        pendingCameraUri = null
    }
    private fun readExpenseReceipt(uri: Uri) {
        val form = activeExpenseForm ?: return
        ocrInProgress = true
        form.findViewById<TextView>(R.id.expenseOcrStatus).setText(R.string.ocr_processing)
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching { ocrService.recognize(uri) }
                .onSuccess { result ->
                    result.amount?.let { form.findViewById<EditText>(R.id.expenseAmountInput).setText(it.toString()) }
                    result.date?.let { form.findViewById<EditText>(R.id.expenseDateInput).setText(it) }
                    result.probableNameOrVendor?.let { form.findViewById<EditText>(R.id.supplierNameInput).setText(it) }
                    form.findViewById<TextView>(R.id.expenseOcrStatus).setText(
                        if (result.amount != null || result.date != null || result.probableNameOrVendor != null || result.rawText.isNotBlank()) R.string.ocr_complete else R.string.ocr_no_text
                    )
                }.onFailure {
                    form.findViewById<TextView>(R.id.expenseOcrStatus).setText(R.string.ocr_no_text)
                }
            ocrInProgress = false
        }
    }
    private val viewModel by lazy { val app = requireActivity().application as ExpenseTrackerApplication; ExpenseViewModel(app.expenseRepository) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_expenses, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        val list = view.findViewById<LinearLayout>(R.id.expenseList)
        view.findViewById<View>(R.id.addExpenseButton).setOnClickListener {
            editingExpense = null
            originalReceiptPath = null
            activeReceiptPath = null
            launchCamera()
        }
        viewLifecycleOwner.lifecycleScope.launch { viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) { viewModel.expenseUiState.collect { ui ->
            list.removeAllViews()
            list.addView(TextView(requireContext()).apply {
                setText(R.string.tap_to_edit_long_press_to_delete)
                setTextAppearance(R.style.TextAppearance_Kindergarten_BodyMedium)
                setPadding(0, 0, 0, 8)
            })
            ui.expenses.forEach { expense -> list.addView(TextView(requireContext()).apply {
                setTextAppearance(R.style.TextAppearance_Kindergarten_BodyLarge)
                text = buildString {
                    append(getString(R.string.expense_list_primary, expense.receiptNumber, expense.expenseDate, NumberFormat.getCurrencyInstance().format(expense.amount)))
                    append("\n").append(getString(R.string.expense_list_supplier, expense.supplierName.ifBlank { getString(R.string.not_available) }))
                    append("\n").append(expense.description)
                    expense.notes?.takeIf(String::isNotBlank)?.let { append("\n").append(getString(R.string.expense_list_note, it)) }
                }; setPadding(0, 16, 0, 16)
                setOnClickListener { startEditingExpense(expense) }
                setOnLongClickListener {
                    MaterialAlertDialogBuilder(requireContext()).setMessage(R.string.delete_expense).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.delete) { _, _ ->
                        expense.receiptPath?.let { File(it).delete() }
                        viewModel.deleteExpense(expense)
                    }.show(); true
                }
            }) }; if (ui.expenses.isEmpty()) list.addView(TextView(requireContext()).apply { setText(R.string.no_data) })
        } } }
    }

    private fun showExpenseFormAfterPhoto() {
        showExpenseForm(runOcr = true)
    }

    private fun startEditingExpense(expense: Expense) {
        val receiptPath = expense.receiptPath?.takeIf { File(it).isFile && File(it).length() > 0L }
        if (receiptPath == null) {
            android.widget.Toast.makeText(requireContext(), R.string.receipt_photo_required, android.widget.Toast.LENGTH_LONG).show()
            return
        }
        editingExpense = expense
        originalReceiptPath = receiptPath
        activeReceiptPath = receiptPath
        showExpenseForm(runOcr = false)
    }

    private fun showExpenseForm(runOcr: Boolean) {
        val receiptPath = activeReceiptPath ?: return
        val existing = editingExpense
        val form = layoutInflater.inflate(R.layout.dialog_expense, null)
        activeExpenseForm = form
        if (existing == null) {
            form.findViewById<EditText>(R.id.expenseDateInput).setText(LocalDate.now().toString())
        } else {
            form.findViewById<TextView>(R.id.expenseFormInstruction).setText(R.string.edit_item_instruction)
            form.findViewById<TextView>(R.id.expenseOcrStatus).setText(R.string.existing_receipt_kept)
            form.findViewById<EditText>(R.id.receiptNumberInput).setText(existing.receiptNumber)
            form.findViewById<EditText>(R.id.expenseDateInput).setText(existing.expenseDate)
            form.findViewById<EditText>(R.id.expenseAmountInput).setText(existing.amount.toString())
            form.findViewById<EditText>(R.id.supplierNameInput).setText(existing.supplierName)
            form.findViewById<EditText>(R.id.descriptionInput).setText(existing.description)
            form.findViewById<EditText>(R.id.expenseNoteInput).setText(existing.notes.orEmpty())
        }
        form.findViewById<View>(R.id.scanExpenseReceiptButton).setOnClickListener { launchCamera() }
        val dialog = MaterialAlertDialogBuilder(requireContext()).setTitle(if (existing == null) R.string.confirm_ocr_expense else R.string.edit_expense).setView(form).setNegativeButton(R.string.cancel) { _, _ ->
            deleteUnsavedReplacementReceipt()
            clearActiveForm()
        }.setPositiveButton(R.string.save, null).create()
        dialog.setOnCancelListener {
            deleteUnsavedReplacementReceipt()
            clearActiveForm()
        }
        dialog.show()
        if (runOcr) readExpenseReceipt(Uri.fromFile(File(receiptPath)))
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener saveExpense@{
            if (ocrInProgress) {
                android.widget.Toast.makeText(requireContext(), R.string.ocr_wait, android.widget.Toast.LENGTH_SHORT).show()
                return@saveExpense
            }
            val amount = form.findViewById<EditText>(R.id.expenseAmountInput).text.toString().toDoubleOrNull()
            val receiptNumber = form.findViewById<EditText>(R.id.receiptNumberInput).text.toString().trim()
            val date = form.findViewById<EditText>(R.id.expenseDateInput).text.toString().trim()
            val supplierName = form.findViewById<EditText>(R.id.supplierNameInput).text.toString().trim()
            val description = form.findViewById<EditText>(R.id.descriptionInput).text.toString().trim()
            val note = form.findViewById<EditText>(R.id.expenseNoteInput).text.toString().trim()
            val verifiedReceiptPath = activeReceiptPath?.takeIf { File(it).isFile && File(it).length() > 0L }
            if (verifiedReceiptPath == null) {
                android.widget.Toast.makeText(requireContext(), R.string.receipt_photo_required, android.widget.Toast.LENGTH_LONG).show()
                return@saveExpense
            }
            if (amount == null || amount <= 0.0 || receiptNumber.isBlank() || supplierName.isBlank() || description.isBlank() || runCatching { LocalDate.parse(date) }.isFailure) {
                android.widget.Toast.makeText(requireContext(), R.string.invalid_entry, android.widget.Toast.LENGTH_LONG).show()
                return@saveExpense
            }
            if (existing == null) {
                viewModel.addExpense(Expense(
                    receiptNumber = receiptNumber,
                    expenseDate = date,
                    category = "other",
                    supplierName = supplierName,
                    description = description,
                    amount = amount,
                    receiptPath = verifiedReceiptPath,
                    manualEntry = false,
                    notes = note.takeIf(String::isNotBlank)
                ))
                clearActiveForm()
                dialog.dismiss()
            } else {
                val oldReceipt = originalReceiptPath
                viewModel.updateExpense(existing.copy(
                    receiptNumber = receiptNumber,
                    expenseDate = date,
                    supplierName = supplierName,
                    description = description,
                    amount = amount,
                    receiptPath = verifiedReceiptPath,
                    notes = note.takeIf(String::isNotBlank),
                    updatedAt = System.currentTimeMillis().toString()
                )) {
                    oldReceipt?.takeIf { it != verifiedReceiptPath }?.let { File(it).delete() }
                    clearActiveForm()
                    dialog.dismiss()
                }
            }
        }
    }

    private fun launchCamera() {
        val (file, uri) = ReceiptStorage.newCameraTarget(requireContext())
        pendingCameraFile = file
        pendingCameraUri = uri
        cameraCapture.launch(uri)
    }

    private fun clearActiveForm() {
        activeReceiptPath = null
        activeExpenseForm = null
        ocrInProgress = false
        editingExpense = null
        originalReceiptPath = null
    }

    private fun deleteUnsavedReplacementReceipt() {
        activeReceiptPath?.takeIf { it != originalReceiptPath }?.let { File(it).delete() }
    }

    override fun onDestroy() {
        deleteUnsavedReplacementReceipt()
        pendingCameraFile?.delete()
        clearActiveForm()
        ocrService.close()
        super.onDestroy()
    }
}

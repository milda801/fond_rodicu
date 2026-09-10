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
import com.google.mlkit.vision.common.InputImage
import com.skolka.expensetracker.services.ocr.OcrService
import com.skolka.expensetracker.services.ocr.ReceiptStorage
import android.net.Uri
import java.io.File
import android.content.DialogInterface

class ExpensesFragment : Fragment() {
    private val ocrService = OcrService()
    private var activeExpenseForm: View? = null
    private var activeReceiptPath: String? = null
    private var pendingCameraFile: File? = null
    private var pendingCameraUri: Uri? = null
    private val cameraCapture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            activeReceiptPath = pendingCameraFile?.absolutePath
            pendingCameraUri?.let(::readExpenseReceipt)
        } else {
            pendingCameraFile?.delete()
        }
        pendingCameraFile = null
        pendingCameraUri = null
    }
    private val receiptPicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri ?: return@registerForActivityResult
        pendingCameraFile = null
        pendingCameraUri = null
        val stored = runCatching { ReceiptStorage.copyIntoAppStorage(requireContext(), uri) }.getOrNull() ?: return@registerForActivityResult
        activeReceiptPath = stored.absolutePath
        readExpenseReceipt(Uri.fromFile(stored))
    }

    private fun readExpenseReceipt(uri: Uri) {
        val form = activeExpenseForm ?: return
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching { ocrService.recognize(uri) { InputImage.fromFilePath(requireContext(), it) } }
                .onSuccess { result ->
                    result.amount?.let { form.findViewById<EditText>(R.id.expenseAmountInput).setText(it.toString()) }
                    result.date?.let { form.findViewById<EditText>(R.id.expenseDateInput).setText(it) }
                    result.probableNameOrVendor?.let { form.findViewById<EditText>(R.id.descriptionInput).setText(it) }
                }.onFailure { android.widget.Toast.makeText(requireContext(), it.message, android.widget.Toast.LENGTH_LONG).show() }
        }
    }
    private val viewModel by lazy { val app = requireActivity().application as ExpenseTrackerApplication; ExpenseViewModel(app.expenseRepository) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_expenses, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        val list = view.findViewById<LinearLayout>(R.id.expenseList)
        view.findViewById<View>(R.id.addExpenseButton).setOnClickListener {
            val form = layoutInflater.inflate(R.layout.dialog_expense, null)
            activeExpenseForm = form
            activeReceiptPath = null
            form.findViewById<EditText>(R.id.expenseDateInput).setText(LocalDate.now().toString())
            form.findViewById<View>(R.id.scanExpenseReceiptButton).setOnClickListener { showReceiptSource() }
            val dialog = MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.add_expense).setView(form).setNegativeButton(R.string.cancel) { _, _ ->
                activeReceiptPath?.let { File(it).delete() }
                activeReceiptPath = null
            }.setPositiveButton(R.string.save, null).create()
            dialog.setOnCancelListener {
                activeReceiptPath?.let { File(it).delete() }
                activeReceiptPath = null
            }
            dialog.show()
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener saveExpense@{
                val amount = form.findViewById<EditText>(R.id.expenseAmountInput).text.toString().toDoubleOrNull()
                val date = form.findViewById<EditText>(R.id.expenseDateInput).text.toString().trim()
                val category = form.findViewById<EditText>(R.id.categoryInput).text.toString().trim()
                val description = form.findViewById<EditText>(R.id.descriptionInput).text.toString().trim()
                if (amount == null || amount <= 0.0 || category.isBlank() || description.isBlank() || runCatching { LocalDate.parse(date) }.isFailure) {
                    android.widget.Toast.makeText(requireContext(), R.string.invalid_entry, android.widget.Toast.LENGTH_LONG).show()
                    return@saveExpense
                }
                viewModel.addExpense(Expense(expenseDate = date, category = category, description = description, amount = amount, receiptPath = activeReceiptPath, manualEntry = activeReceiptPath == null))
                activeReceiptPath = null
                dialog.dismiss()
            }
        }
        viewLifecycleOwner.lifecycleScope.launch { viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) { viewModel.expenseUiState.collect { ui ->
            list.removeAllViews(); ui.expenses.forEach { expense -> list.addView(TextView(requireContext()).apply {
                setTextAppearance(R.style.TextAppearance_Kindergarten_BodyLarge)
                text = "${expense.expenseDate}  ${expense.description}\n${NumberFormat.getCurrencyInstance().format(expense.amount)}"; setPadding(0, 16, 0, 16)
                setOnLongClickListener {
                    MaterialAlertDialogBuilder(requireContext()).setMessage(R.string.delete_expense).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.delete) { _, _ ->
                        expense.receiptPath?.let { File(it).delete() }
                        viewModel.deleteExpense(expense)
                    }.show(); true
                }
            }) }; if (ui.expenses.isEmpty()) list.addView(TextView(requireContext()).apply { setText(R.string.no_data) })
        } } }
    }

    private fun showReceiptSource() {
        MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.choose_receipt)
            .setItems(arrayOf(getString(R.string.take_photo), getString(R.string.choose_image))) { _, which ->
                if (which == 0) {
                    val (file, uri) = ReceiptStorage.newCameraTarget(requireContext())
                    pendingCameraFile = file; pendingCameraUri = uri; cameraCapture.launch(uri)
                } else receiptPicker.launch("image/*")
            }.show()
    }

    override fun onDestroy() {
        ocrService.close()
        super.onDestroy()
    }
}

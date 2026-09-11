package com.skolka.expensetracker.ui.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.R
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.ui.viewmodel.PaymentViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.text.NumberFormat
import com.skolka.expensetracker.services.ocr.OcrService
import com.skolka.expensetracker.services.ocr.ReceiptOcrResult
import com.skolka.expensetracker.services.ocr.ReceiptParser
import com.skolka.expensetracker.services.ocr.ReceiptStorage
import android.net.Uri
import java.io.File
import android.content.DialogInterface

class PaymentsFragment : Fragment() {
    private val ocrService by lazy { OcrService(requireContext().applicationContext) }
    private var activePaymentForm: View? = null
    private var activeReceiptPath: String? = null
    private var pendingCameraFile: File? = null
    private var pendingCameraUri: Uri? = null
    private var pendingFee: FeeConfiguration? = null
    private var editingPayment: Payment? = null
    private var originalReceiptPath: String? = null
    private var formChildren: List<Child> = emptyList()
    private var ocrInProgress = false
    private var activeOcrResult: ReceiptOcrResult? = null
    private val cameraCapture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            val file = pendingCameraFile
            val uri = pendingCameraUri
            if (file != null && uri != null && file.isFile && file.length() > 0L) {
                activeReceiptPath?.takeIf { it != file.absolutePath && it != originalReceiptPath }?.let { File(it).delete() }
                activeReceiptPath = file.absolutePath
                if (activePaymentForm == null) showPaymentFormAfterPhoto() else readPaymentReceipt(uri)
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
    private fun readPaymentReceipt(uri: Uri) {
        val form = activePaymentForm ?: return
        ocrInProgress = true
        form.findViewById<TextView>(R.id.paymentOcrStatus).setText(R.string.ocr_processing)
        viewLifecycleOwner.lifecycleScope.launch {
            val fee = pendingFee
            val expectedAmounts = fee?.let {
                buildList {
                    add(it.yearlyFeeAmount)
                    if (it.splitOption == "two_halves") add(it.yearlyFeeAmount / 2.0)
                }
            }.orEmpty()
            runCatching { ocrService.recognizePayment(uri, expectedAmounts) }
                .onSuccess { result ->
                    activeOcrResult = result
                    result.amount?.let { form.findViewById<EditText>(R.id.paymentAmountInput).setText(it.toString()) }
                    result.date?.let { form.findViewById<EditText>(R.id.paymentDateInput).setText(it) }
                    result.receiptNumber?.let { form.findViewById<EditText>(R.id.paymentReceiptNumberInput).setText(it) }
                    val childNames = viewModel.paymentUiState.value.children.map { it.name }
                    ReceiptParser.bestMatchingNameIndex(result.probableNameOrVendor, childNames)?.let { childIndex ->
                        form.findViewById<Spinner>(R.id.childSpinner).setSelection(childIndex)
                    }
                    form.findViewById<TextView>(R.id.paymentOcrStatus).setText(
                        if (result.amount != null || result.date != null || result.receiptNumber != null || result.probableNameOrVendor != null || result.rawText.isNotBlank()) R.string.ocr_complete else R.string.ocr_no_text
                    )
                }.onFailure {
                    form.findViewById<TextView>(R.id.paymentOcrStatus).setText(R.string.ocr_no_text)
                }
            ocrInProgress = false
        }
    }
    private val viewModel by lazy { val app = requireActivity().application as ExpenseTrackerApplication; PaymentViewModel(app.paymentRepository, app.childRepository) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_payments, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        val list = view.findViewById<LinearLayout>(R.id.paymentList)
        view.findViewById<View>(R.id.addPaymentButton).setOnClickListener {
            startNewPayment()
        }
        viewLifecycleOwner.lifecycleScope.launch { viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
            viewModel.paymentUiState.collect { ui ->
                list.removeAllViews()
                list.addView(TextView(requireContext()).apply {
                    setText(R.string.tap_to_edit_long_press_to_delete)
                    setTextAppearance(R.style.TextAppearance_Kindergarten_BodyMedium)
                    setPadding(0, 0, 0, 8)
                })
                ui.payments.forEach { payment ->
                    val childName = ui.children.firstOrNull { it.id == payment.childId }?.name ?: "—"
                    list.addView(TextView(requireContext()).apply {
                        setTextAppearance(R.style.TextAppearance_Kindergarten_BodyLarge)
                        val receiptLabel = payment.receiptNumber.takeIf(String::isNotBlank)?.let { "#$it · " }.orEmpty()
                        text = "$childName\n$receiptLabel${payment.paymentDate}  ${NumberFormat.getCurrencyInstance().format(payment.amount)}"
                        setPadding(0, 16, 0, 16)
                        setOnClickListener { startEditingPayment(payment) }
                        setOnLongClickListener {
                            MaterialAlertDialogBuilder(requireContext()).setMessage(R.string.delete_payment)
                                .setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.delete) { _, _ ->
                                    payment.receiptPath?.let { File(it).delete() }
                                    viewModel.deletePayment(payment)
                                }.show()
                            true
                        }
                    })
                }
                if (ui.payments.isEmpty()) list.addView(TextView(requireContext()).apply { setText(R.string.no_data) })
            }
        } }
    }

    private fun startNewPayment() {
        val ui = viewModel.paymentUiState.value
        val app = requireActivity().application as ExpenseTrackerApplication
        if (ui.children.isEmpty()) { android.widget.Toast.makeText(requireContext(), R.string.no_children, android.widget.Toast.LENGTH_SHORT).show(); return }
        viewLifecycleOwner.lifecycleScope.launch {
            val fee = app.feeRepository.getLatestFeeConfig()
            if (fee == null) { android.widget.Toast.makeText(requireContext(), R.string.configure_fee_first, android.widget.Toast.LENGTH_SHORT).show(); return@launch }
            pendingFee = fee
            editingPayment = null
            originalReceiptPath = null
            formChildren = ui.children
            activeReceiptPath = null
            launchCamera()
        }
    }

    private fun startEditingPayment(payment: Payment) {
        val app = requireActivity().application as ExpenseTrackerApplication
        viewLifecycleOwner.lifecycleScope.launch {
            val fee = app.feeRepository.getFeeConfigById(payment.feeConfigId)
            val existingChild = app.childRepository.getChildById(payment.childId)
            if (fee == null || existingChild == null) {
                android.widget.Toast.makeText(requireContext(), R.string.invalid_entry, android.widget.Toast.LENGTH_LONG).show()
                return@launch
            }
            pendingFee = fee
            editingPayment = payment
            originalReceiptPath = payment.receiptPath
            activeReceiptPath = payment.receiptPath
            formChildren = (viewModel.paymentUiState.value.children + existingChild).distinctBy { it.id }
            showPaymentForm(runOcr = false)
        }
    }

    private fun showPaymentFormAfterPhoto() {
        showPaymentForm(runOcr = true)
    }

    private fun showPaymentForm(runOcr: Boolean) {
        val fee = pendingFee ?: return
        val ui = viewModel.paymentUiState.value
        val receiptPath = activeReceiptPath ?: return
        val existing = editingPayment
        val form = layoutInflater.inflate(R.layout.dialog_payment, null)
        activePaymentForm = form
        val spinner = form.findViewById<Spinner>(R.id.childSpinner)
        spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, formChildren.map { it.name })
        if (existing == null) {
            form.findViewById<EditText>(R.id.paymentDateInput).setText(LocalDate.now().toString())
        } else {
            form.findViewById<TextView>(R.id.paymentFormInstruction).setText(R.string.edit_item_instruction)
            form.findViewById<TextView>(R.id.paymentOcrStatus).setText(R.string.existing_receipt_kept)
            form.findViewById<EditText>(R.id.paymentReceiptNumberInput).setText(existing.receiptNumber)
            form.findViewById<EditText>(R.id.paymentAmountInput).setText(existing.amount.toString())
            form.findViewById<EditText>(R.id.paymentDateInput).setText(existing.paymentDate)
            form.findViewById<EditText>(R.id.paymentNoteInput).setText(existing.notes.orEmpty())
            spinner.setSelection(formChildren.indexOfFirst { it.id == existing.childId }.coerceAtLeast(0))
        }
        form.findViewById<View>(R.id.scanPaymentReceiptButton).setOnClickListener { launchCamera() }
        val dialog = MaterialAlertDialogBuilder(requireContext()).setTitle(if (existing == null) R.string.confirm_ocr_payment else R.string.edit_payment).setView(form).setNegativeButton(R.string.cancel) { _, _ ->
            deleteUnsavedReplacementReceipt()
            clearActiveForm()
        }.setPositiveButton(R.string.save, null).create()
        dialog.setOnCancelListener {
            deleteUnsavedReplacementReceipt()
            clearActiveForm()
        }
        dialog.show()
        if (runOcr) readPaymentReceipt(Uri.fromFile(File(receiptPath)))
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener savePayment@{
            if (ocrInProgress) {
                android.widget.Toast.makeText(requireContext(), R.string.ocr_wait, android.widget.Toast.LENGTH_SHORT).show()
                return@savePayment
            }
            val amount = form.findViewById<EditText>(R.id.paymentAmountInput).text.toString().toDoubleOrNull()
            val date = form.findViewById<EditText>(R.id.paymentDateInput).text.toString().trim()
            val receiptNumber = form.findViewById<EditText>(R.id.paymentReceiptNumberInput).text.toString().trim()
            val note = form.findViewById<EditText>(R.id.paymentNoteInput).text.toString().trim()
            val verifiedReceiptPath = activeReceiptPath?.takeIf { File(it).isFile && File(it).length() > 0L }
            if (verifiedReceiptPath == null) {
                android.widget.Toast.makeText(requireContext(), R.string.receipt_photo_required, android.widget.Toast.LENGTH_LONG).show()
                return@savePayment
            }
            if (receiptNumber.isBlank() || amount == null || amount <= 0.0 || runCatching { LocalDate.parse(date) }.isFailure) {
                android.widget.Toast.makeText(requireContext(), R.string.invalid_entry, android.widget.Toast.LENGTH_LONG).show()
                return@savePayment
            }
            val childId = formChildren[spinner.selectedItemPosition].id
            val previousPaid = ui.payments.filter { it.id != existing?.id && it.childId == childId && it.feeConfigId == fee.id }.sumOf { it.amount }
            val paymentType = when {
                previousPaid <= 0.0 && amount >= fee.yearlyFeeAmount -> "full_year"
                previousPaid <= 0.0 -> "first_half"
                else -> "second_half"
            }
            val ocrResult = activeOcrResult
            if (existing == null) {
                viewModel.addPayment(Payment(childId = childId, feeConfigId = fee.id, amount = amount, paymentDate = date, paymentType = paymentType, receiptPath = verifiedReceiptPath, receiptNumber = receiptNumber, ocrExtractedName = ocrResult?.probableNameOrVendor, ocrExtractedAmount = ocrResult?.amount, manualEntry = false, notes = note.takeIf(String::isNotBlank)))
                clearActiveForm()
                dialog.dismiss()
            } else {
                val oldReceipt = originalReceiptPath
                viewModel.updatePayment(existing.copy(
                    childId = childId,
                    amount = amount,
                    paymentDate = date,
                    paymentType = paymentType,
                    receiptPath = verifiedReceiptPath,
                    receiptNumber = receiptNumber,
                    ocrExtractedName = ocrResult?.probableNameOrVendor ?: existing.ocrExtractedName,
                    ocrExtractedAmount = ocrResult?.amount ?: existing.ocrExtractedAmount,
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
        activePaymentForm = null
        pendingFee = null
        ocrInProgress = false
        activeOcrResult = null
        editingPayment = null
        originalReceiptPath = null
        formChildren = emptyList()
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

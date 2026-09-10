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
import com.skolka.expensetracker.ui.viewmodel.PaymentViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.text.NumberFormat
import com.google.mlkit.vision.common.InputImage
import com.skolka.expensetracker.services.ocr.OcrService
import com.skolka.expensetracker.services.ocr.ReceiptStorage
import android.net.Uri
import java.io.File
import android.content.DialogInterface

class PaymentsFragment : Fragment() {
    private val ocrService = OcrService()
    private var activePaymentForm: View? = null
    private var activeReceiptPath: String? = null
    private var pendingCameraFile: File? = null
    private var pendingCameraUri: Uri? = null
    private val cameraCapture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            activeReceiptPath = pendingCameraFile?.absolutePath
            pendingCameraUri?.let(::readPaymentReceipt)
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
        readPaymentReceipt(Uri.fromFile(stored))
    }

    private fun readPaymentReceipt(uri: Uri) {
        val form = activePaymentForm ?: return
        viewLifecycleOwner.lifecycleScope.launch {
            runCatching { ocrService.recognize(uri) { InputImage.fromFilePath(requireContext(), it) } }
                .onSuccess { result ->
                    result.amount?.let { form.findViewById<EditText>(R.id.paymentAmountInput).setText(it.toString()) }
                    result.date?.let { form.findViewById<EditText>(R.id.paymentDateInput).setText(it) }
                }.onFailure { android.widget.Toast.makeText(requireContext(), it.message, android.widget.Toast.LENGTH_LONG).show() }
        }
    }
    private val viewModel by lazy { val app = requireActivity().application as ExpenseTrackerApplication; PaymentViewModel(app.paymentRepository, app.childRepository) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_payments, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        val list = view.findViewById<LinearLayout>(R.id.paymentList)
        view.findViewById<View>(R.id.addPaymentButton).setOnClickListener {
            showAddPaymentDialog()
        }
        viewLifecycleOwner.lifecycleScope.launch { viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
            viewModel.paymentUiState.collect { ui ->
                list.removeAllViews()
                ui.payments.forEach { payment ->
                    val childName = ui.children.firstOrNull { it.id == payment.childId }?.name ?: "—"
                    list.addView(TextView(requireContext()).apply {
                        setTextAppearance(R.style.TextAppearance_Kindergarten_BodyLarge)
                        text = "$childName\n${payment.paymentDate}  ${NumberFormat.getCurrencyInstance().format(payment.amount)}"
                        setPadding(0, 16, 0, 16)
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

    private fun showAddPaymentDialog() {
        val ui = viewModel.paymentUiState.value
        val app = requireActivity().application as ExpenseTrackerApplication
        if (ui.children.isEmpty()) { android.widget.Toast.makeText(requireContext(), R.string.no_children, android.widget.Toast.LENGTH_SHORT).show(); return }
        viewLifecycleOwner.lifecycleScope.launch {
            val fee = app.feeRepository.getLatestFeeConfig()
            if (fee == null) { android.widget.Toast.makeText(requireContext(), R.string.configure_fee_first, android.widget.Toast.LENGTH_SHORT).show(); return@launch }
            val form = layoutInflater.inflate(R.layout.dialog_payment, null)
            activePaymentForm = form
            activeReceiptPath = null
            val spinner = form.findViewById<Spinner>(R.id.childSpinner)
            spinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, ui.children.map { it.name })
            form.findViewById<EditText>(R.id.paymentDateInput).setText(LocalDate.now().toString())
            form.findViewById<View>(R.id.scanPaymentReceiptButton).setOnClickListener { showReceiptSource() }
            val dialog = MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.add_payment).setView(form).setNegativeButton(R.string.cancel) { _, _ ->
                activeReceiptPath?.let { File(it).delete() }
                activeReceiptPath = null
            }.setPositiveButton(R.string.save, null).create()
            dialog.setOnCancelListener {
                activeReceiptPath?.let { File(it).delete() }
                activeReceiptPath = null
            }
            dialog.show()
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                val amount = form.findViewById<EditText>(R.id.paymentAmountInput).text.toString().toDoubleOrNull()
                val date = form.findViewById<EditText>(R.id.paymentDateInput).text.toString().trim()
                if (amount == null || amount <= 0.0 || runCatching { LocalDate.parse(date) }.isFailure) {
                    android.widget.Toast.makeText(requireContext(), R.string.invalid_entry, android.widget.Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                val childId = ui.children[spinner.selectedItemPosition].id
                val previousPaid = ui.payments.filter { it.childId == childId && it.feeConfigId == fee.id }.sumOf { it.amount }
                val paymentType = when {
                    previousPaid <= 0.0 && amount >= fee.yearlyFeeAmount -> "full_year"
                    previousPaid <= 0.0 -> "first_half"
                    else -> "second_half"
                }
                viewModel.addPayment(Payment(childId = childId, feeConfigId = fee.id, amount = amount, paymentDate = date, paymentType = paymentType, receiptPath = activeReceiptPath, manualEntry = activeReceiptPath == null))
                activeReceiptPath = null
                dialog.dismiss()
            }
        }
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

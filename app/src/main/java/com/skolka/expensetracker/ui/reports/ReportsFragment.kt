package com.skolka.expensetracker.ui.reports

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.R
import com.skolka.expensetracker.services.export.ReportExporter
import com.skolka.expensetracker.ui.viewmodel.ReportData
import com.skolka.expensetracker.ui.viewmodel.ReportViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.text.NumberFormat

class ReportsFragment : Fragment() {
    private lateinit var exporter: ReportExporter
    private var reportData = ReportData()
    private val viewModel by lazy {
        val app = requireActivity().application as ExpenseTrackerApplication
        ReportViewModel(app.childRepository, app.paymentRepository, app.expenseRepository, app.feeRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_reports, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        exporter = ReportExporter(requireContext())
        view.findViewById<View>(R.id.exportPdfButton).setOnClickListener { exportPdf() }
        view.findViewById<View>(R.id.exportSpreadsheetButton).setOnClickListener { exportSpreadsheet() }
        view.findViewById<View>(R.id.emailButton).setOnClickListener { exportPdf(emailOnly = true) }
        val summary = view.findViewById<TextView>(R.id.reportSummary)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
                viewModel.reportUiState.collect { state ->
                    reportData = state.reportData
                    val money = NumberFormat.getCurrencyInstance()
                    summary.text = "${getString(R.string.total_expected)}: ${money.format(reportData.totalExpected)}\n" +
                        "${getString(R.string.total_collected)}: ${money.format(reportData.totalCollected)}\n" +
                        "${getString(R.string.total_expenses)}: ${money.format(reportData.totalExpenses)}\n" +
                        "${getString(R.string.current_balance)}: ${money.format(reportData.balance)}"
                }
            }
        }
    }

    private fun exportSpreadsheet() {
        val snapshot = reportData
        viewLifecycleOwner.lifecycleScope.launch {
            val file = withContext(Dispatchers.IO) { exporter.createSpreadsheet(snapshot) }
            share(file, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        }
    }

    private fun exportPdf(emailOnly: Boolean = false) {
        val snapshot = reportData
        viewLifecycleOwner.lifecycleScope.launch {
            val file = withContext(Dispatchers.IO) { exporter.createPdf(snapshot) }
            share(file, "application/pdf", emailOnly)
        }
    }

    private fun share(file: File, mimeType: String, emailOnly: Boolean = false) {
        val uri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.files", file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = mimeType
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
            if (emailOnly) putExtra(Intent.EXTRA_TEXT, getString(R.string.reports))
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.send_email)))
    }
}

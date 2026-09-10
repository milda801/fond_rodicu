package com.skolka.expensetracker.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.R
import com.skolka.expensetracker.ui.viewmodel.DashboardViewModel
import com.skolka.expensetracker.ui.viewmodel.PaymentStatus
import kotlinx.coroutines.launch
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.skolka.expensetracker.data.models.Child
import java.time.LocalDate
import java.text.NumberFormat

class DashboardFragment : Fragment() {
    private val viewModel by lazy {
        val app = requireActivity().application as ExpenseTrackerApplication
        DashboardViewModel(app.childRepository, app.paymentRepository, app.expenseRepository, app.feeRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?) =
        inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, state: Bundle?) {
        val summary = view.findViewById<TextView>(R.id.summaryText)
        val statuses = view.findViewById<LinearLayout>(R.id.statusContainer)
        view.findViewById<View>(R.id.addChildButton).setOnClickListener {
            showChildDialog(null)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
                viewModel.dashboardState.collect { data ->
                    val money = NumberFormat.getCurrencyInstance()
                    summary.text = "${getString(R.string.total_collected)}: ${money.format(data.totalCollected)}\n" +
                        "${getString(R.string.total_expenses)}: ${money.format(data.totalExpenses)}\n" +
                        "${getString(R.string.current_balance)}: ${money.format(data.balance)}"
                    statuses.removeAllViews()
                    data.children.forEach { child ->
                        val childSummary = viewModel.getPaymentSummaryForChild(child.id)
                        val label = when (childSummary.status) {
                            PaymentStatus.PAID_FULL -> getString(R.string.paid_full)
                            PaymentStatus.PAID_PARTIAL -> getString(R.string.paid_partial)
                            else -> getString(R.string.not_paid)
                        }
                        statuses.addView(TextView(requireContext()).apply {
                            text = "${child.name}: $label\n${getString(R.string.total_collected)}: ${money.format(childSummary.paid)} · ${getString(R.string.remaining)}: ${money.format(childSummary.remaining)}" +
                                if (childSummary.secondHalfOverdue) "\n${getString(R.string.second_half_overdue)}" else ""
                            textSize = 18f
                            setPadding(0, 16, 0, 16)
                            setTextColor(resources.getColor(when (childSummary.status) {
                                PaymentStatus.PAID_FULL -> R.color.status_paid
                                PaymentStatus.PAID_PARTIAL -> R.color.status_partial
                                else -> R.color.status_unpaid
                            }, requireContext().theme))
                            setOnClickListener { showChildDialog(child) }
                            setOnLongClickListener {
                                MaterialAlertDialogBuilder(requireContext())
                                    .setTitle(R.string.deactivate_child)
                                    .setMessage(R.string.deactivate_child_message)
                                    .setNegativeButton(R.string.cancel, null)
                                    .setPositiveButton(R.string.deactivate_child) { _, _ ->
                                        viewLifecycleOwner.lifecycleScope.launch {
                                            val app = requireActivity().application as ExpenseTrackerApplication
                                            app.childRepository.updateChild(child.copy(status = "inactive", updatedAt = System.currentTimeMillis().toString()))
                                        }
                                    }.show()
                                true
                            }
                        })
                    }
                }
            }
        }
    }

    private fun showChildDialog(existing: Child?) {
        val form = layoutInflater.inflate(R.layout.dialog_child, null)
        val input = form.findViewById<android.widget.EditText>(R.id.childNameInput)
        input.setText(existing?.name.orEmpty())
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(if (existing == null) R.string.add_child else R.string.edit_child)
            .setView(form)
            .setNegativeButton(R.string.cancel, null)
            .setPositiveButton(R.string.save, null)
            .create()
        dialog.setOnShowListener {
            dialog.getButton(android.content.DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                val name = input.text.toString().trim()
                if (name.isBlank()) return@setOnClickListener
                viewLifecycleOwner.lifecycleScope.launch {
                    val app = requireActivity().application as ExpenseTrackerApplication
                    if (existing == null) {
                        app.childRepository.insertChild(Child(name = name, enrollmentDate = LocalDate.now().toString()))
                    } else {
                        app.childRepository.updateChild(existing.copy(name = name, updatedAt = System.currentTimeMillis().toString()))
                    }
                }
                dialog.dismiss()
            }
        }
        dialog.show()
    }
}

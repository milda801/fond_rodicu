package com.skolka.expensetracker.services.export

import com.skolka.expensetracker.ui.viewmodel.ReportData
import java.util.Locale

data class OutstandingChild(val name: String, val missingAmount: Double)

object OutstandingChildren {
    fun from(data: ReportData): List<OutstandingChild> {
        val fee = data.feeConfig ?: return emptyList()
        return data.children.mapNotNull { child ->
            val paid = data.payments
                .filter { it.childId == child.id && it.feeConfigId == fee.id }
                .sumOf { it.amount }
            val missing = (fee.yearlyFeeAmount - paid).coerceAtLeast(0.0)
            missing.takeIf { it >= 0.005 }?.let { OutstandingChild(child.name, it) }
        }.sortedBy { it.name.lowercase(Locale.ROOT) }
    }
}

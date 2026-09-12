package com.skolka.expensetracker.services.export

import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.ui.viewmodel.ReportData
import org.junit.Assert.assertEquals
import org.junit.Test

class OutstandingChildrenTest {
    @Test
    fun listsUnpaidAndPartiallyPaidChildrenUsingOnlyActiveFeePayments() {
        val fee = FeeConfiguration(id = "current", academicYear = "2026-2027", yearlyFeeAmount = 1800.0)
        val john = child("john", "John Wick")
        val caroline = child("caroline", "Caroline Wednesday")
        val paid = child("paid", "Fully Paid")
        val data = ReportData(
            children = listOf(john, caroline, paid),
            payments = listOf(payment("caroline", "current", 900.0), payment("paid", "current", 1800.0), payment("john", "old-fee", 1800.0)),
            feeConfig = fee
        )

        assertEquals(
            listOf(OutstandingChild("Caroline Wednesday", 900.0), OutstandingChild("John Wick", 1800.0)),
            OutstandingChildren.from(data)
        )
    }

    @Test
    fun returnsEmptyWhenNoFeeIsConfiguredOrEveryonePaid() {
        assertEquals(emptyList<OutstandingChild>(), OutstandingChildren.from(ReportData(children = listOf(child("a", "A")))))
        val fee = FeeConfiguration(id = "fee", academicYear = "2026-2027", yearlyFeeAmount = 1800.0)
        assertEquals(emptyList<OutstandingChild>(), OutstandingChildren.from(ReportData(children = listOf(child("a", "A")), payments = listOf(payment("a", "fee", 1800.0)), feeConfig = fee)))
    }

    private fun child(id: String, name: String) = Child(id = id, name = name, enrollmentDate = "2026-09-01")
    private fun payment(childId: String, feeId: String, amount: Double) = Payment(
        childId = childId, feeConfigId = feeId, amount = amount, paymentDate = "2026-09-01", paymentType = "first_half"
    )
}

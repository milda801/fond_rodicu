package com.skolka.expensetracker.services.ocr

import org.junit.Assert.assertEquals
import org.junit.Test

class ReceiptParserTest {
    @Test
    fun parsesEuropeanAmountAndDate() {
        val result = ReceiptParser.parse("Shop Example\nPaid 1 250,50 CZK\n09.09.2026")
        assertEquals(1250.50, result.amount!!, 0.001)
        assertEquals("2026-09-09", result.date)
        assertEquals("Shop Example", result.probableNameOrVendor)
    }

    @Test
    fun selectsLargestAmountAsLikelyTotal() {
        val result = ReceiptParser.parse("Item 25.00\nItem 30.00\nTOTAL 55.00")
        assertEquals(55.0, result.amount!!, 0.001)
    }
}

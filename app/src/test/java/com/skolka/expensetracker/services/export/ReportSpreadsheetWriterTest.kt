package com.skolka.expensetracker.services.export

import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.ui.viewmodel.ReportData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.Base64
import java.util.zip.ZipInputStream

class ReportSpreadsheetWriterTest {
    private val labels = SpreadsheetLabels(
        sheetName = "Financial report",
        payments = "Payments",
        paymentReceiptNumber = "Receipt #",
        childName = "Child name",
        firstHalfAmount = "First half amount",
        secondHalfAmount = "Second half amount",
        receiptPhoto = "Receipt photo",
        expenses = "Expenses",
        countNumber = "Count #",
        supplier = "Supplier",
        amount = "Amount",
        description = "Description",
        note = "Note",
        summary = "Summary",
        numberOfChildren = "Number of children",
        expectedAmount = "Expected amount",
        collectedAmount = "Collected amount",
        balance = "Balance",
        notAvailable = "Not available"
    )

    @Test
    fun halfYearAmountsPlacesInstallmentsInTheirColumns() {
        assertEquals(HalfYearAmounts(900.0, null), ReportSpreadsheetWriter.halfYearAmounts(payment("first_half", 900.0)))
        assertEquals(HalfYearAmounts(null, 900.0), ReportSpreadsheetWriter.halfYearAmounts(payment("second_half", 900.0)))
        assertEquals(HalfYearAmounts(900.0, 900.0), ReportSpreadsheetWriter.halfYearAmounts(payment("full_year", 1800.0)))
        assertEquals(HalfYearAmounts(900.5, 900.5), ReportSpreadsheetWriter.halfYearAmounts(payment("full_year", 1801.0)))
        assertEquals(HalfYearAmounts(900.0, 900.0), ReportSpreadsheetWriter.halfYearAmounts(payment("second_half", 1800.0), 1800.0))
        assertEquals(HalfYearAmounts(900.0, 900.0), ReportSpreadsheetWriter.halfYearAmounts(payment("first_half", 1800.0), 1800.0))
    }

    @Test
    fun workbookContainsBothTablesSummaryAndEmbeddedReceipt() {
        val receipt = File.createTempFile("spreadsheet-receipt", ".png").apply {
            writeBytes(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNk+A8AAQUBAScY42YAAAAASUVORK5CYII="))
            deleteOnExit()
        }
        val child = Child(id = "child-1", name = "Anna & Eliška", enrollmentDate = "2026-09-01")
        val data = ReportData(
            children = listOf(child),
            allChildren = listOf(child),
            payments = listOf(payment("second_half", 1800.0, receipt.absolutePath)),
            expenses = listOf(Expense(receiptNumber = "7", expenseDate = "2026-09-10", category = "other", supplierName = "Papír s.r.o.", description = "Art supplies", amount = 125.5, receiptPath = receipt.absolutePath, notes = "September")),
            feeConfig = com.skolka.expensetracker.data.models.FeeConfiguration(id = "fee-1", academicYear = "2026-2027", yearlyFeeAmount = 1800.0),
            totalExpected = 1800.0,
            totalCollected = 1800.0,
            totalExpenses = 125.5,
            balance = 1674.5
        )

        val output = ByteArrayOutputStream()
        ReportSpreadsheetWriter(labels).write(data, output)
        val entries = unzip(output.toByteArray())
        val sheet = entries["xl/worksheets/sheet1.xml"]?.toString(Charsets.UTF_8)

        assertNotNull(entries["[Content_Types].xml"])
        assertNotNull(entries["xl/styles.xml"])
        assertNotNull(entries["xl/drawings/drawing1.xml"])
        assertNotNull(entries["xl/media/payment-receipt-1.png"])
        assertNotNull(entries["xl/media/expense-receipt-1.png"])
        assertNotNull(sheet)
        assertTrue(sheet!!.indexOf("Summary") < sheet.indexOf("Payments"))
        assertTrue(sheet.contains("Payments"))
        assertTrue(sheet.contains("Expenses"))
        assertTrue(sheet.contains("Summary"))
        assertTrue(sheet.contains("Anna &amp; Eliška"))
        assertTrue(sheet.contains("<v>900.0</v>"))
        assertTrue(sheet.contains("Papír s.r.o."))
        assertTrue(sheet.contains("Number of children"))
        assertTrue(sheet.contains("<c r=\"C9\" s=\"3\"><v>900.0</v></c>"))
        assertTrue(sheet.contains("<c r=\"D9\" s=\"3\"><v>900.0</v></c>"))
        assertTrue(sheet.contains("<v>1674.5</v>"))
        val drawing = entries["xl/drawings/drawing1.xml"]!!.toString(Charsets.UTF_8)
        assertTrue(drawing.contains("<xdr:col>4</xdr:col>"))
        assertTrue(drawing.contains("<xdr:col>5</xdr:col>"))
    }

    private fun payment(type: String, amount: Double, receiptPath: String? = null) = Payment(
        id = "payment-$type-$amount",
        childId = "child-1",
        feeConfigId = "fee-1",
        amount = amount,
        paymentDate = "2026-09-10",
        paymentType = type,
        receiptPath = receiptPath,
        receiptNumber = "3"
    )

    private fun unzip(bytes: ByteArray): Map<String, ByteArray> {
        val entries = mutableMapOf<String, ByteArray>()
        ZipInputStream(bytes.inputStream()).use { zip ->
            var entry = zip.nextEntry
            while (entry != null) {
                entries[entry.name] = zip.readBytes()
                zip.closeEntry()
                entry = zip.nextEntry
            }
        }
        return entries
    }
}

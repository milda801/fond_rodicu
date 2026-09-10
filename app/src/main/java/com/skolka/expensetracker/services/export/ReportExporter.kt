package com.skolka.expensetracker.services.export

import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import com.skolka.expensetracker.R
import com.skolka.expensetracker.ui.viewmodel.ReportData
import java.io.File
import java.io.FileOutputStream
import java.text.NumberFormat

class ReportExporter(private val context: Context) {
    private val reportDirectory = File(context.cacheDir, "reports").apply { mkdirs() }

    fun createCsv(data: ReportData): File {
        val file = File(reportDirectory, "kindergarten-report.csv")
        file.bufferedWriter().use { writer ->
            writer.appendLine(context.getString(R.string.report_summary))
            writer.appendLine("${csv(context.getString(R.string.total_expected))},${data.totalExpected}")
            writer.appendLine("${csv(context.getString(R.string.total_collected))},${data.totalCollected}")
            writer.appendLine("${csv(context.getString(R.string.total_expenses))},${data.totalExpenses}")
            writer.appendLine("${csv(context.getString(R.string.current_balance))},${data.balance}")
            writer.appendLine()
            writer.appendLine(listOf(R.string.report_child, R.string.total_expected, R.string.report_paid, R.string.remaining).joinToString(",") { csv(context.getString(it)) })
            data.children.forEach { child ->
                val paid = data.payments.filter { it.childId == child.id }.sumOf { it.amount }
                val expected = data.feeConfig?.yearlyFeeAmount ?: 0.0
                writer.appendLine("${csv(child.name)},$expected,$paid,${(expected - paid).coerceAtLeast(0.0)}")
            }
            writer.appendLine()
            writer.appendLine(listOf(R.string.receipt_number, R.string.expense_date, R.string.amount, R.string.supplier_name, R.string.description, R.string.note).joinToString(",") { csv(context.getString(it)) })
            data.expenses.forEach { expense ->
                writer.appendLine("${csv(expense.receiptNumber)},${csv(expense.expenseDate)},${expense.amount},${csv(expense.supplierName)},${csv(expense.description)},${csv(expense.notes.orEmpty())}")
            }
        }
        return file
    }

    fun createPdf(data: ReportData): File {
        val file = File(reportDirectory, "kindergarten-report.pdf")
        val document = PdfDocument()
        val paint = Paint().apply { textSize = 12f }
        val titlePaint = Paint().apply { textSize = 20f; isFakeBoldText = true }
        var pageNumber = 1
        var page = document.startPage(PdfDocument.PageInfo.Builder(595, 842, pageNumber).create())
        var canvas = page.canvas
        var y = 48f

        fun newPage() {
            document.finishPage(page)
            pageNumber++
            page = document.startPage(PdfDocument.PageInfo.Builder(595, 842, pageNumber).create())
            canvas = page.canvas
            y = 48f
        }
        fun line(text: String, heading: Boolean = false) {
            if (y > 800f) newPage()
            canvas.drawText(text.take(85), 36f, y, if (heading) titlePaint else paint)
            y += if (heading) 32f else 20f
        }

        val money = NumberFormat.getCurrencyInstance()
        line(context.getString(R.string.report_title), true)
        line("${context.getString(R.string.total_expected)}: ${money.format(data.totalExpected)}")
        line("${context.getString(R.string.total_collected)}: ${money.format(data.totalCollected)}")
        line("${context.getString(R.string.total_expenses)}: ${money.format(data.totalExpenses)}")
        line("${context.getString(R.string.current_balance)}: ${money.format(data.balance)}")
        y += 12f
        line(context.getString(R.string.payment_status), true)
        data.children.forEach { child ->
            val paid = data.payments.filter { it.childId == child.id }.sumOf { it.amount }
            val expected = data.feeConfig?.yearlyFeeAmount ?: 0.0
            line("${child.name}: ${context.getString(R.string.report_paid).lowercase()} ${money.format(paid)}, ${context.getString(R.string.remaining).lowercase()} ${money.format((expected - paid).coerceAtLeast(0.0))}")
        }
        y += 12f
        line(context.getString(R.string.expenses), true)
        data.expenses.forEach {
            line("#${it.receiptNumber} | ${it.expenseDate} | ${money.format(it.amount)} | ${it.supplierName} | ${it.description}${it.notes?.takeIf(String::isNotBlank)?.let { note -> " | ${context.getString(R.string.note)}: $note" }.orEmpty()}")
        }
        document.finishPage(page)
        FileOutputStream(file).use(document::writeTo)
        document.close()
        return file
    }

    private fun csv(value: String): String = "\"${value.replace("\"", "\"\"")}\""
}

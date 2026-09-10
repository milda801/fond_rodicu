package com.skolka.expensetracker.services.export

import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import com.skolka.expensetracker.ui.viewmodel.ReportData
import java.io.File
import java.io.FileOutputStream
import java.text.NumberFormat

class ReportExporter(private val context: Context) {
    private val reportDirectory = File(context.cacheDir, "reports").apply { mkdirs() }

    fun createCsv(data: ReportData): File {
        val file = File(reportDirectory, "kindergarten-report.csv")
        file.bufferedWriter().use { writer ->
            writer.appendLine("Summary")
            writer.appendLine("Expected,${data.totalExpected}")
            writer.appendLine("Collected,${data.totalCollected}")
            writer.appendLine("Expenses,${data.totalExpenses}")
            writer.appendLine("Balance,${data.balance}")
            writer.appendLine()
            writer.appendLine("Child,Expected,Paid,Remaining")
            data.children.forEach { child ->
                val paid = data.payments.filter { it.childId == child.id }.sumOf { it.amount }
                val expected = data.feeConfig?.yearlyFeeAmount ?: 0.0
                writer.appendLine("${csv(child.name)},$expected,$paid,${(expected - paid).coerceAtLeast(0.0)}")
            }
            writer.appendLine()
            writer.appendLine("Expense date,Category,Description,Amount")
            data.expenses.forEach { expense ->
                writer.appendLine("${csv(expense.expenseDate)},${csv(expense.category)},${csv(expense.description)},${expense.amount}")
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
        line("Kindergarten financial report", true)
        line("Expected: ${money.format(data.totalExpected)}")
        line("Collected: ${money.format(data.totalCollected)}")
        line("Expenses: ${money.format(data.totalExpenses)}")
        line("Balance: ${money.format(data.balance)}")
        y += 12f
        line("Payment status", true)
        data.children.forEach { child ->
            val paid = data.payments.filter { it.childId == child.id }.sumOf { it.amount }
            val expected = data.feeConfig?.yearlyFeeAmount ?: 0.0
            line("${child.name}: paid ${money.format(paid)}, remaining ${money.format((expected - paid).coerceAtLeast(0.0))}")
        }
        y += 12f
        line("Expenses", true)
        data.expenses.forEach { line("${it.expenseDate} | ${it.category} | ${it.description} | ${money.format(it.amount)}") }
        document.finishPage(page)
        FileOutputStream(file).use(document::writeTo)
        document.close()
        return file
    }

    private fun csv(value: String): String = "\"${value.replace("\"", "\"\"")}\""
}

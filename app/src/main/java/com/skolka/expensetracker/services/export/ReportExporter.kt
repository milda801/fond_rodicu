package com.skolka.expensetracker.services.export

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import com.skolka.expensetracker.R
import com.skolka.expensetracker.ui.viewmodel.ReportData
import java.io.File
import java.io.FileOutputStream
import java.text.NumberFormat

class ReportExporter(private val context: Context) {
    private val reportDirectory = File(context.cacheDir, "reports").apply { mkdirs() }

    fun createSpreadsheet(data: ReportData): File {
        val file = File(reportDirectory, "kindergarten-report.xlsx")
        val labels = SpreadsheetLabels(
            sheetName = context.getString(R.string.report_title),
            payments = context.getString(R.string.payments),
            paymentReceiptNumber = context.getString(R.string.payment_receipt_number),
            childName = context.getString(R.string.child_name),
            firstHalfAmount = context.getString(R.string.first_half_amount),
            secondHalfAmount = context.getString(R.string.second_half_amount),
            receiptPhoto = context.getString(R.string.receipt_photo),
            expenses = context.getString(R.string.expenses),
            countNumber = context.getString(R.string.receipt_number),
            supplier = context.getString(R.string.supplier_name),
            amount = context.getString(R.string.amount),
            description = context.getString(R.string.description),
            note = context.getString(R.string.note),
            summary = context.getString(R.string.report_summary),
            numberOfChildren = context.getString(R.string.number_of_children),
            expectedAmount = context.getString(R.string.total_expected),
            collectedAmount = context.getString(R.string.total_collected),
            balance = context.getString(R.string.current_balance),
            notAvailable = context.getString(R.string.not_available)
        )
        file.outputStream().buffered().use { ReportSpreadsheetWriter(labels).write(data, it) }
        return file
    }

    fun createPdf(data: ReportData): File {
        val file = File(reportDirectory, "kindergarten-report.pdf")
        val document = PdfDocument()
        val pageWidth = 842
        val pageHeight = 595
        val margin = 24f
        val contentWidth = pageWidth - margin * 2
        val bodyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 10f; color = Color.rgb(30, 45, 45) }
        val headerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 10f; color = Color.WHITE; isFakeBoldText = true }
        val sectionPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 16f; color = Color.WHITE; isFakeBoldText = true }
        val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.STROKE; strokeWidth = 0.7f; color = Color.rgb(176, 190, 197) }
        val sectionFill = Paint().apply { style = Paint.Style.FILL; color = Color.rgb(0, 105, 92) }
        val headerFill = Paint().apply { style = Paint.Style.FILL; color = Color.rgb(0, 137, 123) }
        var pageNumber = 1
        var page = document.startPage(PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create())
        var canvas = page.canvas
        var y = margin
        val money = NumberFormat.getNumberInstance().apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }
        val childNames = (data.allChildren.ifEmpty { data.children }).associate { it.id to it.name }

        fun newPage() {
            document.finishPage(page)
            pageNumber++
            page = document.startPage(PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create())
            canvas = page.canvas
            y = margin
        }

        fun ensureSpace(height: Float) {
            if (y + height > pageHeight - margin) newPage()
        }

        fun section(title: String, width: Float = contentWidth) {
            ensureSpace(28f)
            canvas.drawRect(margin, y, margin + width, y + 26f, sectionFill)
            canvas.drawText(title, margin + 6f, y + 18f, sectionPaint)
            y += 26f
        }

        fun drawCell(text: String, left: Float, top: Float, width: Float, height: Float, paint: Paint, fill: Paint? = null) {
            fill?.let { canvas.drawRect(left, top, left + width, top + height, it) }
            canvas.drawRect(left, top, left + width, top + height, borderPaint)
            val availableWidth = width - 8f
            val fitted = if (paint.measureText(text) <= availableWidth) text else {
                var shortened = text
                while (shortened.length > 1 && paint.measureText("$shortened…") > availableWidth) shortened = shortened.dropLast(1)
                "$shortened…"
            }
            canvas.drawText(fitted, left + 4f, top + paint.textSize + 5f, paint)
        }

        fun drawReceipt(path: String?, left: Float, top: Float, width: Float, height: Float) {
            canvas.drawRect(left, top, left + width, top + height, borderPaint)
            val bitmap = path?.let { decodeSampledBitmap(it, width.toInt() * 2, height.toInt() * 2) }
            if (bitmap == null) {
                drawCell(context.getString(R.string.not_available), left, top, width, height, bodyPaint)
                return
            }
            val scale = minOf((width - 6f) / bitmap.width, (height - 6f) / bitmap.height)
            val drawnWidth = bitmap.width * scale
            val drawnHeight = bitmap.height * scale
            val destination = android.graphics.RectF(
                left + (width - drawnWidth) / 2f,
                top + (height - drawnHeight) / 2f,
                left + (width + drawnWidth) / 2f,
                top + (height + drawnHeight) / 2f
            )
            canvas.drawBitmap(bitmap, null, destination, null)
            bitmap.recycle()
        }

        section(context.getString(R.string.report_summary), 340f)
        listOf(
            context.getString(R.string.number_of_children) to data.children.size.toString(),
            context.getString(R.string.total_expected) to money.format(data.totalExpected),
            context.getString(R.string.total_collected) to money.format(data.totalCollected),
            context.getString(R.string.current_balance) to money.format(data.balance)
        ).forEach { (label, value) ->
            drawCell(label, margin, y, 210f, 22f, headerPaint, headerFill)
            drawCell(value, margin + 210f, y, 130f, 22f, bodyPaint)
            y += 22f
        }
        y += 14f

        val paymentWidths = floatArrayOf(90f, 150f, 115f, 115f, contentWidth - 470f)
        fun paymentHeader() {
            section(context.getString(R.string.payments))
            val headings = listOf(
                context.getString(R.string.payment_receipt_number), context.getString(R.string.child_name),
                context.getString(R.string.first_half_amount), context.getString(R.string.second_half_amount),
                context.getString(R.string.receipt_photo)
            )
            var x = margin
            headings.forEachIndexed { index, heading ->
                drawCell(heading, x, y, paymentWidths[index], 24f, headerPaint, headerFill)
                x += paymentWidths[index]
            }
            y += 24f
        }
        paymentHeader()
        data.payments.forEach { payment ->
            val rowHeight = 94f
            if (y + rowHeight > pageHeight - margin) {
                newPage()
                paymentHeader()
            }
            val halves = ReportSpreadsheetWriter.halfYearAmounts(payment, data.feeConfig?.yearlyFeeAmount)
            val values = listOf(
                payment.receiptNumber,
                childNames[payment.childId] ?: context.getString(R.string.not_available),
                halves.firstHalf?.let(money::format).orEmpty(),
                halves.secondHalf?.let(money::format).orEmpty()
            )
            var x = margin
            values.forEachIndexed { index, value ->
                drawCell(value, x, y, paymentWidths[index], rowHeight, bodyPaint)
                x += paymentWidths[index]
            }
            drawReceipt(payment.receiptPath, x, y, paymentWidths[4], rowHeight)
            y += rowHeight
        }
        y += 14f

        val expenseWidths = floatArrayOf(70f, 130f, 80f, 175f, 135f, contentWidth - 590f)
        fun expenseHeader() {
            section(context.getString(R.string.expenses))
            val headings = listOf(
                context.getString(R.string.receipt_number), context.getString(R.string.supplier_name),
                context.getString(R.string.amount), context.getString(R.string.description),
                context.getString(R.string.note), context.getString(R.string.receipt_photo)
            )
            var x = margin
            headings.forEachIndexed { index, heading ->
                drawCell(heading, x, y, expenseWidths[index], 24f, headerPaint, headerFill)
                x += expenseWidths[index]
            }
            y += 24f
        }
        expenseHeader()
        data.expenses.forEach { expense ->
            val rowHeight = 94f
            if (y + rowHeight > pageHeight - margin) {
                newPage()
                expenseHeader()
            }
            val values = listOf(expense.receiptNumber, expense.supplierName, money.format(expense.amount), expense.description, expense.notes.orEmpty())
            var x = margin
            values.forEachIndexed { index, value ->
                drawCell(value, x, y, expenseWidths[index], rowHeight, bodyPaint)
                x += expenseWidths[index]
            }
            drawReceipt(expense.receiptPath, x, y, expenseWidths[5], rowHeight)
            y += rowHeight
        }
        document.finishPage(page)
        FileOutputStream(file).use(document::writeTo)
        document.close()
        return file
    }

    private fun decodeSampledBitmap(path: String, targetWidth: Int, targetHeight: Int): Bitmap? {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(path, bounds)
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
        var sampleSize = 1
        while (bounds.outWidth / (sampleSize * 2) >= targetWidth && bounds.outHeight / (sampleSize * 2) >= targetHeight) {
            sampleSize *= 2
        }
        return BitmapFactory.decodeFile(path, BitmapFactory.Options().apply { inSampleSize = sampleSize })
    }
}

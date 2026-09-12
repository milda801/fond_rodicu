package com.skolka.expensetracker.services.export

import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.ui.viewmodel.ReportData
import java.io.File
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import kotlin.math.round

data class SpreadsheetLabels(
    val sheetName: String,
    val payments: String,
    val paymentReceiptNumber: String,
    val childName: String,
    val firstHalfAmount: String,
    val secondHalfAmount: String,
    val receiptPhoto: String,
    val expenses: String,
    val countNumber: String,
    val supplier: String,
    val amount: String,
    val description: String,
    val note: String,
    val summary: String,
    val numberOfChildren: String,
    val expectedAmount: String,
    val collectedAmount: String,
    val balance: String,
    val notAvailable: String,
    val outstandingChildren: String,
    val allChildrenPaid: String
)

data class HalfYearAmounts(val firstHalf: Double?, val secondHalf: Double?)

/** Writes a small, standards-based XLSX workbook without a heavyweight spreadsheet dependency. */
class ReportSpreadsheetWriter(private val labels: SpreadsheetLabels) {
    private data class EmbeddedImage(
        val relationshipId: String,
        val fileName: String,
        val extension: String,
        val contentType: String,
        val bytes: ByteArray,
        val sheetColumnIndex: Int,
        val sheetRowIndex: Int,
        val widthEmu: Long,
        val heightEmu: Long
    )

    fun write(data: ReportData, output: OutputStream) {
        val images = collectImages(data)
        ZipOutputStream(output).use { zip ->
            zip.writeText("[Content_Types].xml", contentTypes(images))
            zip.writeText("_rels/.rels", packageRelationships())
            zip.writeText("docProps/core.xml", coreProperties())
            zip.writeText("docProps/app.xml", appProperties())
            zip.writeText("xl/workbook.xml", workbook())
            zip.writeText("xl/_rels/workbook.xml.rels", workbookRelationships())
            zip.writeText("xl/styles.xml", styles())
            zip.writeText("xl/worksheets/sheet1.xml", worksheet(data, images.isNotEmpty()))
            if (images.isNotEmpty()) {
                zip.writeText("xl/worksheets/_rels/sheet1.xml.rels", worksheetRelationships())
                zip.writeText("xl/drawings/drawing1.xml", drawing(images))
                zip.writeText("xl/drawings/_rels/drawing1.xml.rels", drawingRelationships(images))
                images.forEach { zip.writeBytes("xl/media/${it.fileName}", it.bytes) }
            }
        }
    }

    private fun collectImages(data: ReportData): List<EmbeddedImage> {
        val outstandingRowCount = OutstandingChildren.from(data).size.coerceAtLeast(1)
        val paymentTitleRow = maxOf(7, outstandingRowCount + 3)
        val firstPaymentDataRow = paymentTitleRow + 2
        val firstExpenseDataRow = firstPaymentDataRow + data.payments.size + 3
        val images = buildList {
            data.payments.forEachIndexed { index, payment ->
                createEmbeddedImage(
                    path = payment.receiptPath,
                    filePrefix = "payment-receipt",
                    sourceIndex = index,
                    sheetColumnIndex = 4,
                    sheetRowIndex = firstPaymentDataRow - 1 + index
                )?.let(::add)
            }
            data.expenses.forEachIndexed { index, expense ->
                createEmbeddedImage(
                    path = expense.receiptPath,
                    filePrefix = "expense-receipt",
                    sourceIndex = index,
                    sheetColumnIndex = 5,
                    sheetRowIndex = firstExpenseDataRow - 1 + index
                )?.let(::add)
            }
        }
        return images.mapIndexed { relationshipIndex, image ->
            image.copy(relationshipId = "rId${relationshipIndex + 1}")
        }
    }

    private fun createEmbeddedImage(
        path: String?,
        filePrefix: String,
        sourceIndex: Int,
        sheetColumnIndex: Int,
        sheetRowIndex: Int
    ): EmbeddedImage? {
        val file = path?.let(::File) ?: return null
        if (!file.isFile || !file.canRead()) return null
        val bytes = runCatching { file.readBytes() }.getOrNull() ?: return null
        val imageType = imageType(bytes) ?: return null
        val dimensions = imageDimensions(bytes, imageType.first)
        val fitted = fitImage(dimensions?.first ?: 3, dimensions?.second ?: 4)
        return EmbeddedImage(
            relationshipId = "",
            fileName = "$filePrefix-${sourceIndex + 1}.${imageType.first}",
            extension = imageType.first,
            contentType = imageType.second,
            bytes = bytes,
            sheetColumnIndex = sheetColumnIndex,
            sheetRowIndex = sheetRowIndex,
            widthEmu = fitted.first,
            heightEmu = fitted.second
        )
    }

    private fun worksheet(data: ReportData, hasImages: Boolean): String {
        val rows = StringBuilder()
        val childNames = (data.allChildren.ifEmpty { data.children }).associate { it.id to it.name }
        val outstanding = OutstandingChildren.from(data)
        var row = 1

        rows.append(sheetRow(row, listOf(textCell("A", row, labels.summary, 1), textCell("D", row, labels.outstandingChildren, 1)), height = 26.0))
        val summaryTitleRow = row
        val summaryValues = listOf(
            labels.numberOfChildren to data.children.size.toDouble(),
            labels.expectedAmount to data.totalExpected,
            labels.collectedAmount to data.totalCollected,
            labels.balance to data.balance
        )
        val topDataRows = maxOf(summaryValues.size, outstanding.size.coerceAtLeast(1))
        for (index in 0 until topDataRows) {
            val topRow = index + 2
            val cells = buildList {
                summaryValues.getOrNull(index)?.let { (label, value) ->
                    add(textCell("A", topRow, label, 4))
                    add(numberCell("B", topRow, value, if (index == 0) 0 else 3))
                }
                if (outstanding.isEmpty() && index == 0) {
                    add(textCell("D", topRow, labels.allChildrenPaid))
                } else {
                    outstanding.getOrNull(index)?.let { child ->
                        add(textCell("D", topRow, child.name))
                        add(numberCell("E", topRow, child.missingAmount, 3))
                    }
                }
            }
            rows.append(sheetRow(topRow, cells))
        }

        row = topDataRows + 3
        rows.append(sheetRow(row, listOf(textCell("A", row, labels.payments, 1)), height = 26.0))
        val paymentTitleRow = row
        row++
        rows.append(sheetRow(row, listOf(
            textCell("A", row, labels.paymentReceiptNumber, 2),
            textCell("B", row, labels.childName, 2),
            textCell("C", row, labels.firstHalfAmount, 2),
            textCell("D", row, labels.secondHalfAmount, 2),
            textCell("E", row, labels.receiptPhoto, 2)
        )))
        row++
        data.payments.forEach { payment ->
            val halves = halfYearAmounts(payment, data.feeConfig?.yearlyFeeAmount)
            val receiptLabel = if (payment.receiptPath?.let(::isSupportedImage) == true) "" else labels.notAvailable
            rows.append(sheetRow(row, listOf(
                textCell("A", row, payment.receiptNumber),
                textCell("B", row, childNames[payment.childId] ?: labels.notAvailable),
                numberOrBlankCell("C", row, halves.firstHalf, 3),
                numberOrBlankCell("D", row, halves.secondHalf, 3),
                textCell("E", row, receiptLabel)
            ), height = 112.0))
            row++
        }

        row++
        rows.append(sheetRow(row, listOf(textCell("A", row, labels.expenses, 1)), height = 26.0))
        val expenseTitleRow = row
        row++
        rows.append(sheetRow(row, listOf(
            textCell("A", row, labels.countNumber, 2),
            textCell("B", row, labels.supplier, 2),
            textCell("C", row, labels.amount, 2),
            textCell("D", row, labels.description, 2),
            textCell("E", row, labels.note, 2),
            textCell("F", row, labels.receiptPhoto, 2)
        )))
        row++
        data.expenses.forEach { expense ->
            val receiptLabel = if (expense.receiptPath?.let(::isSupportedImage) == true) "" else labels.notAvailable
            rows.append(sheetRow(row, listOf(
                textCell("A", row, expense.receiptNumber),
                textCell("B", row, expense.supplierName),
                numberCell("C", row, expense.amount, 3),
                textCell("D", row, expense.description),
                textCell("E", row, expense.notes.orEmpty()),
                textCell("F", row, receiptLabel)
            ), height = 112.0))
            row++
        }

        val drawing = if (hasImages) "<drawing r:id=\"rId1\"/>" else ""
        return """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships">
  <cols>
    <col min="1" max="1" width="18" customWidth="1"/>
    <col min="2" max="2" width="25" customWidth="1"/>
    <col min="3" max="3" width="19" customWidth="1"/>
    <col min="4" max="4" width="36" customWidth="1"/>
    <col min="5" max="5" width="29" customWidth="1"/>
    <col min="6" max="6" width="29" customWidth="1"/>
  </cols>
  <sheetData>$rows</sheetData>
  <mergeCells count="4"><mergeCell ref="A$summaryTitleRow:B$summaryTitleRow"/><mergeCell ref="D$summaryTitleRow:E$summaryTitleRow"/><mergeCell ref="A$paymentTitleRow:E$paymentTitleRow"/><mergeCell ref="A$expenseTitleRow:F$expenseTitleRow"/></mergeCells>
  $drawing
</worksheet>"""
    }

    private fun summaryRow(row: Int, label: String, value: Double, integer: Boolean = false): String = sheetRow(
        row,
        listOf(textCell("A", row, label, 4), numberCell("B", row, value, if (integer) 0 else 3))
    )

    private fun sheetRow(number: Int, cells: List<String>, height: Double? = null): String {
        val heightAttributes = height?.let { " ht=\"$it\" customHeight=\"1\"" }.orEmpty()
        return "<row r=\"$number\"$heightAttributes>${cells.joinToString("")}</row>"
    }

    private fun textCell(column: String, row: Int, value: String, style: Int = 0): String =
        "<c r=\"$column$row\" s=\"$style\" t=\"inlineStr\"><is><t xml:space=\"preserve\">${xml(value)}</t></is></c>"

    private fun numberCell(column: String, row: Int, value: Double, style: Int): String =
        "<c r=\"$column$row\" s=\"$style\"><v>${finite(value)}</v></c>"

    private fun numberOrBlankCell(column: String, row: Int, value: Double?, style: Int): String =
        value?.let { numberCell(column, row, it, style) } ?: "<c r=\"$column$row\" s=\"$style\"/>"

    private fun contentTypes(images: List<EmbeddedImage>): String {
        val imageDefaults = images.distinctBy { it.extension }.joinToString("") {
            "<Default Extension=\"${it.extension}\" ContentType=\"${it.contentType}\"/>"
        }
        val drawingOverride = if (images.isNotEmpty()) {
            "<Override PartName=\"/xl/drawings/drawing1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.drawing+xml\"/>"
        } else ""
        return """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Types xmlns="http://schemas.openxmlformats.org/package/2006/content-types">
  <Default Extension="rels" ContentType="application/vnd.openxmlformats-package.relationships+xml"/>
  <Default Extension="xml" ContentType="application/xml"/>$imageDefaults
  <Override PartName="/xl/workbook.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml"/>
  <Override PartName="/xl/worksheets/sheet1.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml"/>
  <Override PartName="/xl/styles.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml"/>
  <Override PartName="/docProps/core.xml" ContentType="application/vnd.openxmlformats-package.core-properties+xml"/>
  <Override PartName="/docProps/app.xml" ContentType="application/vnd.openxmlformats-officedocument.extended-properties+xml"/>$drawingOverride
</Types>"""
    }

    private fun packageRelationships() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">
  <Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument" Target="xl/workbook.xml"/>
  <Relationship Id="rId2" Type="http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties" Target="docProps/core.xml"/>
  <Relationship Id="rId3" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties" Target="docProps/app.xml"/>
</Relationships>"""

    private fun coreProperties() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cp:coreProperties xmlns:cp="http://schemas.openxmlformats.org/package/2006/metadata/core-properties" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:dcterms="http://purl.org/dc/terms/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <dc:title>${xml(labels.sheetName)}</dc:title><dc:creator>Výdaje mateřské školy</dc:creator>
</cp:coreProperties>"""

    private fun appProperties() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Properties xmlns="http://schemas.openxmlformats.org/officeDocument/2006/extended-properties" xmlns:vt="http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes"><Application>Výdaje mateřské školy</Application></Properties>"""

    private fun workbook(): String {
        val safeSheetName = labels.sheetName.replace(Regex("[\\[\\]:*?/\\\\]"), " ").take(31).ifBlank { "Report" }
        return """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<workbook xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships"><sheets><sheet name="${xml(safeSheetName)}" sheetId="1" r:id="rId1"/></sheets></workbook>"""
    }

    private fun workbookRelationships() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">
  <Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet" Target="worksheets/sheet1.xml"/>
  <Relationship Id="rId2" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles" Target="styles.xml"/>
</Relationships>"""

    private fun worksheetRelationships() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships"><Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/drawing" Target="../drawings/drawing1.xml"/></Relationships>"""

    private fun styles() = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<styleSheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main">
  <numFmts count="1"><numFmt numFmtId="164" formatCode="#,##0.00"/></numFmts>
  <fonts count="3"><font><sz val="11"/><name val="Calibri"/></font><font><b/><sz val="16"/><color rgb="FFFFFFFF"/><name val="Calibri"/></font><font><b/><sz val="11"/><color rgb="FFFFFFFF"/><name val="Calibri"/></font></fonts>
  <fills count="4"><fill><patternFill patternType="none"/></fill><fill><patternFill patternType="gray125"/></fill><fill><patternFill patternType="solid"><fgColor rgb="FF00695C"/><bgColor indexed="64"/></patternFill></fill><fill><patternFill patternType="solid"><fgColor rgb="FF00897B"/><bgColor indexed="64"/></patternFill></fill></fills>
  <borders count="2"><border/><border><left style="thin"><color rgb="FFB0BEC5"/></left><right style="thin"><color rgb="FFB0BEC5"/></right><top style="thin"><color rgb="FFB0BEC5"/></top><bottom style="thin"><color rgb="FFB0BEC5"/></bottom><diagonal/></border></borders>
  <cellStyleXfs count="1"><xf numFmtId="0" fontId="0" fillId="0" borderId="0"/></cellStyleXfs>
  <cellXfs count="5">
    <xf numFmtId="0" fontId="0" fillId="0" borderId="1" xfId="0" applyBorder="1" applyAlignment="1"><alignment vertical="top" wrapText="1"/></xf>
    <xf numFmtId="0" fontId="1" fillId="2" borderId="1" xfId="0" applyFont="1" applyFill="1" applyBorder="1" applyAlignment="1"><alignment vertical="center"/></xf>
    <xf numFmtId="0" fontId="2" fillId="3" borderId="1" xfId="0" applyFont="1" applyFill="1" applyBorder="1" applyAlignment="1"><alignment vertical="center" wrapText="1"/></xf>
    <xf numFmtId="164" fontId="0" fillId="0" borderId="1" xfId="0" applyNumberFormat="1" applyBorder="1" applyAlignment="1"><alignment vertical="top"/></xf>
    <xf numFmtId="0" fontId="2" fillId="3" borderId="1" xfId="0" applyFont="1" applyFill="1" applyBorder="1" applyAlignment="1"><alignment vertical="center"/></xf>
  </cellXfs>
  <cellStyles count="1"><cellStyle name="Normal" xfId="0" builtinId="0"/></cellStyles>
</styleSheet>"""

    private fun drawing(images: List<EmbeddedImage>): String {
        val anchors = images.mapIndexed { index, image ->
            val name = "Receipt ${index + 1}"
            """<xdr:oneCellAnchor>
  <xdr:from><xdr:col>${image.sheetColumnIndex}</xdr:col><xdr:colOff>50000</xdr:colOff><xdr:row>${image.sheetRowIndex}</xdr:row><xdr:rowOff>50000</xdr:rowOff></xdr:from>
  <xdr:ext cx="${image.widthEmu}" cy="${image.heightEmu}"/>
  <xdr:pic><xdr:nvPicPr><xdr:cNvPr id="${index + 2}" name="$name"/><xdr:cNvPicPr><a:picLocks noChangeAspect="1"/></xdr:cNvPicPr></xdr:nvPicPr><xdr:blipFill><a:blip r:embed="${image.relationshipId}"/><a:stretch><a:fillRect/></a:stretch></xdr:blipFill><xdr:spPr><a:xfrm><a:off x="0" y="0"/><a:ext cx="${image.widthEmu}" cy="${image.heightEmu}"/></a:xfrm><a:prstGeom prst="rect"><a:avLst/></a:prstGeom></xdr:spPr></xdr:pic>
  <xdr:clientData/>
</xdr:oneCellAnchor>"""
        }.joinToString("")
        return """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xdr:wsDr xmlns:xdr="http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing" xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships">$anchors</xdr:wsDr>"""
    }

    private fun drawingRelationships(images: List<EmbeddedImage>): String {
        val relationships = images.joinToString("") {
            "<Relationship Id=\"${it.relationshipId}\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/image\" Target=\"../media/${it.fileName}\"/>"
        }
        return """<?xml version="1.0" encoding="UTF-8" standalone="yes"?><Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">$relationships</Relationships>"""
    }

    companion object {
        fun halfYearAmounts(payment: Payment, yearlyFeeAmount: Double? = null): HalfYearAmounts = when {
            yearlyFeeAmount != null && yearlyFeeAmount > 0.0 && kotlin.math.abs(payment.amount - yearlyFeeAmount) < 0.005 -> splitEvenly(payment.amount)
            payment.paymentType == "second_half" -> HalfYearAmounts(null, payment.amount)
            payment.paymentType == "full_year" -> splitEvenly(payment.amount)
            else -> HalfYearAmounts(payment.amount, null)
        }

        private fun splitEvenly(amount: Double): HalfYearAmounts {
            val first = round(amount * 50.0) / 100.0
            return HalfYearAmounts(first, amount - first)
        }

        private fun isSupportedImage(path: String): Boolean {
            val file = File(path)
            if (!file.isFile || !file.canRead()) return false
            return runCatching {
                file.inputStream().use { input ->
                    val header = ByteArray(12)
                    val bytesRead = input.read(header)
                    imageType(if (bytesRead > 0) header.copyOf(bytesRead) else byteArrayOf()) != null
                }
            }.getOrDefault(false)
        }

        private fun imageType(bytes: ByteArray): Pair<String, String>? = when {
            bytes.size >= 8 && bytes[0] == 0x89.toByte() && bytes[1] == 0x50.toByte() && bytes[2] == 0x4E.toByte() && bytes[3] == 0x47.toByte() -> "png" to "image/png"
            bytes.size >= 3 && bytes[0] == 0xFF.toByte() && bytes[1] == 0xD8.toByte() && bytes[2] == 0xFF.toByte() -> "jpeg" to "image/jpeg"
            else -> null
        }

        private fun imageDimensions(bytes: ByteArray, extension: String): Pair<Int, Int>? {
            if (extension == "png" && bytes.size >= 24) {
                return readInt(bytes, 16) to readInt(bytes, 20)
            }
            if (extension == "jpeg") {
                var offset = 2
                while (offset + 8 < bytes.size) {
                    if (bytes[offset] != 0xFF.toByte()) { offset++; continue }
                    val marker = bytes[offset + 1].toInt() and 0xFF
                    if (marker == 0xD8 || marker == 0xD9) { offset += 2; continue }
                    val length = ((bytes[offset + 2].toInt() and 0xFF) shl 8) or (bytes[offset + 3].toInt() and 0xFF)
                    if (length < 2 || offset + length + 2 > bytes.size) return null
                    if (marker in 0xC0..0xC3 && length >= 7) {
                        val height = ((bytes[offset + 5].toInt() and 0xFF) shl 8) or (bytes[offset + 6].toInt() and 0xFF)
                        val width = ((bytes[offset + 7].toInt() and 0xFF) shl 8) or (bytes[offset + 8].toInt() and 0xFF)
                        return width to height
                    }
                    offset += length + 2
                }
            }
            return null
        }

        private fun readInt(bytes: ByteArray, offset: Int): Int =
            ((bytes[offset].toInt() and 0xFF) shl 24) or ((bytes[offset + 1].toInt() and 0xFF) shl 16) or
                ((bytes[offset + 2].toInt() and 0xFF) shl 8) or (bytes[offset + 3].toInt() and 0xFF)

        private fun fitImage(width: Int, height: Int): Pair<Long, Long> {
            val maxWidth = 2_250_000.0
            val maxHeight = 1_300_000.0
            val scale = minOf(maxWidth / width.coerceAtLeast(1), maxHeight / height.coerceAtLeast(1))
            return (width * scale).toLong() to (height * scale).toLong()
        }

        private fun finite(value: Double): String = if (value.isFinite()) value.toString() else "0"

        private fun xml(value: String): String = value
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&apos;")

        private fun ZipOutputStream.writeText(path: String, text: String) = writeBytes(path, text.toByteArray(Charsets.UTF_8))

        private fun ZipOutputStream.writeBytes(path: String, bytes: ByteArray) {
            putNextEntry(ZipEntry(path))
            write(bytes)
            closeEntry()
        }
    }
}

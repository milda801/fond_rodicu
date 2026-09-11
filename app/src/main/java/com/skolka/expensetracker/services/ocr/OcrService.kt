package com.skolka.expensetracker.services.ocr

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Rect
import android.net.Uri
import androidx.exifinterface.media.ExifInterface
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import java.text.Normalizer
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

data class ReceiptOcrResult(
    val rawText: String,
    val amount: Double?,
    val date: String?,
    val probableNameOrVendor: String?,
    val receiptNumber: String? = null
)

data class ReceiptTextLine(val text: String, val left: Int, val top: Int, val right: Int, val bottom: Int)

class OcrService(private val context: Context) {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    suspend fun recognize(uri: Uri): ReceiptOcrResult = ReceiptParser.parse(process(InputImage.fromFilePath(context, uri)).text)

    suspend fun recognizePayment(uri: Uri, expectedAmounts: List<Double> = emptyList()): ReceiptOcrResult {
        val primary = process(InputImage.fromFilePath(context, uri))
        val lines = primary.textBlocks.flatMap { block -> block.lines }.mapNotNull { line ->
            line.boundingBox?.let { box -> ReceiptTextLine(line.text, box.left, box.top, box.right, box.bottom) }
        }
        val bitmap = loadOrientedBitmap(uri)
        val regions = paymentRegions(lines, bitmap.width, bitmap.height)
        val numberTexts = recognizeRegionVariants(bitmap, regions.number)
        val payerTexts = recognizeRegionVariants(bitmap, regions.payer)
        val amountTexts = recognizeRegionVariants(bitmap, regions.amount)
        bitmap.recycle()
        return ReceiptParser.parsePayment(primary.text, lines, numberTexts, payerTexts, amountTexts, expectedAmounts)
    }

    private suspend fun process(image: InputImage): Text =
        suspendCancellableCoroutine { continuation ->
            recognizer.process(image)
                .addOnSuccessListener(continuation::resume)
                .addOnFailureListener { error -> continuation.resumeWithException(error) }
        }

    private suspend fun recognizeRegionVariants(bitmap: Bitmap, region: Rect): List<String> {
        val blueInk = isolateBlueInk(bitmap, region)
        val blueInkText = runCatching { process(InputImage.fromBitmap(blueInk, 0)).text }
            .getOrDefault("")
            .also { blueInk.recycle() }
        return (listOf(blueInkText) + listOf(1.0f, 1.35f, 1.8f).map { contrast ->
            val enhanced = cropAndEnhance(bitmap, region, contrast)
            runCatching { process(InputImage.fromBitmap(enhanced, 0)).text }
                .getOrDefault("")
                .also { enhanced.recycle() }
        }).distinct()
    }

    private fun loadOrientedBitmap(uri: Uri): Bitmap {
        val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        context.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it, null, options) }
        var sampleSize = 1
        while (maxOf(options.outWidth, options.outHeight) / sampleSize > 3000) sampleSize *= 2
        val decoded = requireNotNull(context.contentResolver.openInputStream(uri)?.use {
            BitmapFactory.decodeStream(it, null, BitmapFactory.Options().apply { inSampleSize = sampleSize })
        }) { "Could not decode receipt image" }
        val orientation = context.contentResolver.openInputStream(uri)?.use { ExifInterface(it).rotationDegrees } ?: 0
        if (orientation == 0) return decoded
        return Bitmap.createBitmap(decoded, 0, 0, decoded.width, decoded.height, Matrix().apply { postRotate(orientation.toFloat()) }, true)
            .also { if (it !== decoded) decoded.recycle() }
    }

    private data class PaymentRegions(val number: Rect, val payer: Rect, val amount: Rect)

    private fun paymentRegions(lines: List<ReceiptTextLine>, width: Int, height: Int): PaymentRegions {
        fun findLabel(vararg labels: String) = lines.firstOrNull { line ->
            val normalized = ReceiptParser.normalized(line.text)
            labels.any(normalized::contains)
        }
        fun safeRect(left: Int, top: Int, right: Int, bottom: Int) = Rect(
            left.coerceIn(0, width - 1), top.coerceIn(0, height - 1),
            right.coerceIn(1, width), bottom.coerceIn(1, height)
        ).also {
            if (it.width() < 2 || it.height() < 2) it.set(0, 0, width, height)
        }

        val numberLabel = findLabel("doklad cislo")
        val payerLabel = findLabel("prijato od", "jmeno adresa")
        val totalLabel = findLabel("celkem")
        val purposeLabel = findLabel("ucel")

        val number = numberLabel?.let {
            val lineHeight = (it.bottom - it.top).coerceAtLeast(1)
            safeRect(it.left - lineHeight, it.top - lineHeight * 7, it.right + lineHeight, it.top)
        } ?: safeRect((width * .48).toInt(), 0, (width * .64).toInt(), (height * .18).toInt())
        val payer = if (payerLabel != null && totalLabel != null) {
            safeRect(payerLabel.right, payerLabel.top, (width * .9).toInt(), totalLabel.top)
        } else safeRect((width * .32).toInt(), (height * .28).toInt(), (width * .9).toInt(), (height * .4).toInt())
        val amount = totalLabel?.let {
            val lineHeight = (it.bottom - it.top).coerceAtLeast(1)
            safeRect(it.left, it.bottom, (width * .55).toInt(), purposeLabel?.top ?: it.bottom + lineHeight * 4)
        } ?: safeRect((width * .18).toInt(), (height * .38).toInt(), (width * .55).toInt(), (height * .49).toInt())
        return PaymentRegions(number, payer, amount)
    }

    private fun cropAndEnhance(source: Bitmap, region: Rect, contrast: Float): Bitmap {
        val cropped = Bitmap.createBitmap(source, region.left, region.top, region.width(), region.height())
        val scale = minOf(3f, 1600f / cropped.width.coerceAtLeast(1)).coerceAtLeast(1.5f)
        val output = Bitmap.createBitmap((cropped.width * scale).toInt(), (cropped.height * scale).toInt(), Bitmap.Config.ARGB_8888)
        val grayscale = ColorMatrix().apply { setSaturation(0f) }
        grayscale.postConcat(ColorMatrix(floatArrayOf(
            contrast, 0f, 0f, 0f, 128f * (1f - contrast),
            0f, contrast, 0f, 0f, 128f * (1f - contrast),
            0f, 0f, contrast, 0f, 128f * (1f - contrast),
            0f, 0f, 0f, 1f, 0f
        )))
        Canvas(output).drawBitmap(cropped, null, Rect(0, 0, output.width, output.height), Paint(Paint.ANTI_ALIAS_FLAG).apply {
            colorFilter = ColorMatrixColorFilter(grayscale)
            isFilterBitmap = true
        })
        cropped.recycle()
        return output
    }

    private fun isolateBlueInk(source: Bitmap, region: Rect): Bitmap {
        val cropped = Bitmap.createBitmap(source, region.left, region.top, region.width(), region.height())
        val pixels = IntArray(cropped.width * cropped.height)
        cropped.getPixels(pixels, 0, cropped.width, 0, 0, cropped.width, cropped.height)
        for (index in pixels.indices) {
            val color = pixels[index]
            val red = Color.red(color)
            val green = Color.green(color)
            val blue = Color.blue(color)
            val chroma = maxOf(red, green, blue) - minOf(red, green, blue)
            val isBlueOrPurpleInk = chroma >= 12 && blue >= red + 6 && blue >= green + 4 && blue < 245
            pixels[index] = if (isBlueOrPurpleInk) Color.BLACK else Color.WHITE
        }
        val isolated = Bitmap.createBitmap(cropped.width, cropped.height, Bitmap.Config.ARGB_8888)
        isolated.setPixels(pixels, 0, cropped.width, 0, 0, cropped.width, cropped.height)
        cropped.recycle()
        val scale = minOf(4f, 1600f / isolated.width.coerceAtLeast(1)).coerceAtLeast(2f)
        return Bitmap.createScaledBitmap(
            isolated,
            (isolated.width * scale).toInt(),
            (isolated.height * scale).toInt(),
            true
        ).also { if (it !== isolated) isolated.recycle() }
    }

    fun close() = recognizer.close()
}

object ReceiptParser {
    private val decimalAmountPattern = Regex("(?<!\\d)(\\d{1,3}(?:[ .\\u00a0]\\d{3})*(?:[,.]\\d{2})|\\d+[,.]\\d{2})(?!\\d)")
    private val totalAmountPattern = Regex("(?<!\\d)(\\d+(?:[ .\\u00a0]\\d{3})*(?:[,.]\\d{1,2})?)(?:\\s*,?\\s*-)?(?!\\d)")
    private val datePatterns = listOf(
        Regex("\\b(\\d{1,2})\\s*[./-]\\s*(\\d{1,2})\\s*[./-]\\s*(\\d{2}|\\d{4})\\b"),
        Regex("\\b(\\d{4})-(\\d{1,2})-(\\d{1,2})\\b")
    )
    private val standaloneReceiptNumberPattern = Regex("(?<!\\d)#?\\s*(\\d{1,4})\\s*[.)/,\\-]?\\s*(?!\\d)")
    private val formLabels = listOf(
        "firma", "doklad cislo", "prijmovy pokladni doklad", "datum vystaveni", "prilohy",
        "prijato od", "jmeno adresa", "celkem", "slovy kc", "ucel", "schvalil",
        "podpis pokladnika", "text", "uctovaci predpis", "bez dane", "dph", "prevzal",
        "zauctoval", "dne"
    )

    fun parse(text: String): ReceiptOcrResult {
        val lines = text.lines().map(String::trim).filter(String::isNotBlank)
        val amount = parseLabeledTotal(lines) ?: decimalAmountPattern.findAll(text)
            .mapNotNull { normalizeAmount(it.groupValues[1]) }.maxOrNull()
        val date = parseDate(text)
        val probableName = parsePayerName(lines) ?: lines.firstOrNull(::isProbableGenericName)
        return ReceiptOcrResult(text, amount, date, probableName, parseReceiptNumber(lines))
    }

    fun parsePayment(
        text: String,
        positionedLines: List<ReceiptTextLine>,
        receiptNumberRegionTexts: List<String>,
        payerRegionTexts: List<String>,
        amountRegionTexts: List<String>,
        expectedAmounts: List<Double> = emptyList()
    ): ReceiptOcrResult {
        val generic = parse(text)
        val receiptNumber = receiptNumberRegionTexts.asSequence().mapNotNull(::parseReceiptNumberRegion).firstOrNull()
            ?: parseSpatialReceiptNumber(positionedLines)
            ?: generic.receiptNumber
        val amountCandidates = buildList {
            amountRegionTexts.forEach { addAll(parseAmountCandidates(it)) }
            parseSpatialAmount(positionedLines)?.let(::add)
            generic.amount?.let(::add)
        }
        val amount = selectPaymentAmount(amountCandidates, expectedAmounts)
        val name = payerRegionTexts.asSequence().flatMap { it.lines() }.map(String::trim).firstOrNull(::isProbablePersonName)
            ?: parseSpatialPayerName(positionedLines)
            ?: generic.probableNameOrVendor
        return generic.copy(amount = amount, probableNameOrVendor = name, receiptNumber = receiptNumber)
    }

    fun bestMatchingNameIndex(extractedName: String?, candidates: List<String>): Int? {
        val target = extractedName?.let(::normalizeForMatching)?.takeIf(String::isNotBlank) ?: return null
        val exactIndex = candidates.indexOfFirst { normalizeForMatching(it) == target }
        if (exactIndex >= 0) return exactIndex

        val targetTokens = target.split(' ').filter(String::isNotBlank).toSet()
        return candidates.mapIndexed { index, candidate ->
            val candidateTokens = normalizeForMatching(candidate).split(' ').filter(String::isNotBlank).toSet()
            val score = targetTokens.intersect(candidateTokens).size.toDouble() /
                targetTokens.union(candidateTokens).size.coerceAtLeast(1)
            index to score
        }.maxByOrNull { it.second }?.takeIf { it.second >= 0.5 }?.first
    }

    internal fun normalized(value: String): String = normalizeForMatching(value)

    private fun parseReceiptNumberRegion(text: String): String? = text.lines().asSequence()
        .map(String::trim).mapNotNull(::extractShortNumber).firstOrNull()

    private fun parseAmountCandidates(text: String): List<Double> = totalAmountPattern.findAll(text)
        .mapNotNull { normalizeAmount(it.groupValues[1]) }
        .filter { it in 1.0..1_000_000.0 }
        .toList()

    fun selectPaymentAmount(candidates: List<Double>, expectedAmounts: List<Double>): Double? {
        val values = candidates.filter { it > 0.0 }.distinct()
        if (values.isEmpty()) return null
        val expected = expectedAmounts.filter { it > 0.0 }.distinct()
        if (expected.isNotEmpty()) {
            val toleranceMatches = values.map { value ->
                value to expected.minOf { target -> kotlin.math.abs(value - target) / target }
            }.filter { it.second <= 0.08 }
            if (toleranceMatches.isNotEmpty()) return toleranceMatches.minBy { it.second }.first

            // A recognizer can merge printed form text into the handwriting (for example
            // 1800 becomes 141787). Never prefill such an impossible value; use the known
            // fee amount only when the field OCR contains its significant digits in order.
            val inferred = expected.firstOrNull { target ->
                val targetDigits = target.toLong().toString()
                values.any { value -> containsDigitsInOrder(value.toLong().toString(), targetDigits) }
            }
            if (inferred != null) return inferred
            return null
        }
        return values.filter { it <= 100_000.0 }.maxOrNull()
    }

    private fun containsDigitsInOrder(value: String, expected: String): Boolean {
        var index = 0
        value.forEach { digit -> if (index < expected.length && digit == expected[index]) index++ }
        return index == expected.length
    }

    private fun parseSpatialReceiptNumber(lines: List<ReceiptTextLine>): String? {
        val label = lines.firstOrNull { normalizeForMatching(it.text).contains("doklad cislo") } ?: return null
        return lines.asSequence().filter { candidate ->
            candidate.bottom <= label.top && candidate.bottom >= label.top - (label.bottom - label.top).coerceAtLeast(1) * 8 &&
                minOf(candidate.right, label.right) > maxOf(candidate.left, label.left)
        }.sortedBy { label.top - it.bottom }.mapNotNull { extractShortNumber(it.text) }.firstOrNull()
    }

    private fun parseSpatialPayerName(lines: List<ReceiptTextLine>): String? {
        val label = lines.firstOrNull {
            val value = normalizeForMatching(it.text)
            value.contains("prijato od") || value.contains("jmeno adresa")
        } ?: return null
        val totalTop = lines.firstOrNull { normalizeForMatching(it.text).contains("celkem") }?.top ?: Int.MAX_VALUE
        return lines.asSequence().filter {
            it.top >= label.top && it.top < totalTop && it.left >= label.left && it !== label
        }.map { it.text.trim() }.firstOrNull(::isProbablePersonName)
    }

    private fun parseSpatialAmount(lines: List<ReceiptTextLine>): Double? {
        val label = lines.firstOrNull { normalizeForMatching(it.text).contains("celkem") } ?: return null
        val purposeTop = lines.firstOrNull { normalizeForMatching(it.text).contains("ucel") }?.top ?: Int.MAX_VALUE
        return lines.asSequence().filter { it.top >= label.top && it.top < purposeTop }
            .flatMap { totalAmountPattern.findAll(it.text).map { match -> match.groupValues[1] } }
            .mapNotNull(::normalizeAmount).filter { it in 1.0..1_000_000.0 }.maxOrNull()
    }

    private fun parseLabeledTotal(lines: List<String>): Double? {
        val totalLineIndex = lines.indexOfFirst { normalizeForMatching(it).contains("celkem") || normalizeForMatching(it).contains("total") }
        if (totalLineIndex < 0) return null

        val candidates = lines.subList(totalLineIndex, minOf(lines.size, totalLineIndex + 4))
            .flatMap { line -> totalAmountPattern.findAll(line).map { it.groupValues[1] }.toList() }
            .mapNotNull(::normalizeAmount)
        return candidates.maxOrNull()
    }

    private fun parsePayerName(lines: List<String>): String? {
        val labelIndex = lines.indexOfFirst { line ->
            val normalized = normalizeForMatching(line)
            normalized.contains("prijato od") || normalized.contains("jmeno adresa")
        }
        if (labelIndex < 0) return null

        val sameLineValue = lines[labelIndex]
            .replace(Regex("(?i)p[řr]ijato\\s+od"), "")
            .replace(Regex("(?i)\\(?jm[eé]no\\s*,?\\s*adresa\\)?"), "")
            .trim(' ', ':', '-', '(', ')')
            .takeIf(::isProbablePersonName)
        if (sameLineValue != null) return sameLineValue

        return lines.drop(labelIndex + 1)
            .take(5)
            .takeWhile { !normalizeForMatching(it).contains("celkem") }
            .firstOrNull(::isProbablePersonName)
    }

    private fun parseReceiptNumber(lines: List<String>): String? {
        val labelIndex = lines.indexOfFirst { line ->
            val normalized = normalizeForMatching(line)
            normalized.contains("doklad") && Regex("\\b(cislo|c)\\b").containsMatchIn(normalized)
        }
        if (labelIndex < 0) return null

        val sameLine = lines[labelIndex]
            .replace(Regex("(?i)doklad\\s*(?:č[ií]slo|cislo|č\\.?|c\\.?)"), "")
            .let(::extractShortNumber)
        if (sameLine != null) return sameLine

        // On this fixed form the handwritten order number is in the box directly above
        // the printed "Doklad číslo" caption. OCR can emit it just before or after the label.
        val nearbyIndexes = (1..5).flatMap { distance -> listOf(labelIndex - distance, labelIndex + distance) }
        return nearbyIndexes.asSequence()
            .filter { it in lines.indices }
            .mapNotNull { extractShortNumber(lines[it]) }
            .firstOrNull()
    }

    private fun extractShortNumber(line: String): String? {
        val matches = standaloneReceiptNumberPattern.findAll(line).toList()
        if (matches.size != 1) return null
        return matches.single().groupValues[1].trimStart('0').ifEmpty { "0" }
    }

    private fun isProbablePersonName(line: String): Boolean {
        val value = line.trim()
        val normalized = normalizeForMatching(value)
        if (value.length !in 3..80 || formLabels.any(normalized::contains)) return false
        if (value.any(Char::isDigit)) return false
        return value.count(Char::isLetter) >= 3 && value.split(Regex("\\s+")).count { it.any(Char::isLetter) } >= 2
    }

    private fun isProbableGenericName(line: String): Boolean {
        val normalized = normalizeForMatching(line)
        return line.any(Char::isLetter) && line.length in 3..80 &&
            decimalAmountPattern.find(line) == null && formLabels.none(normalized::contains)
    }

    private fun normalizeForMatching(value: String): String = Normalizer.normalize(value, Normalizer.Form.NFD)
        .replace(Regex("\\p{M}+"), "")
        .lowercase()
        .replace(Regex("[^a-z0-9]+"), " ")
        .trim()

    private fun normalizeAmount(value: String): Double? {
        val compact = value.replace(" ", "").replace("\u00a0", "")
        val decimalSeparator = maxOf(compact.lastIndexOf(','), compact.lastIndexOf('.'))
        if (decimalSeparator < 0) return compact.toDoubleOrNull()
        val integer = compact.substring(0, decimalSeparator).replace(".", "").replace(",", "")
        val decimal = compact.substring(decimalSeparator + 1)
        return "$integer.$decimal".toDoubleOrNull()
    }

    private fun parseDate(text: String): String? {
        datePatterns.forEachIndexed { index, regex ->
            val match = regex.find(text) ?: return@forEachIndexed
            return runCatching {
                val (year, month, day) = if (index == 0) {
                    Triple(match.groupValues[3], match.groupValues[2], match.groupValues[1])
                } else {
                    Triple(match.groupValues[1], match.groupValues[2], match.groupValues[3])
                }
                val fullYear = year.toInt().let { if (year.length == 2) 2000 + it else it }
                LocalDate.of(fullYear, month.toInt(), day.toInt())
                    .format(DateTimeFormatter.ISO_LOCAL_DATE)
            }.getOrNull()
        }
        return null
    }
}

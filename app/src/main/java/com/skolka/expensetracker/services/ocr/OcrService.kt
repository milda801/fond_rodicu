package com.skolka.expensetracker.services.ocr

import android.net.Uri
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

data class ReceiptOcrResult(
    val rawText: String,
    val amount: Double?,
    val date: String?,
    val probableNameOrVendor: String?
)

class OcrService {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    suspend fun recognize(uri: Uri, imageFactory: (Uri) -> InputImage): ReceiptOcrResult {
        val image = imageFactory(uri)
        val text = suspendCancellableCoroutine<String> { continuation ->
            recognizer.process(image)
                .addOnSuccessListener { result -> continuation.resume(result.text) }
                .addOnFailureListener { error -> continuation.resumeWithException(error) }
        }
        return ReceiptParser.parse(text)
    }

    fun close() = recognizer.close()
}

object ReceiptParser {
    private val amountPattern = Regex("(?<!\\d)(\\d{1,3}(?:[ .]\\d{3})*(?:[,.]\\d{2})|\\d+[,.]\\d{2})(?!\\d)")
    private val datePatterns = listOf(
        Regex("\\b(\\d{1,2})[./-](\\d{1,2})[./-](\\d{4})\\b"),
        Regex("\\b(\\d{4})-(\\d{1,2})-(\\d{1,2})\\b")
    )

    fun parse(text: String): ReceiptOcrResult {
        val lines = text.lines().map(String::trim).filter(String::isNotBlank)
        val amount = amountPattern.findAll(text)
            .mapNotNull { normalizeAmount(it.groupValues[1]) }
            .maxOrNull()
        val date = parseDate(text)
        val probableName = lines.firstOrNull { line ->
            line.any(Char::isLetter) && line.length in 3..80 && amountPattern.find(line) == null
        }
        return ReceiptOcrResult(text, amount, date, probableName)
    }

    private fun normalizeAmount(value: String): Double? {
        val compact = value.replace(" ", "")
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
                LocalDate.of(year.toInt(), month.toInt(), day.toInt())
                    .format(DateTimeFormatter.ISO_LOCAL_DATE)
            }.getOrNull()
        }
        return null
    }
}

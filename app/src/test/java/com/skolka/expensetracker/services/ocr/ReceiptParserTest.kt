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

    @Test
    fun parsesFixedCzechPaymentReceiptFields() {
        val result = ReceiptParser.parse(
            """
            Firma
            3.
            L 7430766
            Doklad číslo
            PŘÍJMOVÝ POKLADNÍ DOKLAD
            Datum vystavení 10. 9. 26
            Přijato od
            (Jméno, adresa)
            Sara Srdinko
            Celkem
            Kč 1800,- slovy Kč
            Účel FOND
            """.trimIndent()
        )

        assertEquals("3", result.receiptNumber)
        assertEquals("Sara Srdinko", result.probableNameOrVendor)
        assertEquals(1800.0, result.amount!!, 0.001)
        assertEquals("2026-09-10", result.date)
    }

    @Test
    fun parsesFieldsWhenValuesShareTheirLabels() {
        val result = ReceiptParser.parse(
            "Doklad cislo: 27\nPrijato od: Žofie Nováková\nCelkem Kč 1 800,-"
        )

        assertEquals("27", result.receiptNumber)
        assertEquals("Žofie Nováková", result.probableNameOrVendor)
        assertEquals(1800.0, result.amount!!, 0.001)
    }

    @Test
    fun matchesOcrNameToKnownChildIgnoringDiacriticsAndCase() {
        val index = ReceiptParser.bestMatchingNameIndex(
            "zofie novakova",
            listOf("Adam Svoboda", "Žofie Nováková")
        )

        assertEquals(1, index)
    }

    @Test
    fun spatialParsingIgnoresPrintedSerialAndUsesFixedFormFields() {
        val result = ReceiptParser.parsePayment(
            text = "7430766\nDoklad číslo\nPŘÍJMOVÝ POKLADNÍ DOKLAD\nPřijato od\nCelkem\nKč",
            positionedLines = listOf(
                ReceiptTextLine("3.", 1010, 85, 1110, 160),
                ReceiptTextLine("7430766", 1290, 35, 1640, 130),
                ReceiptTextLine("Doklad číslo", 1000, 165, 1170, 215),
                ReceiptTextLine("Přijato od", 390, 325, 610, 380),
                ReceiptTextLine("Sara Srdinko", 690, 335, 1110, 395),
                ReceiptTextLine("Celkem", 390, 400, 550, 455),
                ReceiptTextLine("1800,-", 510, 420, 735, 475),
                ReceiptTextLine("Účel", 390, 480, 500, 530)
            ),
            receiptNumberRegionTexts = listOf(""),
            payerRegionTexts = listOf(""),
            amountRegionTexts = listOf("")
        )

        assertEquals("3", result.receiptNumber)
        assertEquals("Sara Srdinko", result.probableNameOrVendor)
        assertEquals(1800.0, result.amount!!, 0.001)
    }

    @Test
    fun enhancedFieldPassesOverrideIncorrectFullPageOcr() {
        val result = ReceiptParser.parsePayment(
            text = "7430766\nDoklad číslo\nPřijato od\nCelkem",
            positionedLines = emptyList(),
            receiptNumberRegionTexts = listOf("3,"),
            payerRegionTexts = listOf("Sara Srdinko"),
            amountRegionTexts = listOf("1800,-")
        )

        assertEquals("3", result.receiptNumber)
        assertEquals("Sara Srdinko", result.probableNameOrVendor)
        assertEquals(1800.0, result.amount!!, 0.001)
    }

    @Test
    fun selectsFeeAmountFromNoisyHandwritingRecognition() {
        val result = ReceiptParser.parsePayment(
            text = "Doklad číslo\nPřijato od\nCelkem",
            positionedLines = emptyList(),
            receiptNumberRegionTexts = listOf("9", "3"),
            payerRegionTexts = listOf("Sara Srdinko"),
            amountRegionTexts = listOf("141787", "1800,-"),
            expectedAmounts = listOf(1800.0, 900.0)
        )

        assertEquals(1800.0, result.amount!!, 0.001)
    }

    @Test
    fun rejectsImpossibleAmountInsteadOfPrefillingIt() {
        assertEquals(null, ReceiptParser.selectPaymentAmount(listOf(141787.0), listOf(1800.0, 900.0)))
    }

    @Test
    fun noisyMergedAmountCanRecoverExpectedFeeWhenDigitsRemainInOrder() {
        assertEquals(1800.0, ReceiptParser.selectPaymentAmount(listOf(14187080.0), listOf(1800.0, 900.0))!!, 0.001)
    }
}

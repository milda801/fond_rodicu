package com.skolka.expensetracker.services.export

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class CzechExportResourcesTest {
    @Test
    fun czechCatalogContainsEveryFixedExportLabel() {
        val english = stringsFrom(File("src/main/res/values/strings.xml"))
        val czech = stringsFrom(File("src/main/res/values-cs/strings.xml"))
        val exportKeys = setOf(
            "report_title", "report_summary", "payments", "payment_receipt_number",
            "child_name", "first_half_amount", "second_half_amount", "receipt_photo",
            "expenses", "receipt_number", "supplier_name", "amount", "description",
            "note", "number_of_children", "total_expected", "total_collected",
            "current_balance", "not_available", "outstanding_children", "all_children_paid"
        )

        assertTrue(exportKeys.all(czech::containsKey))
        assertEquals(exportKeys.size, exportKeys.map(czech::getValue).distinct().size)
        assertFalse(exportKeys.any { english.getValue(it) == czech.getValue(it) })
    }

    private fun stringsFrom(file: File): Map<String, String> {
        val document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
        val nodes = document.getElementsByTagName("string")
        return buildMap {
            for (index in 0 until nodes.length) {
                val element = nodes.item(index) as org.w3c.dom.Element
                put(element.getAttribute("name"), element.textContent)
            }
        }
    }
}

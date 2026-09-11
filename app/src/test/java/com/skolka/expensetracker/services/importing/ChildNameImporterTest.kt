package com.skolka.expensetracker.services.importing

import org.junit.Assert.assertEquals
import org.junit.Test

class ChildNameImporterTest {
    @Test
    fun parsesOneTrimmedNamePerLineAndSkipsBlankLines() {
        val plan = ChildNameImporter.plan("  Jana  Nováková  \n\nPetr Svoboda\r\n", emptyList())

        assertEquals(listOf("Jana Nováková", "Petr Svoboda"), plan.namesToImport)
        assertEquals(emptyList<String>(), plan.duplicateNames)
        assertEquals(2, plan.blankLineCount)
    }

    @Test
    fun detectsExistingAndPastedDuplicatesWithoutCaseOrDiacritics() {
        val plan = ChildNameImporter.plan(
            "Eliska Dvorakova\nELIŠKA DVOŘÁKOVÁ\nPetr Svoboda\npetr svoboda\nJana Nováková",
            listOf("Eliška Dvořáková")
        )

        assertEquals(listOf("Petr Svoboda", "Jana Nováková"), plan.namesToImport)
        assertEquals(listOf("Eliska Dvorakova", "ELIŠKA DVOŘÁKOVÁ", "petr svoboda"), plan.duplicateNames)
    }
}

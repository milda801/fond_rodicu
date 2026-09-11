package com.skolka.expensetracker.services.importing

import java.text.Normalizer
import java.util.Locale

data class ChildNameImportPlan(
    val namesToImport: List<String>,
    val duplicateNames: List<String>,
    val blankLineCount: Int
)

object ChildNameImporter {
    fun plan(pastedText: String, existingNames: Collection<String>): ChildNameImportPlan {
        val existingKeys = existingNames.mapTo(mutableSetOf(), ::duplicateKey)
        val acceptedKeys = mutableSetOf<String>()
        val namesToImport = mutableListOf<String>()
        val duplicateNames = mutableListOf<String>()
        var blankLineCount = 0

        pastedText.replace("\r\n", "\n").replace('\r', '\n').split('\n').forEach { rawLine ->
            val name = rawLine.trim().replace(Regex("\\s+"), " ")
            if (name.isBlank()) {
                blankLineCount++
            } else {
                val key = duplicateKey(name)
                if (key in existingKeys || !acceptedKeys.add(key)) duplicateNames += name else namesToImport += name
            }
        }

        return ChildNameImportPlan(namesToImport, duplicateNames, blankLineCount)
    }

    private fun duplicateKey(name: String): String = Normalizer.normalize(name, Normalizer.Form.NFD)
        .replace(Regex("\\p{M}+"), "")
        .lowercase(Locale.ROOT)
        .trim()
        .replace(Regex("\\s+"), " ")
}

package com.skolka.expensetracker.services.ocr

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.util.UUID

object ReceiptStorage {
    fun newCameraTarget(context: Context): Pair<File, Uri> {
        val file = newFile(context)
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.files", file)
        return file to uri
    }

    fun copyIntoAppStorage(context: Context, source: Uri): File {
        val destination = newFile(context)
        context.contentResolver.openInputStream(source).use { input ->
            requireNotNull(input) { "Could not read selected receipt" }
            destination.outputStream().use(input::copyTo)
        }
        return destination
    }

    private fun newFile(context: Context): File {
        val directory = File(context.filesDir, "receipts").apply { mkdirs() }
        return File(directory, "receipt-${UUID.randomUUID()}.jpg")
    }
}

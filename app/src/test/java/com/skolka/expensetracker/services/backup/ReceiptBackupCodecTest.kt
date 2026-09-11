package com.skolka.expensetracker.services.backup

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.nio.file.Files

class ReceiptBackupCodecTest {
    @Test
    fun encodeAndRestorePreservesReceiptImage() {
        val sourceDirectory = Files.createTempDirectory("receipt-source").toFile()
        val restoreDirectory = Files.createTempDirectory("receipt-restore").toFile()
        try {
            val bytes = byteArrayOf(0x01, 0x23, 0x45, 0x67)
            val source = sourceDirectory.resolve("receipt.jpg").apply { writeBytes(bytes) }

            val encoded = ReceiptBackupCodec.encode("expense", "expense-1", source)
            val restored = ReceiptBackupCodec.restore(listOf(encoded), restoreDirectory)
            val restoredFile = File(restored.getValue("expense:expense-1"))

            assertTrue(restoredFile.isFile)
            assertArrayEquals(bytes, restoredFile.readBytes())
            assertEquals("receipt.jpg", encoded.fileName)
        } finally {
            sourceDirectory.deleteRecursively()
            restoreDirectory.deleteRecursively()
        }
    }

    @Test(expected = IllegalArgumentException::class)
    fun encodeRejectsEmptyReceiptImage() {
        val directory = Files.createTempDirectory("empty-receipt").toFile()
        try {
            ReceiptBackupCodec.encode("payment", "payment-1", directory.resolve("empty.jpg").apply { createNewFile() })
        } finally {
            directory.deleteRecursively()
        }
    }
}

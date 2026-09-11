package com.skolka.expensetracker.services.backup

import com.google.gson.GsonBuilder
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.repository.ChildRepository
import com.skolka.expensetracker.data.repository.ExpenseRepository
import com.skolka.expensetracker.data.repository.FeeConfigurationRepository
import com.skolka.expensetracker.data.repository.PaymentRepository
import kotlinx.coroutines.flow.first
import java.io.File
import java.time.Instant
import java.util.Base64
import java.util.UUID

data class ReceiptBackup(
    val recordType: String,
    val recordId: String,
    val fileName: String,
    val base64Data: String
)

data class AppBackup(
    val formatVersion: Int = 2,
    val createdAt: String,
    val children: List<Child>,
    val feeConfigurations: List<FeeConfiguration>,
    val payments: List<Payment>,
    val expenses: List<Expense>,
    val receipts: List<ReceiptBackup> = emptyList()
)

class BackupService(
    private val children: ChildRepository,
    private val fees: FeeConfigurationRepository,
    private val payments: PaymentRepository,
    private val expenses: ExpenseRepository,
    private val receiptDirectory: File
) {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    suspend fun createJson(): String {
        val paymentRecords = payments.getAllPayments().first()
        val expenseRecords = expenses.getAllExpenses().first()
        val receipts = buildList {
            paymentRecords.forEach { payment -> payment.receiptPath?.let { path -> encodeReceipt("payment", payment.id, path)?.let(::add) } }
            expenseRecords.forEach { expense -> expense.receiptPath?.let { path -> encodeReceipt("expense", expense.id, path)?.let(::add) } }
        }
        require(receipts.size == paymentRecords.size + expenseRecords.size) {
            "Every payment and expense must have a readable receipt image before backup"
        }
        return gson.toJson(AppBackup(
            createdAt = Instant.now().toString(),
            children = children.getAllChildren().first(),
            feeConfigurations = fees.getAllFeeConfigs().first(),
            payments = paymentRecords,
            expenses = expenseRecords,
            receipts = receipts
        ))
    }

    suspend fun restoreJson(json: String): AppBackup {
        val backup = requireNotNull(gson.fromJson(json, AppBackup::class.java)) { "Invalid backup file" }
        require(backup.formatVersion in 1..2) { "Unsupported backup version: ${backup.formatVersion}" }
        require(backup.children.none { it.name.isBlank() }) { "Backup contains an invalid child" }
        require(backup.feeConfigurations.all { it.yearlyFeeAmount > 0.0 }) { "Backup contains an invalid fee" }
        require(backup.payments.all { it.amount > 0.0 }) { "Backup contains an invalid payment" }
        require(backup.expenses.all { it.amount > 0.0 }) { "Backup contains an invalid expense" }

        val restoredPaths = if (backup.formatVersion >= 2) ReceiptBackupCodec.restore(backup.receipts, receiptDirectory) else emptyMap()
        require(backup.formatVersion < 2 || backup.payments.all { restoredPaths.containsKey("payment:${it.id}") }) { "Backup is missing a payment receipt image" }
        require(backup.formatVersion < 2 || backup.expenses.all { restoredPaths.containsKey("expense:${it.id}") }) { "Backup is missing an expense receipt image" }

        backup.children.forEach { children.insertChild(it) }
        backup.feeConfigurations.forEach { fees.insertFeeConfiguration(it) }
        backup.payments.forEach {
            payments.insertPayment(it.copy(receiptPath = restoredPaths["payment:${it.id}"], receiptNumber = it.receiptNumber.orEmpty()))
        }
        backup.expenses.forEach {
            expenses.insertExpense(
                it.copy(
                    receiptNumber = it.receiptNumber.orEmpty(),
                    supplierName = it.supplierName.orEmpty(),
                    receiptPath = restoredPaths["expense:${it.id}"]
                )
            )
        }
        return backup
    }

    private fun encodeReceipt(recordType: String, recordId: String, path: String): ReceiptBackup? {
        val file = File(path).takeIf { it.isFile && it.length() > 0L } ?: return null
        return ReceiptBackupCodec.encode(recordType, recordId, file)
    }
}

object ReceiptBackupCodec {
    fun encode(recordType: String, recordId: String, file: File): ReceiptBackup {
        require(file.isFile && file.length() > 0L) { "Receipt image is missing or empty" }
        return ReceiptBackup(recordType, recordId, file.name, Base64.getEncoder().encodeToString(file.readBytes()))
    }

    fun restore(receipts: List<ReceiptBackup>, receiptDirectory: File): Map<String, String> {
        receiptDirectory.mkdirs()
        return receipts.associate { receipt ->
            require(receipt.recordType == "payment" || receipt.recordType == "expense") { "Invalid receipt type" }
            val bytes = Base64.getDecoder().decode(receipt.base64Data)
            require(bytes.isNotEmpty()) { "Backup contains an empty receipt image" }
            val extension = File(receipt.fileName).extension.takeIf { it.matches(Regex("[A-Za-z0-9]{1,5}")) } ?: "jpg"
            val destination = File(receiptDirectory, "restored-${UUID.randomUUID()}.$extension")
            destination.writeBytes(bytes)
            "${receipt.recordType}:${receipt.recordId}" to destination.absolutePath
        }
    }
}

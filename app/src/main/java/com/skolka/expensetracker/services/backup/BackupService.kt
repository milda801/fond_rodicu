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
import java.time.Instant

data class AppBackup(
    val formatVersion: Int = 1,
    val createdAt: String,
    val children: List<Child>,
    val feeConfigurations: List<FeeConfiguration>,
    val payments: List<Payment>,
    val expenses: List<Expense>
)

class BackupService(
    private val children: ChildRepository,
    private val fees: FeeConfigurationRepository,
    private val payments: PaymentRepository,
    private val expenses: ExpenseRepository
) {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    suspend fun createJson(): String = gson.toJson(
        AppBackup(
            createdAt = Instant.now().toString(),
            children = children.getAllChildren().first(),
            feeConfigurations = fees.getAllFeeConfigs().first(),
            payments = payments.getAllPayments().first(),
            expenses = expenses.getAllExpenses().first()
        )
    )

    suspend fun restoreJson(json: String): AppBackup {
        val backup = requireNotNull(gson.fromJson(json, AppBackup::class.java)) { "Invalid backup file" }
        require(backup.formatVersion == 1) { "Unsupported backup version: ${backup.formatVersion}" }
        require(backup.children.none { it.name.isBlank() }) { "Backup contains an invalid child" }
        require(backup.feeConfigurations.all { it.yearlyFeeAmount > 0.0 }) { "Backup contains an invalid fee" }
        require(backup.payments.all { it.amount > 0.0 }) { "Backup contains an invalid payment" }
        require(backup.expenses.all { it.amount > 0.0 }) { "Backup contains an invalid expense" }

        backup.children.forEach { children.insertChild(it) }
        backup.feeConfigurations.forEach { fees.insertFeeConfiguration(it) }
        backup.payments.forEach { payments.insertPayment(it) }
        backup.expenses.forEach { expenses.insertExpense(it) }
        return backup
    }
}

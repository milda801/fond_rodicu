package com.skolka.expensetracker

import android.app.Application
import com.skolka.expensetracker.data.database.AppDatabase
import com.skolka.expensetracker.data.repository.ChildRepository
import com.skolka.expensetracker.data.repository.ExpenseRepository
import com.skolka.expensetracker.data.repository.FeeConfigurationRepository
import com.skolka.expensetracker.data.repository.PaymentRepository
import com.skolka.expensetracker.data.repository.SyncMetadataRepository

class ExpenseTrackerApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val childRepository by lazy { ChildRepository(database.childDao()) }
    val paymentRepository by lazy { PaymentRepository(database.paymentDao()) }
    val expenseRepository by lazy { ExpenseRepository(database.expenseDao()) }
    val feeRepository by lazy { FeeConfigurationRepository(database.feeConfigurationDao()) }
    val syncRepository by lazy { SyncMetadataRepository(database.syncMetadataDao()) }
}

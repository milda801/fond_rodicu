package com.skolka.expensetracker.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.skolka.expensetracker.ExpenseTrackerApplication
import com.skolka.expensetracker.services.backup.BackupPreferences
import com.skolka.expensetracker.services.backup.BackupService
import java.time.Instant

class BackupWorker(context: Context, parameters: WorkerParameters) : CoroutineWorker(context, parameters) {
    override suspend fun doWork(): Result {
        val uri = BackupPreferences.getUri(applicationContext) ?: return Result.success()
        val app = applicationContext as ExpenseTrackerApplication
        return runCatching {
            val json = BackupService(app.childRepository, app.feeRepository, app.paymentRepository, app.expenseRepository, java.io.File(applicationContext.filesDir, "receipts")).createJson()
            applicationContext.contentResolver.openOutputStream(uri, "wt")?.bufferedWriter()?.use { it.write(json) }
                ?: error("Cloud backup destination is unavailable")
            BackupPreferences.saveSuccess(applicationContext, Instant.now().toString())
            Result.success()
        }.getOrElse {
            BackupPreferences.saveError(applicationContext, it.message ?: "Unknown backup error")
            Result.retry()
        }
    }
}

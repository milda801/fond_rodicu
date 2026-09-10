package com.skolka.expensetracker.data.models

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(defaultValue = "''")
    val receiptNumber: String = "",
    val expenseDate: String,
    val category: String, // supplies, food, activities, utilities, other
    @ColumnInfo(defaultValue = "''")
    val supplierName: String = "",
    val description: String,
    val amount: Double,
    val receiptPath: String? = null,
    val ocrExtractedVendor: String? = null,
    val ocrExtractedAmount: Double? = null,
    val ocrExtractedDate: String? = null,
    val manualEntry: Boolean = false,
    val notes: String? = null,
    val createdAt: String = System.currentTimeMillis().toString(),
    val updatedAt: String = System.currentTimeMillis().toString()
)

package com.skolka.expensetracker.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "payments",
    foreignKeys = [
        ForeignKey(
            entity = Child::class,
            parentColumns = ["id"],
            childColumns = ["childId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FeeConfiguration::class,
            parentColumns = ["id"],
            childColumns = ["feeConfigId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["childId"]),
        Index(value = ["feeConfigId"])
    ]
)
data class Payment(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val childId: String,
    val feeConfigId: String,
    val amount: Double,
    val paymentDate: String,
    val paymentType: String, // full_year, first_half, second_half
    val receiptPath: String? = null,
    val ocrExtractedName: String? = null,
    val ocrExtractedAmount: Double? = null,
    val manualEntry: Boolean = false,
    val notes: String? = null,
    val createdAt: String = System.currentTimeMillis().toString(),
    val updatedAt: String = System.currentTimeMillis().toString()
)

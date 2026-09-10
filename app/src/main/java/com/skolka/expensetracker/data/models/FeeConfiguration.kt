package com.skolka.expensetracker.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "fee_configurations")
data class FeeConfiguration(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val academicYear: String, // e.g., "2024-2025"
    val yearlyFeeAmount: Double,
    val splitOption: String = "full_year", // full_year, two_halves
    val firstHalfDueDate: String? = null,
    val secondHalfDueDate: String? = null,
    val createdAt: String = System.currentTimeMillis().toString(),
    val updatedAt: String = System.currentTimeMillis().toString()
)

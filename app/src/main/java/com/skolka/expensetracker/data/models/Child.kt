package com.skolka.expensetracker.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "children")
data class Child(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val enrollmentDate: String,
    val status: String = "active", // active, inactive
    val notes: String? = null,
    val createdAt: String = System.currentTimeMillis().toString(),
    val updatedAt: String = System.currentTimeMillis().toString()
)

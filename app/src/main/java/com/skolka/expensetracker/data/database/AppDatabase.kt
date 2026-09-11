package com.skolka.expensetracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.skolka.expensetracker.data.dao.ChildDao
import com.skolka.expensetracker.data.dao.ExpenseDao
import com.skolka.expensetracker.data.dao.FeeConfigurationDao
import com.skolka.expensetracker.data.dao.PaymentDao
import com.skolka.expensetracker.data.dao.SyncMetadataDao
import com.skolka.expensetracker.data.models.Child
import com.skolka.expensetracker.data.models.Expense
import com.skolka.expensetracker.data.models.FeeConfiguration
import com.skolka.expensetracker.data.models.Payment
import com.skolka.expensetracker.data.models.SyncMetadata

@Database(
    entities = [
        Child::class,
        FeeConfiguration::class,
        Payment::class,
        Expense::class,
        SyncMetadata::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun childDao(): ChildDao
    abstract fun feeConfigurationDao(): FeeConfigurationDao
    abstract fun paymentDao(): PaymentDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun syncMetadataDao(): SyncMetadataDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "kindergarten_expense_tracker_db"
                )
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE expenses ADD COLUMN receiptNumber TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE expenses ADD COLUMN supplierName TEXT NOT NULL DEFAULT ''")
            }
        }


        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE payments ADD COLUMN receiptNumber TEXT NOT NULL DEFAULT ''")
            }
        }
    }
}

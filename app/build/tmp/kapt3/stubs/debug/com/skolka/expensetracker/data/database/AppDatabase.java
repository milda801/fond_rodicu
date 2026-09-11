package com.skolka.expensetracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/skolka/expensetracker/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "childDao", "Lcom/skolka/expensetracker/data/dao/ChildDao;", "expenseDao", "Lcom/skolka/expensetracker/data/dao/ExpenseDao;", "feeConfigurationDao", "Lcom/skolka/expensetracker/data/dao/FeeConfigurationDao;", "paymentDao", "Lcom/skolka/expensetracker/data/dao/PaymentDao;", "syncMetadataDao", "Lcom/skolka/expensetracker/data/dao/SyncMetadataDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.skolka.expensetracker.data.models.Child.class, com.skolka.expensetracker.data.models.FeeConfiguration.class, com.skolka.expensetracker.data.models.Payment.class, com.skolka.expensetracker.data.models.Expense.class, com.skolka.expensetracker.data.models.SyncMetadata.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.skolka.expensetracker.data.database.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    @org.jetbrains.annotations.NotNull
    public static final com.skolka.expensetracker.data.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.skolka.expensetracker.data.dao.ChildDao childDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.skolka.expensetracker.data.dao.FeeConfigurationDao feeConfigurationDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.skolka.expensetracker.data.dao.PaymentDao paymentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.skolka.expensetracker.data.dao.ExpenseDao expenseDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.skolka.expensetracker.data.dao.SyncMetadataDao syncMetadataDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/skolka/expensetracker/data/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/skolka/expensetracker/data/database/AppDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.skolka.expensetracker.data.database.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}
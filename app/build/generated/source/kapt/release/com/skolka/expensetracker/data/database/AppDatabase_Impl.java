package com.skolka.expensetracker.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.skolka.expensetracker.data.dao.ChildDao;
import com.skolka.expensetracker.data.dao.ChildDao_Impl;
import com.skolka.expensetracker.data.dao.ExpenseDao;
import com.skolka.expensetracker.data.dao.ExpenseDao_Impl;
import com.skolka.expensetracker.data.dao.FeeConfigurationDao;
import com.skolka.expensetracker.data.dao.FeeConfigurationDao_Impl;
import com.skolka.expensetracker.data.dao.PaymentDao;
import com.skolka.expensetracker.data.dao.PaymentDao_Impl;
import com.skolka.expensetracker.data.dao.SyncMetadataDao;
import com.skolka.expensetracker.data.dao.SyncMetadataDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ChildDao _childDao;

  private volatile FeeConfigurationDao _feeConfigurationDao;

  private volatile PaymentDao _paymentDao;

  private volatile ExpenseDao _expenseDao;

  private volatile SyncMetadataDao _syncMetadataDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `children` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `enrollmentDate` TEXT NOT NULL, `status` TEXT NOT NULL, `notes` TEXT, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `fee_configurations` (`id` TEXT NOT NULL, `academicYear` TEXT NOT NULL, `yearlyFeeAmount` REAL NOT NULL, `splitOption` TEXT NOT NULL, `firstHalfDueDate` TEXT, `secondHalfDueDate` TEXT, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `payments` (`id` TEXT NOT NULL, `childId` TEXT NOT NULL, `feeConfigId` TEXT NOT NULL, `amount` REAL NOT NULL, `paymentDate` TEXT NOT NULL, `paymentType` TEXT NOT NULL, `receiptPath` TEXT, `receiptNumber` TEXT NOT NULL, `ocrExtractedName` TEXT, `ocrExtractedAmount` REAL, `manualEntry` INTEGER NOT NULL, `notes` TEXT, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`childId`) REFERENCES `children`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`feeConfigId`) REFERENCES `fee_configurations`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_payments_childId` ON `payments` (`childId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_payments_feeConfigId` ON `payments` (`feeConfigId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `expenses` (`id` TEXT NOT NULL, `receiptNumber` TEXT NOT NULL DEFAULT '', `expenseDate` TEXT NOT NULL, `category` TEXT NOT NULL, `supplierName` TEXT NOT NULL DEFAULT '', `description` TEXT NOT NULL, `amount` REAL NOT NULL, `receiptPath` TEXT, `ocrExtractedVendor` TEXT, `ocrExtractedAmount` REAL, `ocrExtractedDate` TEXT, `manualEntry` INTEGER NOT NULL, `notes` TEXT, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sync_metadata` (`id` TEXT NOT NULL, `lastSyncTime` TEXT, `lastBackupTime` TEXT, `cloudProvider` TEXT, `syncStatus` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'febb07a217dc36656c5489dee04ca2e0')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `children`");
        db.execSQL("DROP TABLE IF EXISTS `fee_configurations`");
        db.execSQL("DROP TABLE IF EXISTS `payments`");
        db.execSQL("DROP TABLE IF EXISTS `expenses`");
        db.execSQL("DROP TABLE IF EXISTS `sync_metadata`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsChildren = new HashMap<String, TableInfo.Column>(7);
        _columnsChildren.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("enrollmentDate", new TableInfo.Column("enrollmentDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChildren = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChildren = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChildren = new TableInfo("children", _columnsChildren, _foreignKeysChildren, _indicesChildren);
        final TableInfo _existingChildren = TableInfo.read(db, "children");
        if (!_infoChildren.equals(_existingChildren)) {
          return new RoomOpenHelper.ValidationResult(false, "children(com.skolka.expensetracker.data.models.Child).\n"
                  + " Expected:\n" + _infoChildren + "\n"
                  + " Found:\n" + _existingChildren);
        }
        final HashMap<String, TableInfo.Column> _columnsFeeConfigurations = new HashMap<String, TableInfo.Column>(8);
        _columnsFeeConfigurations.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("academicYear", new TableInfo.Column("academicYear", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("yearlyFeeAmount", new TableInfo.Column("yearlyFeeAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("splitOption", new TableInfo.Column("splitOption", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("firstHalfDueDate", new TableInfo.Column("firstHalfDueDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("secondHalfDueDate", new TableInfo.Column("secondHalfDueDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFeeConfigurations.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFeeConfigurations = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFeeConfigurations = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFeeConfigurations = new TableInfo("fee_configurations", _columnsFeeConfigurations, _foreignKeysFeeConfigurations, _indicesFeeConfigurations);
        final TableInfo _existingFeeConfigurations = TableInfo.read(db, "fee_configurations");
        if (!_infoFeeConfigurations.equals(_existingFeeConfigurations)) {
          return new RoomOpenHelper.ValidationResult(false, "fee_configurations(com.skolka.expensetracker.data.models.FeeConfiguration).\n"
                  + " Expected:\n" + _infoFeeConfigurations + "\n"
                  + " Found:\n" + _existingFeeConfigurations);
        }
        final HashMap<String, TableInfo.Column> _columnsPayments = new HashMap<String, TableInfo.Column>(14);
        _columnsPayments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("childId", new TableInfo.Column("childId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("feeConfigId", new TableInfo.Column("feeConfigId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("paymentDate", new TableInfo.Column("paymentDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("paymentType", new TableInfo.Column("paymentType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("receiptPath", new TableInfo.Column("receiptPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("receiptNumber", new TableInfo.Column("receiptNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("ocrExtractedName", new TableInfo.Column("ocrExtractedName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("ocrExtractedAmount", new TableInfo.Column("ocrExtractedAmount", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("manualEntry", new TableInfo.Column("manualEntry", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPayments = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPayments.add(new TableInfo.ForeignKey("children", "CASCADE", "NO ACTION", Arrays.asList("childId"), Arrays.asList("id")));
        _foreignKeysPayments.add(new TableInfo.ForeignKey("fee_configurations", "CASCADE", "NO ACTION", Arrays.asList("feeConfigId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPayments = new HashSet<TableInfo.Index>(2);
        _indicesPayments.add(new TableInfo.Index("index_payments_childId", false, Arrays.asList("childId"), Arrays.asList("ASC")));
        _indicesPayments.add(new TableInfo.Index("index_payments_feeConfigId", false, Arrays.asList("feeConfigId"), Arrays.asList("ASC")));
        final TableInfo _infoPayments = new TableInfo("payments", _columnsPayments, _foreignKeysPayments, _indicesPayments);
        final TableInfo _existingPayments = TableInfo.read(db, "payments");
        if (!_infoPayments.equals(_existingPayments)) {
          return new RoomOpenHelper.ValidationResult(false, "payments(com.skolka.expensetracker.data.models.Payment).\n"
                  + " Expected:\n" + _infoPayments + "\n"
                  + " Found:\n" + _existingPayments);
        }
        final HashMap<String, TableInfo.Column> _columnsExpenses = new HashMap<String, TableInfo.Column>(15);
        _columnsExpenses.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("receiptNumber", new TableInfo.Column("receiptNumber", "TEXT", true, 0, "''", TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("expenseDate", new TableInfo.Column("expenseDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("supplierName", new TableInfo.Column("supplierName", "TEXT", true, 0, "''", TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("receiptPath", new TableInfo.Column("receiptPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("ocrExtractedVendor", new TableInfo.Column("ocrExtractedVendor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("ocrExtractedAmount", new TableInfo.Column("ocrExtractedAmount", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("ocrExtractedDate", new TableInfo.Column("ocrExtractedDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("manualEntry", new TableInfo.Column("manualEntry", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExpenses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExpenses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExpenses = new TableInfo("expenses", _columnsExpenses, _foreignKeysExpenses, _indicesExpenses);
        final TableInfo _existingExpenses = TableInfo.read(db, "expenses");
        if (!_infoExpenses.equals(_existingExpenses)) {
          return new RoomOpenHelper.ValidationResult(false, "expenses(com.skolka.expensetracker.data.models.Expense).\n"
                  + " Expected:\n" + _infoExpenses + "\n"
                  + " Found:\n" + _existingExpenses);
        }
        final HashMap<String, TableInfo.Column> _columnsSyncMetadata = new HashMap<String, TableInfo.Column>(5);
        _columnsSyncMetadata.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSyncMetadata.put("lastSyncTime", new TableInfo.Column("lastSyncTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSyncMetadata.put("lastBackupTime", new TableInfo.Column("lastBackupTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSyncMetadata.put("cloudProvider", new TableInfo.Column("cloudProvider", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSyncMetadata.put("syncStatus", new TableInfo.Column("syncStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSyncMetadata = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSyncMetadata = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSyncMetadata = new TableInfo("sync_metadata", _columnsSyncMetadata, _foreignKeysSyncMetadata, _indicesSyncMetadata);
        final TableInfo _existingSyncMetadata = TableInfo.read(db, "sync_metadata");
        if (!_infoSyncMetadata.equals(_existingSyncMetadata)) {
          return new RoomOpenHelper.ValidationResult(false, "sync_metadata(com.skolka.expensetracker.data.models.SyncMetadata).\n"
                  + " Expected:\n" + _infoSyncMetadata + "\n"
                  + " Found:\n" + _existingSyncMetadata);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "febb07a217dc36656c5489dee04ca2e0", "d0e83068ffec29d21272fa66a1a0afb2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "children","fee_configurations","payments","expenses","sync_metadata");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `children`");
      _db.execSQL("DELETE FROM `fee_configurations`");
      _db.execSQL("DELETE FROM `payments`");
      _db.execSQL("DELETE FROM `expenses`");
      _db.execSQL("DELETE FROM `sync_metadata`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ChildDao.class, ChildDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FeeConfigurationDao.class, FeeConfigurationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PaymentDao.class, PaymentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExpenseDao.class, ExpenseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SyncMetadataDao.class, SyncMetadataDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ChildDao childDao() {
    if (_childDao != null) {
      return _childDao;
    } else {
      synchronized(this) {
        if(_childDao == null) {
          _childDao = new ChildDao_Impl(this);
        }
        return _childDao;
      }
    }
  }

  @Override
  public FeeConfigurationDao feeConfigurationDao() {
    if (_feeConfigurationDao != null) {
      return _feeConfigurationDao;
    } else {
      synchronized(this) {
        if(_feeConfigurationDao == null) {
          _feeConfigurationDao = new FeeConfigurationDao_Impl(this);
        }
        return _feeConfigurationDao;
      }
    }
  }

  @Override
  public PaymentDao paymentDao() {
    if (_paymentDao != null) {
      return _paymentDao;
    } else {
      synchronized(this) {
        if(_paymentDao == null) {
          _paymentDao = new PaymentDao_Impl(this);
        }
        return _paymentDao;
      }
    }
  }

  @Override
  public ExpenseDao expenseDao() {
    if (_expenseDao != null) {
      return _expenseDao;
    } else {
      synchronized(this) {
        if(_expenseDao == null) {
          _expenseDao = new ExpenseDao_Impl(this);
        }
        return _expenseDao;
      }
    }
  }

  @Override
  public SyncMetadataDao syncMetadataDao() {
    if (_syncMetadataDao != null) {
      return _syncMetadataDao;
    } else {
      synchronized(this) {
        if(_syncMetadataDao == null) {
          _syncMetadataDao = new SyncMetadataDao_Impl(this);
        }
        return _syncMetadataDao;
      }
    }
  }
}

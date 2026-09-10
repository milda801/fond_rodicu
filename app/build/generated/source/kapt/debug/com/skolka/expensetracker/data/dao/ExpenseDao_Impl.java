package com.skolka.expensetracker.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.skolka.expensetracker.data.models.Expense;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ExpenseDao_Impl implements ExpenseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Expense> __insertionAdapterOfExpense;

  private final EntityDeletionOrUpdateAdapter<Expense> __deletionAdapterOfExpense;

  private final EntityDeletionOrUpdateAdapter<Expense> __updateAdapterOfExpense;

  private final SharedSQLiteStatement __preparedStmtOfDeleteExpenseById;

  public ExpenseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExpense = new EntityInsertionAdapter<Expense>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `expenses` (`id`,`receiptNumber`,`expenseDate`,`category`,`supplierName`,`description`,`amount`,`receiptPath`,`ocrExtractedVendor`,`ocrExtractedAmount`,`ocrExtractedDate`,`manualEntry`,`notes`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Expense entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getReceiptNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getReceiptNumber());
        }
        if (entity.getExpenseDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getExpenseDate());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getSupplierName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSupplierName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        statement.bindDouble(7, entity.getAmount());
        if (entity.getReceiptPath() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getReceiptPath());
        }
        if (entity.getOcrExtractedVendor() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOcrExtractedVendor());
        }
        if (entity.getOcrExtractedAmount() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getOcrExtractedAmount());
        }
        if (entity.getOcrExtractedDate() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getOcrExtractedDate());
        }
        final int _tmp = entity.getManualEntry() ? 1 : 0;
        statement.bindLong(12, _tmp);
        if (entity.getNotes() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getNotes());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getUpdatedAt());
        }
      }
    };
    this.__deletionAdapterOfExpense = new EntityDeletionOrUpdateAdapter<Expense>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `expenses` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Expense entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfExpense = new EntityDeletionOrUpdateAdapter<Expense>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `expenses` SET `id` = ?,`receiptNumber` = ?,`expenseDate` = ?,`category` = ?,`supplierName` = ?,`description` = ?,`amount` = ?,`receiptPath` = ?,`ocrExtractedVendor` = ?,`ocrExtractedAmount` = ?,`ocrExtractedDate` = ?,`manualEntry` = ?,`notes` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Expense entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getReceiptNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getReceiptNumber());
        }
        if (entity.getExpenseDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getExpenseDate());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getSupplierName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSupplierName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDescription());
        }
        statement.bindDouble(7, entity.getAmount());
        if (entity.getReceiptPath() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getReceiptPath());
        }
        if (entity.getOcrExtractedVendor() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOcrExtractedVendor());
        }
        if (entity.getOcrExtractedAmount() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getOcrExtractedAmount());
        }
        if (entity.getOcrExtractedDate() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getOcrExtractedDate());
        }
        final int _tmp = entity.getManualEntry() ? 1 : 0;
        statement.bindLong(12, _tmp);
        if (entity.getNotes() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getNotes());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getUpdatedAt());
        }
        if (entity.getId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteExpenseById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM expenses WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Expense expense, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfExpense.insertAndReturnId(expense);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Expense expense, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfExpense.handle(expense);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Expense expense, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExpense.handle(expense);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExpenseById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteExpenseById.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteExpenseById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getExpenseById(final String id, final Continuation<? super Expense> $completion) {
    final String _sql = "SELECT * FROM expenses WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Expense>() {
      @Override
      @Nullable
      public Expense call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfExpenseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expenseDate");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplierName = CursorUtil.getColumnIndexOrThrow(_cursor, "supplierName");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfOcrExtractedVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedVendor");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfOcrExtractedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedDate");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Expense _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpExpenseDate;
            if (_cursor.isNull(_cursorIndexOfExpenseDate)) {
              _tmpExpenseDate = null;
            } else {
              _tmpExpenseDate = _cursor.getString(_cursorIndexOfExpenseDate);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplierName;
            if (_cursor.isNull(_cursorIndexOfSupplierName)) {
              _tmpSupplierName = null;
            } else {
              _tmpSupplierName = _cursor.getString(_cursorIndexOfSupplierName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpOcrExtractedVendor;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedVendor)) {
              _tmpOcrExtractedVendor = null;
            } else {
              _tmpOcrExtractedVendor = _cursor.getString(_cursorIndexOfOcrExtractedVendor);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
            }
            final String _tmpOcrExtractedDate;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedDate)) {
              _tmpOcrExtractedDate = null;
            } else {
              _tmpOcrExtractedDate = _cursor.getString(_cursorIndexOfOcrExtractedDate);
            }
            final boolean _tmpManualEntry;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfManualEntry);
            _tmpManualEntry = _tmp != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _result = new Expense(_tmpId,_tmpReceiptNumber,_tmpExpenseDate,_tmpCategory,_tmpSupplierName,_tmpDescription,_tmpAmount,_tmpReceiptPath,_tmpOcrExtractedVendor,_tmpOcrExtractedAmount,_tmpOcrExtractedDate,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Expense>> getExpensesByCategory(final String category) {
    final String _sql = "SELECT * FROM expenses WHERE category = ? ORDER BY expenseDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"expenses"}, new Callable<List<Expense>>() {
      @Override
      @NonNull
      public List<Expense> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfExpenseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expenseDate");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplierName = CursorUtil.getColumnIndexOrThrow(_cursor, "supplierName");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfOcrExtractedVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedVendor");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfOcrExtractedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedDate");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Expense> _result = new ArrayList<Expense>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Expense _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpExpenseDate;
            if (_cursor.isNull(_cursorIndexOfExpenseDate)) {
              _tmpExpenseDate = null;
            } else {
              _tmpExpenseDate = _cursor.getString(_cursorIndexOfExpenseDate);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplierName;
            if (_cursor.isNull(_cursorIndexOfSupplierName)) {
              _tmpSupplierName = null;
            } else {
              _tmpSupplierName = _cursor.getString(_cursorIndexOfSupplierName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpOcrExtractedVendor;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedVendor)) {
              _tmpOcrExtractedVendor = null;
            } else {
              _tmpOcrExtractedVendor = _cursor.getString(_cursorIndexOfOcrExtractedVendor);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
            }
            final String _tmpOcrExtractedDate;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedDate)) {
              _tmpOcrExtractedDate = null;
            } else {
              _tmpOcrExtractedDate = _cursor.getString(_cursorIndexOfOcrExtractedDate);
            }
            final boolean _tmpManualEntry;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfManualEntry);
            _tmpManualEntry = _tmp != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Expense(_tmpId,_tmpReceiptNumber,_tmpExpenseDate,_tmpCategory,_tmpSupplierName,_tmpDescription,_tmpAmount,_tmpReceiptPath,_tmpOcrExtractedVendor,_tmpOcrExtractedAmount,_tmpOcrExtractedDate,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Expense>> getAllExpenses() {
    final String _sql = "SELECT * FROM expenses ORDER BY expenseDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"expenses"}, new Callable<List<Expense>>() {
      @Override
      @NonNull
      public List<Expense> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfExpenseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expenseDate");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplierName = CursorUtil.getColumnIndexOrThrow(_cursor, "supplierName");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfOcrExtractedVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedVendor");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfOcrExtractedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedDate");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Expense> _result = new ArrayList<Expense>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Expense _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpExpenseDate;
            if (_cursor.isNull(_cursorIndexOfExpenseDate)) {
              _tmpExpenseDate = null;
            } else {
              _tmpExpenseDate = _cursor.getString(_cursorIndexOfExpenseDate);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplierName;
            if (_cursor.isNull(_cursorIndexOfSupplierName)) {
              _tmpSupplierName = null;
            } else {
              _tmpSupplierName = _cursor.getString(_cursorIndexOfSupplierName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpOcrExtractedVendor;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedVendor)) {
              _tmpOcrExtractedVendor = null;
            } else {
              _tmpOcrExtractedVendor = _cursor.getString(_cursorIndexOfOcrExtractedVendor);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
            }
            final String _tmpOcrExtractedDate;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedDate)) {
              _tmpOcrExtractedDate = null;
            } else {
              _tmpOcrExtractedDate = _cursor.getString(_cursorIndexOfOcrExtractedDate);
            }
            final boolean _tmpManualEntry;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfManualEntry);
            _tmpManualEntry = _tmp != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Expense(_tmpId,_tmpReceiptNumber,_tmpExpenseDate,_tmpCategory,_tmpSupplierName,_tmpDescription,_tmpAmount,_tmpReceiptPath,_tmpOcrExtractedVendor,_tmpOcrExtractedAmount,_tmpOcrExtractedDate,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Expense>> getExpensesByDateRange(final String startDate, final String endDate) {
    final String _sql = "SELECT * FROM expenses WHERE expenseDate BETWEEN ? AND ? ORDER BY expenseDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"expenses"}, new Callable<List<Expense>>() {
      @Override
      @NonNull
      public List<Expense> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfExpenseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "expenseDate");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplierName = CursorUtil.getColumnIndexOrThrow(_cursor, "supplierName");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfOcrExtractedVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedVendor");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfOcrExtractedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedDate");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Expense> _result = new ArrayList<Expense>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Expense _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpExpenseDate;
            if (_cursor.isNull(_cursorIndexOfExpenseDate)) {
              _tmpExpenseDate = null;
            } else {
              _tmpExpenseDate = _cursor.getString(_cursorIndexOfExpenseDate);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplierName;
            if (_cursor.isNull(_cursorIndexOfSupplierName)) {
              _tmpSupplierName = null;
            } else {
              _tmpSupplierName = _cursor.getString(_cursorIndexOfSupplierName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpOcrExtractedVendor;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedVendor)) {
              _tmpOcrExtractedVendor = null;
            } else {
              _tmpOcrExtractedVendor = _cursor.getString(_cursorIndexOfOcrExtractedVendor);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
            }
            final String _tmpOcrExtractedDate;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedDate)) {
              _tmpOcrExtractedDate = null;
            } else {
              _tmpOcrExtractedDate = _cursor.getString(_cursorIndexOfOcrExtractedDate);
            }
            final boolean _tmpManualEntry;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfManualEntry);
            _tmpManualEntry = _tmp != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _item = new Expense(_tmpId,_tmpReceiptNumber,_tmpExpenseDate,_tmpCategory,_tmpSupplierName,_tmpDescription,_tmpAmount,_tmpReceiptPath,_tmpOcrExtractedVendor,_tmpOcrExtractedAmount,_tmpOcrExtractedDate,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getTotalExpenses(final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM expenses";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTotalExpensesByCategory(final String category,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM expenses WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTotalExpensesByDateRange(final String startDate, final String endDate,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM expenses WHERE expenseDate BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<String>> getAllCategories() {
    final String _sql = "SELECT DISTINCT category FROM expenses ORDER BY category ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"expenses"}, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

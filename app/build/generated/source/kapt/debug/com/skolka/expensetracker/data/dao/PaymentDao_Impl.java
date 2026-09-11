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
import com.skolka.expensetracker.data.models.Payment;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
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
public final class PaymentDao_Impl implements PaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payment> __insertionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __deletionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __updateAdapterOfPayment;

  private final SharedSQLiteStatement __preparedStmtOfDeletePaymentById;

  public PaymentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment = new EntityInsertionAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `payments` (`id`,`childId`,`feeConfigId`,`amount`,`paymentDate`,`paymentType`,`receiptPath`,`receiptNumber`,`ocrExtractedName`,`ocrExtractedAmount`,`manualEntry`,`notes`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getChildId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildId());
        }
        if (entity.getFeeConfigId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFeeConfigId());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getPaymentDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPaymentDate());
        }
        if (entity.getPaymentType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPaymentType());
        }
        if (entity.getReceiptPath() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getReceiptPath());
        }
        if (entity.getReceiptNumber() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getReceiptNumber());
        }
        if (entity.getOcrExtractedName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOcrExtractedName());
        }
        if (entity.getOcrExtractedAmount() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getOcrExtractedAmount());
        }
        final int _tmp = entity.getManualEntry() ? 1 : 0;
        statement.bindLong(11, _tmp);
        if (entity.getNotes() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNotes());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getUpdatedAt());
        }
      }
    };
    this.__deletionAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `payments` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `payments` SET `id` = ?,`childId` = ?,`feeConfigId` = ?,`amount` = ?,`paymentDate` = ?,`paymentType` = ?,`receiptPath` = ?,`receiptNumber` = ?,`ocrExtractedName` = ?,`ocrExtractedAmount` = ?,`manualEntry` = ?,`notes` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getChildId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildId());
        }
        if (entity.getFeeConfigId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFeeConfigId());
        }
        statement.bindDouble(4, entity.getAmount());
        if (entity.getPaymentDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPaymentDate());
        }
        if (entity.getPaymentType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPaymentType());
        }
        if (entity.getReceiptPath() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getReceiptPath());
        }
        if (entity.getReceiptNumber() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getReceiptNumber());
        }
        if (entity.getOcrExtractedName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOcrExtractedName());
        }
        if (entity.getOcrExtractedAmount() == null) {
          statement.bindNull(10);
        } else {
          statement.bindDouble(10, entity.getOcrExtractedAmount());
        }
        final int _tmp = entity.getManualEntry() ? 1 : 0;
        statement.bindLong(11, _tmp);
        if (entity.getNotes() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNotes());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getUpdatedAt());
        }
        if (entity.getId() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeletePaymentById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM payments WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Payment payment, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPayment.insertAndReturnId(payment);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Payment payment, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPayment.handle(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Payment payment, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPayment.handle(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePaymentById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePaymentById.acquire();
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
          __preparedStmtOfDeletePaymentById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getPaymentById(final String id, final Continuation<? super Payment> $completion) {
    final String _sql = "SELECT * FROM payments WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Payment>() {
      @Override
      @Nullable
      public Payment call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFeeConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeConfigId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentType = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentType");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfOcrExtractedName = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedName");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Payment _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final String _tmpFeeConfigId;
            if (_cursor.isNull(_cursorIndexOfFeeConfigId)) {
              _tmpFeeConfigId = null;
            } else {
              _tmpFeeConfigId = _cursor.getString(_cursorIndexOfFeeConfigId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpPaymentDate;
            if (_cursor.isNull(_cursorIndexOfPaymentDate)) {
              _tmpPaymentDate = null;
            } else {
              _tmpPaymentDate = _cursor.getString(_cursorIndexOfPaymentDate);
            }
            final String _tmpPaymentType;
            if (_cursor.isNull(_cursorIndexOfPaymentType)) {
              _tmpPaymentType = null;
            } else {
              _tmpPaymentType = _cursor.getString(_cursorIndexOfPaymentType);
            }
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpOcrExtractedName;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedName)) {
              _tmpOcrExtractedName = null;
            } else {
              _tmpOcrExtractedName = _cursor.getString(_cursorIndexOfOcrExtractedName);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
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
            _result = new Payment(_tmpId,_tmpChildId,_tmpFeeConfigId,_tmpAmount,_tmpPaymentDate,_tmpPaymentType,_tmpReceiptPath,_tmpReceiptNumber,_tmpOcrExtractedName,_tmpOcrExtractedAmount,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Payment>> getPaymentsByChild(final String childId) {
    final String _sql = "SELECT * FROM payments WHERE childId = ? ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFeeConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeConfigId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentType = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentType");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfOcrExtractedName = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedName");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final String _tmpFeeConfigId;
            if (_cursor.isNull(_cursorIndexOfFeeConfigId)) {
              _tmpFeeConfigId = null;
            } else {
              _tmpFeeConfigId = _cursor.getString(_cursorIndexOfFeeConfigId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpPaymentDate;
            if (_cursor.isNull(_cursorIndexOfPaymentDate)) {
              _tmpPaymentDate = null;
            } else {
              _tmpPaymentDate = _cursor.getString(_cursorIndexOfPaymentDate);
            }
            final String _tmpPaymentType;
            if (_cursor.isNull(_cursorIndexOfPaymentType)) {
              _tmpPaymentType = null;
            } else {
              _tmpPaymentType = _cursor.getString(_cursorIndexOfPaymentType);
            }
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpOcrExtractedName;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedName)) {
              _tmpOcrExtractedName = null;
            } else {
              _tmpOcrExtractedName = _cursor.getString(_cursorIndexOfOcrExtractedName);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
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
            _item = new Payment(_tmpId,_tmpChildId,_tmpFeeConfigId,_tmpAmount,_tmpPaymentDate,_tmpPaymentType,_tmpReceiptPath,_tmpReceiptNumber,_tmpOcrExtractedName,_tmpOcrExtractedAmount,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Payment>> getPaymentsByFeeConfig(final String feeConfigId) {
    final String _sql = "SELECT * FROM payments WHERE feeConfigId = ? ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (feeConfigId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, feeConfigId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFeeConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeConfigId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentType = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentType");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfOcrExtractedName = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedName");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final String _tmpFeeConfigId;
            if (_cursor.isNull(_cursorIndexOfFeeConfigId)) {
              _tmpFeeConfigId = null;
            } else {
              _tmpFeeConfigId = _cursor.getString(_cursorIndexOfFeeConfigId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpPaymentDate;
            if (_cursor.isNull(_cursorIndexOfPaymentDate)) {
              _tmpPaymentDate = null;
            } else {
              _tmpPaymentDate = _cursor.getString(_cursorIndexOfPaymentDate);
            }
            final String _tmpPaymentType;
            if (_cursor.isNull(_cursorIndexOfPaymentType)) {
              _tmpPaymentType = null;
            } else {
              _tmpPaymentType = _cursor.getString(_cursorIndexOfPaymentType);
            }
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpOcrExtractedName;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedName)) {
              _tmpOcrExtractedName = null;
            } else {
              _tmpOcrExtractedName = _cursor.getString(_cursorIndexOfOcrExtractedName);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
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
            _item = new Payment(_tmpId,_tmpChildId,_tmpFeeConfigId,_tmpAmount,_tmpPaymentDate,_tmpPaymentType,_tmpReceiptPath,_tmpReceiptNumber,_tmpOcrExtractedName,_tmpOcrExtractedAmount,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Payment>> getAllPayments() {
    final String _sql = "SELECT * FROM payments ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFeeConfigId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeConfigId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentType = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentType");
          final int _cursorIndexOfReceiptPath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptPath");
          final int _cursorIndexOfReceiptNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptNumber");
          final int _cursorIndexOfOcrExtractedName = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedName");
          final int _cursorIndexOfOcrExtractedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "ocrExtractedAmount");
          final int _cursorIndexOfManualEntry = CursorUtil.getColumnIndexOrThrow(_cursor, "manualEntry");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final String _tmpFeeConfigId;
            if (_cursor.isNull(_cursorIndexOfFeeConfigId)) {
              _tmpFeeConfigId = null;
            } else {
              _tmpFeeConfigId = _cursor.getString(_cursorIndexOfFeeConfigId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final String _tmpPaymentDate;
            if (_cursor.isNull(_cursorIndexOfPaymentDate)) {
              _tmpPaymentDate = null;
            } else {
              _tmpPaymentDate = _cursor.getString(_cursorIndexOfPaymentDate);
            }
            final String _tmpPaymentType;
            if (_cursor.isNull(_cursorIndexOfPaymentType)) {
              _tmpPaymentType = null;
            } else {
              _tmpPaymentType = _cursor.getString(_cursorIndexOfPaymentType);
            }
            final String _tmpReceiptPath;
            if (_cursor.isNull(_cursorIndexOfReceiptPath)) {
              _tmpReceiptPath = null;
            } else {
              _tmpReceiptPath = _cursor.getString(_cursorIndexOfReceiptPath);
            }
            final String _tmpReceiptNumber;
            if (_cursor.isNull(_cursorIndexOfReceiptNumber)) {
              _tmpReceiptNumber = null;
            } else {
              _tmpReceiptNumber = _cursor.getString(_cursorIndexOfReceiptNumber);
            }
            final String _tmpOcrExtractedName;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedName)) {
              _tmpOcrExtractedName = null;
            } else {
              _tmpOcrExtractedName = _cursor.getString(_cursorIndexOfOcrExtractedName);
            }
            final Double _tmpOcrExtractedAmount;
            if (_cursor.isNull(_cursorIndexOfOcrExtractedAmount)) {
              _tmpOcrExtractedAmount = null;
            } else {
              _tmpOcrExtractedAmount = _cursor.getDouble(_cursorIndexOfOcrExtractedAmount);
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
            _item = new Payment(_tmpId,_tmpChildId,_tmpFeeConfigId,_tmpAmount,_tmpPaymentDate,_tmpPaymentType,_tmpReceiptPath,_tmpReceiptNumber,_tmpOcrExtractedName,_tmpOcrExtractedAmount,_tmpManualEntry,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getTotalPaymentsByFeeConfig(final String feeConfigId,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM payments WHERE feeConfigId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (feeConfigId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, feeConfigId);
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
  public Object getTotalPaymentsByChildAndFeeConfig(final String childId, final String feeConfigId,
      final Continuation<? super Double> $completion) {
    final String _sql = "SELECT SUM(amount) FROM payments WHERE childId = ? AND feeConfigId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    _argIndex = 2;
    if (feeConfigId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, feeConfigId);
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
  public Object getPaymentCountByChildAndFeeConfig(final String childId, final String feeConfigId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM payments WHERE childId = ? AND feeConfigId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    _argIndex = 2;
    if (feeConfigId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, feeConfigId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

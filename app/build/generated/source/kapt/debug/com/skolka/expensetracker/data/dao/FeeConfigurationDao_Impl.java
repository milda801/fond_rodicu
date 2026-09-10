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
import com.skolka.expensetracker.data.models.FeeConfiguration;
import java.lang.Class;
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
public final class FeeConfigurationDao_Impl implements FeeConfigurationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FeeConfiguration> __insertionAdapterOfFeeConfiguration;

  private final EntityDeletionOrUpdateAdapter<FeeConfiguration> __deletionAdapterOfFeeConfiguration;

  private final EntityDeletionOrUpdateAdapter<FeeConfiguration> __updateAdapterOfFeeConfiguration;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFeeConfigById;

  public FeeConfigurationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFeeConfiguration = new EntityInsertionAdapter<FeeConfiguration>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `fee_configurations` (`id`,`academicYear`,`yearlyFeeAmount`,`splitOption`,`firstHalfDueDate`,`secondHalfDueDate`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeeConfiguration entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getAcademicYear() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAcademicYear());
        }
        statement.bindDouble(3, entity.getYearlyFeeAmount());
        if (entity.getSplitOption() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSplitOption());
        }
        if (entity.getFirstHalfDueDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getFirstHalfDueDate());
        }
        if (entity.getSecondHalfDueDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSecondHalfDueDate());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getUpdatedAt());
        }
      }
    };
    this.__deletionAdapterOfFeeConfiguration = new EntityDeletionOrUpdateAdapter<FeeConfiguration>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `fee_configurations` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeeConfiguration entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfFeeConfiguration = new EntityDeletionOrUpdateAdapter<FeeConfiguration>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `fee_configurations` SET `id` = ?,`academicYear` = ?,`yearlyFeeAmount` = ?,`splitOption` = ?,`firstHalfDueDate` = ?,`secondHalfDueDate` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FeeConfiguration entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getAcademicYear() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAcademicYear());
        }
        statement.bindDouble(3, entity.getYearlyFeeAmount());
        if (entity.getSplitOption() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSplitOption());
        }
        if (entity.getFirstHalfDueDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getFirstHalfDueDate());
        }
        if (entity.getSecondHalfDueDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSecondHalfDueDate());
        }
        if (entity.getCreatedAt() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCreatedAt());
        }
        if (entity.getUpdatedAt() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getUpdatedAt());
        }
        if (entity.getId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteFeeConfigById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM fee_configurations WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final FeeConfiguration feeConfiguration,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfFeeConfiguration.insertAndReturnId(feeConfiguration);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final FeeConfiguration feeConfiguration,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFeeConfiguration.handle(feeConfiguration);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final FeeConfiguration feeConfiguration,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfFeeConfiguration.handle(feeConfiguration);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFeeConfigById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFeeConfigById.acquire();
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
          __preparedStmtOfDeleteFeeConfigById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getFeeConfigById(final String id,
      final Continuation<? super FeeConfiguration> $completion) {
    final String _sql = "SELECT * FROM fee_configurations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FeeConfiguration>() {
      @Override
      @Nullable
      public FeeConfiguration call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAcademicYear = CursorUtil.getColumnIndexOrThrow(_cursor, "academicYear");
          final int _cursorIndexOfYearlyFeeAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "yearlyFeeAmount");
          final int _cursorIndexOfSplitOption = CursorUtil.getColumnIndexOrThrow(_cursor, "splitOption");
          final int _cursorIndexOfFirstHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "firstHalfDueDate");
          final int _cursorIndexOfSecondHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "secondHalfDueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final FeeConfiguration _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpAcademicYear;
            if (_cursor.isNull(_cursorIndexOfAcademicYear)) {
              _tmpAcademicYear = null;
            } else {
              _tmpAcademicYear = _cursor.getString(_cursorIndexOfAcademicYear);
            }
            final double _tmpYearlyFeeAmount;
            _tmpYearlyFeeAmount = _cursor.getDouble(_cursorIndexOfYearlyFeeAmount);
            final String _tmpSplitOption;
            if (_cursor.isNull(_cursorIndexOfSplitOption)) {
              _tmpSplitOption = null;
            } else {
              _tmpSplitOption = _cursor.getString(_cursorIndexOfSplitOption);
            }
            final String _tmpFirstHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfFirstHalfDueDate)) {
              _tmpFirstHalfDueDate = null;
            } else {
              _tmpFirstHalfDueDate = _cursor.getString(_cursorIndexOfFirstHalfDueDate);
            }
            final String _tmpSecondHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfSecondHalfDueDate)) {
              _tmpSecondHalfDueDate = null;
            } else {
              _tmpSecondHalfDueDate = _cursor.getString(_cursorIndexOfSecondHalfDueDate);
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
            _result = new FeeConfiguration(_tmpId,_tmpAcademicYear,_tmpYearlyFeeAmount,_tmpSplitOption,_tmpFirstHalfDueDate,_tmpSecondHalfDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getFeeConfigByAcademicYear(final String academicYear,
      final Continuation<? super FeeConfiguration> $completion) {
    final String _sql = "SELECT * FROM fee_configurations WHERE academicYear = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (academicYear == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, academicYear);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FeeConfiguration>() {
      @Override
      @Nullable
      public FeeConfiguration call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAcademicYear = CursorUtil.getColumnIndexOrThrow(_cursor, "academicYear");
          final int _cursorIndexOfYearlyFeeAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "yearlyFeeAmount");
          final int _cursorIndexOfSplitOption = CursorUtil.getColumnIndexOrThrow(_cursor, "splitOption");
          final int _cursorIndexOfFirstHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "firstHalfDueDate");
          final int _cursorIndexOfSecondHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "secondHalfDueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final FeeConfiguration _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpAcademicYear;
            if (_cursor.isNull(_cursorIndexOfAcademicYear)) {
              _tmpAcademicYear = null;
            } else {
              _tmpAcademicYear = _cursor.getString(_cursorIndexOfAcademicYear);
            }
            final double _tmpYearlyFeeAmount;
            _tmpYearlyFeeAmount = _cursor.getDouble(_cursorIndexOfYearlyFeeAmount);
            final String _tmpSplitOption;
            if (_cursor.isNull(_cursorIndexOfSplitOption)) {
              _tmpSplitOption = null;
            } else {
              _tmpSplitOption = _cursor.getString(_cursorIndexOfSplitOption);
            }
            final String _tmpFirstHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfFirstHalfDueDate)) {
              _tmpFirstHalfDueDate = null;
            } else {
              _tmpFirstHalfDueDate = _cursor.getString(_cursorIndexOfFirstHalfDueDate);
            }
            final String _tmpSecondHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfSecondHalfDueDate)) {
              _tmpSecondHalfDueDate = null;
            } else {
              _tmpSecondHalfDueDate = _cursor.getString(_cursorIndexOfSecondHalfDueDate);
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
            _result = new FeeConfiguration(_tmpId,_tmpAcademicYear,_tmpYearlyFeeAmount,_tmpSplitOption,_tmpFirstHalfDueDate,_tmpSecondHalfDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<FeeConfiguration>> getAllFeeConfigs() {
    final String _sql = "SELECT * FROM fee_configurations ORDER BY academicYear DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"fee_configurations"}, new Callable<List<FeeConfiguration>>() {
      @Override
      @NonNull
      public List<FeeConfiguration> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAcademicYear = CursorUtil.getColumnIndexOrThrow(_cursor, "academicYear");
          final int _cursorIndexOfYearlyFeeAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "yearlyFeeAmount");
          final int _cursorIndexOfSplitOption = CursorUtil.getColumnIndexOrThrow(_cursor, "splitOption");
          final int _cursorIndexOfFirstHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "firstHalfDueDate");
          final int _cursorIndexOfSecondHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "secondHalfDueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<FeeConfiguration> _result = new ArrayList<FeeConfiguration>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FeeConfiguration _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpAcademicYear;
            if (_cursor.isNull(_cursorIndexOfAcademicYear)) {
              _tmpAcademicYear = null;
            } else {
              _tmpAcademicYear = _cursor.getString(_cursorIndexOfAcademicYear);
            }
            final double _tmpYearlyFeeAmount;
            _tmpYearlyFeeAmount = _cursor.getDouble(_cursorIndexOfYearlyFeeAmount);
            final String _tmpSplitOption;
            if (_cursor.isNull(_cursorIndexOfSplitOption)) {
              _tmpSplitOption = null;
            } else {
              _tmpSplitOption = _cursor.getString(_cursorIndexOfSplitOption);
            }
            final String _tmpFirstHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfFirstHalfDueDate)) {
              _tmpFirstHalfDueDate = null;
            } else {
              _tmpFirstHalfDueDate = _cursor.getString(_cursorIndexOfFirstHalfDueDate);
            }
            final String _tmpSecondHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfSecondHalfDueDate)) {
              _tmpSecondHalfDueDate = null;
            } else {
              _tmpSecondHalfDueDate = _cursor.getString(_cursorIndexOfSecondHalfDueDate);
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
            _item = new FeeConfiguration(_tmpId,_tmpAcademicYear,_tmpYearlyFeeAmount,_tmpSplitOption,_tmpFirstHalfDueDate,_tmpSecondHalfDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getLatestFeeConfig(final Continuation<? super FeeConfiguration> $completion) {
    final String _sql = "SELECT * FROM fee_configurations ORDER BY academicYear DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FeeConfiguration>() {
      @Override
      @Nullable
      public FeeConfiguration call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAcademicYear = CursorUtil.getColumnIndexOrThrow(_cursor, "academicYear");
          final int _cursorIndexOfYearlyFeeAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "yearlyFeeAmount");
          final int _cursorIndexOfSplitOption = CursorUtil.getColumnIndexOrThrow(_cursor, "splitOption");
          final int _cursorIndexOfFirstHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "firstHalfDueDate");
          final int _cursorIndexOfSecondHalfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "secondHalfDueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final FeeConfiguration _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpAcademicYear;
            if (_cursor.isNull(_cursorIndexOfAcademicYear)) {
              _tmpAcademicYear = null;
            } else {
              _tmpAcademicYear = _cursor.getString(_cursorIndexOfAcademicYear);
            }
            final double _tmpYearlyFeeAmount;
            _tmpYearlyFeeAmount = _cursor.getDouble(_cursorIndexOfYearlyFeeAmount);
            final String _tmpSplitOption;
            if (_cursor.isNull(_cursorIndexOfSplitOption)) {
              _tmpSplitOption = null;
            } else {
              _tmpSplitOption = _cursor.getString(_cursorIndexOfSplitOption);
            }
            final String _tmpFirstHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfFirstHalfDueDate)) {
              _tmpFirstHalfDueDate = null;
            } else {
              _tmpFirstHalfDueDate = _cursor.getString(_cursorIndexOfFirstHalfDueDate);
            }
            final String _tmpSecondHalfDueDate;
            if (_cursor.isNull(_cursorIndexOfSecondHalfDueDate)) {
              _tmpSecondHalfDueDate = null;
            } else {
              _tmpSecondHalfDueDate = _cursor.getString(_cursorIndexOfSecondHalfDueDate);
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
            _result = new FeeConfiguration(_tmpId,_tmpAcademicYear,_tmpYearlyFeeAmount,_tmpSplitOption,_tmpFirstHalfDueDate,_tmpSecondHalfDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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

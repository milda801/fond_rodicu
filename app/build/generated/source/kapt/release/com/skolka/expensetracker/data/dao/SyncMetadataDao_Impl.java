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
import com.skolka.expensetracker.data.models.SyncMetadata;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SyncMetadataDao_Impl implements SyncMetadataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SyncMetadata> __insertionAdapterOfSyncMetadata;

  private final EntityDeletionOrUpdateAdapter<SyncMetadata> __deletionAdapterOfSyncMetadata;

  private final EntityDeletionOrUpdateAdapter<SyncMetadata> __updateAdapterOfSyncMetadata;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastSyncTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastBackupTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCloudProvider;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SyncMetadataDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSyncMetadata = new EntityInsertionAdapter<SyncMetadata>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `sync_metadata` (`id`,`lastSyncTime`,`lastBackupTime`,`cloudProvider`,`syncStatus`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SyncMetadata entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getLastSyncTime() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLastSyncTime());
        }
        if (entity.getLastBackupTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastBackupTime());
        }
        if (entity.getCloudProvider() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCloudProvider());
        }
        if (entity.getSyncStatus() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSyncStatus());
        }
      }
    };
    this.__deletionAdapterOfSyncMetadata = new EntityDeletionOrUpdateAdapter<SyncMetadata>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `sync_metadata` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SyncMetadata entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfSyncMetadata = new EntityDeletionOrUpdateAdapter<SyncMetadata>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `sync_metadata` SET `id` = ?,`lastSyncTime` = ?,`lastBackupTime` = ?,`cloudProvider` = ?,`syncStatus` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SyncMetadata entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getLastSyncTime() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLastSyncTime());
        }
        if (entity.getLastBackupTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastBackupTime());
        }
        if (entity.getCloudProvider() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCloudProvider());
        }
        if (entity.getSyncStatus() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSyncStatus());
        }
        if (entity.getId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateLastSyncTime = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE sync_metadata SET lastSyncTime = ?, syncStatus = 'idle'";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastBackupTime = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE sync_metadata SET lastBackupTime = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE sync_metadata SET syncStatus = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCloudProvider = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE sync_metadata SET cloudProvider = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM sync_metadata";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final SyncMetadata syncMetadata,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfSyncMetadata.insertAndReturnId(syncMetadata);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final SyncMetadata syncMetadata,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSyncMetadata.handle(syncMetadata);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final SyncMetadata syncMetadata,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSyncMetadata.handle(syncMetadata);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastSyncTime(final String timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastSyncTime.acquire();
        int _argIndex = 1;
        if (timestamp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, timestamp);
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
          __preparedStmtOfUpdateLastSyncTime.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastBackupTime(final String timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastBackupTime.acquire();
        int _argIndex = 1;
        if (timestamp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, timestamp);
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
          __preparedStmtOfUpdateLastBackupTime.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSyncStatus(final String status,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatus.acquire();
        int _argIndex = 1;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, status);
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
          __preparedStmtOfUpdateSyncStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCloudProvider(final String provider,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCloudProvider.acquire();
        int _argIndex = 1;
        if (provider == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, provider);
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
          __preparedStmtOfUpdateCloudProvider.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
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
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getSyncMetadataById(final String id,
      final Continuation<? super SyncMetadata> $completion) {
    final String _sql = "SELECT * FROM sync_metadata WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SyncMetadata>() {
      @Override
      @Nullable
      public SyncMetadata call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfLastBackupTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastBackupTime");
          final int _cursorIndexOfCloudProvider = CursorUtil.getColumnIndexOrThrow(_cursor, "cloudProvider");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final SyncMetadata _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
            }
            final String _tmpLastBackupTime;
            if (_cursor.isNull(_cursorIndexOfLastBackupTime)) {
              _tmpLastBackupTime = null;
            } else {
              _tmpLastBackupTime = _cursor.getString(_cursorIndexOfLastBackupTime);
            }
            final String _tmpCloudProvider;
            if (_cursor.isNull(_cursorIndexOfCloudProvider)) {
              _tmpCloudProvider = null;
            } else {
              _tmpCloudProvider = _cursor.getString(_cursorIndexOfCloudProvider);
            }
            final String _tmpSyncStatus;
            if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
              _tmpSyncStatus = null;
            } else {
              _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
            }
            _result = new SyncMetadata(_tmpId,_tmpLastSyncTime,_tmpLastBackupTime,_tmpCloudProvider,_tmpSyncStatus);
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
  public Flow<SyncMetadata> getSyncMetadata() {
    final String _sql = "SELECT * FROM sync_metadata LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sync_metadata"}, new Callable<SyncMetadata>() {
      @Override
      @Nullable
      public SyncMetadata call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfLastBackupTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastBackupTime");
          final int _cursorIndexOfCloudProvider = CursorUtil.getColumnIndexOrThrow(_cursor, "cloudProvider");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final SyncMetadata _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpLastSyncTime;
            if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
              _tmpLastSyncTime = null;
            } else {
              _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
            }
            final String _tmpLastBackupTime;
            if (_cursor.isNull(_cursorIndexOfLastBackupTime)) {
              _tmpLastBackupTime = null;
            } else {
              _tmpLastBackupTime = _cursor.getString(_cursorIndexOfLastBackupTime);
            }
            final String _tmpCloudProvider;
            if (_cursor.isNull(_cursorIndexOfCloudProvider)) {
              _tmpCloudProvider = null;
            } else {
              _tmpCloudProvider = _cursor.getString(_cursorIndexOfCloudProvider);
            }
            final String _tmpSyncStatus;
            if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
              _tmpSyncStatus = null;
            } else {
              _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
            }
            _result = new SyncMetadata(_tmpId,_tmpLastSyncTime,_tmpLastBackupTime,_tmpCloudProvider,_tmpSyncStatus);
          } else {
            _result = null;
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

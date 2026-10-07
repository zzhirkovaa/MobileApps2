package ru.mirea.zhirkova.wilddex.data.database;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ObservationDao_Impl implements ObservationDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<ObservationEntity> __insertAdapterOfObservationEntity;

  public ObservationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfObservationEntity = new EntityInsertAdapter<ObservationEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `observations` (`id`,`userId`,`animalId`,`animalName`,`animalScientificName`,`animalImageUrl`,`animalDescription`,`date`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          final ObservationEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        statement.bindLong(3, entity.getAnimalId());
        if (entity.getAnimalName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getAnimalName());
        }
        if (entity.getAnimalScientificName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getAnimalScientificName());
        }
        if (entity.getAnimalImageUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getAnimalImageUrl());
        }
        if (entity.getAnimalDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getAnimalDescription());
        }
        if (entity.getDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getDate());
        }
      }
    };
  }

  @Override
  public void insert(final ObservationEntity observation) {
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfObservationEntity.insert(_connection, observation);
      return null;
    });
  }

  @Override
  public List<ObservationEntity> getByUserId(final int userId) {
    final String _sql = "SELECT * FROM observations WHERE userId = ?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, userId);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfAnimalId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "animalId");
        final int _columnIndexOfAnimalName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "animalName");
        final int _columnIndexOfAnimalScientificName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "animalScientificName");
        final int _columnIndexOfAnimalImageUrl = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "animalImageUrl");
        final int _columnIndexOfAnimalDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "animalDescription");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final List<ObservationEntity> _result = new ArrayList<ObservationEntity>();
        while (_stmt.step()) {
          final ObservationEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final int _tmpAnimalId;
          _tmpAnimalId = (int) (_stmt.getLong(_columnIndexOfAnimalId));
          final String _tmpAnimalName;
          if (_stmt.isNull(_columnIndexOfAnimalName)) {
            _tmpAnimalName = null;
          } else {
            _tmpAnimalName = _stmt.getText(_columnIndexOfAnimalName);
          }
          final String _tmpAnimalScientificName;
          if (_stmt.isNull(_columnIndexOfAnimalScientificName)) {
            _tmpAnimalScientificName = null;
          } else {
            _tmpAnimalScientificName = _stmt.getText(_columnIndexOfAnimalScientificName);
          }
          final String _tmpAnimalImageUrl;
          if (_stmt.isNull(_columnIndexOfAnimalImageUrl)) {
            _tmpAnimalImageUrl = null;
          } else {
            _tmpAnimalImageUrl = _stmt.getText(_columnIndexOfAnimalImageUrl);
          }
          final String _tmpAnimalDescription;
          if (_stmt.isNull(_columnIndexOfAnimalDescription)) {
            _tmpAnimalDescription = null;
          } else {
            _tmpAnimalDescription = _stmt.getText(_columnIndexOfAnimalDescription);
          }
          final String _tmpDate;
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmpDate = null;
          } else {
            _tmpDate = _stmt.getText(_columnIndexOfDate);
          }
          _item = new ObservationEntity(_tmpId,_tmpUserId,_tmpAnimalId,_tmpAnimalName,_tmpAnimalScientificName,_tmpAnimalImageUrl,_tmpAnimalDescription,_tmpDate);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void deleteById(final int observationId) {
    final String _sql = "DELETE FROM observations WHERE id = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, observationId);
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

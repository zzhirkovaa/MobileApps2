package ru.mirea.zhirkova.wilddex.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ObservationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ObservationEntity observation);

    @Query("SELECT * FROM observations WHERE userId = :userId")
    List<ObservationEntity> getByUserId(int userId);

    @Query("DELETE FROM observations WHERE id = :observationId")
    void deleteById(int observationId);
}

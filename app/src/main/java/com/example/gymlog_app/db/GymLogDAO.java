package com.example.gymlog_app.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gymlog_app.GymLog;

import java.util.List;

@Dao
public interface GymLogDAO {

    @Insert
    //ellipses (...) indicates that the insert statement can take one or more args
    void insert(GymLog... gymLogs);

    @Update
    void update(GymLog... gymLogs);

    @Delete
    //No ellipses because we only want to delete one at a time
    void delete(GymLog gymLog);

    /** getGymLogs
     * Allows selection of everything from Gymlog table
     * @return a list of gymlog objects from the table in descending order by date
     */
    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " ORDER BY mDate DESC")
    List<GymLog> getGymLogs();

    /** getGymLogsById
     * Allows selection of items from Gymlog table where mLogId matches the value passed in
     * @param logId is the value passed in
     * @return a gymlog object
     */
    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE mLogId = :logId")
    GymLog getGymLogsById(int logId);

}

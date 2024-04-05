package com.example.gymlog_app.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gymlog_app.GymLog;

@Database(entities = {GymLog.class}, version = 0)
public abstract class AppDatabase extends androidx.room.RoomDatabase{
    public static final String DB_NAME = "com.example.gymlog_app.GYMLOG_DATABASE";
    public static final String GYMLOG_TABLE = "com.example.gymlog_app.GYMLOG_TABLE";
    public abstract GymLogDAO getGymLogDAO();


}

package com.example.gymlog_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gymlog_app.db.AppDatabase;

import java.util.Date;

/**
 * @author Krishna Tagdiwala
 * @since Apr 4, 2024
 * CST 338 with Dr. C
 * Gymlog Application
 */

//annotation indicates that the gymlog object refers to the correct table
@Entity(tableName = AppDatabase.GYMLOG_TABLE)
public class GymLog {

    //fields

    //database will automatically supply a key value with
    @PrimaryKey(autoGenerate = true)
    private int mLogId;

    private String mExercise;
    private int mReps;
    private double mWeight;

    private Date mDate;

    public GymLog(String mExercise, int mReps, double mWeight) {
        this.mExercise = mExercise;
        this.mReps = mReps;
        this.mWeight = mWeight;

        mDate = new Date();
    }

    public int getmLogId() {
        return mLogId;
    }

    public void setmLogId(int mLogId) {
        this.mLogId = mLogId;
    }

    public String getmExercise() {
        return mExercise;
    }

    public void setmExercise(String mExercise) {
        this.mExercise = mExercise;
    }

    public int getmReps() {
        return mReps;
    }

    public void setmReps(int mReps) {
        this.mReps = mReps;
    }

    public double getmWeight() {
        return mWeight;
    }

    public void setmWeight(double mWeight) {
        this.mWeight = mWeight;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}

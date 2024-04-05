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

    public int getLogId() {
        return mLogId;
    }

    public void setLogId(int mLogId) {
        this.mLogId = mLogId;
    }

    public String getExercise() {
        return mExercise;
    }

    public void setExercise(String mExercise) {
        this.mExercise = mExercise;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int mReps) {
        this.mReps = mReps;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double mWeight) {
        this.mWeight = mWeight;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    @Override
    public String toString() {
        String output;

        output = mExercise + "\n" + mWeight + " : " + mReps + "\n" + getDate();

        return output;
    }
}

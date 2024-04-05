package com.example.gymlog_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gymlog_app.db.AppDatabase;
import com.example.gymlog_app.db.GymLogDAO;

import java.util.List;

/**
 * @author Krishna Tagdiwala
 * @since Apr 4, 2024
 * CST 338 with Dr. C
 * Gymlog Application
 */

public class MainActivity extends AppCompatActivity {

    TextView mMainDisplay;

    //Relate to user input and button
    EditText mExercise;
    EditText mWeight;
    EditText mReps;

    Button mSubmitButton;

    GymLogDAO mGymLogDAO;

    List<GymLog> mGymLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI Elements are "wired-up"
        mMainDisplay = findViewById(R.id.mainGymLogDisplay);
        mExercise = findViewById(R.id.mainExerciseEditText);
        mWeight = findViewById(R.id.mainWeightEditText);
        mReps = findViewById(R.id.mainRepsEditText);

        mSubmitButton = findViewById(R.id.mainSubmitButton);

        /*  Room.databaseBuilder calls a static method in the Room database
            Context (this): where we are when we're building this
            What will be built (AppDatabase.class): an AppDatabase
            Name of database being build (AppDatabase.DB_NAME)
         */
        mGymLogDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                // ideally database queries should not be done on main thread (they take a long time)
                // but we'll make an exception this time :p
                .allowMainThreadQueries()
                // constructs the object
                .build()
                // returns the instance
                .getGymLogDAO();
        // Follows the Singleton Pattern -- ensures only one instance of AppDatabase exists at a time
            //updates information on the current View
            refreshDisplay();

    }

    /** refreshDisplay
     * used to redraw the display whenever values are added
     */
    private void refreshDisplay(){
        //returns all the records from the database and storing them in the mGymLogs list
        mGymLogs = mGymLogDAO.getGymLogs();

        if(mGymLogs.size() <= 0){
            mMainDisplay.setText(R.string.noLogsMessage);
        }
        StringBuilder sb = new StringBuilder();
        for(GymLog log : mGymLogs){
            sb.append(log);
            sb.append("\n");
            sb.append("=============");
            sb.append("\n");
        }
        mMainDisplay.setText(sb.toString());
    }
}
package com.example.kaleb.truestrength;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kaleb on 15/10/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1; //current version of the database
    private static final String DATABASE_NAME = "exercises.db"; //the name of the database

    //table and column names for the Exercises Table
    private static final String TABLE_EXERCISES = "Exercises"; //the name of the Exercises Table
    private static final String COLUMN_EXERCISE_ID = "ID"; //column for the Exercise ID
    private static final String COLUMN_WEEK = "Week"; //column for the Week
    private static final String COLUMN_DAY = "Day"; //column for the Day
    private static final String COLUMN_EXERCISE_NUMBER = "exerciseNumber"; //column for the number of the Exercise (e.g Ex 1a)
    private static final String COLUMN_EXERCISE_NAME = "exerciseName"; //column for the exercise name
    private static final String COLUMN_EXERCISE_TYPE = "exerciseType"; //column for the exercise type
    private static final String COLUMN_REST_TIME = "restTime"; //column for the Rest time

    //table and column names for the User Data table
    private static final String TABLE_USER_DATA = "UserData"; // the name of the User Data table
    private static final String COLUMN_UD_ID = "udID"; //column for the User Data id
    private static final String COLUMN_EX_ID = "exID"; //column for the Exercise ID (Foreign Key)
    private static final String COLUMN_WEIGHT = "Weight"; //column for the Weight lifted
    private static final String COLUMN_NUM_REPS = "numReps"; //column for the Number of Reps done.

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create the Exercises table
        String exQuery = "CREATE TABLE " + TABLE_EXERCISES + "(" +
                COLUMN_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEEK + " TEXT, " +
                COLUMN_DAY + " TEXT, " +
                COLUMN_EXERCISE_NUMBER + " TEXT, " +
                COLUMN_EXERCISE_NAME + " TEXT, " +
                COLUMN_EXERCISE_TYPE + " TEXT, " +
                COLUMN_REST_TIME + " INTEGER " + ");";

        //Create the User Data table
        String udQuery = "CREATE TABLE " + TABLE_USER_DATA + "(" +
                COLUMN_UD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EX_ID + " INTEGER , " +
                COLUMN_WEIGHT + " INTEGER, " +
                COLUMN_NUM_REPS + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_EX_ID + ") REFERENCES " + TABLE_EXERCISES + "(" +
                COLUMN_EX_ID + "));";

        sqLiteDatabase.execSQL(exQuery);
        sqLiteDatabase.execSQL(udQuery);
        //sqLiteDatabase.execSQL(insertInitialData());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DATA);
        onCreate(sqLiteDatabase);
    }
    public void insert(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO " +  TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY  + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1a\", \"Foam Roll\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1b\", \"Mobility/Activation Drills\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:1c\", \"Rotator Cuff Work\", \"Warmup\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:2\", \"Bench Press\", \"Strength\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:3\", \"Pendlay Row\", \"Strength\", 120000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4a\", \"Incline DB Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:4b\", \"Cable Pull Overs\", \"Conditioning\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5a\", \"Chest Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:5b\", \"Lat Pulldown\", \"Conditioning\", 60000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6a\", \"Cable Cross Over\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:6b\", \"T-Bar Row\", \"Conditioning\", 30000);");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7a\", \"Cook-Willis Press\", \"Conditioning\");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_EXERCISES + "(" + COLUMN_WEEK + ", " + COLUMN_DAY + ", " + COLUMN_EXERCISE_NUMBER + ", " + COLUMN_EXERCISE_NAME + ", " + COLUMN_EXERCISE_TYPE + ", " + COLUMN_REST_TIME + ") VALUES (\"Week 1\", \"Day 1\", \"Ex:7b\", \"Pull ups\", \"Conditioning\", 30000);");
    }

    //Print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISES + " WHERE 1;";

        //Cursor point to a location in your results
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("Week"))!= null){
                dbString += c.getString(c.getColumnIndex("Week"));
                dbString += "\t";
                if(c.getString(c.getColumnIndex("Day")) != null){
                    dbString += c.getString(c.getColumnIndex("Day"));
                    dbString += "\t";
                    if(c.getString(c.getColumnIndex("exerciseNumber")) != null){
                        dbString += c.getString(c.getColumnIndex("exerciseNumber"));
                        dbString += "\t";
                        if(c.getString(c.getColumnIndex("exerciseName")) != null){
                            dbString += c.getString(c.getColumnIndex("exerciseName"));
                            dbString += "\t";
                            if(c.getString(c.getColumnIndex("exerciseType")) != null){
                                dbString += c.getString(c.getColumnIndex("exerciseType"));
                                dbString += "\t";
                                if(c.getString(c.getColumnIndex("restTime")) != null){
                                    dbString += c.getString(c.getColumnIndex("restTime"));
                                }
                            }
                        }
                    }
                }
            }
            dbString += "\n";
            c.moveToNext();
        }
        sqLiteDatabase.close();
        return dbString;
    }

    //method to display current week
    public String getWeek(String Week){
        String week = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT " + COLUMN_WEEK + " FROM " + TABLE_EXERCISES + " WHERE " + COLUMN_WEEK + " = '" + Week + "';";

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        if(c.getString(c.getColumnIndex("Week")) != null){
            week += c.getString(c.getColumnIndex("Week"));
        }

        sqLiteDatabase.close();
        return week;
    }
    


    public String getExerciseName(String week, String day){
        String field = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISES;

        Cursor c = sqLiteDatabase.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("ID")) != null){
                field += c.getString(c.getColumnIndex("ID"));
                field += "\t";
                if(c.getString(c.getColumnIndex("exerciseName")) != null){
                    field += c.getString(c.getColumnIndex("exerciseName"));
                    field += '\n';
                }
            }
            c.moveToNext();
        }

        sqLiteDatabase.close();
        return field;
    }
}

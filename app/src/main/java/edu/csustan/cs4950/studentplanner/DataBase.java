package edu.csustan.cs4950.studentplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public static final String ASSIGNMENT_TABLE = "ASSIGNMENT_TABLE";
    public static final String COLUMN_ASSIGNMENT_NAME = "ASSIGNMENT_NAME";
    public static final String COLUMN_ASSIGNMENT_DESCRIPTION = "ASSIGNMENT_DESCRIPTION";
    public static final String COLUMN_DUE_DATE = "DUE_DATE";
    public static final String COLUMN_ASSIGNMENT_TASK = "ASSIGNMENT_TASK";
    public static final String COLUMN_ID = "ID";

    public DataBase(@Nullable Context context) {

        super(context, "assignment.db", null, 1);
    }

    //Called the first time a database is accessed. This will create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ASSIGNMENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ASSIGNMENT_NAME + " TEXT, " + COLUMN_ASSIGNMENT_DESCRIPTION + " TEXT, " + COLUMN_DUE_DATE + " INTEGER, " + COLUMN_ASSIGNMENT_TASK + " TEXT)";

        db.execSQL(createTableStatement);

    }
    // Called if the database changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(AssignmentModel assignmentModel) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ASSIGNMENT_NAME, assignmentModel.getAssignment());
        cv.put(COLUMN_ASSIGNMENT_DESCRIPTION, assignmentModel.getDescription());
        cv.put(COLUMN_DUE_DATE, assignmentModel.getDate());
        cv.put(COLUMN_ASSIGNMENT_TASK, assignmentModel.getTask());

        long insert = db.insert(ASSIGNMENT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }

    }
    public List<AssignmentModel> getEverything(){

        List<AssignmentModel> returnList = new ArrayList<>();

        //get data from database
        String queryString = "SELECT * FROM " + ASSIGNMENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            //loop through the result set and create new customer objects. put them into the return lsit
            do{
                int assignmentID = cursor.getInt(0);
                String assignmentName = cursor.getString(1);
                String assignmentDescription = cursor.getString(2);
                int dueDate = cursor.getInt(3);
                String assignmentTask = cursor.getString(4);

                AssignmentModel newAssignment = new AssignmentModel(assignmentID,assignmentName, assignmentDescription, dueDate, assignmentTask);
                returnList.add(newAssignment);

            } while (cursor.moveToNext());

        }
        else{

            //In the event of failure
        }
        cursor.close();
        db.close();
        return returnList;

    }
}

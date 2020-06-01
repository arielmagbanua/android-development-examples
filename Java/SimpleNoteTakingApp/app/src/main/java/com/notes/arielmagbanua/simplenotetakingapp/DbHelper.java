package com.notes.arielmagbanua.simplenotetakingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = "DbHelper";
    public static final String DB_NAME = "app_notes.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NOTES = "notes";
    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_BODY = "body";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_UPDATED_AT = "updated_at";

    public DbHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNotesTable = "CREATE TABLE "+TABLE_NOTES+"(" +
                COL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_BODY + " TEXT, " +
                COL_CREATED_AT + " TEXT, " +
                COL_UPDATED_AT + " TEXT" +
                ")";

        db.execSQL(createNotesTable);
        Log.d(TAG, createNotesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // inserting a note
    public long insertNote(SQLiteDatabase db, String title, String body){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_BODY, body);
        cv.put(COL_CREATED_AT, year + "-" + month + "-" + day);
        cv.put(COL_UPDATED_AT, year + "-" + month + "-" + day);

        return db.insert(TABLE_NOTES, null, cv);
    }

    public boolean updateNote(SQLiteDatabase db, int id, String title, String body){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_BODY, body);
        cv.put(COL_UPDATED_AT, year + "-" + month + "-" + day);

        int numberOfRowsAffected = db.update(TABLE_NOTES, cv, COL_ID+"="+id, null);
        return numberOfRowsAffected > 0;
    }

    public boolean deleteNote(SQLiteDatabase db, long id){
        int numberOfRowsDeleted = db.delete(TABLE_NOTES, COL_ID + "=" + id, null);
        return numberOfRowsDeleted > 0;
    }

    public ArrayList<Note> getAllNotes(SQLiteDatabase db){
        ArrayList<Note> notes = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NOTES, null, null, null, null, null, null);

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
            String body = cursor.getString(cursor.getColumnIndex(COL_BODY));
            String createdAt = cursor.getString(cursor.getColumnIndex(COL_CREATED_AT));
            String updatedAt = cursor.getString(cursor.getColumnIndex(COL_UPDATED_AT));

            Note note = new Note(id, title, body, createdAt, updatedAt);
            notes.add(note);
        }

        return notes;
    }
}

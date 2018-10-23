package com.notes.arielmagbanua.simplenotetakingapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DbHelper dbHelper = null;
    private SQLiteDatabase db = null;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the DBHelper
        dbHelper = new DbHelper(this);
        // Get the writable database connection
        db = dbHelper.getWritableDatabase();

        // insert note sample
        long id = dbHelper.insertNote(db, "My First Note", "This is my very first note!");
        if(id > 0){
            Log.d(TAG, "onCreate: Note was inserted");
        }

        // This is how you close the SQLiteDatabase connection
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.add_note){
            // Start the add note activity here
            Intent noteIntent = new Intent(this, NotesActivity.class);
            startActivity(noteIntent);
        }

        return true;
    }
}

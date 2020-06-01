package com.notes.arielmagbanua.simplenotetakingapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {
    private EditText titleEditText = null;
    private EditText bodyEditText = null;
    private DbHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        titleEditText = findViewById(R.id.note_title);
        bodyEditText = findViewById(R.id.note_body);

        dbHelper = new DbHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.save_note){
            // Perform saving of the note
            String title = titleEditText.getText().toString();
            String body = bodyEditText.getText().toString();

            // get the database connection
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long noteID = dbHelper.insertNote(db, title, body);

            if(noteID > 0){
                // Toast that a note was successfully inserted.
                Toast.makeText(this, "Note is saved!", Toast.LENGTH_SHORT).show();
            }

            // close the connection
            db.close();
        }

        // finish the activity
        finish();

        return true;
    }
}

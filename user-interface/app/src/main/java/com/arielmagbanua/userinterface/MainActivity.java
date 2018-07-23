package com.arielmagbanua.userinterface;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all the buttons
        Button showToastButton = findViewById(R.id.show_toast);
        Button showDialogButton = findViewById(R.id.show_dialog);

        // Implement listeners here
        showDialogButton.setOnClickListener(this);
        Toast.makeText(this, "Application Thinker!!!", Toast.LENGTH_LONG).show();
    }

    public void showToast(View view){
        Toast.makeText(this, "Advance Thinker!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.show_dialog){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Sample Dialog");
            builder.setMessage("Are you an advance thinker?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Positive button clicked!", Toast.LENGTH_SHORT).show();

                    // Your logic here...
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Negative button clicked!", Toast.LENGTH_SHORT).show();

                    // Your logic here...
                }
            });
            builder.setNeutralButton("Meh...", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Neutral button clicked!", Toast.LENGTH_SHORT).show();

                    // Your logic here...
                }
            });

            builder.show();
        }
    }
}

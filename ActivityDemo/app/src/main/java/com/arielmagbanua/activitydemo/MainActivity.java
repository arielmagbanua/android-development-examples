package com.arielmagbanua.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String NUMBER_KEY = "number_key";
    private Button startButton = null;
    private EditText numberField = null;
    private double number = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondActivityIntent);
            }
        });

        numberField = findViewById(R.id.number);

        number = Math.random();

        numberField.setText("");
        numberField.setText(number+"");

        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble(NUMBER_KEY, number);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        number = savedInstanceState.getDouble(NUMBER_KEY);
        Log.d(TAG, "original: "+number);
    }
}

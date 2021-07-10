package com.arielmagbanua.intentextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int numberExtra = intent.getIntExtra(MainActivity.NUMBER_EXTRA, 0);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message + " " +numberExtra);

        setContentView(textView);
    }
}

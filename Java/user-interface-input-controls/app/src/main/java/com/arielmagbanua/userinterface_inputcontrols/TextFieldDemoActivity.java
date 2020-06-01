package com.arielmagbanua.userinterface_inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TextFieldDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field_demo);

        getSupportActionBar().setTitle("Text Field Demo");
    }
}

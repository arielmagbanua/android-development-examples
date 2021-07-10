package com.arielmagbanua.userinterface_inputcontrols;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class TextFieldDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field_demo);

        getSupportActionBar().setTitle("Text Field Demo");
    }
}

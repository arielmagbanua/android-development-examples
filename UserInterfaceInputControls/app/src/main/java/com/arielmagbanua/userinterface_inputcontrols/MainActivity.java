package com.arielmagbanua.userinterface_inputcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonsDemo = findViewById(R.id.buttons_demo);
        Button textFieldDemo = findViewById(R.id.text_field_demo);
        Button checkboxDemo = findViewById(R.id.checkbox_demo);
        Button radioButtonDemo = findViewById(R.id.radio_button_demo);
        Button toggleDemo = findViewById(R.id.toggle_demo);
        Button spinnerDemo = findViewById(R.id.spinner_demo);
        Button pickersDemo = findViewById(R.id.pickers_demo);

        buttonsDemo.setOnClickListener(this);
        textFieldDemo.setOnClickListener(this);
        checkboxDemo.setOnClickListener(this);
        radioButtonDemo.setOnClickListener(this);
        toggleDemo.setOnClickListener(this);
        spinnerDemo.setOnClickListener(this);
        pickersDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttons_demo:
                Intent buttonsDemoIntent = new Intent(this, ButtonsDemoActivity.class);
                startActivity(buttonsDemoIntent);
                break;

            case R.id.text_field_demo:
                Intent textFieldDemoIntent = new Intent(this, TextFieldDemoActivity.class);
                startActivity(textFieldDemoIntent);
                break;

            case R.id.checkbox_demo:
                Intent checkboxDemoIntent = new Intent(this, CheckboxDemoActivity.class);
                startActivity(checkboxDemoIntent);
                break;

            case R.id.radio_button_demo:
                Intent radioButtonDemoIntent = new Intent(this, RadioButtonDemoActivity.class);
                startActivity(radioButtonDemoIntent);
                break;

            case R.id.toggle_demo:
                Intent toggleDemoIntent = new Intent(this, ToggleDemoActivity.class);
                startActivity(toggleDemoIntent);
                break;

            case R.id.spinner_demo:
                Intent spinnerDemoIntent = new Intent(this, SpinnerDemoActivity.class);
                startActivity(spinnerDemoIntent);
                break;

            case R.id.pickers_demo:
                Intent pickersDemoIntent = new Intent(this, PickersDemoActivity.class);
                startActivity(pickersDemoIntent);
                break;
        }
    }
}

package com.arielmagbanua.userinterface_inputcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_demo);

        getSupportActionBar().setTitle("Radio Buttons Demo");

        RadioGroup flavorGroup = findViewById(R.id.flavor_group);
        flavorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.vanilla_radioButton:
                        Toast.makeText(RadioButtonDemoActivity.this, "Vanilla!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chocolate_radioButton:
                        Toast.makeText(RadioButtonDemoActivity.this, "Chocolate!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.strawberry_radioButton:
                        Toast.makeText(RadioButtonDemoActivity.this, "Strawberry!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.double_dutch_radioButton:
                        Toast.makeText(RadioButtonDemoActivity.this, "Double Dutch!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}

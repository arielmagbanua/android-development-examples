package com.arielmagbanua.userinterface_inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleDemoActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private boolean toggleButtonValue = false;
    private boolean toggleSwitchValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_demo);

        getSupportActionBar().setTitle("Toggle Demo");

        ToggleButton toggleButton = findViewById(R.id.toggle_button);
        SwitchCompat toggleSwitch = findViewById(R.id.toggle_switch);

        toggleButtonValue = toggleButton.isChecked();
        toggleSwitchValue = toggleSwitch.isChecked();

        toggleButton.setOnCheckedChangeListener(this);
        toggleSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        String messsage = "";

        switch (id){
            case R.id.toggle_button:
                toggleButtonValue = isChecked;
                messsage = isChecked ? "Toggle Button is on" : "Toggle Button is off";
                break;

            case R.id.toggle_switch:
                toggleSwitchValue = isChecked;
                messsage = isChecked ? "Toggle Switch is on" : "Toggle Button is off";
                break;
        }

        Toast.makeText(this, messsage, Toast.LENGTH_SHORT).show();
    }
}

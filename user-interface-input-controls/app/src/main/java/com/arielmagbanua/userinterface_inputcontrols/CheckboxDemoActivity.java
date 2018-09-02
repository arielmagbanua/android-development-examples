package com.arielmagbanua.userinterface_inputcontrols;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckboxDemoActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox vanillaCheckbox = null;
    private CheckBox chocolateCheckBox = null;
    private CheckBox strawberryCheckBox = null;
    private CheckBox doubleDutchCheckBox = null;
    private boolean vanillaCheckBoxValue = false;
    private boolean chocolateCheckBoxValue = false;
    private boolean strawberryCheckBoxValue = false;
    private boolean doubleDutchCheckBoxValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_demo);

        getSupportActionBar().setTitle("CheckBox Demo");

        vanillaCheckbox = findViewById(R.id.vanilla_checkBox);
        chocolateCheckBox = findViewById(R.id.chocolate_checkBox);
        strawberryCheckBox = findViewById(R.id.strawberry_checkBox);
        doubleDutchCheckBox = findViewById(R.id.double_dutch_checkBox);

        FloatingActionButton orderFab = findViewById(R.id.order_fab);
        orderFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vanillaCheckBoxValue = vanillaCheckbox.isChecked();
                chocolateCheckBoxValue = chocolateCheckBox.isChecked();
                strawberryCheckBoxValue = strawberryCheckBox.isChecked();
                doubleDutchCheckBoxValue = doubleDutchCheckBox.isChecked();

                Toast.makeText(CheckboxDemoActivity.this, "Flavors added to cart.", Toast.LENGTH_SHORT).show();
            }
        });

        vanillaCheckbox.setOnCheckedChangeListener(this);
        chocolateCheckBox.setOnCheckedChangeListener(this);
        strawberryCheckBox.setOnCheckedChangeListener(this);
        doubleDutchCheckBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";
        int id = buttonView.getId();

        switch (id){
            case R.id.vanilla_checkBox:
                message = isChecked ? "Vanilla is chosen!" : "";
                break;

            case R.id.chocolate_checkBox:
                message = isChecked ? "Chocolate is chosen!" : "";
                break;

            case R.id.strawberry_checkBox:
                message = isChecked ? "Strawberry is chosen!" : "";
                break;

            case R.id.double_dutch_checkBox:
                message = isChecked ? "Double Dutch is chosen!" : "";
                break;
        }

        if(!message.isEmpty()){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}

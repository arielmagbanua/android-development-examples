package com.arielmagbanua.userinterface_inputcontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ButtonsDemoActivity extends AppCompatActivity implements View.OnClickListener {

    // Interface variable | Option 1
    private View.OnClickListener clickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Toast.makeText(ButtonsDemoActivity.this, "Variable Listener", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_demo);

        getSupportActionBar().setTitle("Buttons Demo");

        // find all the buttons
        Button ordinaryButton = findViewById(R.id.ordinary_button);
        ImageButton imageButton = findViewById(R.id.image_button);
        Button buttonWithIconAtLeft = findViewById(R.id.button_with_icon_at_left);
        Button buttonWithIconAtRight = findViewById(R.id.button_with_icon_at_right);

        // Anonymous Inner Class | Option 3
        ordinaryButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonsDemoActivity.this, "Ordinary button is clicked", Toast.LENGTH_LONG).show();
            }
        });

        // Registering event listener through interface variable | Option 1
//        imageButton.setOnClickListener(clickListener);
//        buttonWithIconAtLeft.setOnClickListener(clickListener);

        // Using named class | Option 2
        ButtonsDemoActivity.ActivityClickHandler clickHandler = new ButtonsDemoActivity.ActivityClickHandler();
        imageButton.setOnClickListener(clickHandler);
        buttonWithIconAtLeft.setOnClickListener(clickHandler);

        // Using the Activity class that implements the Listener interface | Option 4
        buttonWithIconAtLeft.setOnClickListener(this);
        buttonWithIconAtRight.setOnClickListener(this);
    }


    // Using named class | Option 2
    public static class ActivityClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // do something here
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.ordinary_button:
                Toast.makeText(this, "Ordinary Button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.image_button:
                Toast.makeText(this, "Image Button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button_with_icon_at_left:
                Toast.makeText(this, "Button With Left Icon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button_with_icon_at_right:
                Toast.makeText(this, "Button with Right Icon", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

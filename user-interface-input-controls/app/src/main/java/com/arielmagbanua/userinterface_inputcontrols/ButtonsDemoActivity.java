package com.arielmagbanua.userinterface_inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonsDemoActivity extends AppCompatActivity implements View.OnClickListener {

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

//        ordinaryButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ButtonsDemoActivity.this, "Ordinary button is clicked", Toast.LENGTH_LONG).show();
//            }
//        });

        imageButton.setOnClickListener(clickListener);
        buttonWithIconAtLeft.setOnClickListener(clickListener);
//        ordinaryButton.setOnClickListener(this);
//        imageButton.setOnClickListener(this);
//        buttonWithIconAtLeft.setOnClickListener(this);
//        buttonWithIconAtRight.setOnClickListener(this);
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

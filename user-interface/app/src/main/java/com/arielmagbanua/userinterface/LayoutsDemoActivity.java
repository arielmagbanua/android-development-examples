package com.arielmagbanua.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutsDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts_demo);

        Button linearLayoutDemoButton = findViewById(R.id.linear_layout_demo_button);
        Button relativeLayoutDemoButton = findViewById(R.id.relative_layout_demo_button);
        Button listViewDemoButton = findViewById(R.id.list_view_demo_button);
        Button gridViewDemoButton = findViewById(R.id.grid_view_demo_button);

        linearLayoutDemoButton.setOnClickListener(this);
        relativeLayoutDemoButton.setOnClickListener(this);
        listViewDemoButton.setOnClickListener(this);
        gridViewDemoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.linear_layout_demo_button:
                break;

            case R.id.relative_layout_demo_button:
                break;

            case R.id.list_view_demo_button:
                break;

            case R.id.grid_view_demo_button:
                break;
        }
    }
}

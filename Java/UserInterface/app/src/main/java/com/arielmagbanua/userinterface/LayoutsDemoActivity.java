package com.arielmagbanua.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LayoutsDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts_demo);

        Button linearLayoutDemoButton = findViewById(R.id.linear_layout_demo_button);
        Button relativeLayoutDemoButton = findViewById(R.id.relative_layout_demo_button);
        Button listViewDemoButton = findViewById(R.id.list_view_demo_button);
        Button gridViewDemoButton = findViewById(R.id.grid_view_demo_button);
        Button constraintLayoutDemoButton = findViewById(R.id.constraint_layout_demo_button);

        linearLayoutDemoButton.setOnClickListener(this);
        relativeLayoutDemoButton.setOnClickListener(this);
        listViewDemoButton.setOnClickListener(this);
        gridViewDemoButton.setOnClickListener(this);
        constraintLayoutDemoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.linear_layout_demo_button:

                Intent linearLayoutDemoIntent = new Intent(this, LinearLayoutDemoActivity.class);
                startActivity(linearLayoutDemoIntent);

                break;

            case R.id.relative_layout_demo_button:

                Intent relativeLayoutDemoIntent = new Intent(this, RelativeLayoutDemoActivity.class);
                startActivity(relativeLayoutDemoIntent);

                break;

            case R.id.list_view_demo_button:

                Intent listViewDemoIntent = new Intent(this, ListViewDemoActivity.class);
                startActivity(listViewDemoIntent);

                break;

            case R.id.grid_view_demo_button:

                Intent gridViewDemoIntent = new Intent(this, GridViewDemoActivity.class);
                startActivity(gridViewDemoIntent);

                break;

            case R.id.constraint_layout_demo_button:

                Intent constraintLayoutDemoIntent = new Intent(this, ConstraintLayoutDemoActivity.class);
                startActivity(constraintLayoutDemoIntent);

                break;

        }
    }
}

package com.arielmagbanua.userinterface_inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerDemoActivity extends AppCompatActivity {

    private String[] students = {
            "Clyde",
            "Avel",
            "Yeltsin",
            "Joshua",
            "Charles",
            "Aprilyn",
            "Hazel",
            "Sarah",
            "Max",
            "Colder",
            "Jack",
            "Ethan",
            "Aaron"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        getSupportActionBar().setTitle("Spinner Demo");

        ArrayList<String> studentDataSet = new ArrayList<>(Arrays.asList(students));

        Spinner studentsSpinner = findViewById(R.id.students_spinner);
        StudentsSpinnerAdapter adapter = new StudentsSpinnerAdapter(this, R.layout.student_spinner_item_layout, studentDataSet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        studentsSpinner.setAdapter(adapter);
    }
}

package com.arielmagbanua.userinterface_inputcontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import androidx.appcompat.app.AppCompatActivity;

public class SpinnerDemoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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

        studentsSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView studentNameTextView = view.findViewById(R.id.name_textView);
        String message = studentNameTextView.getText().toString() + " position: "+position;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // your codes here
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Toast.makeText(this, "Nothing selected!", Toast.LENGTH_LONG).show();
    }
}

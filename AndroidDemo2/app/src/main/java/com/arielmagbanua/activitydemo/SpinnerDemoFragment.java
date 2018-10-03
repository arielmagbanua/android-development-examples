package com.arielmagbanua.activitydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerDemoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.spinner_demo_layout, container, false);

        ArrayList<String> studentDataSet = new ArrayList<>(Arrays.asList(students));

        Spinner studentsSpinner = layout.findViewById(R.id.students_spinner);
        StudentsSpinnerAdapter adapter = new StudentsSpinnerAdapter(getActivity(), R.layout.student_spinner_item_layout, studentDataSet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        studentsSpinner.setAdapter(adapter);

        studentsSpinner.setOnItemSelectedListener(this);

        return  layout;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView studentNameTextView = view.findViewById(R.id.name_textView);
        String message = studentNameTextView.getText().toString() + " position: "+position;
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

        // your codes here
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

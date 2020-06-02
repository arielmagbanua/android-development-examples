package com.arielmagbanua.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentAdapter extends ArrayAdapter<String>{

    private String[] students = null;
    private Context context = null;
    private int layoutResource = -1;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull String[] students) {
        super(context, resource, students);

        this.students = students;
        this.context = context;
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return students.length;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return students[position];
    }

    @Override
    public int getPosition(@Nullable String item) {

        for (int i = 0; i < students.length; i++){
            if(item.equals(students[i])){
                return i;
            }
        }

        return -1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String studentName = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View studentItemLayout = inflater.inflate(layoutResource, parent, false);
        TextView studentNameTextView = studentItemLayout.findViewById(R.id.student_name);

        // set the student name
        studentNameTextView.setText(studentName);
        return studentItemLayout;
    }
}

package com.arielmagbanua.userinterface_inputcontrols;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentsSpinnerAdapter extends ArrayAdapter<String> {

    private Context context;
    private int itemLayoutResource;
    private ArrayList<String> students = new ArrayList<>();

    public StudentsSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<String> students) {
        super(context, resource, students);

        this.context = context;
        this.itemLayoutResource = resource;
        this.students.addAll(students);
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return this.students.get(position);
    }

    @Override
    public int getCount() {
        return this.students.size();
    }

    @Override
    public int getPosition(@Nullable String item) {
        return this.students.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String studentName = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View studentItemLayout = inflater.inflate(itemLayoutResource, parent, false);

        TextView studentNameTextView = studentItemLayout.findViewById(R.id.name_textView);
        studentNameTextView.setText(studentName);

        return studentItemLayout;
    }
}

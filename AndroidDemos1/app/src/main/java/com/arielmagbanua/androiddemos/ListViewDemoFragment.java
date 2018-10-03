package com.arielmagbanua.androiddemos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewDemoFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView studentListView = null;
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
        View layout = inflater.inflate(R.layout.list_view_demo_layout, container, false);

        studentListView = layout.findViewById(R.id.students_listview);

        StudentAdapter adapter = new StudentAdapter(getActivity(), R.layout.student_item_layout, students);
        studentListView.setAdapter(adapter);
        studentListView.setOnItemClickListener(this);

        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView studentTextView = view.findViewById(R.id.student_name);
        Toast.makeText(getActivity(), studentTextView.getText().toString(), Toast.LENGTH_LONG).show();
    }
}

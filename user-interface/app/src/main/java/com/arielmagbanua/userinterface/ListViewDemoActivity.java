package com.arielmagbanua.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView studentListView = null;
    private String[] students = {
            "Clyde",
            "Avel",
            "Yeltsin",
            "Joshua",
            "Ariel",
            "Charles",
            "Joe",
            "Hannah",
            "Jane",
            "Joy",
            "April",
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
        setContentView(R.layout.activity_list_view_demo);

        studentListView = findViewById(R.id.students_listview);
        StudentAdapter adapter = new StudentAdapter(this, R.layout.student_item_layout, students);
        studentListView.setAdapter(adapter);
        studentListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView studentTextView = view.findViewById(R.id.student_name);
        Toast.makeText(this, studentTextView.getText().toString(), Toast.LENGTH_LONG).show();
    }
}

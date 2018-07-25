package com.arielmagbanua.taskperformance1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskPerformance1 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TaskPerformance1";
    private EditText editTextTitle = null;
    private EditText editTextBlog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_performance_1);

        Button postButton = findViewById(R.id.post_button);
        editTextTitle = findViewById(R.id.title);
        editTextBlog = findViewById(R.id.blog);

        postButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title = editTextTitle.getText().toString();
        String blog = editTextBlog.getText().toString();

        Log.d(TAG, "blog is posted!");
        Log.d(TAG, "Title: "+title);
        Log.d(TAG, "Blog: "+blog);
    }
}

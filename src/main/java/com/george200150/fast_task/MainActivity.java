package com.george200150.fast_task;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button buttonViewTasks;
    private Button buttonAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViewTasks = (Button) findViewById(R.id.button_view_tasks);
        buttonAddTask = (Button) findViewById(R.id.button_add_task);

        buttonViewTasks.setOnClickListener(view ->
                Log.d("YOUR TAG", "George!")
        );
    }
}
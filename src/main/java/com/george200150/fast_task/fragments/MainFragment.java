package com.george200150.fast_task.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;

public class MainFragment extends Fragment {
    private Button buttonViewTasks;
    private Button buttonAddTask;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        buttonViewTasks = (Button) view.findViewById(R.id.button_view_tasks);
        buttonAddTask = (Button) view.findViewById(R.id.button_add_task);

        buttonViewTasks.setOnClickListener(x -> {
            Log.d("YOUR TAG", "George!");
            Navigation.findNavController(view).navigate(R.id.fragment_task_list);
        });
    }
}

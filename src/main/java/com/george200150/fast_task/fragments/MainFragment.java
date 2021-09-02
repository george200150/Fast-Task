package com.george200150.fast_task.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;

public class MainFragment extends Fragment {
    private Button mainButtonViewTasks;
    private Button mainButtonAddTask;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        mainButtonViewTasks = (Button) view.findViewById(R.id.main_button_view_tasks);
        mainButtonAddTask = (Button) view.findViewById(R.id.main_button_add_task);

        mainButtonViewTasks.setOnClickListener(x -> {
            Navigation.findNavController(view).navigate(R.id.fragment_task_list);
        });
    }
}

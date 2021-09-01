package com.george200150.fast_task.fragments.tasks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;
import com.george200150.fast_task.domain.Task;
import com.george200150.fast_task.fragments.LocationEditFragment;

public class TaskMetaEditFragment extends Fragment {
    private Button edit_location_button;
    private static Task selectedTask;

    public TaskMetaEditFragment() {
        super(R.layout.fragment_task_meta_edit);
    }

    public static void setTask(Task task){
        selectedTask = task;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        edit_location_button = view.findViewById(R.id.button_edit_metadata);

        edit_location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationEditFragment.setSelectedLocation(selectedTask.getLocation());
                Navigation.findNavController(view).navigate(R.id.fragment_location_edit);
            }
        });
    }
}

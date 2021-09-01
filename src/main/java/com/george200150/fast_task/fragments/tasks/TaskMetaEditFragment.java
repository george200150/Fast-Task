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
    private static Task selectedTask;

    private Button editLocationButton;
    private Button taskMetaEditButtonEditRegistered;
    private Button taskMetaEditButtonEditDeadline;
    // TODO: sort the fields in the interface in the same order they appear in Task
    // TODO: get all the fields from the interface and dynamically complete them
    // TODO: make the priority label synchronise with the priority seekBar

    public TaskMetaEditFragment() {
        super(R.layout.fragment_task_meta_edit);
    }

    public static void setTask(Task task){
        selectedTask = task;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        editLocationButton = view.findViewById(R.id.button_edit_metadata);
        taskMetaEditButtonEditRegistered = view.findViewById(R.id.task_meta_edit_button_edit_registered);
        taskMetaEditButtonEditDeadline = view.findViewById(R.id.task_meta_edit_button_edit_deadline);

        editLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationEditFragment.setSelectedLocation(selectedTask.getLocation());
                Navigation.findNavController(view).navigate(R.id.fragment_location_edit);
            }
        });

        // TODO: create callback interface; implement classes for performing specific value setting;
        //  override here onResume(); add listeners to registered and deadline buttons;
        //  create fragment java and xml for date picking; add information to nav_graph;
        // similar code example is in fragments\LocationEditFragment.java
        // three different interval buttons have different callbacks and are redirected to the same fragment
    }
}

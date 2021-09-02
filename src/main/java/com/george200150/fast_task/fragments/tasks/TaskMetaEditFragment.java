package com.george200150.fast_task.fragments.tasks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;
import com.george200150.fast_task.domain.Task;
import com.george200150.fast_task.formatters.DurationFormatter;
import com.george200150.fast_task.fragments.LocationEditFragment;

public class TaskMetaEditFragment extends Fragment {
    private static Task selectedTask;

    private TextView taskMetaEditTextViewPriority;
    private SeekBar taskMetaEditSeekBarPriority;
    private CheckBox taskMetaEditCheckBoxDone;
    private EditText taskMetaEditEditTextDuration;
    private Button taskMetaEditButtonLocation;
    private Button taskMetaEditButtonEditRegistered;
    private Button taskMetaEditButtonEditDeadline;
    private Button taskMetaEditButtonUpdateMetadata;

    public TaskMetaEditFragment() {
        super(R.layout.fragment_task_meta_edit);
    }

    public static void setTask(Task task){
        selectedTask = task;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        taskMetaEditTextViewPriority = view.findViewById(R.id.task_meta_edit_textView_priority);
        taskMetaEditTextViewPriority.setText("PRIORITY: " + selectedTask.getPriority());
        taskMetaEditCheckBoxDone = view.findViewById(R.id.task_meta_edit_checkBox_done);
        taskMetaEditCheckBoxDone.setChecked(selectedTask.isDone());
        taskMetaEditSeekBarPriority = view.findViewById(R.id.task_meta_edit_seekBar_priority);
        taskMetaEditSeekBarPriority.setProgress(selectedTask.getPriority());
        taskMetaEditSeekBarPriority.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                taskMetaEditTextViewPriority.setText("PRIORITY: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        taskMetaEditButtonEditRegistered = view.findViewById(R.id.task_meta_edit_button_edit_registered);
        taskMetaEditButtonEditDeadline = view.findViewById(R.id.task_meta_edit_button_edit_deadline);
        taskMetaEditButtonUpdateMetadata = view.findViewById(R.id.task_meta_edit_button_update_metadata);
        taskMetaEditEditTextDuration = view.findViewById(R.id.task_meta_edit_editText_duration);
        taskMetaEditEditTextDuration.setText(DurationFormatter.formatDuration(selectedTask.getDuration()));

        taskMetaEditButtonLocation = view.findViewById(R.id.task_meta_edit_button_edit_location);
        taskMetaEditButtonLocation.setText("LOCATION: \n" + selectedTask.getLocation().toString());

        taskMetaEditButtonLocation.setOnClickListener(new View.OnClickListener() {
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

        taskMetaEditButtonEditRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}

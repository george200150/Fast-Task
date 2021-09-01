package com.george200150.fast_task.fragments.subtasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.george200150.fast_task.R;
import com.george200150.fast_task.builders.DateFormatBuilder;
import com.george200150.fast_task.constants.DateFormatStrings;
import com.george200150.fast_task.domain.Task;
import com.george200150.fast_task.fragments.tasks.TaskMetaEditFragment;

import java.time.Duration;

public class SubTaskListFragment extends Fragment {
    private SubTasksAdapter subTasksAdapter;
    private RecyclerView subTaskView;
    private Button editMetaButton;
    private TextView textViewMetadata;
    // TODO: add viewModel
    public static Task selectedTask;

    public static void setSelectedTask(Task task) {
        selectedTask = task;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subtask_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subTaskView = view.findViewById(R.id.subtask_list);
        editMetaButton = view.findViewById(R.id.button_edit_metadata);
        textViewMetadata = view.findViewById(R.id.textView_metadata);

        textViewMetadata.setText("PRIORITY: " + selectedTask.getPriority() + "\n" +
                "CREATED: " + DateFormatBuilder.getSDF(DateFormatStrings.displayDateFormat).format(selectedTask.getRegistered()) + "\n" +
                "DEADLINE: " + DateFormatBuilder.getSDF(DateFormatStrings.displayDateFormat).format(selectedTask.getDeadline()) + "\n" +
                "DURATION: " + formatDuration(selectedTask.getDuration()) + "\n" +
                "LOCATION: " + selectedTask.getLocation());

        editMetaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskMetaEditFragment.setTask(selectedTask);
                Navigation.findNavController(view).navigate(R.id.fragment_task_meta_edit);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        subTasksAdapter = new SubTasksAdapter(this, selectedTask);
        subTaskView.setLayoutManager(new LinearLayoutManager(this.getContext())); // additional line
        subTaskView.setAdapter(subTasksAdapter);
    }

    // TODO: put it in its right place
    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}

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
import com.george200150.fast_task.formatters.DurationFormatter;
import com.george200150.fast_task.fragments.tasks.TaskMetaEditFragment;

public class SubTaskListFragment extends Fragment {
    private SubTasksAdapter subTasksAdapter;
    private RecyclerView subtaskListRecyclerView;
    private Button subtaskListButtonEditMetadata;
    private TextView subtaskListTextViewMetadata;
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
        subtaskListRecyclerView = view.findViewById(R.id.subtask_list_recyclerView);
        subtaskListButtonEditMetadata = view.findViewById(R.id.task_meta_edit_button_edit_location);
        subtaskListTextViewMetadata = view.findViewById(R.id.subtask_list_textView_metadata);

        subtaskListTextViewMetadata.setText("PRIORITY: " + selectedTask.getPriority() + "\n" +
                "CREATED: " + DateFormatBuilder.getSDF(DateFormatStrings.displayDateFormat).format(selectedTask.getRegistered()) + "\n" +
                "DEADLINE: " + DateFormatBuilder.getSDF(DateFormatStrings.displayDateFormat).format(selectedTask.getDeadline()) + "\n" +
                "DURATION: " + DurationFormatter.formatDuration(selectedTask.getDuration())+ "\n" +
                "LOCATION: " + selectedTask.getLocation());

        subtaskListButtonEditMetadata.setOnClickListener(new View.OnClickListener() {
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
        subtaskListRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext())); // additional line
        subtaskListRecyclerView.setAdapter(subTasksAdapter);
    }
}

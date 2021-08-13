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
import com.george200150.fast_task.domain.Task;

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

        textViewMetadata.setText("PRIORITY: " + selectedTask.getPriority() +
                selectedTask.getRegistered() +
                selectedTask.getDeadline() +
                selectedTask.getDuration() +
                selectedTask.getLocation());


        editMetaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
}

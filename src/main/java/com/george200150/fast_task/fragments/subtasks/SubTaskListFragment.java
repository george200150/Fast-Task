package com.george200150.fast_task.fragments.subtasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.george200150.fast_task.R;

public class SubTaskListFragment extends Fragment {
    private SubTasksAdapter subTasksAdapter;
    private RecyclerView subTaskView;
    // TODO: add viewModel

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        subTasksAdapter = new SubTasksAdapter(this);
        subTaskView.setLayoutManager(new LinearLayoutManager(this.getContext())); // additional line
        subTaskView.setAdapter(subTasksAdapter);
    }
}

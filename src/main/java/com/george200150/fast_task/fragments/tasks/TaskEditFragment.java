package com.george200150.fast_task.fragments.tasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.george200150.fast_task.R;

public class TaskEditFragment extends Fragment {

    public static String TASK_ID;

    public TaskEditFragment() {
        // Required empty public constructor
    }

    public static TaskEditFragment newInstance(String param1, String param2) {
        TaskEditFragment fragment = new TaskEditFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subtask_list, container, false);
    }
}
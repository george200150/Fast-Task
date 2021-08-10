package com.george200150.fast_task.fragments.subtasks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.george200150.fast_task.R;

public class SubTaskEditFragment extends Fragment {

    public static String SUBTASK_ID;

    public SubTaskEditFragment() {
        // Required empty public constructor
    }

    public static SubTaskEditFragment newInstance(String param1, String param2) {
        SubTaskEditFragment fragment = new SubTaskEditFragment();
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
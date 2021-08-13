package com.george200150.fast_task.fragments.subtasks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.EditText;

import com.george200150.fast_task.R;
import com.george200150.fast_task.domain.SubTask;

public class SubTaskEditFragment extends Fragment {
    public static SubTask selectedSubTask;
    private EditText edit_description_text;

    public static void setSelectedSubTask(SubTask subTask) {
        selectedSubTask = subTask;
    }

    public SubTaskEditFragment() {
        super(R.layout.fragment_subtask_edit);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        edit_description_text = view.findViewById(R.id.editText_subtask_description);
        edit_description_text.setText(selectedSubTask.getDescription());
    }
}
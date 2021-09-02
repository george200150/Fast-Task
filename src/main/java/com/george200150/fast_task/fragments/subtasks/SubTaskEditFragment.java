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
    private EditText subtaskEditEditTextDescription;

    public static void setSelectedSubTask(SubTask subTask) {
        selectedSubTask = subTask;
    }

    public SubTaskEditFragment() {
        super(R.layout.fragment_subtask_edit);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        subtaskEditEditTextDescription = view.findViewById(R.id.subtask_edit_editText_description);
        subtaskEditEditTextDescription.setText(selectedSubTask.getDescription());
    }
}
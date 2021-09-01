package com.george200150.fast_task.fragments.intervals;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.george200150.fast_task.R;

public class IntervalEditFragment extends Fragment {
    private EditText intervalEditTextViewDays;
    private Button buttonUpdateInterval;
    private TimePicker intervalEditTimepicker;
    public IntervalEditFragment() {
        super(R.layout.fragment_interval_edit);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        intervalEditTextViewDays = view.findViewById(R.id.interval_edit_textview_days);
        buttonUpdateInterval = view.findViewById(R.id.button_update_interval);
        intervalEditTimepicker = view.findViewById(R.id.interval_edit_timepicker);
    }
}

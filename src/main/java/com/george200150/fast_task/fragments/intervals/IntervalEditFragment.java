package com.george200150.fast_task.fragments.intervals;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;
import com.george200150.fast_task.callbacks.WorkingHoursCallbackInterface;
import com.george200150.fast_task.domain.Interval;
import com.george200150.fast_task.domain.WorkSchedule;
import com.george200150.fast_task.formatters.TimeFormatter;

public class IntervalEditFragment extends Fragment {
    private static WorkingHoursCallbackInterface selectedCallback;
    private static Interval selectedWorkingHours;
    private static WorkSchedule selectedWorkSchedule;

    private Button intervalEditButtonUpdateInterval;
    private TimePicker intervalEditTimepickerBegin;
    private TimePicker intervalEditTimepickerEnd;
    public IntervalEditFragment() {
        super(R.layout.fragment_interval_edit);
    }

    public static void setCallback(WorkingHoursCallbackInterface callback) {
        selectedCallback = callback;
    }

    public static void setInterval(Interval workingHours) {
        selectedWorkingHours = workingHours;
    }

    public static void setWorkingSchedule(WorkSchedule workSchedule) {
        selectedWorkSchedule = workSchedule;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        intervalEditButtonUpdateInterval = view.findViewById(R.id.interval_edit_button_update_interval);
        intervalEditTimepickerBegin = view.findViewById(R.id.interval_edit_timepicker_begin);
        intervalEditTimepickerEnd = view.findViewById(R.id.interval_edit_timepicker_end);

        // TODO: set the workingHours values to the timePicker (selectedWorkingHours)

        intervalEditButtonUpdateInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String begin = TimeFormatter.formatHourMinute(intervalEditTimepickerBegin.getHour(), intervalEditTimepickerBegin.getMinute());
                String end = TimeFormatter.formatHourMinute(intervalEditTimepickerEnd.getHour(), intervalEditTimepickerEnd.getMinute());
                Interval interval = new Interval(begin, end);
                selectedCallback.setWorkingHours(selectedWorkSchedule, interval);
                Navigation.findNavController(view).navigate(R.id.fragment_location_edit);
            }
        });
    }
}

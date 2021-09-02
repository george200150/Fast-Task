package com.george200150.fast_task.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.george200150.fast_task.R;
import com.george200150.fast_task.callbacks.CallbackSetSat;
import com.george200150.fast_task.callbacks.CallbackSetSun;
import com.george200150.fast_task.callbacks.CallbackSetWeek;
import com.george200150.fast_task.domain.Location;
import com.george200150.fast_task.fragments.intervals.IntervalEditFragment;


public class LocationEditFragment extends Fragment {
    public static Location selectedLocation;
    private EditText locationEditEditTextName;
    private EditText locationEditEditTextType;
    private EditText locationEditEditTextCoordinates;
    private Button locationEditButtonWeekdaysInterval;
    private Button locationEditButtonSaturdayInterval;
    private Button locationEditButtonSundayInterval;
    private Button locationEditButtonNewLocation;
    private Button locationEditButtonUpdateLocation;

    public static void setSelectedLocation(Location location) {selectedLocation = location; }

    public LocationEditFragment() {
        super(R.layout.fragment_location_edit);
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: this is not a good thing to add hardcoded strings
        locationEditButtonWeekdaysInterval.setText("L-V: " + selectedLocation.getWorkSchedule().getWorkingHoursMondayToFriday().toString());
        locationEditButtonSaturdayInterval.setText("S: " + selectedLocation.getWorkSchedule().getWorkingHoursSaturday().toString());
        locationEditButtonSundayInterval.setText("D: " + selectedLocation.getWorkSchedule().getWorkingHoursSunday().toString());
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        locationEditEditTextName = view.findViewById(R.id.location_edit_editText_name);
        locationEditEditTextType = view.findViewById(R.id.location_edit_editText_type);
        locationEditEditTextCoordinates = view.findViewById((R.id.location_edit_editText_coordinates));

        locationEditEditTextName.setText(selectedLocation.getName());
        locationEditEditTextType.setText(selectedLocation.getType());
        locationEditEditTextCoordinates.setText(selectedLocation.getCoordinates());

        locationEditButtonSundayInterval = view.findViewById(R.id.location_edit_button_sunday_interval);
        locationEditButtonSaturdayInterval = view.findViewById(R.id.location_edit_button_saturday_interval);
        locationEditButtonWeekdaysInterval = view.findViewById(R.id.location_edit_button_weekdays_interval);

        locationEditButtonNewLocation = view.findViewById(R.id.location_edit_button_new_location);
        locationEditButtonUpdateLocation = view.findViewById(R.id.location_edit_button_update_location);

        locationEditButtonNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = locationEditEditTextName.getText().toString();
                String type = locationEditEditTextType.getText().toString();



                // TODO: save new location to database
            }
        });

        locationEditButtonUpdateLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: update location in database
            }
        });




        locationEditButtonWeekdaysInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntervalEditFragment.setCallback(new CallbackSetWeek());
                IntervalEditFragment.setWorkingSchedule(selectedLocation.getWorkSchedule());
                IntervalEditFragment.setInterval(selectedLocation.getWorkSchedule().getWorkingHoursMondayToFriday());
                Navigation.findNavController(view).navigate(R.id.fragment_interval_edit);
            }
        });

        locationEditButtonSaturdayInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntervalEditFragment.setCallback(new CallbackSetSat());
                IntervalEditFragment.setWorkingSchedule(selectedLocation.getWorkSchedule());
                IntervalEditFragment.setInterval(selectedLocation.getWorkSchedule().getWorkingHoursSaturday());
                Navigation.findNavController(view).navigate(R.id.fragment_interval_edit);
            }
        });

        locationEditButtonSundayInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntervalEditFragment.setCallback(new CallbackSetSun());
                IntervalEditFragment.setWorkingSchedule(selectedLocation.getWorkSchedule());
                IntervalEditFragment.setInterval(selectedLocation.getWorkSchedule().getWorkingHoursSunday());
                Navigation.findNavController(view).navigate(R.id.fragment_interval_edit);
            }
        });
    }
}
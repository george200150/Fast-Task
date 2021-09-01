package com.george200150.fast_task.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.george200150.fast_task.R;
import com.george200150.fast_task.domain.Location;

public class LocationEditFragment extends Fragment {
    public static Location selectedLocation;
    private EditText edit_location_name;
    private EditText edit_location_type;
    private EditText edit_location_coordintates;
//    private Button locationEdit_button_sunday_interval;
//    private Button location_edit_button_sunday_interval;
//    private Button location_edit_button_sunday_interval;

    public static void setSelectedLocation(Location location) {selectedLocation = location; }

    public LocationEditFragment() {
        super(R.layout.fragment_location_edit);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        edit_location_name = view.findViewById(R.id.location_edit_editText_name);
        edit_location_name.setText(selectedLocation.getName());
        edit_location_type = view.findViewById(R.id.location_edit_editText_type);
        edit_location_type.setText(selectedLocation.getType());
        edit_location_coordintates = view.findViewById((R.id.location_edit_editText_coordinates));
        edit_location_coordintates.setText(selectedLocation.getCoordinates());

    }
}
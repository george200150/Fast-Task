package com.george200150.fast_task.fragments.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.george200150.fast_task.R;
import com.george200150.fast_task.task.Interval;
import com.george200150.fast_task.task.Location;
import com.george200150.fast_task.task.Task;
import com.george200150.fast_task.task.WorkSchedule;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    private List<Task> tasks = new ArrayList<>();
    private View.OnClickListener clickListener;

    public TasksAdapter(Fragment fragment) {
        // TODO: might not need fragment
        //super(fragment);

        // TODO: only for testing purposes
        Task task1 = new Task();
        task1.setRegistered(Date.from(Instant.now()));
        task1.setDuration(Duration.ofSeconds(6000, 0));
        task1.setDeadline(Date.from(Instant.now().plus(180, ChronoUnit.MINUTES)));
        Interval interval = new Interval("00:00", "23:59");
        WorkSchedule workSchedule = new WorkSchedule(interval, interval, interval);
        Location location = new Location("name", "type", "N:0.0,E:0.0", workSchedule);
        task1.setLocation(location);
        tasks.add(task1);

        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = (Task) view.getTag();
                Bundle bundle = new Bundle();
                bundle.putString(TaskEditFragment.TASK_ID, task.getId());
                Navigation.findNavController(view).navigate(R.id.fragment_task_edit, bundle);
            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.location.setText(task.getLocation().toString());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView location;
        public ViewHolder(@NonNull View taskView) {
            super(taskView);
            location = taskView.findViewById(R.id.text_location);
        }
    }
}

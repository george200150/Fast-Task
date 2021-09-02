package com.george200150.fast_task.fragments.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.george200150.fast_task.R;
import com.george200150.fast_task.builders.DateFormatBuilder;
import com.george200150.fast_task.constants.DateFormatStrings;
import com.george200150.fast_task.domain.Interval;
import com.george200150.fast_task.domain.Location;
import com.george200150.fast_task.domain.SubTask;
import com.george200150.fast_task.domain.Task;
import com.george200150.fast_task.domain.WorkSchedule;
import com.george200150.fast_task.fragments.subtasks.SubTaskListFragment;

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
        task1.setId("x");
        task1.setRegistered(Date.from(Instant.now()));
        task1.setDuration(Duration.ofSeconds(120, 0));
        task1.setDeadline(Date.from(Instant.now()));
        Interval interval1 = new Interval("00:00", "23:59");
        WorkSchedule workSchedule1 = new WorkSchedule(interval1, interval1, interval1);
        Location location1 = new Location("Profi", "Market", "N:0.0,E:0.0", workSchedule1);
        task1.setLocation(location1);
        task1.setPriority(0);
        List<SubTask> todos1 = task1.getTodos();
        todos1.add(new SubTask("Buy 1 can of soda", false));
        todos1.add(new SubTask("Buy 2 bottles of water", false));
        todos1.add(new SubTask("Buy some flowers for Ann", false));
        task1.setTodos(todos1);
        tasks.add(task1);


        Task task2 = new Task();
        task2.setId("y");
        task2.setRegistered(Date.from(Instant.now()));
        task2.setDuration(Duration.ofSeconds(140, 0));
        task2.setDeadline(Date.from(Instant.now().plus(180, ChronoUnit.MINUTES)));
        Interval interval21 = new Interval("08:00", "20:00");
        Interval interval22 = new Interval("08:00", "16:00");
        Interval interval23 = new Interval("10:00", "14:00");
        WorkSchedule workSchedule2 = new WorkSchedule(interval21, interval22, interval23);
        Location location2 = new Location("Intersport", "Store", "N:23.45,E:0.0", workSchedule2);
        task2.setLocation(location2);
        task2.setPriority(2);
        task2.setDone(true);
        List<SubTask> todos2 = task2.getTodos();
        todos2.add(new SubTask("Purchase 1 pair of sneakers", true));
        todos2.add(new SubTask("Purchase a t-shirt", true));
        task2.setTodos(todos2);
        tasks.add(task2);

        Task task3 = new Task();
        task3.setId("z");
        task3.setRegistered(Date.from(Instant.now()));
        task3.setDuration(Duration.ofSeconds(1400, 0));
        task3.setDeadline(Date.from(Instant.now().plus(360, ChronoUnit.MINUTES)));
        Interval interval3 = new Interval("00:00", "00:00");
        WorkSchedule workSchedule3 = new WorkSchedule(interval3, interval3, interval3);
        Location location3 = new Location("Home", "Flat", "N:0.0,E:33.67", workSchedule3);
        task3.setLocation(location3);
        task3.setPriority(5);
        List<SubTask> todos3 = task3.getTodos();
        todos3.add(new SubTask("Say to Ann Happy Birthday!", false));
        task3.setTodos(todos3);
        tasks.add(task3);



        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = (Task) view.getTag();
                // passing bundle from fragment to fragment requires creating a new fragment just for that
                // decided to create a static method in the destination fragment instead
                SubTaskListFragment.setSelectedTask(task);
                // TODO: could potentially create bugs when editing the task and coming back to this fragment
                Navigation.findNavController(view).navigate(R.id.fragment_subtask_list);
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
        holder.deadline.setText(DateFormatBuilder.getSDF(DateFormatStrings.displayDateFormat).format(task.getDeadline()));
        holder.itemView.setTag(task);
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView location;
        private TextView deadline;
        public ViewHolder(@NonNull View taskView) {
            super(taskView);
            location = taskView.findViewById(R.id.view_task_textView_location);
            deadline = taskView.findViewById(R.id.view_task_textView_deadline);
        }
    }
}

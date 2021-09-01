package com.george200150.fast_task.fragments.subtasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.george200150.fast_task.R;
import com.george200150.fast_task.domain.SubTask;
import com.george200150.fast_task.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class SubTasksAdapter extends RecyclerView.Adapter<SubTasksAdapter.ViewHolder> {
    private List<SubTask> subTasks = new ArrayList<>();
    private View.OnClickListener clickListener;

    public SubTasksAdapter(Fragment fragment, Task selectedTask) {
        subTasks.addAll(selectedTask.getTodos());

        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubTask subTask = (SubTask) view.getTag();
                SubTaskEditFragment.setSelectedSubTask(subTask);
                Navigation.findNavController(view).navigate(R.id.fragment_subtask_edit);
            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_subtask, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubTask subTask = subTasks.get(position);
        holder.description.setText(subTask.getDescription());
        holder.itemView.setTag(subTask);
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return subTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView description;
        public ViewHolder(@NonNull View subTaskView) {
            super(subTaskView);
            description = subTaskView.findViewById(R.id.text_description);
        }
    }
}

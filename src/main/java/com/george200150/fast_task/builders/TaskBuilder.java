package com.george200150.fast_task.builders;

import com.george200150.fast_task.task.Task;

import java.util.ArrayList;

public class TaskBuilder {

    // TODO: Not Implemented yet
    public Task getResultTask() {
        Task task = new Task();
        task.setDone(false);
        task.setPriority(0);

        task.setRegistered(null);
        task.setDeadline(null);
        task.setDuration(null);

        task.setTodos(new ArrayList<>());

        return task;
    }
}

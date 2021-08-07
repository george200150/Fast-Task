package com.george200150.fast_task.builders;

import com.george200150.fast_task.exceptions.JsonFormatException;
import com.george200150.fast_task.task.Task;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TaskBuilder {

    // TODO: Not Implemented yet
    public Task getResultTask() {
        Task task = new Task();
        task.setDone(false);
        task.setPriority(0);

        task.setRegistered(null);
        task.setDeadline(null);
        task.setDuration(null);

        task.setTodos(null);

        return task;
    }
}

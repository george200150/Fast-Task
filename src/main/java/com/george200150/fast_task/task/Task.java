package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Task {
    @SerializedName("done") // status of the task - done or not done
    private boolean done;
    @SerializedName("priority") // importance of task; the lower the number, the higher the priority
    private int priority;
    // time information such as when the task was created, when it must be done and how long
    @SerializedName("registered")
    private Date registered;
    @SerializedName("deadline")
    private Date deadline;
    @SerializedName("duration")
    private Duration duration;
    // list of check items in the to-do list
    @SerializedName("todos")
    private List<SubTask> todos;

    public Task() {
        todos = new ArrayList<>();
    }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public Date getRegistered() { return registered; }
    public void setRegistered(Date registered) { this.registered = registered; }
    public Date getDeadline() { return deadline; }
    public void setDeadline(Date deadline) { this.deadline = deadline; }
    public Duration getDuration() { return duration; }
    public void setDuration(Duration duration) { this.duration = duration; }
    public List<SubTask> getTodos() { return todos; }
    public void setTodos(List<SubTask> todos) { this.todos = todos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return isDone() == task.isDone() &&
                getPriority() == task.getPriority() &&
                getRegistered().equals(task.getRegistered()) &&
                getDeadline().equals(task.getDeadline()) &&
                getDuration().equals(task.getDuration()) &&
                getTodos().equals(task.getTodos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDone(), getPriority(), getRegistered(), getDeadline(), getDuration(), getTodos());
    }
}

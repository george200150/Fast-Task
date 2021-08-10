package com.george200150.fast_task.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SubTask {
    // description of the subtask
    @SerializedName("description")
    private String description;
    // status of the subtask - checked or not checked
    @SerializedName("checked")
    private boolean checked;

    public SubTask(String description, boolean checked) {
        this.description = description;
        this.checked = checked;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTask)) return false;
        SubTask subTask = (SubTask) o;
        return getDescription().equals(subTask.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), isChecked());
    }
}

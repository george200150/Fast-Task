package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

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
}

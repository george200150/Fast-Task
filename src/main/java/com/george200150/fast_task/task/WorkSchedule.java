package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

public class WorkSchedule {
    @SerializedName("workingHoursMondayToFriday")
    private Interval workingHoursMondayToFriday;
    @SerializedName("workingHoursSaturday")
    private Interval workingHoursSaturday;
    @SerializedName("workingHoursSunday")
    private Interval workingHoursSunday;

    public WorkSchedule(Interval workingHoursMondayToFriday, Interval workingHoursSaturday, Interval workingHoursSunday) {
        this.workingHoursMondayToFriday = workingHoursMondayToFriday;
        this.workingHoursSaturday = workingHoursSaturday;
        this.workingHoursSunday = workingHoursSunday;
    }

    public Interval getWorkingHoursMondayToFriday() { return workingHoursMondayToFriday; }
    public void setWorkingHoursMondayToFriday(Interval workingHoursMondayToFriday) { this.workingHoursMondayToFriday = workingHoursMondayToFriday; }
    public Interval getWorkingHoursSaturday() { return workingHoursSaturday; }
    public void setWorkingHoursSaturday(Interval workingHoursSaturday) { this.workingHoursSaturday = workingHoursSaturday; }
    public Interval getWorkingHoursSunday() { return workingHoursSunday; }
    public void setWorkingHoursSunday(Interval workingHoursSunday) { this.workingHoursSunday = workingHoursSunday; }
}

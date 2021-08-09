package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkSchedule)) return false;
        WorkSchedule that = (WorkSchedule) o;
        return getWorkingHoursMondayToFriday().equals(that.getWorkingHoursMondayToFriday()) &&
                getWorkingHoursSaturday().equals(that.getWorkingHoursSaturday()) &&
                getWorkingHoursSunday().equals(that.getWorkingHoursSunday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkingHoursMondayToFriday(), getWorkingHoursSaturday(), getWorkingHoursSunday());
    }

    public String getWorkingHoursForToday() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            return "D: " + workingHoursSunday;
        } else if (day >= Calendar.MONDAY && day <= Calendar.FRIDAY) {
            return "L-V: " + workingHoursMondayToFriday;
        } else { // if (day == Calendar.SATURDAY) {
            return "S: " + workingHoursSaturday;
        }
    }
}

package com.george200150.fast_task.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Location {
    // name of the location
    @SerializedName("name")
    private String name;
    // type of the location - hospital, supermarket, flower shop
    @SerializedName("type")
    private String type;
    // coordinates of the location - N-E coordinates TODO: check gps coordinates format
    @SerializedName("coordinates")
    private String coordinates;

    // timetable of the location
    @SerializedName("workSchedule")
    private WorkSchedule workSchedule;

    public Location(String name, String type, String coordinates, WorkSchedule workSchedule) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.workSchedule = workSchedule;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getCoordinates() { return coordinates; }
    public void setCoordinates(String coordinates) { this.coordinates = coordinates; }
    public WorkSchedule getWorkSchedule() { return workSchedule; }
    public void setWorkSchedule(WorkSchedule workSchedule) { this.workSchedule = workSchedule; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getName().equals(location.getName()) &&
                getType().equals(location.getType()) &&
                getCoordinates().equals(location.getCoordinates()) &&
                getWorkSchedule().equals(location.getWorkSchedule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getCoordinates(), getWorkSchedule());
    }

    @Override
    public String toString() {
        return  type + ", " + name + "\nProgram: " + workSchedule.getWorkingHoursForToday();
    }
}

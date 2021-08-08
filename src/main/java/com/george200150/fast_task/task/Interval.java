package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Interval {
    // begin of an interval
    @SerializedName("begin")
    private String begin;
    // end of an interval
    @SerializedName("end")
    private String end;

    public Interval(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    public String getBegin() { return begin; }
    public String getEnd() { return end; }
    public void setBegin(String begin) { this.begin = begin; }
    public void setEnd(String end) { this.end = end; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return getBegin().equals(interval.getBegin()) &&
                getEnd().equals(interval.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBegin(), getEnd());
    }
}

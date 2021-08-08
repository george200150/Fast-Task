package com.george200150.fast_task.task;

import com.google.gson.annotations.SerializedName;

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
}

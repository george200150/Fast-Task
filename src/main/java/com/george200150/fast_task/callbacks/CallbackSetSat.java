package com.george200150.fast_task.callbacks;

import com.george200150.fast_task.domain.Interval;
import com.george200150.fast_task.domain.WorkSchedule;

public class CallbackSetSat implements WorkingHoursCallbackInterface {
    public WorkSchedule setWorkingHours(WorkSchedule workSchedule, Interval hours){
        workSchedule.setWorkingHoursSaturday(hours);
        return workSchedule;
    }
}
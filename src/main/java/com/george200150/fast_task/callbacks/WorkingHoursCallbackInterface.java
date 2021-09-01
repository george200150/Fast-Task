package com.george200150.fast_task.callbacks;

import com.george200150.fast_task.domain.Interval;
import com.george200150.fast_task.domain.WorkSchedule;

//define callback interface
public interface WorkingHoursCallbackInterface {
    WorkSchedule setWorkingHours(WorkSchedule workSchedule, Interval hours);
}

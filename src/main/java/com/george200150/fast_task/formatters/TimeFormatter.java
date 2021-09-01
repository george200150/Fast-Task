package com.george200150.fast_task.formatters;

import com.george200150.fast_task.constants.DateFormatStrings;

public class TimeFormatter {
    public static String formatHourMinute(int hour, int minute) {
        return String.format(DateFormatStrings.hourMinuteDigitalFormat, hour, minute);
    }
}

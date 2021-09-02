package com.george200150.fast_task.formatters;

import com.george200150.fast_task.constants.DateFormatStrings;

import java.time.Duration;

public class DurationFormatter {
    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                DateFormatStrings.hourMinuteSecondDigitalFormat,
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}

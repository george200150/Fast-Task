package com.george200150.fast_task.builders;

import java.text.SimpleDateFormat;

public class DateFormatBuilder {
    public static SimpleDateFormat getSDF(String format) {
        // TODO: decide if factory or builder
        return new SimpleDateFormat(format);
    }
}

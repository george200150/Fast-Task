package com.george200150.fast_task.builders;

import com.google.gson.Gson;

import static com.george200150.fast_task.constants.DateFormat.stringDateFormat;

public class GsonBuilder {
    public static Gson buildGson() {
        return new com.google.gson.GsonBuilder().setDateFormat(stringDateFormat).setPrettyPrinting().create();
    }
}

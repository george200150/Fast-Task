package com.george200150.fast_task.parser;

import com.george200150.fast_task.builders.GsonBuilder;
import com.george200150.fast_task.exceptions.JsonFormatException;
import com.george200150.fast_task.task.TodoList;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExporter {
    // lazy init, singleton
    private static Gson gson;
    private static FileWriter fw;

    public static void exportList(TodoList todoList, String fileName) {
        if (gson == null) {
            gson = GsonBuilder.buildGson();
        }
        String jsonString = gson.toJson(todoList);
        try {
            writeJsonToFile(jsonString, fileName);
        } catch (IOException e) {
            throw new JsonFormatException(e.getMessage());
        }
    }

    private static void writeJsonToFile(String jsonString, String fileName) throws IOException {
        if (fw == null) {
            fw = new FileWriter(fileName);
        }
        try {
            fw.write(jsonString);
        } finally {
            fw.flush();
            fw.close();
        }
    }
}

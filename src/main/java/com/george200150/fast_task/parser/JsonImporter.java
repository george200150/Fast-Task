package com.george200150.fast_task.parser;

import com.george200150.fast_task.builders.GsonBuilder;
import com.george200150.fast_task.exceptions.JsonFileNotFoundException;
import com.george200150.fast_task.task.TodoList;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonImporter {
    // lazy init, singleton
    private static Gson gson;
    private static JsonParser parser;

    public static TodoList importList(String fileName) {
        try {
            String jsonString = readJsonFromFile(fileName);
            return getTodoListFromJson(jsonString);
        } catch (Exception e) {
            throw new JsonFileNotFoundException(e.getMessage());
        }
    }

    private static TodoList getTodoListFromJson(String jsonString) {
        if (parser == null) {
            parser = new JsonParser();
            gson = GsonBuilder.buildGson();
        }
        JsonElement mJson = parser.parse(jsonString);
        return gson.fromJson(mJson, TodoList.class);
    }

    private static String readJsonFromFile(String fileName) throws IOException {
        return getStringFromFile(fileName);
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile(String filePath) throws IOException {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }

}

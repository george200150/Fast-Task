package com.george200150.fast_task.parser;

import com.george200150.fast_task.domain.Interval;
import com.george200150.fast_task.domain.Location;
import com.george200150.fast_task.domain.Task;
import com.george200150.fast_task.domain.TodoList;
import com.george200150.fast_task.domain.WorkSchedule;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonParserTest {
    private String fileName = "test.json";
    private Task task1 = new Task();
    private Task task2 = new Task();
    private Interval interval = new Interval("00:00", "23:59");
    private WorkSchedule workSchedule = new WorkSchedule(interval, interval, interval);
    private Location location = new Location("name", "type", "N:0.0,E:0.0", workSchedule);
    @Test
    public void exporterExportTest() {
        task1.setRegistered(Date.from(Instant.now()));
        task1.setDuration(Duration.ofSeconds(6000, 0));
        task1.setDeadline(Date.from(Instant.now().plus(180, ChronoUnit.MINUTES)));
        task1.setLocation(location);

        task2.setDone(true);
        task2.setPriority(1);
        task2.setRegistered(Date.from(Instant.now()));
        task2.setDuration(Duration.ofSeconds(120, 10));
        task2.setDeadline(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));
        task2.setLocation(location);

        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        TodoList todoList = new TodoList();
        todoList.setTodoList(taskList);
        JsonExporter.exportList(todoList, fileName);

        TodoList todoList2 = JsonImporter.importList(fileName);
        for (int i = 0; i < todoList.getTodoList().size(); i++) {
            Task t1 = todoList.getTodoList().get(i);
            Task t2 = todoList2.getTodoList().get(i);
            assertEquals(t1.equals(t2), true);
        }
    }
}
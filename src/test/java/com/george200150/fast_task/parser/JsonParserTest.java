package com.george200150.fast_task.parser;

import com.george200150.fast_task.task.Task;
import com.george200150.fast_task.task.TodoList;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JsonParserTest {
    private String fileName = "test.json";
    private Task task1 = new Task();
    private Task task2 = new Task();
    @Test
    public void exporterExportTest() {
        task1.setRegistered(Date.from(Instant.now()));
        task1.setDuration(Duration.ofSeconds(6000, 0));
        task1.setDeadline(Date.from(Instant.now().plus(180, ChronoUnit.MINUTES)));

        task2.setDone(true);
        task2.setPriority(1);
        task2.setRegistered(Date.from(Instant.now()));
        task2.setDuration(Duration.ofSeconds(120, 10));
        task2.setDeadline(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));
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
            assertEquals(t1.equals(t2), true); // TODO: difference in time of 45 ms
        }
    }
}
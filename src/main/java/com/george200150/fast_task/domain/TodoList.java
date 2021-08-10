package com.george200150.fast_task.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TodoList {
    @SerializedName("todoList")
    private List<Task> todoList;

    public TodoList() { }

    public List<Task> getTodoList() { return todoList; }
    public void setTodoList(List<Task> todoList) { this.todoList = todoList; }
}

package com.fajlay.bestTodo.dtos;

public class TodoDto {
    private int id;
    private String todoLabel;
    private String todoDescription;
    private Boolean completed;
    private int userId;



    public TodoDto() {
    }

    public TodoDto(int id, String todoLabel, String todoDescription, Boolean completed, int userId) {
        this.id = id;
        this.todoLabel = todoLabel;
        this.todoDescription = todoDescription;
        this.completed = completed;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoLabel() {
        return todoLabel;
    }

    public void setTodoLabel(String todoLabel) {
        this.todoLabel = todoLabel;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", todoLabel='" + todoLabel + '\'' +
                ", todoDescription='" + todoDescription + '\'' +
                ", completed=" + completed +
                ", user=" + userId +
                '}';
    }
}

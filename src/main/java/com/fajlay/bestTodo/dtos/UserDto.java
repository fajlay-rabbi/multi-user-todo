package com.fajlay.bestTodo.dtos;


import java.util.List;

public class UserDto {
    private int id;
    private String name;

    private String email;
    private String password;

    private List<TodoDto> todos;





    public UserDto() {
    }

    public UserDto(int id, String name, String email, String password, List<TodoDto> todos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.todos = todos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", todos=" + todos +
                '}';
    }
}

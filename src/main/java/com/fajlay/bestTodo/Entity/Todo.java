package com.fajlay.bestTodo.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "todo_label")
    private String todoLabel;

    @Column(name = "todo_description")
    private String todoDescription;

    @Column(name = "completed")
    private Boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




    public Todo() {
    }

    public Todo(int id, String todoLabel, String todoDescription, Boolean completed, User user) {
        this.id = id;
        this.todoLabel = todoLabel;
        this.todoDescription = todoDescription;
        this.completed = completed;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

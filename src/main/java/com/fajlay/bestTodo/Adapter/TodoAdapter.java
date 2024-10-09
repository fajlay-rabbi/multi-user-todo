package com.fajlay.bestTodo.Adapter;

import com.fajlay.bestTodo.Entity.Todo;
import com.fajlay.bestTodo.Entity.User;
import com.fajlay.bestTodo.Repository.UserRepository;
import com.fajlay.bestTodo.dtos.TodoDto;

public class TodoAdapter {
    public static TodoDto toTodoDto (Todo todo){
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setTodoLabel(todo.getTodoLabel());
        todoDto.setTodoDescription(todo.getTodoDescription());
        todoDto.setCompleted(todo.getCompleted());
        todoDto.setUserId(todo.getUser().getId());

        return todoDto;
    }

    public static Todo toTodoEntity(TodoDto todoDto, UserRepository userRepository){
        Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setTodoLabel(todoDto.getTodoLabel());
        todo.setTodoDescription(todoDto.getTodoDescription());
        todo.setCompleted(todoDto.getCompleted());

        User user = userRepository
                .findById(todoDto.getUserId())
                        .orElseThrow(()-> new RuntimeException("No user found!!"));

        todo.setUser(user);

        return todo;
    }







    public static Todo updateTodoEntity(TodoDto todoDto, Todo todo){
        if (todoDto.getTodoLabel() != null){
            todo.setTodoLabel(todoDto.getTodoLabel());
        }
        if (todoDto.getTodoDescription() != null){
            todo.setTodoDescription(todoDto.getTodoDescription());
        }
        if (todoDto.getCompleted() != null){
            todo.setCompleted(todo.getCompleted());
        }

        return todo;
    }

}

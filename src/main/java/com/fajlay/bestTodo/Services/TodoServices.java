package com.fajlay.bestTodo.Services;

import com.fajlay.bestTodo.Adapter.TodoAdapter;
import com.fajlay.bestTodo.Repository.TodoRepository;
import com.fajlay.bestTodo.Entity.Todo;
import com.fajlay.bestTodo.Repository.UserRepository;
import com.fajlay.bestTodo.dtos.TodoDto;
import com.fajlay.bestTodo.exceptions.NoSuchTodoFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServices {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    TodoServices(TodoRepository todoRepository, UserRepository userRepository){
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<TodoDto> getAllTodos(){
        return todoRepository.findAll()
                .stream()
                .map(TodoAdapter::toTodoDto)
                .collect(Collectors.toList());
    }

    public TodoDto createTodo(TodoDto todoDto){
        Todo todo = TodoAdapter.toTodoEntity(todoDto,userRepository);
        todo = this.todoRepository.save(todo);

        return TodoAdapter.toTodoDto(todo);
    }

    public TodoDto getTodosById(int id){
        Todo todo = this.todoRepository.findById(id).orElseThrow(() -> new NoSuchTodoFound("ID: " + id));
        return TodoAdapter.toTodoDto(todo);
    }

    public void deleteTodosById(int id){
        this.todoRepository.deleteById(id);
    }

    public TodoDto updateDto(TodoDto todoDto, int id){
        Todo todo = this.todoRepository.findById(id).orElseThrow(()-> new NoSuchTodoFound("ID: " + id));
        TodoAdapter.updateTodoEntity(todoDto, todo);
        this.todoRepository.save(todo);

        return TodoAdapter.toTodoDto(todo);
    }

}

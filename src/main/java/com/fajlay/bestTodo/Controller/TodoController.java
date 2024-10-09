package com.fajlay.bestTodo.Controller;

import com.fajlay.bestTodo.Services.TodoServices;
import com.fajlay.bestTodo.dtos.TodoDto;
import com.fajlay.bestTodo.exceptions.NoSuchTodoFound;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    private final TodoServices todoServices;
    TodoController(TodoServices todoServices){
        this.todoServices = todoServices;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<TodoDto>> getAllTodo(){
        List<TodoDto> todos = todoServices.getAllTodos();

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable int id){
         TodoDto todo = todoServices.getTodosById(id);

         return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<TodoDto> createTodo(@Valid @RequestBody TodoDto todo){
       TodoDto todos = todoServices.createTodo(todo);

       return new ResponseEntity<>(todos, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todo, @PathVariable int id){
       TodoDto todoDto = todoServices.updateDto(todo, id);

       return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTodoById(@PathVariable int id){
        todoServices.deleteTodosById(id);
    }

}

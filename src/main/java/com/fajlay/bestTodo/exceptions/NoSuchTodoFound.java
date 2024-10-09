package com.fajlay.bestTodo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchTodoFound extends RuntimeException {
    public NoSuchTodoFound(String s) {
        super(s);
    }
}

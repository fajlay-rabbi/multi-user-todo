package com.fajlay.bestTodo.Adapter;

import com.fajlay.bestTodo.Entity.User;
import com.fajlay.bestTodo.dtos.TodoDto;
import com.fajlay.bestTodo.dtos.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserAdapter {
    public static User  toUserEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        if (user.getTodos() != null){
            List<TodoDto> todos = user.getTodos().stream()
                    .map(TodoAdapter::toTodoDto)
                    .collect(Collectors.toList());

            userDto.setTodos(todos);
        }

        return userDto;
    }

    public static User updateUserEntity(UserDto userDto, User user){
        if (userDto.getName() != null){
            user.setName(userDto.getName());
        }
        if (userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPassword() != null){
            user.setPassword(userDto.getPassword());
        }

        return user;
    }
}

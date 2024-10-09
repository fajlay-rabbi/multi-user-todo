package com.fajlay.bestTodo.Services;
import com.fajlay.bestTodo.Adapter.UserAdapter;
import com.fajlay.bestTodo.Entity.User;
import com.fajlay.bestTodo.Repository.UserRepository;
import com.fajlay.bestTodo.dtos.TodoDto;
import com.fajlay.bestTodo.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private  final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto){
        User user = UserAdapter.toUserEntity(userDto);
        user = this.userRepository.save(user);

        return UserAdapter.toUserDto(user);
    }

    public List<UserDto> getAllUser(){
        return this.userRepository.findAll()
                .stream()
                .map(UserAdapter::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(int id){
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User found!"));

        return UserAdapter.toUserDto(user);
    }

    public UserDto updateUser(UserDto userDto, int Id){
        User user = this.userRepository.findById(Id).orElseThrow(() -> new RuntimeException("No user found"));
        UserAdapter.updateUserEntity(userDto,user);
        this.userRepository.save(user);

        return UserAdapter.toUserDto(user);
    }

    public void deleteUser(int id){
        this.userRepository.deleteById(id);
    }

}

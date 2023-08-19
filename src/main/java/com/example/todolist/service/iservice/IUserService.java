package com.example.todolist.service.iservice;

import com.example.todolist.dal.dto.UserDto;
import com.example.todolist.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDto> getAll();
    UserDto getById(String id);

    List<UserDto> search(String keyword);

    UserDto insert(UserDto userDto);

    UserDto update(UserDto userDto);

    boolean delete(String id);
}

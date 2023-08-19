package com.example.todolist.dal.mapper;

import com.example.todolist.dal.dto.UserDto;
import com.example.todolist.entity.Task;
import com.example.todolist.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setAddress(user.getAddress());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());

        return tmp;
    }

    public static List<UserDto> toUserList(List<User> users){
        List<UserDto> result = new ArrayList<>();
        for(User user : users){
            UserDto userDto = toUserDto(user);
            result.add(userDto);
        }
        return result;
    }

    public static User toUser(UserDto userDto){
        User tmp = new User();
        tmp.setId(userDto.getId());
        tmp.setName(userDto.getName());
        tmp.setAddress(userDto.getAddress());
        tmp.setEmail(userDto.getEmail());
        tmp.setPhone(userDto.getPhone());
        return tmp;
    }

}

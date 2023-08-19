package com.example.todolist.service.serviceimlp;

import com.example.todolist.dal.dto.UserDto;
import com.example.todolist.dal.mapper.UserMapper;
import com.example.todolist.dal.repository.UserRepository;
import com.example.todolist.entity.User;
import com.example.todolist.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = UserMapper.toUserList(users);
        return result;
    }

    @Override
    public UserDto getById(String id) {
            User user = userRepository.findById(id).orElse(null);
            UserDto result = UserMapper.toUserDto(user);

            return result;
    }

    @Override
    public List<UserDto> search(String keyword) {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();

        for(User user : users){
            if(user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
            if(user.getEmail().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
            if(user.getAddress().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
            if(user.getPhone().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto insert(UserDto userDto) {
            String uuid = UUID.randomUUID().toString();
            userDto.setId(uuid);
            User user = UserMapper.toUser(userDto);
            userRepository.save(user);
            return userDto;

    }

    @Override
    public UserDto update(UserDto userDto) {
        userRepository.save(UserMapper.toUser(userDto));
        return userDto;
    }

    @Override
    public boolean delete(String id) {
        try {
            userRepository.deleteById(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}

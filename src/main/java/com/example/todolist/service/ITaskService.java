package com.example.todolist.service;

import com.example.todolist.dal.dto.TaskDto;


import java.util.List;
public interface ITaskService {
    List<TaskDto> getAllTask();
}

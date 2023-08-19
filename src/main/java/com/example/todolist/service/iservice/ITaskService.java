package com.example.todolist.service.iservice;

import com.example.todolist.dal.dto.TaskDto;
import java.util.List;
public interface ITaskService {
    List<TaskDto> getAllTask();
    TaskDto getById(String id);

    List<TaskDto> search(String keyword);

    TaskDto insert(TaskDto taskDto);

    TaskDto update(TaskDto taskDto);

    boolean delete(String id);
}

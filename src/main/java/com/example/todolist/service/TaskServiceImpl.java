package com.example.todolist.service;
import com.example.todolist.dal.dao.ITaskDAO;
import com.example.todolist.dal.dao.TaskDAO;
import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.dal.mapper.TaskMapper;
import com.example.todolist.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TaskServiceImpl implements ITaskService {
    @Autowired
    private ITaskDAO taskDAO;
    @Override
    public List<TaskDto> getAllTask() {
        ArrayList<Task> tasks = taskDAO.getAllTask();
        List<TaskDto> result = TaskMapper.toTaskDtoList(tasks);
        return result;
    }
}





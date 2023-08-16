package com.example.todolist.dal.mapper;

import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static TaskDto toTaskDto(Task task){
        TaskDto tmp = new TaskDto();
        tmp.setId(task.getId());
        tmp.setTitle(task.getTitle());
        tmp.setDescription(task.getDescription());
        tmp.setIsCompleted(task.getIsCompleted());
        tmp.setCreatedDate(task.getCreatedDate());
        tmp.setUpdatedDate(task.getUpdatedDate());
        return tmp;
    }

    public static List<TaskDto> toTaskDtoList(List<Task> tasks){
        List<TaskDto> result = new ArrayList<>();
        for(Task task : tasks){
            TaskDto taskDto = toTaskDto(task);
            result.add(taskDto);
        }
        return result;
    }

    public static Task toTask(TaskDto taskDto){
        Task tmp = new Task();
        tmp.setId(taskDto.getId());
        tmp.setTitle(taskDto.getTitle());
        tmp.setDescription(taskDto.getDescription());
        tmp.setIsCompleted(taskDto.getIsCompleted());
        tmp.setCreatedDate(taskDto.getCreatedDate());
        tmp.setUpdatedDate(taskDto.getUpdatedDate());
        return tmp;
    }
}

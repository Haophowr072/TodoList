package com.example.todolist.controller;

import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @GetMapping("/task")
    public ResponseEntity<?> getAllTask(){
        List<TaskDto> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }
}

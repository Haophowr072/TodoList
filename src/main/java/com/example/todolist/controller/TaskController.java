package com.example.todolist.controller;

import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @GetMapping("")
    public ResponseEntity<?> getAllTask(){
        List<TaskDto> tasks = taskService.getAllTask();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        TaskDto task = taskService.getById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword){
        List<TaskDto> tasks = taskService.search(keyword);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping ("/insert")
    public ResponseEntity<?> insert(@RequestBody TaskDto taskDto){
        String error = insertValidation(taskDto);
        if(error.isEmpty()){
            TaskDto task = taskService.insert(taskDto);
            return ResponseEntity.ok(task);
        }else {
            return ResponseEntity.ok(error);
        }
    }
    //Hàm ktr đầu vào của taskDto
    public String insertValidation(TaskDto taskDto){
        String result = "";
        if(taskDto.getTitle() == null)
            result = "Đầu vào không hợp lệ";

        return result;
    }
}

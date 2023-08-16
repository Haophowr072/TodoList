package com.example.todolist.controller;

import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.service.ITaskService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> insert(@RequestBody @Valid TaskDto taskDto, BindingResult bindingResult) {
        String errors = handleErrorsNotId(bindingResult);
        if(errors.isEmpty()){
            TaskDto task = taskService.insert(taskDto);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.ok(errors);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid TaskDto taskDto, BindingResult bindingResult){
        String errors = handleErrors(bindingResult);
        if(errors.isEmpty()){
            TaskDto task = taskService.insert(taskDto);
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.ok(errors);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathParam("id") String id){
        boolean task = taskService.delete(id);

        return ResponseEntity.ok(task);
    }


    public static String handleErrors(BindingResult bindingResult) {

        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        String errorMgs = "";
        for (String key : errors.keySet()) {
            errorMgs += errors.get(key) + "\n";
        }
        return errorMgs;
    }

    public static String handleErrorsNotId(BindingResult bindingResult) {

        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage())
        );
        String errorMgs = "";
        for (String key : errors.keySet()) {
            errorMgs = errors.get(key) + "\n";
        }
        return errorMgs;
    }
}





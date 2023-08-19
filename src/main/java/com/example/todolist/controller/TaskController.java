package com.example.todolist.controller;

import com.example.todolist.dal.dto.ResponseDto;
import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.service.iservice.ITaskService;
import com.example.todolist.service.iservice.IUserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public ResponseEntity<?> getAllTask(){
        List<TaskDto> tasks = taskService.getAllTask();
        if(tasks == null){
            return new ResponseEntity<>(new ResponseDto(List.of("Lấy danh sách task thất bại"),
                    HttpStatus.BAD_REQUEST.value(), tasks),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Lấy danh sách task thành công!"),
                HttpStatus.OK.value(), tasks),
                HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable String userId){
        TaskDto task = taskService.getById(userId);
        if(task == null){
            return new ResponseEntity<>(new ResponseDto(List.of("Lấy task thất bại"),
                    HttpStatus.BAD_REQUEST.value(), task),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Lấy task thành công"),
                HttpStatus.OK.value(), task),
                HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword){
        List<TaskDto> tasks = taskService.search(keyword);
        if(tasks == null){
            return new ResponseEntity<>(new ResponseDto(List.of("Lấy thất bại"),
                    HttpStatus.BAD_REQUEST.value(), tasks),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Tìm kiếm thành công"),
                HttpStatus.OK.value(), tasks),
                HttpStatus.OK);
    }

    @PostMapping ("/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid TaskDto taskDto) {
        TaskDto task = taskService.insert(taskDto);
        if(task == null){
            return new ResponseEntity<>(new ResponseDto(List.of("Thêm thất bại!"),
                    HttpStatus.BAD_REQUEST.value(), task),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Thêm thành công!"),
                HttpStatus.OK.value(), task),
                HttpStatus.OK);

    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid TaskDto taskDto){
        String error = exception(taskDto);
        if (error.isEmpty()) {
            TaskDto task = taskService.update(taskDto);

            if (task == null) {
                return new ResponseEntity<>(new ResponseDto(List.of("Cập nhật thất bại!"),
                        HttpStatus.BAD_REQUEST.value(), task),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(new ResponseDto(List.of("Cập nhật thành công!"),
                    HttpStatus.OK.value(), task),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Vui lòng thêm id"),
                HttpStatus.OK.value(), error),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathParam("id") String id){
        boolean task = taskService.delete(id);
        if(task == false){
            return new ResponseEntity<>(new ResponseDto(List.of("Xóa thất bại!"),
                    HttpStatus.BAD_REQUEST.value(), task),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Xóa thành công!"),
                HttpStatus.OK.value(), task),
                HttpStatus.OK);
    }
    //Validation id
    public String exception(TaskDto taskDto){
        String message;
        if(taskDto.getId().isEmpty()){
            return message = "Validation Failed";
        }
        return "";
    }


}





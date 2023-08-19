package com.example.todolist.controller;


import com.example.todolist.dal.dto.ResponseDto;
import com.example.todolist.dal.dto.TaskDto;
import com.example.todolist.dal.dto.UserDto;
import com.example.todolist.service.iservice.IUserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable @Valid String id){
        if(id.isEmpty()){
            UserDto users = userService.getById(id);
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.ok("Vui lòng nhập Id");
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword){
        List<UserDto> users = userService.search(keyword);
        return ResponseEntity.ok(users);
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid UserDto userDto){
        UserDto user = userService.insert(userDto);
        if(user == null){
            return new ResponseEntity<>(new ResponseDto(List.of("Thêm thất bại!"),
                    HttpStatus.BAD_REQUEST.value(), user),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Thêm thành công!"),
                    HttpStatus.OK.value(), user),
                    HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UserDto userDto){
        if(exception(userDto).isEmpty()) {
            UserDto user = userService.update(userDto);
            if (user == null) {
                return new ResponseEntity<>(new ResponseDto(List.of("Cập nhật thất bại!"),
                        HttpStatus.BAD_REQUEST.value(), user),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(new ResponseDto(List.of("Cập nhật thành công!"),
                    HttpStatus.OK.value(), user),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Vui lòng nhập id"),
                HttpStatus.OK.value(), exception(userDto)),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathParam("id") String id) {
        boolean user = userService.delete(id);
        if(user == false){
            return new ResponseEntity<>(new ResponseDto(List.of("Xóa thất bại!"),
                    HttpStatus.BAD_REQUEST.value(), user),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseDto(List.of("Xóa thành công!"),
                HttpStatus.OK.value(), user),
                HttpStatus.OK);
       }


    //Validation id
    public String exception(UserDto userDto){
        String message;
        if(userDto.getId().isEmpty()){
            return message = "Validation Failed";
        }
        return "";
    }
}

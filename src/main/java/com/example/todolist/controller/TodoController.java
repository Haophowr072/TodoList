package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("api/v1")
public class TodoController {

    List<Todo> todoList = new ArrayList<>();

    @GetMapping("/listTodo")
    public ResponseEntity<?> TodoList(Model model, @RequestParam(value = "limit", required = false) Integer limit){
        // Trả về đối tượng todoList.
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
        model.addAttribute("todoList", limit != null ? todoList.subList(0, limit) : todoList);
        return ResponseEntity.ok(todoList);
    }
    @GetMapping("/addTodo")
    public ResponseEntity<?> addTodo(Model model) {
        // Thêm mới một đối tượng Todo vào model
        model.addAttribute("todo", new Todo());
        // Trả về template addTodo.html
        return ResponseEntity.ok(model);
    }
    /*
@ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
 */
    @PostMapping("/addTodo")
    public ResponseEntity<?> addTodo(@ModelAttribute Todo todo) {
        // Thêm đối tượng todo vào list
        todoList.add(todo);
        // Trả về trang thành công success.html
        return ResponseEntity.ok(todo);
    }

}

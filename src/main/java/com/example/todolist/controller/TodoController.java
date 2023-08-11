package com.example.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1")
public class TodoController {
    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodoList(Model model){
        return "addTodo";
    }
    @RequestMapping(value = "/createTodo", method = RequestMethod.POST)
    public String createTodoList(@ModelAttribute Todo todo){
        return "createTodo";
    }
}

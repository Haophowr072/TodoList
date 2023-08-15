package com.example.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@RequiredArgsConstructor
public class TodoListApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TodoListApplication.class, args);

    }
}

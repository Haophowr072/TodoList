package com.example.todolist.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {
    private String detail;
    private String title;
}

package com.example.todolist.dal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private Boolean isCompleted;

}

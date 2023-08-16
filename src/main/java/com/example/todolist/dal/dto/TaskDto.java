package com.example.todolist.dal.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    @NotEmpty(message = "Vui lòng nhập id")
    private String id;
    @NotEmpty(message = "Vui lòng nhập title")
    private String title;
    private String description;
    private Boolean isCompleted;
    private Date createdDate;
    private Date updatedDate;
}

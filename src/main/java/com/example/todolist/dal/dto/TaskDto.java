package com.example.todolist.dal.dto;

import com.example.todolist.entity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String id;
    @NotEmpty(message = "Vui lòng nhập title")
    private String title;
    private String description;
    private Boolean isCompleted;
    private Date createdDate;
    private Date updatedDate;
    private String userId;

}

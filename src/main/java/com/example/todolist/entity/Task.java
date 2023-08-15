package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Table(name = "task")
@Entity
public class Task{
    @Id
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "is_completed")
    private Boolean isCompleted;
}

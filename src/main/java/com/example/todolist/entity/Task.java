package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Table(name = "task")
@Entity
public class Task implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "isCompleted")
    private Boolean isCompleted;
}

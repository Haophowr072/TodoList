package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class User {
    @Id
    private String id;
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;


}

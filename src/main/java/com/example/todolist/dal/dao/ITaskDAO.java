package com.example.todolist.dal.dao;

import com.example.todolist.entity.Task;

import java.util.ArrayList;


public interface ITaskDAO {
    public ArrayList<Task> getAllTask();
}

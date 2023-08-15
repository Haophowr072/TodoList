package com.example.todolist.dal.dao;

import com.example.todolist.ConnectSqlServer;
import com.example.todolist.entity.Task;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class TaskDAO implements ITaskDAO{

    @Override
    public ArrayList<Task> getAllTask() {
        Connection conn = ConnectSqlServer.openConnection();
        ArrayList<Task> resutl = new ArrayList<>();

        try {
            String sql = "select * from task";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Boolean isCompleted = rs.getBoolean("isCompleted");

                resutl.add(new Task(id, title, description, isCompleted));
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }finally {
            ConnectSqlServer.closeConnection(conn);
        }
        return resutl;
    }
}

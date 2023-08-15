package com.example.todolist;

import java.sql.*;


public class ConnectSqlServer {
    public static Connection openConnection(){
        Connection conn = null;

        try {
            String dbURL = "jdbc:mysql://localhost:3306/todolist";
            String userName = "admin";
            String password = "123456";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect successfully");
        }catch (SQLException | ClassNotFoundException ex){
            System.out.println("Connect failure!" + ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }




}

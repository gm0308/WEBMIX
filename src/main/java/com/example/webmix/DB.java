package com.example.webmix;

import java.sql.*;

public class DB {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/webmix";
        String userName = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


}






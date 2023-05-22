package org.example.repository.db;

import java.sql.*;

public class ConnectionManager {
    public static Connection con;

    public static void getConnection() {
        con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db01";    // jdbc는 DB 이름
        String id = "root";
        String pwd = "0711";

        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, id, pwd);
                System.out.println("Connected...");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Connection Failed!");
                e.printStackTrace();    // 예외 발생시 내용 출력
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection Failed. Check Driver or URL");
            e.printStackTrace();        // 예외 발생시 내용 출력
        }
    }
}
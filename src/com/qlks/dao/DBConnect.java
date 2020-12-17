package com.qlks.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hello
 */
public class DBConnect {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_HOCVIEN;user=sa;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

package com.qlks.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class DBConnect {
    private static DBConnect instance;
    private static Connection conn;

    static {
        final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String URL = "jdbc:sqlserver://localhost:1433;databasename=QL_KHACH_SAN";
        final String USERNAME = "sa";
        final String PASSWORD = "123abc";
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static DBConnect getInstance() throws SQLException{
        if (instance == null) {
            instance = new DBConnect();
        }else if(instance.getConnection().isClosed()){
            instance = new DBConnect();
        }
        return instance;
    }

}

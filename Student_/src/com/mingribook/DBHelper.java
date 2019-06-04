package com.mingribook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper implements DBConfig {
    
    private static Connection conn;// 创建Connection类型引用
    private static Statement stat;// 创建Statement类型引用
    private static ResultSet rs;// 创建ResultSet类型引用
    
    public static Connection getConnection() {// 获得Connection类型对象
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Statement openStatement() {// 获得Statement类型对象
        try {
            stat = getConnection().createStatement();
            return stat;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static int update(String sql) {// 完成数据的更新操作
        try {
            return openStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static ResultSet query(String sql) {// 完成数据的查询操作
        try {
            rs = openStatement().executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void close() {// 释放资源
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

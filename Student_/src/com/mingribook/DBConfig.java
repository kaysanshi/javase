package com.mingribook;

public interface DBConfig {
    String DRIVER = "com.mysql.jdbc.Driver";// 声明数据库的驱动
    String URL = "jdbc:mysql://localhost:3306/db_database17";// 声明数据库的URL
    String USERNAME = "root";// 声明数据库用户名
    String PASSWORD = "111";// 声明数据库中root用户对应的密码
}

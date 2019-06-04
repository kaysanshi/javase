package com.heima;
//数据库的操作jdbc的操作

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	public static void main(String[] args) {
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");//常用
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
			//建立连接
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String passWord="123";
			Connection conn=DriverManager.getConnection(url,user,passWord);
			//创建语句
			Statement st=conn.createStatement();
			//执行语句
			ResultSet rs=st.executeQuery("select*from stu");
			//处理结果
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接；
		}
	}

}

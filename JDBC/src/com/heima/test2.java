package com.heima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {
	public static void main(String[] args) {
		//创建数据库；
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//注册驱动三种方式
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
			//创建连接
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String password="123";
			conn=DriverManager.getConnection(url,user,password);
			//创建语句 预编译；
			st=conn.createStatement();
			//在此处要书写sql语句；
			String sql="select*from stu";
			//执行
			rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(st!=null){
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}

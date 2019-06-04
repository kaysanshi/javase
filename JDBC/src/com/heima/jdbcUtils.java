package com.heima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//工具类；只要用的时候进行调用就可以；
public final class jdbcUtils {
	private static String url="jdbc:mysql://localhost:3306/Student";
	private static String user="root";
	private static String passWord="123";
	private jdbcUtils(){
		
	}
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,passWord) ;
	}
	public static void free(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
			rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

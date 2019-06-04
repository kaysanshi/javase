package com.heima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//原始的数据单列模式操作；
public final class JdbcUtilsSing {
	private  String url="jdbc:mysql://localhost:3306/Student";
	private  String user="root";
	private  String passWord="123";
	
	private static JdbcUtilsSing instance=null;
	
	private JdbcUtilsSing(){
		
	}
	public static JdbcUtilsSing getInstance(){
		if(instance==null){
			synchronized (JdbcUtilsSing.class) {
				if(instance==null){
					instance=new JdbcUtilsSing();
				}
			}
		}
		return instance;
	}
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public   Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,passWord) ;
	}
	public  void free(ResultSet rs,Statement st,Connection conn){
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

package com.server.sql;
//这是对数据库的操作;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String url="jdbc:mysql://localhost:3306/Student?";
	String user="root";
	String password="123";
	public void close(){
		try {
			if(rs!=null){
			rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//查询如有的话直接换回结果集;
	public ResultSet queryExectue(String sql, String[] paras) {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			ps=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return rs;
	}

}

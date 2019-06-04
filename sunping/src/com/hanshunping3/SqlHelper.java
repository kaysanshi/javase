package com.hanshunping3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//写一个类用于专门对数据库的操作
//但是model层中必须让他 进行初始化;
public class SqlHelper {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//这些放到构造函数是好进行初始化
	public SqlHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String password="123";
			//得到连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//这里的操作是用来查询
	public ResultSet queryExcetion(String sql,String[]paras){
		try {
			ps=conn.prepareStatement(sql);
			//对参数赋值
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			//执行查询
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//这时不能关闭因为在查询的model层还要还回一个结果集
			//this.close();
		}
		//返回结果集
		return rs;
	}
	//进行增删改
	public boolean upExcetion(String sql,String[]paras){
		boolean b=false;
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return false;
		
	}
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}

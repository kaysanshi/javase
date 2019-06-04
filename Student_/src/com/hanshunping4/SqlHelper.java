package com.hanshunping4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	//定义数据库的知识
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;//类似于一个临时表，用来暂时存储数据库查询的结果集；
		//关闭数据库的方法;
		public void close(){
			try {
				if(rs!=null){
				rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//查询数据库操作
		public ResultSet queryExectue(String sql,String[] paras){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student?user=root&password=123";
				conn=DriverManager.getConnection(url);
				
				pst=conn.prepareStatement(sql);
				//给参数?赋值：
				for(int i=0;i<paras.length;i++){
					pst.setString(i+1, paras[i]);
				}
				rs=pst.executeQuery();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					//暂时不要关闭;
					//this.close();
				}
			return rs;
			
		}
		/*//查询数据库操作当时是为了初始化进行写的代码,
		public ResultSet queryExectue(String sql){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/Student?user=root&password=123";
				conn=DriverManager.getConnection(url);
				
				pst=conn.prepareStatement(sql);
				
				rs=pst.executeQuery();
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					//暂时不要关闭;
					//this.close();
				}
			return rs;
			
		}
	*/
		//增删改
		public boolean updExcetion(String sql,String[] paras){
			boolean b=true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student?user=root&password=123";
			conn=DriverManager.getConnection(url);
			
			pst=conn.prepareStatement(sql);
			//给参数?赋值：
			for(int i=0;i<paras.length;i++){
				pst.setString(i+1, paras[i]);
			}
			//执行Sql语句
			if(pst.executeUpdate()!=1){
				b=false;
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				this.close();
			}
		return false;
		}
}

package com.heima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {
	public static void main(String[] args) {
		//�������ݿ⣻
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//ע���������ַ�ʽ
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
			//��������
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String password="123";
			conn=DriverManager.getConnection(url,user,password);
			//������� Ԥ���룻
			st=conn.createStatement();
			//�ڴ˴�Ҫ��дsql��䣻
			String sql="select*from stu";
			//ִ��
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

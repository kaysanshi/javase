package com.hanshunping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 


/*
 * �����ݿ��ж�ȡ����
 */
public class test2 {	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//��������
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			String url="jdbc:mysql://localhost:3306/Student?user=root&password=123";
			conn=DriverManager.getConnection(url);
			stmt=conn.createStatement();
			//����Sql���
			rs=stmt.executeQuery("select*from stu");
			while(rs.next()){
				System.out.println(rs.getString("stuId"));
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					
					if(rs!=null){
					rs.close();
					}
					if(stmt!=null){
						stmt.close();
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

}

package com.heima;
//���ݿ�Ĳ���jdbc�Ĳ���

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	public static void main(String[] args) {
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");//����
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
			//��������
			String url="jdbc:mysql://localhost:3306/Student";
			String user="root";
			String passWord="123";
			Connection conn=DriverManager.getConnection(url,user,passWord);
			//�������
			Statement st=conn.createStatement();
			//ִ�����
			ResultSet rs=st.executeQuery("select*from stu");
			//������
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر����ӣ�
		}
	}

}

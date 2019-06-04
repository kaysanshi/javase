package com.heima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
//		create("name",new Date(),100);
		Date d=read(1);
		System.out.println(d);
	}
	static void create(String name,Date birthday,float money){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	try {
			//��������
		conn=jdbcUtils.getConnection();
			//�������
		
		//���@Ҫʹ���е�������ȡ���η���
		String sql="insert into time(name,birthday,money)values(?,?,?)";	
		
		ps= conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDate(2,new java.sql.Date(birthday.getTime() ));
		ps.setFloat(3, money);
		//ִ�����
		int i=ps.executeUpdate();
		System.out.println(i);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, ps, conn);	
		}
	}
	static Date read(int id){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Date birthday=null;
	try {
			//��������
		conn=jdbcUtils.getConnection();
			//�������
		st=conn.createStatement();
		//���@Ҫʹ���е�������ȡ���η���
		String sql="select birthday from time where id="+id;	
		//ִ�����
		//
		rs=st.executeQuery(sql);
		while(rs.next()){
			birthday=rs.getDate("birthday");
			//
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	return birthday;
	}
}

package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	public static void main(String[] args) {
		create();
		read();
//		delete();
//		update();
	}
	//�xȡ;
	static void read(){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//��������
		conn=jdbcUtils.getConnection();
			//�������
		st=conn.createStatement();
		//���@Ҫʹ���е�������ȡ���η���
		String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu";	
		//ִ�����
		//
		rs=st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getObject("stuId")+"\t"+
		rs.getObject("stuName")+"\t"+rs.getObject("stuSex")+"\t"
		+rs.getObject("stuAge")+"\t"+rs.getObject("stuDept"));
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	//���� ����
	static void create(){
			//ʹ�õĿ�����ΪJava.sql���е�
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		try {
				//��������
			conn=jdbcUtils.getConnection();
				//�������
			st=conn.createStatement();
			//���@Ҫʹ���е�������ȡ���η���
			String sql="insert into stu(stuId,stuName,stuSex,stuAge,stuDept)"
					+ "values('07','lihu','��',20,'���')";
			//ִ�������һ��intֵ����
			int i=st.executeUpdate(sql);
			//
			System.out.println(i);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, st, conn);	
			}
		}
	//�h��
	static void delete(){
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//��������
		conn=jdbcUtils.getConnection();
			//�������
		st=conn.createStatement();
		//���@Ҫʹ���е�������ȡ���η���
		String sql="delete from stu where stuAge<40";
		st.executeUpdate(sql);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	//����
	static void update(){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//��������,ʹ���Լ��ķ�װ�õ����;
		conn=jdbcUtils.getConnection();
			//�������
		st=conn.createStatement();
		//���@Ҫʹ���е�������ȡ���η���
		String sql="update  stu set stuAge=stuAge+10";
		st.executeUpdate(sql);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	
	
}

package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
	}
	static void read(){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//��������
			conn=jdbcUtils.getConnection();
			//����ģʽ�ĵ���
			conn=JdbcUtilsSing.getInstance().getConnection();
			//�������
			st=conn.createStatement();
			//
			String sql="select* from stu";
			//ִ�����
			rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+
			rs.getObject(2)+"\t"+rs.getObject(3)+"\t"
			+rs.getObject(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				jdbcUtils.free(rs, st, conn);
				//
				JdbcUtilsSing.getInstance().free(rs, st, conn);
		}
	}
}

package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.Current;
//PreparedStatement�� Statement �Ա�;
//sql��ע������;�������ݿ�Ƶ���ı���sql���;
public class Read {
	//�xȡ;
		static void read(String name){
			//ʹ�õĿ�����ΪJava.sql���е�
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		try {
				//��������
			conn=jdbcUtils.getConnection();
			long start=System.currentTimeMillis();
				//�������
			st=conn.createStatement();
			//���@Ҫʹ���е�������ȡ���η���
			String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu where stuName = '"+name+"'";	
			//ִ�����
			//
			rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getObject("stuId")+"\t"+
			rs.getObject("stuName")+"\t"+rs.getObject("stuSex")+"\t"
			+rs.getObject("stuAge")+"\t"+rs.getObject("stuDept"));
			}
			long endtime=System.currentTimeMillis();
			System.out.println(endtime-start);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, st, conn);	
			}
		}
		public static void main(String[] args) {
			read("��");
//			//��ѯ���е�ʱ��:1Ϊ��,0Ϊ��;
//			read("'or 1 or'");
		}
}

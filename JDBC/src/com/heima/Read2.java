package com.heima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//PreparedStatement�� Statement �Ա�;
//Ԥ����ķ�ʽ���ǽ��sqlע������;һ��Ч�ʻ��;
//��������,���ӵ������;
public class Read2 {
	
	static void read(String name){
		//ʹ�õĿ�����ΪJava.sql���е�
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	try {
			//��������
		conn=jdbcUtils.getConnection();
		long start=System.currentTimeMillis();
			//�������
		//���@Ҫʹ���е�������ȡ���η���
		String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu where stuName = ?";	
		//Ԥ����ķ�ʽ;
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);//����ĳһ��ֵ;
		//ִ�����
		//
		rs=ps.executeQuery();
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
		jdbcUtils.free(rs, ps, conn);	
		}
	}
	public static void main(String[] args) {
//		read("��");
//		?????//��ѯ���е�ʱ��:1Ϊ��,0Ϊ��;
		read("'or 1 or'");
	}
}

package com.zcib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//���ݿ�����еĲ������������
public class SqlHelp {
	/*
	 * ���ݿ�Ĳ���:
	 * 1.��ѯ
	 * 2.��ɾ��
	 * 3.��ȡ��Ϣ�б�Ȼ��ת��Ϊlist�����ú���Ĳ�����Щ;
	 */
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String url="jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//�ر����ݿ�ķ���;
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
			//��ѯ���ݿ����
			public ResultSet queryExectue(String sql,String[] paras){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection(url,"root","123");
					pst=conn.prepareStatement(sql);
					//������?��ֵ��
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
						throw new RuntimeException(e1.getMessage(),e1);
					}finally{
						//��ʱ��Ҫ�ر�;�رջᵼ�²�ѯ�������;
						//this.close();
					}
				return rs;
				
			}
			//��ɾ��
			public boolean updExcetion(String sql,String[] paras){
				boolean b=true;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url,"root","123");
				
				pst=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				//������?��ֵ��
				for(int i=0;i<paras.length;i++){
					pst.setString(i+1, paras[i]);
				}
				//ִ��Sql���
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
			return b;
			}
			/*
			 * ��һ��ResultSet����ת��Ϊһ��List����list�з���Map<String,Object>����;
			 */
			@SuppressWarnings("unused")
			public  List RSToList(ResultSet rs) throws SQLException{
				List  list = new ArrayList();
				ResultSetMetaData rsmd = rs.getMetaData();//��ȡ��ṹ
				int columncount=rsmd.getColumnCount();
				//����������¼
				while(rs.next()){
					//����map����;
					Map map =  (Map) new HashMap();
					for(int i=1;i<=columncount;i++){
						//����ֶ�����rsmd.getColumnName(i)��Ϊkey����Ӧ��ֵΪvalue
						 map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
					}
					list.add(map);//����һ����¼��ӵ�list��
				}
				return list;
			}

}

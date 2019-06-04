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
//数据库的所有的操作都在这个类
public class SqlHelp {
	/*
	 * 数据库的操作:
	 * 1.查询
	 * 2.增删改
	 * 3.读取信息列表然后转化为list集合让后序的操作这些;
	 */
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String url="jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
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
					conn=DriverManager.getConnection(url,"root","123");
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
						throw new RuntimeException(e1.getMessage(),e1);
					}finally{
						//暂时不要关闭;关闭会导致查询结果错误;
						//this.close();
					}
				return rs;
				
			}
			//增删改
			public boolean updExcetion(String sql,String[] paras){
				boolean b=true;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url,"root","123");
				
				pst=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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
			return b;
			}
			/*
			 * 将一个ResultSet对象转换为一个List对象list中放入Map<String,Object>对象;
			 */
			@SuppressWarnings("unused")
			public  List RSToList(ResultSet rs) throws SQLException{
				List  list = new ArrayList();
				ResultSetMetaData rsmd = rs.getMetaData();//获取表结构
				int columncount=rsmd.getColumnCount();
				//逐条读出记录
				while(rs.next()){
					//创建map对象;
					Map map =  (Map) new HashMap();
					for(int i=1;i<=columncount;i++){
						//表的字段名（rsmd.getColumnName(i)）为key，对应的值为value
						 map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
					}
					list.add(map);//将这一条记录添加到list中
				}
				return list;
			}

}

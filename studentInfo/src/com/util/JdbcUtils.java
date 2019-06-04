package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用来操作数据库的类
public class JdbcUtils {
	//定义需要的对象
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/students";
	String user="root";
	String passwd="123";
	int sum=0;
	//构造函数，初始化
	public JdbcUtils(){
		try {
			//加载驱动
			Class.forName(driver);
			//得到连接
			con=DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询获取及结果[]params，通过?赋值方式可以防止漏洞注入方式，保证安全性
	public ResultSet queryExecute(String sql,String []params){
		try {
			ps=con.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=0;i<params.length;i++){
				ps.setString(i+1, params[i]);
			}
			//执行查询
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			throw new RuntimeException(e.getMessage(),e);
		}
		//返回结果集
		return rs;
	}
	/*
	 * 将一个ResultSet对象转换为一个List<Map<String,Object>>对象
	 */
	public static List<Map<String,Object>> RSToList(ResultSet rs) throws SQLException{
		List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
		ResultSetMetaData rsmd = rs.getMetaData();//获取表结构
		//逐条读出记录
		while(rs.next()){
			//创建一个Map对象
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				//表的字段名（rsmd.getColumnName(i)）为key，对应的值为value
				map.put(rsmd.getColumnName(i).toLowerCase(),rs.getObject(i));
			}
			list.add(map);//将这一条记录添加到list中
		}
		return list;
	}
	//获取操作的结果的个数
	public int queryExecute(String sql){
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if(rs.next()){
				sum=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//返回结果集
		return sum;
	}
	//增加删除修改操作
	public boolean savegrade(String sql,String []params){
		boolean b=true;
		try {
			ps=con.prepareStatement(sql);
			//对sql的参数赋值
			for(int i=1;i<params.length;i++){
				ps.setString(i, params[i]);
			}
			//执行查询
			if(ps.executeUpdate()!=1){
				b=false;
			}
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		//返回结果集
		return b;
		
	}
	//关闭资源的方法
	public void close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}


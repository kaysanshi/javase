package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//这是让所有的数据模型来操作的数据库模型,
//数据库模型专门用来操作数据库的类
public class SqlHelper {
	//定义需要的对象
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sum=0;//记录条数;
		//初始化操作;
	public SqlHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Restaurant?";
			String user="root";
			String passwd="123";
			
			//得到连接
			con=DriverManager.getConnection(url,user,passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	///进行查询的操作;返回了一个结果集rs;
	//[]params，通过?赋值方式可以防止漏洞注入方式，保证安全性
		public ResultSet queryExecute(String sql,String []params){
			try {
				ps=con.prepareStatement(sql);
				//对sql的参数赋值
				for(int i=0;i<params.length;i++)
				{
					ps.setString(i+1, params[i]);
				}
				//执行查询
				rs=ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			//返回结果集
			return rs;
		}
		//查询条数实际上是在又下角显示的操作记录
		public int queryExecute(String sql)
		{
			try {
				ps=con.prepareStatement(sql);
				//返回一个结果集
				rs=ps.executeQuery();
				if(rs.next())
				{
					sum=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			//返回结果集
			return sum;
		}
		//更新增删改的操作
		public boolean updateExecete(String sql,String []params)
		{
			boolean b=true;
			try {
				ps=con.prepareStatement(sql);
				//对sql的参数赋值
				for(int i=0;i<params.length;i++)
				{
					ps.setString(i+1, params[i]);
				}
				//执行查询不返回任何结果集时使用这个语句
				if(ps.executeUpdate()!=1)
				{
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
		public void close()
		{
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

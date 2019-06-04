//package com.mhl.db;
//import java.sql.*;
//public class SqlHelper {
//	Connection con=null;
//	PreparedStatement ps=null;
//	ResultSet rs=null;
//	public SqlHelper()
//	{
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=restaurant","sa","");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	public ResultSet query(String sql,String []params)
//	{
//	try {
//			ps=con.prepareStatement(sql);
//		
//			for(int i=0;i<params.length;i++)
//			{
//			ps.setString(i+1, params[i]);
//			}
//			rs=ps.executeQuery();
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//	return rs;
//	}
//	public void close()
//	{
//	try{
//	if(rs!=null)
//	{
//	rs.close();
//	}
//	if(ps!=null)
//	{
//		ps.close();
//	}
//	if(con!=null)
//	{
//		con.close();
//	}
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//	}
//	}
//}
/*
 * 对数据库操作的类
 * 对数据库的操作，就是crud
 * 调用存储过程
 * 
 *注意：如果连接数据库时出现如下异常则表示未引入三个JAR驱动包，另外一个原因就是SQL语句有语法错误
 *java.lang.ClassNotFoundException: com.microsoft.jdbc.sqlserver.SQLServerDviver
 * */
package com.mhl.db;
import java.util.*;
import java.sql.*;
public class SqlHelper {
	//定义需要的对象
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=restaurant";
	String user="sa";
	String passwd="";
	int sum=0;
	//构造函数，初始化ct
	public SqlHelper()
	{
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
	//[]params，通过?赋值方式可以防止漏洞注入方式，保证安全性
	public ResultSet queryExecute(String sql,String []params)
	{
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
	public int queryExecute(String sql)
	{
		try {
			ps=con.prepareStatement(sql);
			
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
			//执行查询
			if(ps.executeUpdate()!=1)
			{
				b=false;
			}
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
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

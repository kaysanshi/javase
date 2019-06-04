package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo1 {
	public static void main(String[] args){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try{
			//1.注册数据库驱动
			//--由于mysql在Driver类的实现中自己注册了一次,而我们又注册了一次,于是会导致MySql驱动被注册两次
			//--创建MySql的Driver对象时,导致了程序和具体的Mysql驱动绑死在了一起,在切换数据库时需要改动java代码
			//DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql:///blob?user=root&password=123");
			//3.获取传输器对象
			stat = conn.createStatement();
			//4.利用传输器传输sql语句到数据库中执行,获取结果集对象
			rs = stat.executeQuery("select * from account");
			//5.遍历结果集获取查询结果
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					stat = null;
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					conn = null;
				}
			}
		}
	}
}

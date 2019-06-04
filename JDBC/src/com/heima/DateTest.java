package com.heima;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
//		create("name",new Date(),100);
		Date d=read(1);
		System.out.println(d);
	}
	static void create(String name,Date birthday,float money){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	try {
			//创建连接
		conn=jdbcUtils.getConnection();
			//创建语句
		
		//在這要使用列的名來拿取簡單方便
		String sql="insert into time(name,birthday,money)values(?,?,?)";	
		
		ps= conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDate(2,new java.sql.Date(birthday.getTime() ));
		ps.setFloat(3, money);
		//执行语句
		int i=ps.executeUpdate();
		System.out.println(i);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, ps, conn);	
		}
	}
	static Date read(int id){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Date birthday=null;
	try {
			//创建连接
		conn=jdbcUtils.getConnection();
			//创建语句
		st=conn.createStatement();
		//在這要使用列的名來拿取簡單方便
		String sql="select birthday from time where id="+id;	
		//执行语句
		//
		rs=st.executeQuery(sql);
		while(rs.next()){
			birthday=rs.getDate("birthday");
			//
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	return birthday;
	}
}

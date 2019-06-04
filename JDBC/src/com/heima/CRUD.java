package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	public static void main(String[] args) {
		create();
		read();
//		delete();
//		update();
	}
	//讀取;
	static void read(){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//创建连接
		conn=jdbcUtils.getConnection();
			//创建语句
		st=conn.createStatement();
		//在這要使用列的名來拿取簡單方便
		String sql="select stuId,stuName,stuSex,stuAge,stuDept from stu";	
		//执行语句
		//
		rs=st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getObject("stuId")+"\t"+
		rs.getObject("stuName")+"\t"+rs.getObject("stuSex")+"\t"
		+rs.getObject("stuAge")+"\t"+rs.getObject("stuDept"));
		}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	//創建 插入
	static void create(){
			//使用的库类型为Java.sql包中的
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
		try {
				//创建连接
			conn=jdbcUtils.getConnection();
				//创建语句
			st=conn.createStatement();
			//在這要使用列的名來拿取簡單方便
			String sql="insert into stu(stuId,stuName,stuSex,stuAge,stuDept)"
					+ "values('07','lihu','男',20,'序好')";
			//执行语句是一個int值更新
			int i=st.executeUpdate(sql);
			//
			System.out.println(i);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.free(rs, st, conn);	
			}
		}
	//刪除
	static void delete(){
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//创建连接
		conn=jdbcUtils.getConnection();
			//创建语句
		st=conn.createStatement();
		//在這要使用列的名來拿取簡單方便
		String sql="delete from stu where stuAge<40";
		st.executeUpdate(sql);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	//更新
	static void update(){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
	try {
			//创建连接,使用自己的封装好的类库;
		conn=jdbcUtils.getConnection();
			//创建语句
		st=conn.createStatement();
		//在這要使用列的名來拿取簡單方便
		String sql="update  stu set stuAge=stuAge+10";
		st.executeUpdate(sql);
	} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		jdbcUtils.free(rs, st, conn);	
		}
	}
	
	
}

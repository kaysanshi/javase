package com.heima;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
	}
	static void read(){
		//使用的库类型为Java.sql包中的
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//创建连接
			conn=jdbcUtils.getConnection();
			//单列模式的调用
			conn=JdbcUtilsSing.getInstance().getConnection();
			//创建语句
			st=conn.createStatement();
			//
			String sql="select* from stu";
			//执行语句
			rs=st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+
			rs.getObject(2)+"\t"+rs.getObject(3)+"\t"
			+rs.getObject(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				jdbcUtils.free(rs, st, conn);
				//
				JdbcUtilsSing.getInstance().free(rs, st, conn);
		}
	}
}

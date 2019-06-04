package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itheima.util.JDBCUtils;

public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from user where name=? and password=?");
			ps.setString(1, "zs");
			ps.setString(2, "999");
			
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("email"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}

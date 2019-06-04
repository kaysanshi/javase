package com.mingribook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mingribook.db.DbTools;
import com.mingribook.util.Users;

public class UserDao {
	public List<Users> selectAll() {
		String sql = "select * from tb_login";
		DbTools db = new DbTools();
		Connection conn = db.getConn();
		List<Users> ls=new ArrayList<Users>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				if(rs.getInt(4)!=1){
					Users us = new Users();
					us.setId(rs.getInt(1));
					us.setUsername(rs.getString(2));
					us.setPassword(rs.getString(3));
					us.setPopedom(rs.getString(4));
					ls.add(us);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
	public int loginuser(String name, String pwd) {
		String sql = "select popedom from tb_login where username='" + name
				+ "' and password='" + pwd+"'";
		DbTools db = new DbTools();
		Connection conn = db.getConn();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()){
				if (rs.getInt(1) == 1) {
					return 1;
				} else {
					return 2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}
	public void addUser(String name,String pwd){
		String sql="insert into tb_login (username,password)values('"+name+"','"+pwd+"')";
		DbTools db = new DbTools();
		Connection conn = db.getConn();
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(int id){
		String sql="delete from tb_login where id="+id;
		DbTools db=new DbTools();
		Connection conn=db.getConn();
		ResultSet rs=null;
		try {
			Statement st=conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

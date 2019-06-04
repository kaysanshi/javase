package com.zcib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.zcib.domain.User;
import com.zcib.util.JDBCUtils;

public class UserDao {
	
	/*根据用户名查找数据库
	 * 查找成功，则返回User对象
	 * 查找失败，抛出异常
	 */
	public User find(String username){
		
			String sql = "select * from tb_user where username=?";
			List<Map<String,Object>> list = JDBCUtils.find(sql, username);
			User user = null;
			if(list.size()>0){
				user = new User();
				Map map = list.get(0);
				user.setId((Integer) map.get("id"));
				user.setUsername(map.get("username").toString());
				user.setPassword(map.get("password").toString());
				//....
			}
			return user;
			
	}
	
	/*
	 * 将User中的数据写入数据库，注册成功
	 */
	public void insert(User user){
		
		String sql = "insert into tb_user(username,password,birthday,email,isenable) values(?,?,?,?,?)";
		Object params[]={
				user.getUsername(),user.getPassword(),
				new java.sql.Date(user.getBirthday().getTime()),
				user.getEmail(),user.getIsenable(),
		};
		Object key = JDBCUtils.insert(sql,params);
		user.setId(Integer.parseInt(key.toString()));
	}
}

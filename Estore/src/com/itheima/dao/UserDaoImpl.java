package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;

public class UserDaoImpl implements UserDao{

	@Override
	public Object findUserByName(String username) {
		// TODO Auto-generated method stub
		String sql="select *from user where username=?";
		QueryRunner runner=new QueryRunner();
		try {
			return runner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		 
	}

	@Override
	public void addUSer(User user) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,?,?,?,?,?,?,?,null)";
		QueryRunner runner=new QueryRunner();
		try {
			 runner.update(sql, user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getRole(),user.getState(),user.getActivecode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}

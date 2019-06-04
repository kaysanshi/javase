package cn.test.memo.dao.impl;

import java.util.List;

import cn.test.memo.dao.UserDao;
import cn.test.memo.entity.User;
import cn.test.memo.util.BeanHandler;
import cn.test.memo.util.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User find(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user where username=? and password=?";
		List<User> list = JdbcUtil.query(sql, new BeanHandler<User>(User.class), username, password);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}
	
	@Override
	public User find(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from user where username=?";
		List<User> list = JdbcUtil.query(sql, new BeanHandler<User>(User.class), username);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user (nick, username, password, last_login_time, last_login_ip) values (?,?,?,?,?)";
		return JdbcUtil.update(sql, user.getNick(), user.getUsername(), user.getPassword(), user.getLast_login_time(), user.getLast_login_ip());
	}

	@Override
	public int updatepwd(User user, String newpwd) {
		// TODO Auto-generated method stub
		String sql = "update user set password=? where id=?";
		return JdbcUtil.update(sql, newpwd, user.getId());
	}

	@Override
	public int updatelogin(String last_login_time, String last_login_ip, int id) {
		// TODO Auto-generated method stub
		String sql = "update user set last_login_time=?,last_login_ip=? where id=?";
		return JdbcUtil.update(sql, last_login_time, last_login_ip, id);
	}

}

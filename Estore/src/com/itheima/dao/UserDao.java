package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * 查看用户名是否重复
	 * @param username
	 * @return
	 */
	Object findUserByName(String username);
	/**
	 * 添加用户
	 * @param user
	 */
	void addUSer(User user);

}

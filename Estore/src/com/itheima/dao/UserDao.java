package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * �鿴�û����Ƿ��ظ�
	 * @param username
	 * @return
	 */
	Object findUserByName(String username);
	/**
	 * ����û�
	 * @param user
	 */
	void addUSer(User user);

}

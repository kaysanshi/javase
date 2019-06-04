package cn.test.memo.dao;

import cn.test.memo.entity.User;

public interface UserDao {
	public User find(String username, String password);
	public User find(String username);
	public int add(User user);
	public int updatepwd(User user, String newpwd);
	public int updatelogin(String last_login_time, String last_login_ip, int id);
}

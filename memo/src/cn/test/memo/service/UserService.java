package cn.test.memo.service;

import java.util.Date;

import cn.test.memo.dao.UserDao;
import cn.test.memo.dao.impl.UserDaoImpl;
import cn.test.memo.entity.User;
import cn.test.memo.util.DateUtil;
import cn.test.memo.util.StringUtil;

public class UserService {
	private UserDao userDao;
	
	public UserService() {
		this.userDao = new UserDaoImpl();
	}
	
	public void updatalogin(User user, String last_login_ip) {
		userDao.updatelogin(DateUtil.udateTostrdatetime(new Date()), last_login_ip, user.getId());
	}
	
	public User login(String username, String password) {
		return userDao.find(username, StringUtil.stringToMD5(password));
	}
	
	public boolean checkUsername(String username) {
		User user = userDao.find(username);
		if (user == null)
			return true;
		return false;
	}
	
	public boolean add(User user) {
		user.setPassword(StringUtil.stringToMD5(user.getPassword()));
		user.setLast_login_time(DateUtil.udateTostrdatetime(new Date()));
		int res = userDao.add(user);
		if (res == 0)
			return false;
		return true;
	}
	
	public boolean updatepwd(User user, String newpwd) {
		newpwd = (StringUtil.stringToMD5(newpwd));
		int res = userDao.updatepwd(user, newpwd);
		if (res == 0)
			return false;
		return true;
	}
}

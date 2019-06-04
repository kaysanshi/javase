package com.zcib.service;

import com.zcib.dao.UserDao;
import com.zcib.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	/*
	 * 通过用户名和密码查询user对象，返回User
	 */
	public User validate(String username,String password) throws UserException {
		
		User user = userDao.find(username);
		if(user==null){
			throw new UserException("用户不存在！");
		}
		if(!user.getPassword().equals(password))
		{
			throw new UserException("密码错误！");
   		}
		return user;
	}
	
	public void validateUserName(String username) throws UserException{
		User user = userDao.find(username);
		if(user != null){
			throw new UserException("用户名已存在！");
		}else{
			throw new UserException("恭喜，用户名可用！");
		}
	}
	
	/*
	 * 注册新用户
	 * 调用UserDao中的insert方法，将数据存入数据库中
	 * 注册成功，返回User对象
	 * 不成功，返回空
	 */
	public void regist(User user) throws UserException{
		User cUser = userDao.find(user.getUsername());
		if(cUser != null)
			throw new UserException("用户名已占用！");
		//还可以查询email是否已使用
		userDao.insert(user);
	}
}

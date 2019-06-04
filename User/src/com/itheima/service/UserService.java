package com.itheima.service;

import com.itheima.dao.XmlUserdao;
import com.itheima.domain.User;
import com.ithiema.exception.MsgException;

public class UserService {
	private XmlUserdao dao = new XmlUserdao();
	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException{
		//1.检查用户名是否已经存在,如果已经存在则提示
		if(dao.findUser(user.getUsername())!=null){
			throw new MsgException("用户名已经存在!");
		}
		//2.如果不存在则调用dao中的方法添加用户
		dao.addUser(user);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUser(username, password);
	}
	
}

package com.itheima.service;

import com.itheima.dao.XmlUserdao;
import com.itheima.domain.User;
import com.ithiema.exception.MsgException;

public class UserService {
	private XmlUserdao dao = new XmlUserdao();
	/**
	 * ����û�
	 * @param user
	 * @throws MsgException 
	 */
	public void registUser(User user) throws MsgException{
		//1.����û����Ƿ��Ѿ�����,����Ѿ���������ʾ
		if(dao.findUser(user.getUsername())!=null){
			throw new MsgException("�û����Ѿ�����!");
		}
		//2.��������������dao�еķ�������û�
		dao.addUser(user);
	}
	
	/**
	 * ����û��������Ƿ���ȷ
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUser(username, password);
	}
	
}

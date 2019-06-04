package com.itheima.test;

import com.itheima.dao.XmlUserdao;
import com.itheima.domain.User;

public class XmlUserDaoTest {
	public void testFindUserByUserName(){
		XmlUserdao dao = new XmlUserdao();
		User user = dao.findUser("adminxxx");
		System.out.println(user);
	}
	

	public void testFindUserByNMandPSW(){
		XmlUserdao dao = new XmlUserdao();
		User user = dao.findUser("admin", "adminxx");
		System.out.println(user);
	}
	
	public void testAddUser(){
		XmlUserdao dao = new XmlUserdao();
		User user = new User();
		user.setUsername("ÆÓÇ¬");
		user.setPassward("123");
		user.setNickname("Ð¡ÆÓÆÓ");
		user.setEmail("piaoqian@itcast.cn");
		dao.addUser(user);
	}
}

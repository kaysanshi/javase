package com.itheima.service;

import java.util.UUID;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.factory.BasicFactory;
import com.itheima.util.DaoUtils;

public class UserServiceImpl implements UserService {
	private UserDao dao=BasicFactory.getFactory().getInstance(UserDao.class);
	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		//�����û����Ƿ����
		if (dao.findUserByName(user.getUsername())!=null) {
			throw new RuntimeException("�û����Ѵ���");
		}
		//2.����dao�еķ���
		user.setRole("user");
		user.setState(0);
		user.setActivecode(UUID.randomUUID().toString());
		dao.addUSer(user);
		
		//3.���ͼ����ʼ�
	}

}

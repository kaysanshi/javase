package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.AddminDao;
import com.zcib.domain.Addmin;

/**
 * 管理员业务逻辑层
 * @author 555
 *@date 2018年5月8日
 */
public class AddminService {
	private AddminDao dao=new AddminDao();
	/*
	 * 核对用户	
	 */
	public Addmin cherckuser(String username, String password) {
		// TODO Auto-generated method stub
		return dao.cherUser(username,password);
	}
	/**
	 * 注册用户
	 * @param addmin
	 * @return
	 */
	public boolean registAddmin(Addmin addmin) {
		// TODO Auto-generated method stub
		return dao.registAddmin(addmin);
	}
	/**
	 * 获得个人信息
	 * @param addmin
	 * @return
	 */
	public List<Map<String, Object>> getAddminInfoById(Addmin addmin) {
		// TODO Auto-generated method stub
		return dao.getAddminInfoById(addmin);
	}
	/**
	 * 修改个人信息
	 * @param addmin
	 * @return
	 */
	public int updeteAddmin(Addmin addmin) {
		// TODO Auto-generated method stub
		return dao.updateAddmin(addmin);
	}
	

}

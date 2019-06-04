package com.mingribook;

import java.util.Vector;
public class UserInforList {
	private static UserInforList user=new  UserInforList();
	private Vector  vector=null;
	/*
	 * 利用private调用构造函数防止被外界产生新的instance对象
	 */
	public UserInforList () {
		this.vector=new Vector<>();
	}
	/*
	 * 增加用户
	 */
	public boolean addUserInfo(String user){
		if(user!=null){
			this.vector.add(user);
			return true;
		}else{
		
		return false;
		}
	}
	/*
	 * 获取用户的列表
	 */
	public Vector getList(){
		return vector;
	}
	/*
	 * 移除用户
	 */
	public void remove(String user){
		if(user!=null){
			vector.removeElement(user);
		}
	}
	public static UserInforList getInstance() {
		// TODO Auto-generated method stub
		return user;
	}
}

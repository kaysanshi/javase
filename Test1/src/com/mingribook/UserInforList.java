package com.mingribook;

import java.util.Vector;
public class UserInforList {
	private static UserInforList user=new  UserInforList();
	private Vector  vector=null;
	/*
	 * ����private���ù��캯����ֹ���������µ�instance����
	 */
	public UserInforList () {
		this.vector=new Vector<>();
	}
	/*
	 * �����û�
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
	 * ��ȡ�û����б�
	 */
	public Vector getList(){
		return vector;
	}
	/*
	 * �Ƴ��û�
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

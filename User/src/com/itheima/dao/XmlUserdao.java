package com.itheima.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.itheima.domain.User;

import com.itheima.util.XmlDaoUtils;


public class XmlUserdao {
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User findUser(String username){
		Document document=XmlDaoUtils.getDom();
		Element root=document.getRootElement();
		//����xpath���ʽ����xml��ѡ��ڵ�Ϊusername���û���Ԫ��
		List list=root.selectNodes("//users[@username='"+username+"']");
		if (list.size()>0) {
			
			Element userEle= (Element) list.get(0);
			//����ȡ��Ԫ�����õ�javabean��
			User user=new User();
			user.setUsername(userEle.attributeValue("username"));
			user.setPassward(userEle.attributeValue("passward"));
			user.setNickname(userEle.attributeValue("nickname"));
			user.setEmail(userEle.attributeValue("email"));
			return user;
		}
		
		return null;
		
	}
	/**
	 * �����û�
	 * @param user
	 */
	public void addUser(User user){
		//������user��ǩ����Ԫ�أ����������ԣ�
		Document document=XmlDaoUtils.getDom();
		Element root=document.getRootElement();
		Element userEle=DocumentHelper.createElement("users");
		userEle.setAttributeValue("username", user.getUsername());
		userEle.setAttributeValue("passsward", user.getPassward());
		userEle.setAttributeValue("nickname", user.getNickname());
		userEle.setAttributeValue("email", user.getEmail());
		//���ص�<user>Ԫ����
		
		
		//��д��xml�ļ�
		
	}
	/**
	 * �ҵ��û�ͨ������
	 * @param name �û���
	 * @param passward
	 */
	
	public User findUser(String name,String passward){
		Document document=XmlDaoUtils.getDom();
		Element root=document.getRootElement();
		//����xpath���ʽ����xml��ѡ��ڵ�Ϊusername���û�������������ڴ����Ԫ��
		List list=root.selectNodes("//users[@username='"+name+"'and @passward'"+passward+"']");
		if (list.size()>0) {
			
			Element userEle= (Element) list.get(0);
			//����ȡ��Ԫ�����õ�javabean��
			User user=new User();
			user.setUsername(userEle.attributeValue("username"));
			user.setPassward(userEle.attributeValue("passward"));
			user.setNickname(userEle.attributeValue("nickname"));
			user.setEmail(userEle.attributeValue("email"));
			return user;
		}
		
		return null;
	}

}

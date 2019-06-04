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
		//利用xpath表达式，在xml中选择节点为username的用户名元素
		List list=root.selectNodes("//users[@username='"+username+"']");
		if (list.size()>0) {
			
			Element userEle= (Element) list.get(0);
			//将获取的元素设置到javabean中
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
	 * 增加用户
	 * @param user
	 */
	public void addUser(User user){
		//就是在user标签创建元素，并设置属性；
		Document document=XmlDaoUtils.getDom();
		Element root=document.getRootElement();
		Element userEle=DocumentHelper.createElement("users");
		userEle.setAttributeValue("username", user.getUsername());
		userEle.setAttributeValue("passsward", user.getPassward());
		userEle.setAttributeValue("nickname", user.getNickname());
		userEle.setAttributeValue("email", user.getEmail());
		//挂载到<user>元素上
		
		
		//回写到xml文件
		
	}
	/**
	 * 找到用户通过密码
	 * @param name 用户名
	 * @param passward
	 */
	
	public User findUser(String name,String passward){
		Document document=XmlDaoUtils.getDom();
		Element root=document.getRootElement();
		//利用xpath表达式，在xml中选择节点为username的用户名并且密码等于传入的元素
		List list=root.selectNodes("//users[@username='"+name+"'and @passward'"+passward+"']");
		if (list.size()>0) {
			
			Element userEle= (Element) list.get(0);
			//将获取的元素设置到javabean中
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

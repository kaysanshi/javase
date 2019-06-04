package com.qq.client.tools;
///管理用户聊天的界面的

import java.util.HashMap;

import com.qq.client.view.QQChat;

public class ManageQQChat {
	//
	private static HashMap<String,QQChat> hm=new HashMap<String,QQChat>();
	//加入
	public static void addQQChat(String userIDfriendID,QQChat chat){
		hm.put(userIDfriendID, chat);
	}
	//取出;
	public static QQChat getQQChat(String userIDfriendID){
		
		return(QQChat) hm.get(userIDfriendID);
		
	}

}

package com.qq.client.tools;
///�����û�����Ľ����

import java.util.HashMap;

import com.qq.client.view.QQChat;

public class ManageQQChat {
	//
	private static HashMap<String,QQChat> hm=new HashMap<String,QQChat>();
	//����
	public static void addQQChat(String userIDfriendID,QQChat chat){
		hm.put(userIDfriendID, chat);
	}
	//ȡ��;
	public static QQChat getQQChat(String userIDfriendID){
		
		return(QQChat) hm.get(userIDfriendID);
		
	}

}

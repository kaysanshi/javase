package com.server.model;
import java.util.HashMap;
//这是对客户端线程的管理的类
public class ManageQQClientTh {
	
	public static HashMap< String, ServerConnectClient> hm=new HashMap<>();
	//向hm中添加一个客户端通讯线程;
	public static void addClientThread(String userId,ServerConnectClient sct) {
		hm.put(userId, sct);
	}
	public static ServerConnectClient getClientThread(String userId) {
		return (ServerConnectClient)hm.get(userId);
	}
}

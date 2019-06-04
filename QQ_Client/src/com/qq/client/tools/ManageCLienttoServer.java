package com.qq.client.tools;
//管理客户端与服务器保持通讯的类;

import java.util.HashMap;

public class ManageCLienttoServer {
	
	private static HashMap<String, ClientConServerTh> hm=new HashMap<>();
	//把创建好的ClientConServerTh线程放入到这里
	public static void addClientConServerTh(String userId,ClientConServerTh ccst){
		hm.put(userId, ccst);
	}
	public static ClientConServerTh getClientConServerTh(String userId){
		return (ClientConServerTh)hm.get(userId);
	}
	

}

package com.server.model;
import java.util.HashMap;
//���ǶԿͻ����̵߳Ĺ������
public class ManageQQClientTh {
	
	public static HashMap< String, ServerConnectClient> hm=new HashMap<>();
	//��hm�����һ���ͻ���ͨѶ�߳�;
	public static void addClientThread(String userId,ServerConnectClient sct) {
		hm.put(userId, sct);
	}
	public static ServerConnectClient getClientThread(String userId) {
		return (ServerConnectClient)hm.get(userId);
	}
}

package com.qq.client.tools;
//����ͻ��������������ͨѶ����;

import java.util.HashMap;

public class ManageCLienttoServer {
	
	private static HashMap<String, ClientConServerTh> hm=new HashMap<>();
	//�Ѵ����õ�ClientConServerTh�̷߳��뵽����
	public static void addClientConServerTh(String userId,ClientConServerTh ccst){
		hm.put(userId, ccst);
	}
	public static ClientConServerTh getClientConServerTh(String userId){
		return (ClientConServerTh)hm.get(userId);
	}
	

}

/*
 * Tcp������ƻ���:
 */
package com.mingribook;
//��ȡ����ip��ַ:
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Adress {
	
	public static void main(String[] args) {
		InetAddress ip;//���� 
		try {
			ip=InetAddress.getLocalHost();//ʵ����
			String localname=ip.getHostName();
			String localip=ip.getHostAddress();
			System.out.println("������:"+localname);
			System.out.println("����ip:"+localip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

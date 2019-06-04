/*
 * Tcp程序设计基础:
 */
package com.mingribook;
//获取本机ip地址:
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Adress {
	
	public static void main(String[] args) {
		InetAddress ip;//声明 
		try {
			ip=InetAddress.getLocalHost();//实例化
			String localname=ip.getHostName();
			String localip=ip.getHostAddress();
			System.out.println("本机名:"+localname);
			System.out.println("本机ip:"+localip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

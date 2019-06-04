package com.hanshunping1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//序列化传输机制;
public class MyClients {
	
	public MyClients() {
		// TODO Auto-generated constructor stub
	try {
		Socket socket=new Socket("192.168.1.111", 3033);
		//
		System.out.println("kaishi ");
		//通过objectoutput流来进行传递对象;
		ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
		User user=new User();
		user.setName("456");
		user.setPass("123");
		oos.writeObject(user);
		socket.close();///不关闭时不会显示 ,然后出错
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public static void main(String[] args) {
		new MyClients();
	}

}

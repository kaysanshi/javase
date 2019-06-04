package com.hanshunping1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	ServerSocket s;
	public Myserver() {
		// TODO Auto-generated constructor stub
		
		try {
			s = new ServerSocket(3033);
			System.out.println("等待连接");
			Socket socket=s.accept();
			//一对象流的形式读取
			ObjectInputStream ois1=new ObjectInputStream(socket.getInputStream());
			User user=(User)ois1.readObject();
			System.out.println("从客户端的接收的"+user.getName()+";"+user.getPass());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		new Myserver();
	}
}

package com.server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.qq.common.Message;
//某个客户端连接服务器的通讯线程类
public class ServerConnectClient  extends Thread{
	
	Socket s;
	 public ServerConnectClient(Socket s) {
		//把服务器与客户端的链接给s;
		 this.s=s;
	}
	@Override
	public void run() {
			// TODO Auto-generated method stub
		while (true) {
			//让改线程可以接受到客户端的信息;
			try {
//				Thread.sleep(2000);
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message message=(Message) ois.readObject();
			System.out.println(message.getSender()+"给"+message.getGetter()+"说"+message.getCon());
			//这里进行转发;
			/*
			 * 转发时出现错误;???????????已解决;
			 */
			//取得接收人的通讯线程;
			ServerConnectClient scClient=ManageQQClientTh.getClientThread(message.getGetter());
			ObjectOutputStream oos=new ObjectOutputStream(scClient.s.getOutputStream());
				oos.writeObject(message);
		
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
}

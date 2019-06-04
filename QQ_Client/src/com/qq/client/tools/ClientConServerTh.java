package com.qq.client.tools;


import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.qq.client.view.QQChat;
import com.qq.common.Message;
//客户端和服务器保持通讯的类;消息是在这接收的;
public class ClientConServerTh extends Thread{
	private Socket s;
	
	public Socket getS() {
		return s;
	}
	public void setS(Socket s) {
		this.s = s;
	}
	
	
	public ClientConServerTh(Socket s) {
		// TODO Auto-generated constructor stub
			this.s=s;
	}
	public void run() {
		// TODO Auto-generated method stub
			while (true) {
				//不停的读取
				ObjectInputStream ois;
				try {
					ois = new ObjectInputStream(s.getInputStream());
				Message message=(Message) ois.readObject();
				System.out.println(message.getSender()+"给"+message.getGetter()+"说"+message.getCon());
				///然后就进行转发:及时显示到该显示的界面;
				QQChat qqChat=ManageQQChat.getQQChat(message.getGetter()+" "+message.getSender());
				//System.out.println(message.getSender()+"给"+message.getGetter()+"说"+message.getCon());
				//System.out.println("以到处");
				//显示:
				qqChat.showMessage(message);
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
	}
}
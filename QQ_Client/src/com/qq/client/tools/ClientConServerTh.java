package com.qq.client.tools;


import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.qq.client.view.QQChat;
import com.qq.common.Message;
//�ͻ��˺ͷ���������ͨѶ����;��Ϣ��������յ�;
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
				//��ͣ�Ķ�ȡ
				ObjectInputStream ois;
				try {
					ois = new ObjectInputStream(s.getInputStream());
				Message message=(Message) ois.readObject();
				System.out.println(message.getSender()+"��"+message.getGetter()+"˵"+message.getCon());
				///Ȼ��ͽ���ת��:��ʱ��ʾ������ʾ�Ľ���;
				QQChat qqChat=ManageQQChat.getQQChat(message.getGetter()+" "+message.getSender());
				//System.out.println(message.getSender()+"��"+message.getGetter()+"˵"+message.getCon());
				//System.out.println("�Ե���");
				//��ʾ:
				qqChat.showMessage(message);
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
	}
}
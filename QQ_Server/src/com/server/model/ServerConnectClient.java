package com.server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.qq.common.Message;
//ĳ���ͻ������ӷ�������ͨѶ�߳���
public class ServerConnectClient  extends Thread{
	
	Socket s;
	 public ServerConnectClient(Socket s) {
		//�ѷ�������ͻ��˵����Ӹ�s;
		 this.s=s;
	}
	@Override
	public void run() {
			// TODO Auto-generated method stub
		while (true) {
			//�ø��߳̿��Խ��ܵ��ͻ��˵���Ϣ;
			try {
//				Thread.sleep(2000);
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message message=(Message) ois.readObject();
			System.out.println(message.getSender()+"��"+message.getGetter()+"˵"+message.getCon());
			//�������ת��;
			/*
			 * ת��ʱ���ִ���;???????????�ѽ��;
			 */
			//ȡ�ý����˵�ͨѶ�߳�;
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

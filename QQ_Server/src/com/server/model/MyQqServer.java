package com.server.model;
//QQ�������ķ����;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

import com.qq.common.Message;
import com.qq.common.User;
import com.server.view1.MySeverJFrame;
public class MyQqServer {
	
	Socket s1;
	ServerSocket ss;
	MySeverJFrame mjf;
	public MyQqServer() {
		// TODO Auto-generated constructor stub
		try {
			ss=new ServerSocket(3033);
			JOptionPane.showMessageDialog(mjf,"����������");
			System.out.println("�ȴ�����");
		while (true) {
				s1=ss.accept();
			System.out.println("��ʼ����");
	//��֤��¼;
			ObjectInputStream ois=new ObjectInputStream(s1.getInputStream());
			User user= (User)ois.readObject();
			System.out.println(user.getId()+",,"+user.getPassward());
			String userId=user.getId();
			String userpd=user.getPassward();
			///��??????�Ѿ����;
			//�����ݿ�����������֤;
			QQServerUser uModel=new QQServerUser();
			Message message=new Message();
			//������Ϣ;
			ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
			if(uModel.checkUser(userId, userpd)){
				message.setMeType("1");
				oos.writeObject(message);
		/*
		����֤;
			Message message=new Message();
			ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
			if(userpd.equals("123")){
				message.setMeType("1");
				oos.writeObject(message);
		*/
	///��������Ϣ�������õ���;	
			////���ﵥ��һ���߳���ͻ��˱���ͨѶ;
			ServerConnectClient sClient=new ServerConnectClient(s1);
			//���뵽map��;
			ManageQQClientTh.addClientThread(userId, sClient);
			//������ͻ���ͨѶ���߳�����һ��;
			    sClient.start();
			
			}else{
				JOptionPane.showMessageDialog(this.mjf, "����������֤��Ϣ����,");
				message.setMeType("2"); 
				oos.writeObject(message);
			}
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
}

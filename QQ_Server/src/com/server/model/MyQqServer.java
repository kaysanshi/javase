package com.server.model;
//QQ服务器的服务端;

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
			JOptionPane.showMessageDialog(mjf,"服务器启动");
			System.out.println("等待连接");
		while (true) {
				s1=ss.accept();
			System.out.println("开始接收");
	//验证登录;
			ObjectInputStream ois=new ObjectInputStream(s1.getInputStream());
			User user= (User)ois.readObject();
			System.out.println(user.getId()+",,"+user.getPassward());
			String userId=user.getId();
			String userpd=user.getPassward();
			///题??????已经解决;
			//与数据库链接用于验证;
			QQServerUser uModel=new QQServerUser();
			Message message=new Message();
			//换回信息;
			ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
			if(uModel.checkUser(userId, userpd)){
				message.setMeType("1");
				oos.writeObject(message);
		/*
		简单验证;
			Message message=new Message();
			ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
			if(userpd.equals("123")){
				message.setMeType("1");
				oos.writeObject(message);
		*/
	///这里是信息传递所用的类;	
			////这里单开一个线程与客户端保持通讯;
			ServerConnectClient sClient=new ServerConnectClient(s1);
			//加入到map中;
			ManageQQClientTh.addClientThread(userId, sClient);
			//启动与客户端通讯的线程是哪一个;
			    sClient.start();
			
			}else{
				JOptionPane.showMessageDialog(this.mjf, "服务器端验证信息错误,");
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

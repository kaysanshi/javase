package com.qq.client.view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;

import com.qq.client.model.QQClient;
import com.qq.client.tools.ClientConServerTh;
import com.qq.client.tools.ManageCLienttoServer;
import com.qq.common.Message;

//�������,�ͻ���Ҫ���ڶ�ȡ��״̬,��Ϊ�߳���
public class QQChat extends JFrame implements ActionListener{
	JTextField jField;
	JButton jb;
	JTextArea jTextArea;
	JPanel jp1;
	QQFriends f1;
	String userId;
	String friendId;
	JScrollPane jScrollPane;
	 public QQChat(String userid,String friend) {
		 this.userId=userid;
		 this.friendId=friend;
		jField=new JTextField(20);
		jb=new JButton("����");
		jb.addActionListener(this);
		jb.setActionCommand("send");
		jTextArea=new JTextArea();
		jp1=new JPanel();
		jp1.add(jField);
		jp1.add(jb);
		jScrollPane=new JScrollPane(jTextArea);
		this.add(jScrollPane,"Center");
		this.add(jp1, "South");
		this.setTitle(userid+"��"+friend+"����");
		this.setIconImage(new ImageIcon("image\\qq.jpg").getImage());
		this.setSize(500, 300);
		this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		});
		
		this.setVisible(true);
	 }
	 //дһ����ʾ��Ϣ�ķ���
	 public void showMessage(Message message) {
		 String info=message.getSender()+":"+message.getCon()+"\r\n";
			this.jTextArea.append(info);
			jTextArea.setFont(new Font("����", Font.BOLD, 15));
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("send")) {
			Message message=new Message();
			message.setSender(this.userId);
			message.setGetter(this.friendId);
			message.setCon(jField.getText());
			message.setSendtime(new Date().toString());
			//���͸�������;
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ManageCLienttoServer.getClientConServerTh(userId).getS().getOutputStream());
				oos.writeObject(message);
				String info=message.getSender()+":"+message.getCon()+"\r\n";
				this.jTextArea.append(info);
				jTextArea.setFont(new Font("����", Font.BOLD, 17));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while (true) {
//			//��ȡ..���������������ȡ���ɹ��Ļ�;
//			try {
//				ObjectInputStream ois=new ObjectInputStream(QQClient.socket.getInputStream());
//				Message message=(Message) ois.readObject();
//				//��ʾ
//				String info=message.getSender()+":"+message.getCon()+"\r\n";
//				this.jTextArea.append(info);
//				jTextArea.setFont(new Font("����", Font.BOLD, 15));
//	String info=message.getSender()+":"+message.getCon()+"\r\n";
//	this.jTextArea.append(info);
//	jTextArea.setFont(new Font("����", Font.BOLD, 15));
//			} catch (IOException | ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//	}
}

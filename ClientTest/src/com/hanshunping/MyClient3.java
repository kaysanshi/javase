package com.hanshunping;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClient3  extends JFrame implements ActionListener{
	
	
	JTextArea jArea=null;
	JTextField jField=null;
	JScrollPane jsp=null;
	JButton jb=null;
	JPanel Jp1=null;
	PrintWriter pWriter=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyClient3();

	}
	
	public MyClient3(){
		jArea=new JTextArea();
		jsp=new JScrollPane(jArea);
		this.add(jsp,"Center");
		jField=new JTextField(20);
		jb=new JButton("����");
		jb.addActionListener(this);
		Jp1=new JPanel();
		Jp1.add(jField);
		Jp1.add(jb);
		this.add(Jp1, "South");
		this.setTitle("�ͻ��˴���");
		this.setSize(400, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		//������
		try {
			Socket ss=new Socket("202.196.37.239", 2222);
			InetAddress netAddress = ss.getInetAddress();// ���Զ�̷������ĵ�ַ
            String netIp = netAddress.getHostAddress();// ���Զ�̷�������IP��ַ 
            int netPort = ss.getPort();// ���Զ�̷������Ķ˿ں�
            InetAddress localAddress = ss.getLocalAddress();// ��ÿͻ��˵ĵ�ַ
            String localIp = localAddress.getHostAddress();// ��ÿͻ��˵�IP��ַ
            int localPort = ss.getLocalPort();// ��ÿͻ��˵Ķ˿ں�
            jArea.append("Զ�̷�������IP��ַ��" + netIp + "\n");
            jArea.append("Զ�̷������Ķ˿ںţ�" + netPort + "\n");
            jArea.append("�ͻ������ص�IP��ַ��" + localIp + "\n");
            jArea.append("�ͻ������صĶ˿ںţ�" + localPort + "\n");
			InputStreamReader iReader=new InputStreamReader(ss.getInputStream());
			BufferedReader bReader=new BufferedReader(iReader);
			pWriter=new  PrintWriter(ss.getOutputStream(),true);
			while (true) {
				//��ͣ�Ķ�ȡ
				String info=bReader.readLine();
				jArea.append("�����:"+info+"\r\n");
				
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(jb)) {
			jArea.append("�ͻ���:"+jField.getText()+"\r\n");
			pWriter.println(jField.getText());
			jField.setText("");
		}
	}

}

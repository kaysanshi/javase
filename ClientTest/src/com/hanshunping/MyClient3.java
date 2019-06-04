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
		jb=new JButton("发送");
		jb.addActionListener(this);
		Jp1=new JPanel();
		Jp1.add(jField);
		Jp1.add(jb);
		this.add(Jp1, "South");
		this.setTitle("客户端窗口");
		this.setSize(400, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		//建立来
		try {
			Socket ss=new Socket("202.196.37.239", 2222);
			InetAddress netAddress = ss.getInetAddress();// 获得远程服务器的地址
            String netIp = netAddress.getHostAddress();// 获得远程服务器的IP地址 
            int netPort = ss.getPort();// 获得远程服务器的端口号
            InetAddress localAddress = ss.getLocalAddress();// 获得客户端的地址
            String localIp = localAddress.getHostAddress();// 获得客户端的IP地址
            int localPort = ss.getLocalPort();// 获得客户端的端口号
            jArea.append("远程服务器的IP地址：" + netIp + "\n");
            jArea.append("远程服务器的端口号：" + netPort + "\n");
            jArea.append("客户机本地的IP地址：" + localIp + "\n");
            jArea.append("客户机本地的端口号：" + localPort + "\n");
			InputStreamReader iReader=new InputStreamReader(ss.getInputStream());
			BufferedReader bReader=new BufferedReader(iReader);
			pWriter=new  PrintWriter(ss.getOutputStream(),true);
			while (true) {
				//不停的读取
				String info=bReader.readLine();
				jArea.append("服务端:"+info+"\r\n");
				
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
			jArea.append("客户端:"+jField.getText()+"\r\n");
			pWriter.println(jField.getText());
			jField.setText("");
		}
	}

}

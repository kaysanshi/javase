package com.hanshunping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sever3  extends JFrame implements ActionListener{
	
	JTextArea jTArea=null;
	JTextField jField=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jPanel=null;
	PrintWriter pWriter=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sever3();
	}
	public Sever3() {
		// TODO Auto-generated constructor stub
		jTArea=new JTextArea();
		jsp=new JScrollPane(jTArea);
		jField=new JTextField(16);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jPanel=new JPanel();
		jPanel.add(jField);
		jPanel.add(jb);
		this.add(jsp,"Center");
		this.add(jPanel, "South");
		this.setTitle("服务端");
		this.setSize(400, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		//建立 监听
		
		try {
			ServerSocket ss=new ServerSocket(2222);
			//等待;
			Socket  s=ss.accept();
			jTArea.append("客户端已经连接"+"\r\n");
			InputStreamReader iReader=new InputStreamReader(s.getInputStream());
			BufferedReader bReader=new BufferedReader(iReader);
			pWriter=new  PrintWriter(s.getOutputStream(),true);
			//读取
			while (true) {
				String info=bReader.readLine();
				jTArea.append("客户端:"+info+"\r\n");
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			pWriter.close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(jb)) {
			//把服务器的发送出去
			String str=jField.getText();
			jTArea.append("服务器:"+str+"\r\n");
			pWriter.println(str);
			jField.setText("");
			
		}
	}

}

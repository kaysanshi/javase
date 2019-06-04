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
		jb=new JButton("����");
		jb.addActionListener(this);
		jPanel=new JPanel();
		jPanel.add(jField);
		jPanel.add(jb);
		this.add(jsp,"Center");
		this.add(jPanel, "South");
		this.setTitle("�����");
		this.setSize(400, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		//���� ����
		
		try {
			ServerSocket ss=new ServerSocket(2222);
			//�ȴ�;
			Socket  s=ss.accept();
			jTArea.append("�ͻ����Ѿ�����"+"\r\n");
			InputStreamReader iReader=new InputStreamReader(s.getInputStream());
			BufferedReader bReader=new BufferedReader(iReader);
			pWriter=new  PrintWriter(s.getOutputStream(),true);
			//��ȡ
			while (true) {
				String info=bReader.readLine();
				jTArea.append("�ͻ���:"+info+"\r\n");
				
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
			//�ѷ������ķ��ͳ�ȥ
			String str=jField.getText();
			jTArea.append("������:"+str+"\r\n");
			pWriter.println(str);
			jField.setText("");
			
		}
	}

}

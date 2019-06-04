package com.mingribook;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class MYClien extends JFrame{

	private PrintWriter writer;
	Socket socket;
	private JTextArea tArea=new JTextArea();
	private JTextField jField=new JTextField();
	Container cc;
	
	public MYClien(String title){
		super(title);
		cc=this.getContentPane();
		cc.add(tArea, "North");
		cc.add(jField,"South");
		jField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writer.println(jField.getText());
				tArea.append(jField.getText()+'\n');
				jField.setText("");
			}
		});
		this.setBounds(300, 260, 340, 220);
		this.setVisible(true);
	}
	private void connect(){
		tArea.append("尝试连接\n");
		try {
			socket=new Socket("202.196.37.239",8998);
			writer=new PrintWriter(socket.getOutputStream(),true);
			tArea.append("连接完成");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MYClien clien=new MYClien("向服务器发送数据");
		clien.connect();
	}
}

package com.mingribook1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Wheather extends JFrame implements Runnable,ActionListener{
	Thread thread;
	////
	int port=9898;
	InetAddress iAddress=null;
	MulticastSocket socket=null;//�㲥�׽���;
	DatagramPacket packet=null;//�������ݰ�
	
	boolean b=false;
	JPanel JP1;
	JTextArea jArea;
	JScrollPane jsp;
	JTextField jField;
	JButton jb,jb2;
	
	public Wheather() {
		thread=new Thread(this);//��������;
		jArea=new JTextArea();
		jsp=new JScrollPane(jArea);
		jField=new JTextField(15);
		jb=new JButton("��ʼ�㲥");
		jb.addActionListener(this);
		jb2=new JButton("ֹͣ����");
		jb2.addActionListener(this);
		JP1=new JPanel();
		JP1.add(jb2);
		JP1.add(jField);
		JP1.add(jb);
		this.add(jsp,"Center");
		this.add(JP1, "South");
		this.setSize(400,300);
		this.setTitle("�㲥��ϢԴ");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		//////////////
		///ʵ����inetAddress ������㲥
		try {
			iAddress=InetAddress.getByName("224.225.10.0");//ָ����ַ
			socket=new MulticastSocket(port);
			socket.setTimeToLive(1);//zָ����Χ
			socket.joinGroup(iAddress);//���뵽�㲥����
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//�����ݴ��,
	public void showit() {
		
		byte[] data=jField.getText().getBytes();
		jArea.setFont(new Font("����", Font.PLAIN, 15));
		packet=new DatagramPacket(data, data.length,iAddress,port);//���������ݰ�;
		jArea.append("�㲥��ʼ:"+new String(data)+"\r\n");	
		
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			try {
				Thread.sleep(300);
				this.showit();
				socket.send(packet);//��������;
			} catch (IOException | InterruptedException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (b==true) {
				break;
			}
		}		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb){
			if(!(thread.isAlive())){
			thread=new Thread(this);
			
			}
		  thread.start();
		  	b=false;
		}else if(e.getSource()==jb2){
			b=true;
		}
	}
	
	public static void main(String[] args) {
		Wheather wheather=new Wheather();	
	}
}

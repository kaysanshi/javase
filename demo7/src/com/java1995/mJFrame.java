package com.java1995;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mJFrame extends JFrame {
	//�����������ڴ��壻
	public mJFrame(){
		MyJpanel p= new MyJpanel();
		this.add(p);
		this.setTitle("���Ǳ���");
		this.setSize(500,300);
		this.setVisible(true);
		//���Ҫʹ����رձ��봴�������¼�
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new mJFrame();
	}
}
class MyJpanel extends JPanel{
	//Ҫ��д����
	public void paintComponent(Graphics g){
		g.drawString("���Ǹ����", 100, 100);
	}
}

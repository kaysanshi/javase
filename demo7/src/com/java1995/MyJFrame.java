package com.java1995;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyJFrame extends JFrame{
//�������м����¼��Ĳ��Ҿ��еĴ��壻
	public MyJFrame(){
		this.setTitle("�������");
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		this.setSize(width/2, height/2);//���ô�С
		this.setLocation(width/4, height/4);//��ʼλֵ
		this.repaint();//������ľ���
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			//��д���еķ�����
			public void windowClosing(WindowEvent w){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MyJFrame();
	}
}

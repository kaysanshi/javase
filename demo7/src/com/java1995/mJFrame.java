package com.java1995;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mJFrame extends JFrame {
	//面板必须依赖于窗体；
	public mJFrame(){
		MyJpanel p= new MyJpanel();
		this.add(p);
		this.setTitle("这是标题");
		this.setSize(500,300);
		this.setVisible(true);
		//如果要使窗体关闭必须创建监听事件
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
	//要重写方法
	public void paintComponent(Graphics g){
		g.drawString("这是个面板", 100, 100);
	}
}

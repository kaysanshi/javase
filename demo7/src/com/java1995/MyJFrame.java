package com.java1995;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyJFrame extends JFrame{
//创建带有监听事件的并且居中的窗体；
	public MyJFrame(){
		this.setTitle("窗体居中");
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		this.setSize(width/2, height/2);//设置大小
		this.setLocation(width/4, height/4);//起始位值
		this.repaint();//绘组件的矩形
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			//重写其中的方法；
			public void windowClosing(WindowEvent w){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MyJFrame();
	}
}

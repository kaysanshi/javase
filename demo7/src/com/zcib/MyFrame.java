package com.zcib;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		this.setTitle("我第一个窗口");
		this.setSize(200,300);
		//定义一个按钮
		JButton btn=new JButton("按钮");
		//设置流式布局管理器
		this.setLayout(new FlowLayout());
		//添加按钮组件
		this.add(btn);
		//设置单击关闭按钮的默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

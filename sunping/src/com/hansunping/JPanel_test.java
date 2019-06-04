package com.hansunping;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * JPanel 面板使用法：
 * 定义组件：JButton,把按钮加入到Jpanel面板；同时可以设置按钮位置；
 * 在把Jpanel面板加入到JFrame中;
 */
public class JPanel_test extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public JPanel_test(){
		//创建组件
		//jpanel默认为流布局
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("jb1");
		jb2=new JButton("jb2");
		jb3=new JButton("jb3");
		jb4=new JButton("jb4");
		jb5=new JButton("jb5");
		jb6=new JButton("jb6");
		//设置布局
		
		//添加组件
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		//把JPanel加入到jFrame
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jb6, BorderLayout.CENTER);
		//设置JFrame窗口
		this.setTitle("JPanel多布局");
		this.setSize(400, 500);
		this.setLocation(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JPanel_test();
	}
}

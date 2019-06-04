package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
/*
 * 单选框复选框的应用；
 * 1，创建组件；
 * 2.设置布局
 * 3.设置组群
 * 4.将其添加到JPanel
 * 5.将JPanel添加到JFrame
 * 6.设置JFrame的属性
 */
public class Box_t extends JFrame{
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JRadioButton jrb1,jrb2;//单选框组件
	JCheckBox jcb1,jcb2,jcb3;//复选框组件
	JButton jb1,jb2;//按钮
	public Box_t(){
		//创建组件
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("你喜欢的运动");
		jcb1=new JCheckBox("蓝求");
		jcb2=new JCheckBox("足球");
		jcb3=new JCheckBox("乒乓球");
		
		jlb2=new JLabel("你的性别");
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		//布局管理设置
		this.setLayout(new GridLayout(3,1));
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//添加组件到JPanel
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//
		this.setTitle("欢迎登陆");
		this.setSize(300, 250);
		this.setLocation(400, 350);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Box_t();
	}

}

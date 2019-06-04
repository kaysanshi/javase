package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
 * 1.创建组件
 * 2.添加到面板
 * 3、将面板添加到窗口
 * 4.设置窗口属性
 */
public class JP_M extends JFrame{
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JLabel jlb1,jlb2,jlb3;
	JTextField jtf;
	JPasswordField jpw;
	public JP_M(){
		//创建组件
		jp1 =new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//标签；
		jlb1=new JLabel("账号");
		jlb2=new JLabel("密码");
		//按钮
		jb1=new JButton("登录");
		jb2=new JButton("退出");
		//文本框的应用数字代表长度
		jtf=new JTextField(15);
		jpw=new JPasswordField(15);
		//设置标签按钮布局
		this.setLayout(new GridLayout(3,1));
		//添加组件到Jpanel
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpw);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//将JPannel添加到jFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//设置JFrame
		this.setTitle("登录界面");
		this.setSize(300, 200);
		this.setLocation(300, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JP_M();
	}

}

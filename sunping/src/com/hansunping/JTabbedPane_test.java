package com.hansunping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/*
 * qq页面的开发
 * 选项卡创格
 */
public class JTabbedPane_test extends JFrame {
	//南部区域
	JPanel jp1;
	//登录，取消，清除向导
	JButton jb1,jb2,jb3;
	
	//北部区域加图片
	JLabel jlb1;
	
	//中部
	JTabbedPane jtp;//选项卡窗格
	//qq号码，手机号，邮箱，
	JPanel jp2,jp3,jp4;
	//账号，密码，忘记密码，清除号码，申请密码保护
	JLabel jlb2,jlb3,jlb4,jlb5;//标签
	JTextField jtf;//文本框
	JPasswordField jpw;//密码框
	JButton jb4;
	//隐身登录,记住密码
	JCheckBox jcb1,jcb2;//复选框
	public JTabbedPane_test(){
		//南部，
		jp1=new JPanel();
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		jb3=new JButton("清除向导");
		//北部
		jlb1=new JLabel(new ImageIcon("Image\\qqjiemain.jpg"));
		//中部；
		jlb2=new JLabel("账号",JLabel.CENTER);
		jlb3=new JLabel("密码",JLabel.CENTER);
		jlb4=new JLabel("忘记密码",JLabel.CENTER);
		jlb4.setFont(new Font("宋体",Font.PLAIN,15));
		jlb4.setForeground(Color.BLUE);
		jlb5=new JLabel("<html><s href='www.qq.com'>申请密码保护</s>");
		jlb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置手行
		
		jtf=new JTextField();
		jpw=new JPasswordField();
		jb4=new JButton(new ImageIcon("Image\\qq.jpg"));
		
		jcb1=new JCheckBox("隐身登录");
		jcb2=new JCheckBox("记住密码");
		
		//中部可变的面板
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.BLACK);
		jp4=new JPanel();
		jp4.setBackground(Color.CYAN);
		//中部；选项卡格
		jtp.add("QQ号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("邮箱登录",jp4);
		//设置中部的布局
		jp2.setLayout(new GridLayout(3,3));
		//添加到面板yi中部；
//		jp2.add(jtp);
		jp2.add(jlb2);
		jp2.add(jtf);
		jp2.add(jlb4);
		jp2.add(jlb3);
		jp2.add(jpw);
		jp2.add(jlb5);
		jp2.add(jcb1);
		jp2.add(jcb2);
		//中部的手机登录
		
	
		//南部
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		//添加到JFrame;
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jlb1,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		
		//设置窗体
		this.setTitle("qq");
		this.setIconImage((new ImageIcon("Image\\qq.jpg")).getImage());
		this.setSize(450, 250);
		this.setLocation(650, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		new JTabbedPane_test();
	}
}

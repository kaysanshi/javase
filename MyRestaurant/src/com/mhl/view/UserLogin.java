package com.mhl.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.mhl.model.UserModel;

import Tools.Tools;
public class UserLogin extends JDialog implements ActionListener{
	//定义组件
	JLabel jl1,jl2,jl3;
	JTextField jName;
	JPasswordField jpass;
	JButton jcon,jCansel;
	public static void main(String[] args) {
		 UserLogin ul=new  UserLogin();
	}
	public UserLogin(){
		this.getContentPane();
		//创建组件
		jl1=new JLabel("请输入用户名:");
		jl1.setFont(Tools.f1);
		jl1.setBounds(60,200,150,15);
		jName=new JTextField(10);
		jName.setBounds(170, 195, 150, 25);
		//设置下陷感觉;
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jl1);
		this.add(jName);
		jl2=new JLabel("请输入密码:");
		jl2.setFont(Tools.f1);
		jl2.setBounds(60,260,150,15);
		jpass=new JPasswordField(10);
		jpass.setBounds(170,255, 150, 25);
		//设置下陷感觉;
		jpass.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jl2);
		this.add(jpass);
		jcon=new JButton("登录");
		jcon.addActionListener(this);
		jcon.setBounds(100,300,65,35);
		this.add(jcon);
		jCansel=new JButton("取消");
		jCansel.addActionListener(this);
		jCansel.setBounds(220, 300, 65,35);
		this.add(jCansel);
		
		jl2=new JLabel("{员工号}");
		jl2.setFont(Tools.f1);
		//设置前景色;
		jl2.setForeground(Color.red);
		jl2.setBounds(100,210, 100, 30);
		this.add(jl2);
		
		
		
		
		
		this.setLayout(null);
		//创建BackImage对象
		BackImage bi=new BackImage();
		//把位置确定下来
		bi.setBounds(0, 0,360, 360);
		this.add(bi);
		//不使用上下框
		this.setUndecorated(true);
		this.setSize(360,360);
		//确定JWindow的位置
		int weight=Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的长
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高；
		//初始位置；
		this.setLocation(weight/2-200, height/2-150);
		this.setVisible(true);
	}
	class BackImage extends JPanel{
		Image im;
		public BackImage(){
			try {
				im=ImageIO.read(new File("image\\login.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			g.drawImage(im, 0, 0, 360,360,this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jcon)){
			System.out.println("你已经进入登录界面");
			String uid=this.jName.getText().trim();
			String p=new String(this.jpass.getPassword());
			UserModel um=new UserModel();
			String user=new String (um.checkUser(uid, p).trim());
			String empname=um.getNameById(uid);
			Window1 w1=new Window1();
		}else if(e.getSource().equals(jCansel)){
			System.out.println("你将取消这个进入");
			this.dispose();
		}
	}

}

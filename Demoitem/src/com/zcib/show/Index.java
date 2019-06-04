package com.zcib.show;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zcib.controller.Manager;
import com.zcib.model.UserModel;
public class Index extends JFrame implements ActionListener{
	/*
	 * 主页面的控制
	 * 1.基本信息标的初始化:manager--->goodsmodel--->db
	 * 2.登录的验证:manager--->usermodel-->db
	 */
	private static final long serialVersionUID = 1L;
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2,jb3;
	JTextField jtf;
	JPasswordField jps;
	public Index(){
		this.setLayout(null);
		this.setBounds(0, 0, 460, 350);
		jl1=new JLabel("请输入账号:");
		jtf=new JTextField(10);
		//绝对布局的设置方式
		jl1.setBounds(80, 80, 150, 30);
		jtf.setBounds(160, 80, 150, 30);
		this.add(jl1);
		this.add(jtf);
		jl2=new JLabel("请输入密码:");
		jps=new JPasswordField(10);
		jl2.setBounds(80, 150, 150, 30);
		jps.setBounds(160, 150, 150, 30);
		this.add(jl2);
		this.add(jps);
		jb1=new JButton("登录");
		jb1.addActionListener(this);
		jb1.setActionCommand("denglu");
		jb2=new JButton("取消");
		jb3=new JButton("注册");
		jb3.addActionListener(this);
		jb3.setActionCommand("zhuce");
		jb3.setBounds(50, 250,70, 35);
		jb2.setBounds(170, 250, 70, 35);
		jb1.setBounds(280, 250,70, 35);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3); 
		jl3=new JLabel("欢迎来到本系统");
		jl3.setBounds(100,30, 300, 40);
		jl3.setFont(new Font("华文新魏",Font.BOLD,30));
		this.add(jl3);
		this.setSize(460,350);
		int weight=Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的长
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高；
		//初始位置；
		this.setLocation(weight/2-200, height/2-150);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	//事件的使用
@Override 
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("denglu")){
		String userId=jtf.getText().trim();
		String userpd=new String( this.jps.getPassword());
		UserModel uModel=new UserModel();
		if(uModel.checkUser(userId, userpd)){
			//JOptionPane.showMessageDialog(this, "你输入的密码正确准备进入系统");
			Manager manager=new Manager();
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "你输入的密码不正确请重新输入");
		}
	}else if(e.getActionCommand().equals("zhuce")){
		String useId=jtf.getText().trim();
		String usepd=new String( this.jps.getPassword());
		UserModel user=new UserModel();
		System.out.println("开始注册");
		if(user.addUser(useId, usepd)){
			//弹提示框:
			JOptionPane.showMessageDialog(this, "你已注册成功可以进行登录");
		}else{
			JOptionPane.showMessageDialog(this, "注册失败请从新注册");
		}	
	}else{
		JOptionPane.showMessageDialog(this, "你已取消登录");
		}
}

public static void main(String[] args) {
	new Index();
}
}


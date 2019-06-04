package com.hanshunping4;
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
//绝对布局使用登录界面
public class Showview extends JFrame implements ActionListener{
		JLabel jl1,jl2,jl3;
		JButton jb1,jb2;
		JTextField jtf;
		JPasswordField jps;
	
	public Showview(){
		this.setLayout(null);
		this.setBounds(0, 0, 360, 300);
		jl1=new JLabel("请输入账号:");
		jtf=new JTextField(10);
		//绝对布局的设置方式
		jl1.setBounds(50, 50, 150, 30);
		jtf.setBounds(130, 50, 150, 30);
		this.add(jl1);
		this.add(jtf);
		jl2=new JLabel("请输入密码:");
		jps=new JPasswordField(10);
		jl2.setBounds(50, 100, 150, 30);
		jps.setBounds(130, 100, 150, 30);
		this.add(jl2);
		this.add(jps);
		jb1=new JButton("登录");
		jb1.addActionListener(this);
		jb1.setActionCommand("denglu");
		jb2=new JButton("取消");
		jb1.setBounds(50, 180,80, 40);
		jb2.setBounds(180, 180, 80, 40);
		this.add(jb1);
		this.add(jb2);
		jl3=new JLabel("欢迎来到学生管理系统");
		jl3.setBounds(50,10, 300, 30);
		jl3.setFont(new Font("华文新魏",Font.BOLD,20));
		this.add(jl3);
		this.setSize(360,300);
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
///监听事件的处理;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("denglu")){
			String userId=jtf.getText().trim();
			String userpd=new String( this.jps.getPassword());
			userModel uModel=new userModel();
			if(uModel.checkUser(userId, userpd)){
				StuManage s=new StuManage();
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "请输入正确的密码");
			}
		}else{
			JOptionPane.showMessageDialog(this, "请输入正确的密码");
		}
	}
			

	public static void main(String[] args) {
		new Showview();
	}
	
}


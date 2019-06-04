package com.qq.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.qq.client.model.QQClientUser;
import com.qq.common.User;

//qq界面的开发:
//需要用到JTabbedPane就是选项卡组件
public class QQJFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//南部
	JButton jb1,jb2;
	//中部
	JPanel jp1,jp2,jp3,jp4;
	JLabel jl2,jl3,jl4,jl5;
	JTabbedPane jtp;
	public JTextField jtf;
	public JPasswordField jpf;
	JCheckBox jbBox1,jBox2;
	///第二个窗格
	JLabel jp2_jl2,jp2_jl3,jp2_jl4,jp2_jl5;
	JTabbedPane jp2_jtp;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jbBox1,jp2_jBox2;
	//第三个窗格
	JLabel jp3_jl2,jp3_jl3,jp3_jl4,jp3_jl5;
	JTabbedPane jp3_jtp;
	JTextField jp3_jtf;
	JPasswordField jp3_jpf;
	JCheckBox jp3_jbBox1,jp3_jBox2;
	//北部
	JLabel jl1;
	
	public QQJFrame() {
		// TODO Auto-generated constructor stub
		//北部;
		jl1=new JLabel(new ImageIcon("image\\QQ_J.png"));
		//南部
		jb1=new JButton("登录");
		jb1.addActionListener(this);
		jb1.setActionCommand("login");
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setActionCommand("exit");
		//中部
		jl2=new JLabel("QQ号码",JLabel.CENTER);
		jl3=new JLabel("QQ密码",JLabel.CENTER);
		jl4=new JLabel("忘记密码",JLabel.CENTER);
		jl4.setFont(new Font("宋体",Font.PLAIN,15));
		jl4.setForeground(Color.BLUE);
		jl5=new JLabel("<html><s href='www.qq.com'>申请密码保护</s>");
		jbBox1=new JCheckBox("隐身登录");
		jBox2=new JCheckBox("记住密码");
		jtf=new JTextField();
		jpf=new JPasswordField();
		///添加到中部的布局
		
		
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(3,3));
		jp1.add(jl2);
		jp1.add(jtf);
		jp1.add(jl4);
		jp1.add(jl3);
		jp1.add(jpf);
		jp1.add(jl5);
		jp1.add(jbBox1);
		jp1.add(jBox2);
		/////////////////////第二个面板
		jp2_jl2=new JLabel("手机号码",JLabel.CENTER);
		jp2_jl3=new JLabel("QQ密码",JLabel.CENTER);
		jp2_jl4=new JLabel("忘记密码",JLabel.CENTER);
		jp2_jl4.setFont(new Font("宋体",Font.PLAIN,15));
		jp2_jl4.setForeground(Color.BLUE);
		jp2_jl5=new JLabel("<html><s href='www.qq.com'>申请密码保护</s>");
		jp2_jbBox1=new JCheckBox("隐身登录");
		jp2_jBox2=new JCheckBox("记住密码");
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		///添加到第二个面板中的组件
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(3,3));
		jp2.add(jp2_jl2);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jl4);
		jp2.add(jp2_jl3);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jl5);
		jp2.add(jp2_jbBox1);
		jp2.add(jp2_jBox2);
		////////////////////////////第三个选项卡面板
		jp3_jl2=new JLabel("邮箱号码",JLabel.CENTER);
		jp3_jl3=new JLabel("邮箱密码",JLabel.CENTER);
		jp3_jl4=new JLabel("忘记密码",JLabel.CENTER);
		jp3_jl4.setFont(new Font("宋体",Font.PLAIN,15));
		jp3_jl4.setForeground(Color.BLUE);
		jp3_jl5=new JLabel("<html><s href='www.qq.com'>申请密码保护</s>");
		jp3_jbBox1=new JCheckBox("隐身登录");
		jp3_jBox2=new JCheckBox("记住密码");
		jp3_jtf=new JTextField();
		jp3_jpf=new JPasswordField();
		///添加到中部的布局
		jp3=new JPanel();
		jp3.setLayout(new GridLayout(3,3));
		jp3.add(jp3_jl2);
		jp3.add(jp3_jtf);
		jp3.add(jp3_jl4);
		jp3.add(jp3_jl3);
		jp3.add(jp3_jpf);
		jp3.add(jp3_jl5);
		jp3.add(jp3_jbBox1);
		jp3.add(jp3_jBox2);
		///////
		jtp=new JTabbedPane();//选项卡面板
		jtp.add("QQ号码登录", jp1);
		jtp.add("手机登录",jp2);
		jtp.add("邮箱登录",jp3);
		//添加到南部的JPanel4中
		jp4=new JPanel();
		jp4.add(jb1);
		jp4.add(jb2);
		///
		this.add(jp4,BorderLayout.SOUTH);
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp, BorderLayout.CENTER);
		this.setTitle("QQ");
		this.setIconImage(new ImageIcon("image\\qq.jpg").getImage());
		this.setLocation(400,300);
		this.setSize(540, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	///////
	public static void main(String[] args) {
		new QQJFrame();
	}
	/////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("login")){
			System.out.println("点击");
			QQClientUser qqc=new QQClientUser();
			User user=new User();
			user.setId(jtf.getText());
			user.setPassward(new String(jpf.getPassword()));
			System.out.println(user.getId()+","+user.getPassward());
			//new qq_Friends(user.getId());
			//false;判断为假;
			if (qqc.CheckUser(user)){
				new QQFriends(user.getId());
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "主窗口你输入的不正确");
			}
			
		}else if(e.getActionCommand().equals("exit")){
			this.dispose();
		}
	}
}

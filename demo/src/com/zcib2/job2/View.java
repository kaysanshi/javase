package com.zcib2.job2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sun.awt.image.PixelConverter.Bgrx;
public class View extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtf1,jtf2,jtf3;
	JCheckBox jcb1,jcb2,jcb3;//复选
	JRadioButton jrb1,jrb2;//单选
	JComboBox<String> jcb;//下拉框
	JTextArea jTextArea;
	JScrollPane js1;
	JButton jb1,jb2;
	public View(){
		
		jl1=new JLabel("姓名:");
		jl2=new JLabel("性别:");
		jl3=new JLabel("生日:");
		jl4=new JLabel("爱好:");
		jl5=new JLabel("邮件:");
		jl6=new JLabel("学历:");
		jl7=new JLabel("附录:");
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jTextArea=new JTextArea(100,100);
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		jcb1=new JCheckBox("体育");
		jcb2=new JCheckBox("音乐");
		jcb3=new JCheckBox("旅游");
		String[] string={"本科","专科","博士"};
		jcb=new JComboBox<String>(string);
	
		jb1=new JButton("注册");
		jb1.addActionListener(this);
		jb1.setActionCommand("zhuce");
		jb2=new JButton("重置");
		jb2.addActionListener(this);
		jb2.setActionCommand("resert");
		this.setLayout(null);
		this.setBounds(0, 0, 400, 550);
		ButtonGroup bg=new ButtonGroup(); 
		jl1.setBounds(30, 20,30, 40);
		jtf1.setBounds(70,20,150,30);
		jl2.setBounds(30, 70,30, 30);
		jrb1.setBounds(90, 70, 50, 40);
		jrb2.setBounds(150, 70, 50, 40);
		jl3.setBounds(30, 110,30, 40);
		jtf2.setBounds(70,110,150,30);
		jl4.setBounds(30, 160,30, 40);
		jcb1.setBounds(80, 160,60, 40);
		jcb2.setBounds(150, 160,60, 40);
		jcb3.setBounds(210, 160,60, 40);
		jl5.setBounds(30, 210,30, 40);
		jtf3.setBounds(70,210,150,30);
		jl6.setBounds(30, 270,30, 40);
		jcb.setBounds(70, 270, 150, 40);
		jl7.setBounds(30, 320,30, 40);
		jTextArea.setBounds(70, 320,150,80);
		jb1.setBounds(30, 420,60,30);
		jb2.setBounds(120, 420,60,30);
		js1=new JScrollPane(jTextArea);
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		
		bg.add(jrb1);
		bg.add(jrb2);
		
		this.add(jrb1);
		this.add(jrb2);
		this.add(jl3);
		this.add(jtf2);
		
		this.add(jl4);
		this.add(jcb1);
		this.add(jcb2);
		this.add(jcb3);
		
		this.add(jl5);
		this.add(jtf3);
		this.add(jl6);
		this.add(jcb);
		this.add(jl7);
		this.add(js1);
		this.add(jb1);
		this.add(jb2);
		this.add(jTextArea);
		this.setTitle("欢迎登陆");
		
		this.setSize(400, 550);
		this.setLocation(400, 350);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("zhuce")){
			new ResultView(this);
		}else if(arg0.getActionCommand().equals("resert")){
			jtf1.setText("");
			
		}
	}
	public static void main(String[] args) {
		new View();
	}
}

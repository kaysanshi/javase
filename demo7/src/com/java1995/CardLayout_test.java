package com.java1995;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
//卡片布局可以做成循环列表;
public class CardLayout_test extends JFrame implements ActionListener{ 
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3;
	JLabel jl1,jl2,jl3;
	public CardLayout_test() {
		// TODO Auto-generated constructor stub
		jp1=new JPanel();
		jb1=new JButton("按钮一");
		jb1.addActionListener(this);
		jb2=new JButton("按钮二");
		jb2.addActionListener(this);
		jb3=new JButton("按钮三");
		jb3.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		//用卡片布局管理
		jp2=new JPanel();
		jp2.setLayout(new CardLayout());
		jl1=new JLabel(new ImageIcon("image\\131116-106.jpg"));
		jl2=new JLabel(new ImageIcon("image\\338659-106.jpg"));
		jl3=new JLabel(new ImageIcon("image\\42197-106.jpg"));
		jp2.add("标签1",jl1);
		jp2.add("标签2",jl2);
		jp2.add("标签3",jl3);
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH,jp1);
		this.add(BorderLayout.CENTER, jp2);
		this.setTitle("卡片布局管理");
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CardLayout_test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jb1) {
			//按钮一点击显示图片
			((CardLayout)jp2.getLayout()).show(jp2, "标签1");
		}else if (e.getSource()==jb2) {
			((CardLayout)jp2.getLayout()).show(jp2, "标签2");
		}else if(e.getSource()==jb3){
			((CardLayout)jp2.getLayout()).show(jp2, "标签3");
		}
	}
}

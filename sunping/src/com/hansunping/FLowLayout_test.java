package com.hansunping;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 1.继承JFrame;
 * 2.定义组件
 * 3.创建组件 
 * 4。添加组件；设置布局管理
 * 5.窗体设置
 * 6.显示窗体；
 */
public class FLowLayout_test extends JFrame {
	JButton jb1,jub2,jb3,jb4,jb5;
	public FLowLayout_test(){
		
		//对按钮命名
		jb1=new JButton("按钮一");
		//jb1.setSize(100,200);无效设置大小；
		jub2=new JButton("按钮二");
		jb3=new JButton("按钮三");
		jb4=new JButton("按钮四");
		jb5=new JButton("按钮五");	
		//添加按妞
		this.add(jb1);
		this.add(jub2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		//设置流式布局可以设置按那个方式对齐new FlowLayout(FlowLayout.LEADING)
		this.setLayout(new FlowLayout());
		//设置窗体
		this.setTitle("流式布局");
		this.setSize(300, 400);
		this.setLocation(200, 200);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//禁止改变大小
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FLowLayout_test();
	}

}

package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 1.继承JFrame;
 * 2.定义组件
 * 3.创建组件
 * 设置布局管理
 * 4.添加组件；
 * 5.窗体设置
 * 6.显示窗体；
 */
public class GridLayOut_test extends JFrame{
	int size=9;
	JButton[] arr=new JButton[size];
	public GridLayOut_test(){
		//创建组件
		for(int i=0;i<size;i++){
			arr[i]=new JButton(String.valueOf(i));
		}
		//设置布局管理器；网格式的；前面两个是控制数目后面两个是分割位置
		this.setLayout(new GridLayout(3,3,10,10));
		//添加组件
		for(int i=0;i<size;i++){
			this.add(arr[i]);
		}
		//添加窗口
		this.setTitle("网格布局管理器");
		this.setSize(400, 500);
		this.setLocation(400, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		//设置不可变形
		this.setResizable(false);
	}
	public static void main(String[] args) {
		new GridLayOut_test();
	}
}

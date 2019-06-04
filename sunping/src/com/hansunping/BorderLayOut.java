package com.hansunping;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * 1.继承JFrame;
 * 2.定义组件
 * 3.创建组件
 * 4.添加组件；设置布局管理
 * 5.窗体设置
 * 6.显示窗体；
 */
public class BorderLayOut extends JFrame{
	//边界布局管理器；
	JButton jb1,jb2,jb3,jb4,jb5;
	public  BorderLayOut(){
		jb1=new JButton("中部");
		jb2=new JButton("北部");
		jb3=new JButton("西部");
		jb4=new JButton("东部");
		jb5=new JButton("南部");
		//中间布局可以改变；当其他未设置时
		//如不指定位置时当创建下一个时就会把上一个给覆盖； 
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2, BorderLayout.SOUTH);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.WEST);
		this.setTitle("边界布局");
		this.setSize(500, 300);
		//初始位置
		this.setLocation(200, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayOut();
	}

}

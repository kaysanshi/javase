package com.java1995;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test_JLable {
	public static void main(String[] args) {
	new tJFrame();
	}
}
class tJFrame extends JFrame{
	public tJFrame(){
		this.setTitle("标签的测试");
		this.setSize(500, 400);
		JLabel jlable=new JLabel("文字");
		this.add(jlable);
		//还可以加入图片；进行构造方法中可以直接传入他的路径及其描述
		Icon image=new ImageIcon("C:\\Users\\Administrator\\Pictures\\素材\\101.jpg");
		JLabel jlabel=new JLabel(image);
		this.add(jlabel);
		//监听事件；
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//设置可显示
		this.setVisible(true);
	}
}
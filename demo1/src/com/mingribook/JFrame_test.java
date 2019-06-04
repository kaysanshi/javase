package com.mingribook;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
//要继承JFrame类；
public class JFrame_test extends JFrame{
	public void CreateJFrame(String title){
		JFrame jf=new JFrame(title);//实例化一个JFrame的对象；
		Container container=jf.getContentPane();//获取容器；
		JLabel jl=new JLabel("这是一个JFrame窗体");//创建一个标签；
		jl.setHorizontalAlignment(SwingConstants.CENTER);//使标签上的文字居中；
		container.add(jl);//将标签添加到容器中；
		container.setBackground(Color.BLUE);//设置窗体颜色；
		container.setLayout(null);
		jf.setVisible(true);//是窗体可视；
		jf.setSize(800, 800);//设置窗体大小
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗体关闭方式；
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFrame_test().CreateJFrame("这是我第一个创建的JFrame窗体");
	}

}

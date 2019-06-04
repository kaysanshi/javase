package com.hansunping;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * 多行文本框组件的使用
 */
public class JTextArea_test extends JFrame{
	JPanel jp;//面板
	JTextArea jta;//多行文本框
	JScrollPane jsp,jsp1;
	JButton jb1;//按钮
	JComboBox jcb;//下拉框
	JTextField jtf;//文本框
	public JTextArea_test(){
		//设置多行文本框并应用滚动方格组件
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		String[] s={"老铁","扎心","尼玛","菜逼"};
		jcb=new JComboBox(s);
		
		jtf=new JTextField(10);//文本框；
		jb1=new JButton("发送");
		//添加到面板
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb1);
		//添加到JFrame;
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		//设置窗口；
		this.setTitle("qq");
		this.setIconImage((new ImageIcon("Image\\qq.jpg")).getImage());
		this.setSize(400, 350);
		this.setLocation(300, 350);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
public static void main(String[] args) {
	new JTextArea_test();
}
}

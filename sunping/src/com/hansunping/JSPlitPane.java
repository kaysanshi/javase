package com.hansunping;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

/*
 * 可拆分窗格的使用
 */
public class JSPlitPane extends JFrame{
	JSplitPane jsp;
	JLabel jlb;
	JList jl;
	public JSPlitPane(){
		//创建并添加组件
		String []s={"number","boy","girl","math","lady","Jframe"};
		jl=new JList(s);
		//添加图片
		jlb=new JLabel(new ImageIcon("image\\java.png"));
		//拆分窗格并加入列表下拉组件，和标签，设置可伸缩变化
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jl,jlb);
		jsp.setOneTouchExpandable(true);//提供折叠部件;
		
		//添加
		this.add(jsp);
		this.setTitle("金山词霸");
		this.setSize(500, 500);
		this.setLocation(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JSPlitPane();
	}

}

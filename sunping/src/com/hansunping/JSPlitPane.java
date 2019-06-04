package com.hansunping;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;

/*
 * �ɲ�ִ����ʹ��
 */
public class JSPlitPane extends JFrame{
	JSplitPane jsp;
	JLabel jlb;
	JList jl;
	public JSPlitPane(){
		//������������
		String []s={"number","boy","girl","math","lady","Jframe"};
		jl=new JList(s);
		//���ͼƬ
		jlb=new JLabel(new ImageIcon("image\\java.png"));
		//��ִ��񲢼����б�����������ͱ�ǩ�����ÿ������仯
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jl,jlb);
		jsp.setOneTouchExpandable(true);//�ṩ�۵�����;
		
		//���
		this.add(jsp);
		this.setTitle("��ɽ�ʰ�");
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

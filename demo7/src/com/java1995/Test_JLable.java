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
		this.setTitle("��ǩ�Ĳ���");
		this.setSize(500, 400);
		JLabel jlable=new JLabel("����");
		this.add(jlable);
		//�����Լ���ͼƬ�����й��췽���п���ֱ�Ӵ�������·����������
		Icon image=new ImageIcon("C:\\Users\\Administrator\\Pictures\\�ز�\\101.jpg");
		JLabel jlabel=new JLabel(image);
		this.add(jlabel);
		//�����¼���
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//���ÿ���ʾ
		this.setVisible(true);
	}
}
package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
 * 1.�������
 * 2.��ӵ����
 * 3���������ӵ�����
 * 4.���ô�������
 */
public class JP_M extends JFrame{
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JLabel jlb1,jlb2,jlb3;
	JTextField jtf;
	JPasswordField jpw;
	public JP_M(){
		//�������
		jp1 =new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//��ǩ��
		jlb1=new JLabel("�˺�");
		jlb2=new JLabel("����");
		//��ť
		jb1=new JButton("��¼");
		jb2=new JButton("�˳�");
		//�ı����Ӧ�����ִ�����
		jtf=new JTextField(15);
		jpw=new JPasswordField(15);
		//���ñ�ǩ��ť����
		this.setLayout(new GridLayout(3,1));
		//��������Jpanel
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpw);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//��JPannel��ӵ�jFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//����JFrame
		this.setTitle("��¼����");
		this.setSize(300, 200);
		this.setLocation(300, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new JP_M();
	}

}

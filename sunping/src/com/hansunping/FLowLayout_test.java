package com.hansunping;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 1.�̳�JFrame;
 * 2.�������
 * 3.������� 
 * 4�������������ò��ֹ���
 * 5.��������
 * 6.��ʾ���壻
 */
public class FLowLayout_test extends JFrame {
	JButton jb1,jub2,jb3,jb4,jb5;
	public FLowLayout_test(){
		
		//�԰�ť����
		jb1=new JButton("��ťһ");
		//jb1.setSize(100,200);��Ч���ô�С��
		jub2=new JButton("��ť��");
		jb3=new JButton("��ť��");
		jb4=new JButton("��ť��");
		jb5=new JButton("��ť��");	
		//��Ӱ��
		this.add(jb1);
		this.add(jub2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		//������ʽ���ֿ������ð��Ǹ���ʽ����new FlowLayout(FlowLayout.LEADING)
		this.setLayout(new FlowLayout());
		//���ô���
		this.setTitle("��ʽ����");
		this.setSize(300, 400);
		this.setLocation(200, 200);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		//��ֹ�ı��С
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FLowLayout_test();
	}

}

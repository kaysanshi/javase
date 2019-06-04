package com.hansunping;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * 1.�̳�JFrame;
 * 2.�������
 * 3.�������
 * 4.�����������ò��ֹ���
 * 5.��������
 * 6.��ʾ���壻
 */
public class BorderLayOut extends JFrame{
	//�߽粼�ֹ�������
	JButton jb1,jb2,jb3,jb4,jb5;
	public  BorderLayOut(){
		jb1=new JButton("�в�");
		jb2=new JButton("����");
		jb3=new JButton("����");
		jb4=new JButton("����");
		jb5=new JButton("�ϲ�");
		//�м䲼�ֿ��Ըı䣻������δ����ʱ
		//�粻ָ��λ��ʱ��������һ��ʱ�ͻ����һ�������ǣ� 
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2, BorderLayout.SOUTH);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.WEST);
		this.setTitle("�߽粼��");
		this.setSize(500, 300);
		//��ʼλ��
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

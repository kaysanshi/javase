package com.hansunping;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * JPanel ���ʹ�÷���
 * ���������JButton,�Ѱ�ť���뵽Jpanel��壻ͬʱ�������ð�ťλ�ã�
 * �ڰ�Jpanel�����뵽JFrame��;
 */
public class JPanel_test extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public JPanel_test(){
		//�������
		//jpanelĬ��Ϊ������
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("jb1");
		jb2=new JButton("jb2");
		jb3=new JButton("jb3");
		jb4=new JButton("jb4");
		jb5=new JButton("jb5");
		jb6=new JButton("jb6");
		//���ò���
		
		//������
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		//��JPanel���뵽jFrame
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		this.add(jb6, BorderLayout.CENTER);
		//����JFrame����
		this.setTitle("JPanel�಼��");
		this.setSize(400, 500);
		this.setLocation(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JPanel_test();
	}
}

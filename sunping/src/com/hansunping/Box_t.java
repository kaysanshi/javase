package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
/*
 * ��ѡ��ѡ���Ӧ�ã�
 * 1�����������
 * 2.���ò���
 * 3.������Ⱥ
 * 4.������ӵ�JPanel
 * 5.��JPanel��ӵ�JFrame
 * 6.����JFrame������
 */
public class Box_t extends JFrame{
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JRadioButton jrb1,jrb2;//��ѡ�����
	JCheckBox jcb1,jcb2,jcb3;//��ѡ�����
	JButton jb1,jb2;//��ť
	public Box_t(){
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("��ϲ�����˶�");
		jcb1=new JCheckBox("����");
		jcb2=new JCheckBox("����");
		jcb3=new JCheckBox("ƹ����");
		
		jlb2=new JLabel("����Ա�");
		jrb1=new JRadioButton("��");
		jrb2=new JRadioButton("Ů");
		
		jb1=new JButton("ע���û�");
		jb2=new JButton("ȡ��ע��");
		//���ֹ�������
		this.setLayout(new GridLayout(3,1));
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//��������JPanel
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		//
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//
		this.setTitle("��ӭ��½");
		this.setSize(300, 250);
		this.setLocation(400, 350);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Box_t();
	}

}

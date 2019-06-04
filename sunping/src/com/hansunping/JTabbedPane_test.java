package com.hansunping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/*
 * qqҳ��Ŀ���
 * ѡ�����
 */
public class JTabbedPane_test extends JFrame {
	//�ϲ�����
	JPanel jp1;
	//��¼��ȡ���������
	JButton jb1,jb2,jb3;
	
	//���������ͼƬ
	JLabel jlb1;
	
	//�в�
	JTabbedPane jtp;//ѡ�����
	//qq���룬�ֻ��ţ����䣬
	JPanel jp2,jp3,jp4;
	//�˺ţ����룬�������룬������룬�������뱣��
	JLabel jlb2,jlb3,jlb4,jlb5;//��ǩ
	JTextField jtf;//�ı���
	JPasswordField jpw;//�����
	JButton jb4;
	//�����¼,��ס����
	JCheckBox jcb1,jcb2;//��ѡ��
	public JTabbedPane_test(){
		//�ϲ���
		jp1=new JPanel();
		jb1=new JButton("��¼");
		jb2=new JButton("ȡ��");
		jb3=new JButton("�����");
		//����
		jlb1=new JLabel(new ImageIcon("Image\\qqjiemain.jpg"));
		//�в���
		jlb2=new JLabel("�˺�",JLabel.CENTER);
		jlb3=new JLabel("����",JLabel.CENTER);
		jlb4=new JLabel("��������",JLabel.CENTER);
		jlb4.setFont(new Font("����",Font.PLAIN,15));
		jlb4.setForeground(Color.BLUE);
		jlb5=new JLabel("<html><s href='www.qq.com'>�������뱣��</s>");
		jlb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//��������
		
		jtf=new JTextField();
		jpw=new JPasswordField();
		jb4=new JButton(new ImageIcon("Image\\qq.jpg"));
		
		jcb1=new JCheckBox("�����¼");
		jcb2=new JCheckBox("��ס����");
		
		//�в��ɱ�����
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.BLACK);
		jp4=new JPanel();
		jp4.setBackground(Color.CYAN);
		//�в���ѡ���
		jtp.add("QQ����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("�����¼",jp4);
		//�����в��Ĳ���
		jp2.setLayout(new GridLayout(3,3));
		//��ӵ����yi�в���
//		jp2.add(jtp);
		jp2.add(jlb2);
		jp2.add(jtf);
		jp2.add(jlb4);
		jp2.add(jlb3);
		jp2.add(jpw);
		jp2.add(jlb5);
		jp2.add(jcb1);
		jp2.add(jcb2);
		//�в����ֻ���¼
		
	
		//�ϲ�
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		//��ӵ�JFrame;
		this.add(jp1,BorderLayout.SOUTH);
		this.add(jlb1,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		
		//���ô���
		this.setTitle("qq");
		this.setIconImage((new ImageIcon("Image\\qq.jpg")).getImage());
		this.setSize(450, 250);
		this.setLocation(650, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		new JTabbedPane_test();
	}
}

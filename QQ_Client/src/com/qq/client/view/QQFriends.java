package com.qq.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.qq.client.tools.ManageQQChat;

//�����б�;�õ����õĿ�Ƭ����CardLayout
public class QQFriends extends JFrame implements ActionListener,MouseListener{
	//��Ƭ����
	CardLayout cLayout;
	//�����б�
	JScrollPane jsp1;//����������jpanel;
	JButton jb1,jb2,jb3;
	JPanel jp1_1,jp1_2,jp1_3;//�ܵ�Japnel1,�ͷ�������ť��JPanel;
	//İ�����б�
	JPanel jp2_1,jp2_2,jp2_3;
	JButton jp2_jb1,jp2_jb2,jp2_jb3;
	JScrollPane jsp2;
	//�������б�;
	JPanel jp3_1,jp3_2,jp3_3;
	JButton jp3_jb1,jp3_jb2,jp3_jb3;
	JScrollPane jsp3;
	//�������а������Ĵ��JPanel;
	JPanel jPanel;
	String userId;
	//��Ƭһ
	public void card1() {
		jb1=new JButton("�ҵĺ���");
		jb1.addActionListener(this);
		jb2=new JButton("İ����");
		jb2.addActionListener(this);
		jb3=new JButton("������");
		jb3.addActionListener(this);
		jp1_1=new JPanel(new BorderLayout());
		jp1_2=new JPanel(new GridLayout(30,1,4,4));
		///
		JLabel[] jl1=new JLabel[30];
		for (int i = 0; i < jl1.length; i++) {
			jl1[i]=new JLabel(""+i,new ImageIcon("image\\haoyou.png"),JLabel.LEFT);
//			//���ò�����
//			jl1[i].setEnabled(false);
//			if (jl1[i].equals(userId)) {
//				jl1[i].setEnabled(true);
//			}
			jl1[i].addMouseListener(this);
			jp1_2.add(jl1[i]);
		}
		jp1_3=new JPanel(new GridLayout(2, 1));
		//��������ť����
		jp1_3.add(jb2);
		jp1_3.add(jb3);
		jsp1=new JScrollPane(jp1_2);
		//
		jp1_1.add(jb1,"North");
		jp1_1.add(jsp1,"Center");
		jp1_1.add(jp1_3,"South");
		
	}
	//��Ƭ��
	public void card2() {
		jp2_jb1=new JButton("�ҵĺ���");
		jp2_jb1.addActionListener(this);
		jp2_jb2=new JButton("İ����");
		jp2_jb2.addActionListener(this);
		jp2_jb3=new JButton("������");
		jp2_jb3.addActionListener(this);
		//�����һ�ſ�Ƭ
		jp2_1=new JPanel(new BorderLayout());
		jp2_2=new JPanel(new GridLayout(30,1,4,4));
		///
		JLabel[] jl2=new JLabel[20];
		for (int i = 0; i < jl2.length; i++) {
			jl2[i]=new JLabel(""+i,new ImageIcon("image\\moshengren.png"),JLabel.LEFT);
			jl2[i].addMouseListener(this);
			jp2_2.add(jl2[i]);
		}
		jp2_3=new JPanel(new GridLayout(2, 1));
		//��������ť����
		jp2_3.add(jp2_jb1);
		jp2_3.add(jp2_jb2);
		jsp2=new JScrollPane(jp2_2);
		//
		jp2_1.add(jp2_3,"North");
		jp2_1.add(jsp2,"Center");
		jp2_1.add(jp2_jb3,"South");
		
	}
	//��Ƭ��;
	public void card3(){
		jp3_jb1=new JButton("�ҵĺ���");
		jp3_jb1.addActionListener(this);
		jp3_jb2=new JButton("İ����");
		jp3_jb2.addActionListener(this);
		jp3_jb3=new JButton("������");
		jp3_jb3.addActionListener(this);
		//�����һ�ſ�Ƭ
		jp3_1=new JPanel(new BorderLayout());
		jp3_2=new JPanel(new GridLayout(30,1,4,4));
		///
		JLabel[] jl3=new JLabel[10];
		for (int i = 0; i < jl3.length; i++) {
			jl3[i]=new JLabel(""+i,new ImageIcon("image\\haoyou.png"),JLabel.LEFT);
			jl3[i].addMouseListener(this);
			jp3_2.add(jl3[i]);
		}
		jp3_3=new JPanel(new GridLayout(3, 1));
		//��������ť����
		jp3_3.add(jp3_jb1);
		jp3_3.add(jp3_jb2);
		jp3_3.add(jp3_jb3);
		jsp3=new JScrollPane(jp3_2);
		//
		jp3_1.add(jp3_3,"North");
		jp3_1.add(jsp3,"Center");
		
	}
	 public QQFriends(String userId) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.card1();
		this.card2();
		this.card3();
		
		//���ֳ�ʼ��;
		cLayout=new CardLayout();
		jPanel=new JPanel(cLayout);
		jPanel.add(jp1_1,"��Ƭ1");
		jPanel.add(jp2_1, "��Ƭ2");
		jPanel.add(jp3_1, "��Ƭ3");
		this.add(jPanel);
		this.setTitle(this.userId+" �����б�");
		this.setSize(300, 600);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new qq_Friends();
//	}
	//��Ƭ������Ҫ�����л�����Ҫ���ж�ȫ�����м���,����Ҫʵ��һ��ѭ���б�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jb1) {
			System.out.println("1");
			cLayout.show(jPanel,"��Ƭ1");
		}else if (e.getSource()==jb2) {	
			System.out.println("3");
			cLayout.show(jPanel,"��Ƭ2");
		}else if (e.getSource()==jb3) {
			System.out.println("2");
			cLayout.show(jPanel,"��Ƭ3");	
		}else if (e.getSource()==jp2_jb1){
			System.out.println("0");
			cLayout.show(jPanel,"��Ƭ1");
		}else if(e.getSource()==jp2_jb2){
			cLayout.show(jPanel,"��Ƭ2");
		}else if (e.getSource()==jp2_jb3){
			System.out.println("0");
			cLayout.show(jPanel,"��Ƭ3");
		}else if(e.getSource()==jp3_jb1){
			cLayout.show(jPanel,"��Ƭ1");
		}else if (e.getSource()==jp3_jb2){
			System.out.println("0");
			cLayout.show(jPanel,"��Ƭ2");
		}else if(e.getSource()==jp3_jb3){
			cLayout.show(jPanel,"��Ƭ3");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount()==2) {
			System.out.println("��������");
			JLabel number =(JLabel)e.getSource();  
			String friend=number.getText();
			System.out.println("��Ҫ��:"+friend+"����");
			QQChat QQ =new QQChat(this.userId,friend);
			//������ļ��뵽���������
			ManageQQChat.addQQChat(this.userId+" "+friend, QQ);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//��������������ɫ;
		// TODO Auto-generated method stub
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.BLUE);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//������뿪�����ɫ;
		JLabel jLabel=(JLabel)e.getSource();
		jLabel.setForeground(Color.black);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

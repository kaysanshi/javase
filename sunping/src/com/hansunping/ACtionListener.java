package com.hansunping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ACtionListener extends JFrame{
	JPanel jp;
	JButton jb1,jb2;
	public ACtionListener(){
		jp=new JPanel();
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		
		jb1.addActionListener(new myActionListener());
		jb1.setActionCommand("��ɫ");
		jb2.addActionListener(new myActionListener());
		jb2.setActionCommand("��ɫ");
		
		jp.setBackground(Color.BLUE);
		this.add(jp);
		this.add(jb1,BorderLayout.SOUTH);
		this.add(jb2, BorderLayout.NORTH);
		this.setTitle("����");
		this.setSize(300, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
//��ʵ���������Ӧ����JPanel�У��ð��°�ť�ķ����д�������Ķ���
class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("��ɫ")){
				System.out.println("��ɫ��ť����");
				jp.setBackground(Color.BLACK);
			}else if(e.getActionCommand().equals("��ɫ")){
				System.out.println("��ɫ��ť����");
				jp.setBackground(Color.RED);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ACtionListener();
	}

}



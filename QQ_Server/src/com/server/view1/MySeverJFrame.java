package com.server.view1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.server.model.MyQqServer;
//����һ���������Ĵ���
public class MySeverJFrame extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1,jb2;
	public MySeverJFrame() {
		// TODO Auto-generated constructor stub
		jp1=new JPanel();
		jb1=new JButton("����������");
		jb1.addActionListener(this);
		jb1.setActionCommand("kaishi");
		jb2=new JButton("�رշ�����");
		jb2.addActionListener(this);
		jb2.setActionCommand("guanbi");
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1);
		this.setTitle("����������");
		this.setSize(500,400);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MySeverJFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("kaishi")) {
			MyQqServer ms=new MyQqServer();
		}else if (e.getActionCommand().equals("guanbi")) {
			this.dispose();
		}
	}
}

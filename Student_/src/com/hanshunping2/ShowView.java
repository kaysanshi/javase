package com.hanshunping2;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ShowView extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2,jb3;
	JTextField jtf;
	JPasswordField jps;

public ShowView(){
	this.setLayout(null);
	this.setBounds(0, 0, 360, 300);
	jl1=new JLabel("�������˺�:");
	jtf=new JTextField(10);
	//���Բ��ֵ����÷�ʽ
	jl1.setBounds(50, 50, 150, 30);
	jtf.setBounds(130, 50, 150, 30);
	this.add(jl1);
	this.add(jtf);
	jl2=new JLabel("����������:");
	jps=new JPasswordField(10);
	jl2.setBounds(50, 100, 150, 30);
	jps.setBounds(130, 100, 150, 30);
	this.add(jl2);
	this.add(jps);
	jb1=new JButton("��¼");
	jb1.addActionListener(this);
	jb1.setActionCommand("denglu");
	jb2=new JButton("ȡ��");
	jb3=new JButton("ע��");
	jb3.addActionListener(this);
	jb3.setActionCommand("zhuce");
	jb3.setBounds(30, 180,70, 35);
	jb2.setBounds(140, 180, 70, 35);
	jb1.setBounds(240, 180,70, 35);
	this.add(jb1);
	this.add(jb2);
	this.add(jb3);
	jl3=new JLabel("��ӭ����ѧ������ϵͳ");
	jl3.setBounds(50,10, 300, 30);
	jl3.setFont(new Font("������κ",Font.BOLD,20));
	this.add(jl3);
	this.setSize(360,300);
	int weight=Toolkit.getDefaultToolkit().getScreenSize().width;//��ȡ��Ļ�ĳ�
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ��Ļ�ĸߣ�
	//��ʼλ�ã�
	this.setLocation(weight/2-200, height/2-150);
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
	this.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("denglu")){
		if(jtf.getText().equals("123")&&jps.getText().equals("123")){
			Student s=new Student();
			this.dispose();
	}else{
		JOptionPane.showMessageDialog(this, "��������ȷ������");
		}
	}
	if(e.getSource().equals("zhuce")){
		
	}
}

public static void main(String[] args) {
	new ShowView();
}

}

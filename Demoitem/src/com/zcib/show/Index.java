package com.zcib.show;

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

import com.zcib.controller.Manager;
import com.zcib.model.UserModel;
public class Index extends JFrame implements ActionListener{
	/*
	 * ��ҳ��Ŀ���
	 * 1.������Ϣ��ĳ�ʼ��:manager--->goodsmodel--->db
	 * 2.��¼����֤:manager--->usermodel-->db
	 */
	private static final long serialVersionUID = 1L;
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2,jb3;
	JTextField jtf;
	JPasswordField jps;
	public Index(){
		this.setLayout(null);
		this.setBounds(0, 0, 460, 350);
		jl1=new JLabel("�������˺�:");
		jtf=new JTextField(10);
		//���Բ��ֵ����÷�ʽ
		jl1.setBounds(80, 80, 150, 30);
		jtf.setBounds(160, 80, 150, 30);
		this.add(jl1);
		this.add(jtf);
		jl2=new JLabel("����������:");
		jps=new JPasswordField(10);
		jl2.setBounds(80, 150, 150, 30);
		jps.setBounds(160, 150, 150, 30);
		this.add(jl2);
		this.add(jps);
		jb1=new JButton("��¼");
		jb1.addActionListener(this);
		jb1.setActionCommand("denglu");
		jb2=new JButton("ȡ��");
		jb3=new JButton("ע��");
		jb3.addActionListener(this);
		jb3.setActionCommand("zhuce");
		jb3.setBounds(50, 250,70, 35);
		jb2.setBounds(170, 250, 70, 35);
		jb1.setBounds(280, 250,70, 35);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3); 
		jl3=new JLabel("��ӭ������ϵͳ");
		jl3.setBounds(100,30, 300, 40);
		jl3.setFont(new Font("������κ",Font.BOLD,30));
		this.add(jl3);
		this.setSize(460,350);
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
	//�¼���ʹ��
@Override 
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("denglu")){
		String userId=jtf.getText().trim();
		String userpd=new String( this.jps.getPassword());
		UserModel uModel=new UserModel();
		if(uModel.checkUser(userId, userpd)){
			//JOptionPane.showMessageDialog(this, "�������������ȷ׼������ϵͳ");
			Manager manager=new Manager();
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "����������벻��ȷ����������");
		}
	}else if(e.getActionCommand().equals("zhuce")){
		String useId=jtf.getText().trim();
		String usepd=new String( this.jps.getPassword());
		UserModel user=new UserModel();
		System.out.println("��ʼע��");
		if(user.addUser(useId, usepd)){
			//����ʾ��:
			JOptionPane.showMessageDialog(this, "����ע��ɹ����Խ��е�¼");
		}else{
			JOptionPane.showMessageDialog(this, "ע��ʧ�������ע��");
		}	
	}else{
		JOptionPane.showMessageDialog(this, "����ȡ����¼");
		}
}

public static void main(String[] args) {
	new Index();
}
}


package com.qq.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.qq.client.model.QQClientUser;
import com.qq.common.User;

//qq����Ŀ���:
//��Ҫ�õ�JTabbedPane����ѡ����
public class QQJFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�ϲ�
	JButton jb1,jb2;
	//�в�
	JPanel jp1,jp2,jp3,jp4;
	JLabel jl2,jl3,jl4,jl5;
	JTabbedPane jtp;
	public JTextField jtf;
	public JPasswordField jpf;
	JCheckBox jbBox1,jBox2;
	///�ڶ�������
	JLabel jp2_jl2,jp2_jl3,jp2_jl4,jp2_jl5;
	JTabbedPane jp2_jtp;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jbBox1,jp2_jBox2;
	//����������
	JLabel jp3_jl2,jp3_jl3,jp3_jl4,jp3_jl5;
	JTabbedPane jp3_jtp;
	JTextField jp3_jtf;
	JPasswordField jp3_jpf;
	JCheckBox jp3_jbBox1,jp3_jBox2;
	//����
	JLabel jl1;
	
	public QQJFrame() {
		// TODO Auto-generated constructor stub
		//����;
		jl1=new JLabel(new ImageIcon("image\\QQ_J.png"));
		//�ϲ�
		jb1=new JButton("��¼");
		jb1.addActionListener(this);
		jb1.setActionCommand("login");
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		jb2.setActionCommand("exit");
		//�в�
		jl2=new JLabel("QQ����",JLabel.CENTER);
		jl3=new JLabel("QQ����",JLabel.CENTER);
		jl4=new JLabel("��������",JLabel.CENTER);
		jl4.setFont(new Font("����",Font.PLAIN,15));
		jl4.setForeground(Color.BLUE);
		jl5=new JLabel("<html><s href='www.qq.com'>�������뱣��</s>");
		jbBox1=new JCheckBox("�����¼");
		jBox2=new JCheckBox("��ס����");
		jtf=new JTextField();
		jpf=new JPasswordField();
		///��ӵ��в��Ĳ���
		
		
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(3,3));
		jp1.add(jl2);
		jp1.add(jtf);
		jp1.add(jl4);
		jp1.add(jl3);
		jp1.add(jpf);
		jp1.add(jl5);
		jp1.add(jbBox1);
		jp1.add(jBox2);
		/////////////////////�ڶ������
		jp2_jl2=new JLabel("�ֻ�����",JLabel.CENTER);
		jp2_jl3=new JLabel("QQ����",JLabel.CENTER);
		jp2_jl4=new JLabel("��������",JLabel.CENTER);
		jp2_jl4.setFont(new Font("����",Font.PLAIN,15));
		jp2_jl4.setForeground(Color.BLUE);
		jp2_jl5=new JLabel("<html><s href='www.qq.com'>�������뱣��</s>");
		jp2_jbBox1=new JCheckBox("�����¼");
		jp2_jBox2=new JCheckBox("��ס����");
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		///��ӵ��ڶ�������е����
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(3,3));
		jp2.add(jp2_jl2);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jl4);
		jp2.add(jp2_jl3);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jl5);
		jp2.add(jp2_jbBox1);
		jp2.add(jp2_jBox2);
		////////////////////////////������ѡ����
		jp3_jl2=new JLabel("�������",JLabel.CENTER);
		jp3_jl3=new JLabel("��������",JLabel.CENTER);
		jp3_jl4=new JLabel("��������",JLabel.CENTER);
		jp3_jl4.setFont(new Font("����",Font.PLAIN,15));
		jp3_jl4.setForeground(Color.BLUE);
		jp3_jl5=new JLabel("<html><s href='www.qq.com'>�������뱣��</s>");
		jp3_jbBox1=new JCheckBox("�����¼");
		jp3_jBox2=new JCheckBox("��ס����");
		jp3_jtf=new JTextField();
		jp3_jpf=new JPasswordField();
		///��ӵ��в��Ĳ���
		jp3=new JPanel();
		jp3.setLayout(new GridLayout(3,3));
		jp3.add(jp3_jl2);
		jp3.add(jp3_jtf);
		jp3.add(jp3_jl4);
		jp3.add(jp3_jl3);
		jp3.add(jp3_jpf);
		jp3.add(jp3_jl5);
		jp3.add(jp3_jbBox1);
		jp3.add(jp3_jBox2);
		///////
		jtp=new JTabbedPane();//ѡ����
		jtp.add("QQ�����¼", jp1);
		jtp.add("�ֻ���¼",jp2);
		jtp.add("�����¼",jp3);
		//��ӵ��ϲ���JPanel4��
		jp4=new JPanel();
		jp4.add(jb1);
		jp4.add(jb2);
		///
		this.add(jp4,BorderLayout.SOUTH);
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp, BorderLayout.CENTER);
		this.setTitle("QQ");
		this.setIconImage(new ImageIcon("image\\qq.jpg").getImage());
		this.setLocation(400,300);
		this.setSize(540, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	///////
	public static void main(String[] args) {
		new QQJFrame();
	}
	/////////
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("login")){
			System.out.println("���");
			QQClientUser qqc=new QQClientUser();
			User user=new User();
			user.setId(jtf.getText());
			user.setPassward(new String(jpf.getPassword()));
			System.out.println(user.getId()+","+user.getPassward());
			//new qq_Friends(user.getId());
			//false;�ж�Ϊ��;
			if (qqc.CheckUser(user)){
				new QQFriends(user.getId());
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "������������Ĳ���ȷ");
			}
			
		}else if(e.getActionCommand().equals("exit")){
			this.dispose();
		}
	}
}

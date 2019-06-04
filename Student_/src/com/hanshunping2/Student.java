package com.hanshunping2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//model1ģʽ:
public class Student extends JFrame implements ActionListener{
	//�������
	JPanel jp1,jp2;
	JLabel jl1; 
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	
	StudentModel sm=null;
	//�����������JDBC���õĽӿ�
	Connection conn=null;//���ض����ݿ������
	Statement stmt=null;//���ڴ������ݿ���SQL������Ĵ���
	PreparedStatement pst=null;//�̳���Statement�ӿ�����ִ�ж�̬��sql��䣻
	
	//
	public Student(){
		jp1=new JPanel();
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("����������");
		//�ϲ�
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		//�в�
		
		//�²�
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
		
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//��������ģ�Ͷ���
		StudentModel sm=new StudentModel();
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	//��������ִ����Ӧ�Ĳ�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="chaxun"){
			System.out.println("��ѯ");
			//���ݷ�װ��ģ�����Ժ���Լ򵥵Ĳ�ѯ��
			String name=this.jtf.getText().trim();
			//sql���
			String sql="select * from stu where stuName='"+name+"'";
			//�����µ�����ģ��
			sm=new StudentModel(sql);
			jt.setModel(sm);
		}else if(e.getActionCommand()=="tianjia"){
			 StudentAddDiolag sa=new StudentAddDiolag(this,"���ѧ��",true);
			//�����µ�����ģ��
				sm=new StudentModel(); 
				jt.setModel(sm);
		}else if(e.getActionCommand()=="xiugai"){
			System.out.println("1233");
			//��ѡ��һ��
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			StudentUpDialog su= new StudentUpDialog(this,"�޸�",true,sm,rowNum);
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand()=="shanchu"){
			//���ȱ���Ҫѡ��һ��
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			String stuId=(String)sm.getValueAt(rowNum, 0);
			//System.out.println("Id="+"id");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/Student?user=root&password=123";
				conn= DriverManager.getConnection(url);
				//����һ������
				stmt=conn.createStatement();
				//Ԥ�������
				pst=conn.prepareStatement("delete from stu where stuId=?");
				//PreparedStatement�еķ���������ֵ���óɸ�������ֵ����
				pst.setString(1, stuId);
				//ִ���ڸ�SQL���PreparedStatement������������һ��SQL���ݲ������ԣ�DML�����
				//��INSERT �� UPDATE��DELETE ; �򲻷����κ����ݵ�SQL��䣬
				pst.executeUpdate();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					if(pst!=null){
					pst.close();
					}
					if(stmt!=null){
						stmt.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//���½��棻
			sm=new StudentModel(); 
			jt.setModel(sm);
		}
	}
	
	
	public static void main(String[] args) {
		Student s=new Student();
	}
}

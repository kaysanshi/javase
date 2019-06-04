package com.hanshunping2;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/*
 * �޸ĸ��´��룻����һ���Ի��򣬲�ʵ�ּ���ģʽ��
 */
public class StudentUpDialog extends JDialog implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
//	JTable jt;
	//JScrollPane jsp;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	public StudentUpDialog(Frame owner,String title,boolean modal,StudentModel sm,int rowNums){
		super(owner,title,modal);

		jl1=new JLabel("ѧ��");
		jl2=new JLabel("����");
		jl3=new JLabel("�Ա�");
		jl4=new JLabel("����");
		jl5=new JLabel("ϵ��");
		jl6=new JLabel("��ַ");
		
		jtf1=new JTextField();
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		//���������޸�
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums,1));
		jtf3=new JTextField();
		jtf3.setText(sm.getValueAt(rowNums,2)+"");
		jtf4=new JTextField();
		jtf4.setText(sm.getValueAt(rowNums, 3)+"");
		jtf5=new JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums,4));
		jtf6=new JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums, 5));
		
		jb1=new JButton("�޸�");
		jb1.addActionListener(this);
		jb1.setActionCommand("xiugai1");
		
		jb2=new JButton("ȡ��");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//���ò���
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
	
		
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setLocation(500,400);
		this.setSize(400,250);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="xiugai1"){
			//�������ݿ���
			Connection conn=null;
			Statement stmt=null;
			PreparedStatement pst=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student?user=root&password=root";
			conn=  DriverManager.getConnection(url);
			//����һ������
			stmt=conn.createStatement();
			String sql="update stu set stuName=?,"
					+ "stuSex=?,stuAge=?,stuDept=? ,stuAddress=? where stuId=?";
			
			
			pst=conn.prepareStatement(sql);
			System.out.println("1");
			//��������ֵ��
			pst.setString(1, jtf2.getText());
			pst.setString(2, jtf3.getText());
			pst.setString(3, jtf4.getText());
			pst.setString(4, jtf5.getText());
			pst.setString(5, jtf6.getText());
			pst.setString(6, jtf1.getText());
			
			System.out.println("2");
			//ִ��Sql���
			pst.executeUpdate();
			System.out.println("3");
//			pst.executeQuery();
			//conn.close();
			this.dispose();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("cuowu");
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
			
		}
		
	}

}
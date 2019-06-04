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
//model1模式:
public class Student extends JFrame implements ActionListener{
	//定义组件
	JPanel jp1,jp2;
	JLabel jl1; 
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	
	StudentModel sm=null;
	//下面的三个是JDBC常用的接口
	Connection conn=null;//与特定数据库的链接
	Statement stmt=null;//用于创建数据库中SQL语句对象的传递
	PreparedStatement pst=null;//继承于Statement接口用于执行动态的sql语句；
	
	//
	public Student(){
		jp1=new JPanel();
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("请输入名字");
		//上部
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		//中部
		
		//下部
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
		
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//创建数据模型对象
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
	//接受命令执行相应的操作；
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="chaxun"){
			System.out.println("查询");
			//数据封装到模型中以后可以简单的查询了
			String name=this.jtf.getText().trim();
			//sql语句
			String sql="select * from stu where stuName='"+name+"'";
			//构建新的数据模型
			sm=new StudentModel(sql);
			jt.setModel(sm);
		}else if(e.getActionCommand()=="tianjia"){
			 StudentAddDiolag sa=new StudentAddDiolag(this,"添加学生",true);
			//构建新的数据模型
				sm=new StudentModel(); 
				jt.setModel(sm);
		}else if(e.getActionCommand()=="xiugai"){
			System.out.println("1233");
			//先选中一行
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选中一行");
				return;
			}
			//显示修改对话框
			StudentUpDialog su= new StudentUpDialog(this,"修改",true,sm,rowNum);
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand()=="shanchu"){
			//首先必须要选中一行
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this,"请选中一行");
				return;
			}
			String stuId=(String)sm.getValueAt(rowNum, 0);
			//System.out.println("Id="+"id");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/Student?user=root&password=123";
				conn= DriverManager.getConnection(url);
				//创建一个对象
				stmt=conn.createStatement();
				//预处理对象
				pst=conn.prepareStatement("delete from stu where stuId=?");
				//PreparedStatement中的方法将参数值设置成给定的数值对象
				pst.setString(1, stuId);
				//执行在该SQL语句PreparedStatement对象，它必须是一个SQL数据操纵语言（DML）语句
				//如INSERT ， UPDATE或DELETE ; 或不返回任何内容的SQL语句，
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
			//更新界面；
			sm=new StudentModel(); 
			jt.setModel(sm);
		}
	}
	
	
	public static void main(String[] args) {
		Student s=new Student();
	}
}

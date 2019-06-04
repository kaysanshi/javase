package com.hanshunping3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hanshunping2.StudentAddDiolag;
import com.hanshunping2.StudentModel;
import com.hanshunping2.StudentUpDialog;
//model2模式,后台和操作分离;
public class Student extends JFrame implements ActionListener{
	
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5;
	JScrollPane jsp;
	JTable jt;
	StudentModel sm=null;
	//
	public Student(){
		jp1=new JPanel();
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("请输入姓名");
		jtf=new JTextField(10);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
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
		jb5=new JButton("刷新");
		jb5.addActionListener(this);
		jb5.setActionCommand("shuaxin");
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		StudentModel sm=new StudentModel();
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("学生信息管理");
		this.setSize(400, 300);
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
		if(e.getActionCommand().equals("chaxun")){
			System.out.println("查询");
			//数据封装到模型中以后可以简单的查询了
			String name=this.jtf.getText().trim();
			//sql语句
			String sql="select * from stu where stuName='"+name+"'";
			//构建新的数据模型
			sm=new StudentModel(sql);
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("修改");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//显示修改对话框
			stuUpdialog su= new stuUpdialog(this,"修改",true,sm,rowNum);
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("shanchu")){
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			String stuId=(String)sm.getValueAt(rowNum, 0);
			String sql="delete from stu where stuId= ?";
			String []pares={stuId};
			StuModel temp=new StuModel();
			temp.upStu(sql,pares);
			
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("tianjia")){
			 StudentAddDiolag sa=new StudentAddDiolag(this,"添加学生",true);
				//构建新的数据模型
					sm=new StudentModel(); 
					jt.setModel(sm);
		}else if(e.getActionCommand().equals("shuaxin")){
			sm=new StudentModel(); 
			jt.setModel(sm);
		}
	}
	public static void main(String[] args) {
		Student s=new Student();
	}

}

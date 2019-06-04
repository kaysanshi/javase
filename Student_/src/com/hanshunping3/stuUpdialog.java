package com.hanshunping3;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hanshunping2.StudentModel;

public class stuUpdialog extends JDialog implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
//	JTable jt;
	//JScrollPane jsp;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	public stuUpdialog(Frame owner,String title,boolean modal,StudentModel sm,int rowNums){
		super(owner,title,modal);

		jl1=new JLabel("学号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		jl5=new JLabel("系别");
		jl6=new JLabel("地址");
		
		jtf1=new JTextField();
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		//主键不能修改
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
		
		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb1.setActionCommand("xiugai1");
		
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//设置布局
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
			
			String sql="update stu set stuName=?,"
					+ "stuSex=?,stuAge=?,stuDept=? ,stuAddress=? where stuId=?";
			String []pares={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
			StuModel temp=new StuModel();
			temp.upStu(sql, pares);
			this.dispose();
		}
		
	}

}


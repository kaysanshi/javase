package com.mhl.view;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;
//添加界面
public class AddEmpDialog extends JDialog implements ActionListener{

	JPanel p1,p2,p3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JButton jb1,jb2;
	
	public AddEmpDialog(EmpInfo empInfo,String title,boolean model)
	{
		//super(empInfo,title,model);
		p1=new JPanel(new GridLayout(6,1));
		jl1=new JLabel("empid");
		jl2=new JLabel("empname");
		jl3=new JLabel("sex");
		jl4=new JLabel("zhiwei");
		jl5=new JLabel("address");
		jl6=new JLabel("xl");
		p1.add(jl1);
		p1.add(jl2);
		p1.add(jl3);
		p1.add(jl4);
		p1.add(jl5);
		p1.add(jl6);
		p2=new JPanel(new GridLayout(6,1));
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		p2.add(jtf1);
		p2.add(jtf2);
		p2.add(jtf3);
		p2.add(jtf4);
		p2.add(jtf5);
		p2.add(jtf6);
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("添加");
		jb1.setFont(MyTools.f4);
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.setFont(MyTools.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(p1,"West");
		this.add(p2,"Center");
		this.add(p3,"South");
		

		this.setSize(400,250);

		this.setTitle("添加员工");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource()==jb1)
		{
			String sql="insert into rszl(empid,empname,sex,zhiwei,address,xl) values(?,?,?,?,?,?)";
			String []params={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText()};
			EmpModel em=new EmpModel();
			if(!em.UpdateModel(sql, params))
			{
				JOptionPane.showMessageDialog(null, "添加失败，请输入正确数据类型！");
			}
			JOptionPane.showMessageDialog(null, "恭喜！添加成功！");
			this.dispose();
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
	
	
	
}

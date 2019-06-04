package com.mhl.view;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;
//添加界面

public class UpdLoginDialog extends JDialog implements ActionListener{

	JPanel p1,p2,p3;
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1,jb2;
	public UpdLoginDialog(EmpLogin empInfo,String title,boolean model,EmpModel em,int rowNum)
	{
		super();
		p1=new JPanel(new GridLayout(2,1));
		jl1=new JLabel("empid");
		jl2=new JLabel("empname");
		
		p1.add(jl1);
		p1.add(jl2);
		
		p2=new JPanel(new GridLayout(2,1));
		jtf1=new JTextField();
		jtf1.setText(em.getValueAt(rowNum, 0)+"");
		jtf1.setEditable(false);
		//System.out.println(em.getValueAt(rowNum, 0)+"");
		jtf2=new JTextField();
		jtf2.setText( em.getValueAt(rowNum, 2)+"");
		
		p2.add(jtf1);
		p2.add(jtf2);
		
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("修改");
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
		

		this.setSize(400,150);

		this.setTitle("修改登陆信息");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource()==jb1)
		{
//			String empId=jtf1.getText();
			String sql="update login set passwd=? where empid=?";
			String []params={jtf2.getText(),jtf1.getText()};
			EmpModel em=new EmpModel();
			if(!em.UpdateModel(sql, params))
			{
				JOptionPane.showMessageDialog(null, "修改失败，请输入正确数据类型!");
			}
			JOptionPane.showMessageDialog(null, "恭喜！修改成功！");
			this.dispose();
			
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
	
	
	
}

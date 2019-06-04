package com.mhl.view2;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JDialog;

import com.mhl.model.*;
import com.mhl.tools.MyTools;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
//添加界面
public class AccountDetail extends JDialog implements ActionListener{

	JPanel p1,p2,p3;
	JLabel jl1,jl2;
	JTable table;
	JScrollPane jsp;
	JButton jb1,jb2;
	String deskid,bookid;
	EmpModel em;
	public AccountDetail(Accounts a)
	{

		
		super();
		deskid=a.jtf1.getText().trim();
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jl1=new JLabel("您的消费情况如下：");
		p1.add(jl1);
		p2=new JPanel(new BorderLayout());
		String sql="select bookid from bookdish where deskid=?";
		String[]params={deskid};
		OrderModel om=new OrderModel();
		bookid=om.query(sql, params);
		
		//System.out.print(bookid);
		String sql1="select bookdetail.foodid,foodname,foodnum,price from bookdetail,menu where menu.foodid=bookdetail.foodid and bookid=?";
		String[]params1={bookid};
		em=new EmpModel();
		em.query(sql1, params1);
		table=new JTable(em);
		//table.setModel(em);
		jsp=new JScrollPane(table);
		p2.add(jsp);
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("结账");
		jb1.setFont(MyTools.f4);
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.setFont(MyTools.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p3,"South");
		

		this.setSize(600,400);

		this.setTitle("结账");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getSource()==jb1)
		{
			
			int row=this.table.getRowCount();
//			System.out.print(row);

			String []num=new String[row];
			String []price=new String[row];
			int sum=0;
			for(int i=0;i<row;i++)
			{
				
//				String foodId=(String)this.table.getValueAt(i, 3);
//				System.out.print(foodId);
				price[i]=(String)this.table.getValueAt(i,3);
				num[i]=(String)this.table.getValueAt(i,2);
				sum+=(Integer.valueOf(num[i])).intValue()*(Float.valueOf(price[i]).floatValue());
//				price[i]=Float.valueOf(String.valueOf(this.table.getValueAt(i, 3))).floatValue();
//						
//				num[i]=Integer.valueOf(String.valueOf(this.table.getValueAt(i, 2))).intValue();
//				
//				sum+=Integer.valueOf(String.valueOf(num[i]*price[i])).intValue();
			}
			OrderModel em=new OrderModel();
			String []params={deskid};
			String sql="update status set deskstatus=2 where deskid=?";
			em.UpdateModel(sql, params);
			String sql2="delete from bookdish where deskid=?";
			em.UpdateModel(sql2, params);
			JOptionPane.showMessageDialog(this, "消费总金额为："+sum+"元");
			this.dispose();
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
	
	
	
}



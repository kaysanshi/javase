package com.zcib.show;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.zcib.controller.InStorageManage;
import com.zcib.db.SqlHelp;
import com.zcib.model.GoodsModel;
import com.zcib.model.InStorageModel;
import com.zcib.util.TDate;

import jdk.nashorn.internal.objects.annotations.Where;
import sun.text.resources.cldr.om.FormatData_om;
//增加库存量
public class InStorage extends JDialog implements ActionListener{
	/*
	 * 这里需要把数据库里的信息读出来,然后显示到页面中
	 * 1.需检查读出的信息 是否匹配输入的信息,进行验证;
	 * 2.入库编号自动生成;
	 */
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JButton jb1,jb2;
	//JTable jt;
	//JScrollPane jsp;
	JComboBox jcb;
	SqlHelp sHelp=new SqlHelp();
	ResultSet set;
	List list;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	 public InStorage(InStorageManage Manager,String title,boolean modal){
		super(Manager,title,modal);
		TDate date=new TDate();
		jl1=new JLabel("入库编号");
		jl2=new JLabel("物品编号");
		jl3=new JLabel("名称");
		jl4=new JLabel("入库量");
		jl5=new JLabel("现库存量");
		jl6=new JLabel("操作员");
		jl7=new JLabel("入库时间");
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		jtf7=new JTextField();
		
		
		jb1=new JButton("确定");
		jb2=new JButton("取消");
		jb1.setActionCommand("queding");
		jb1.addActionListener(this);
		jb2.setActionCommand("quxiao");
		jb2.addActionListener(this);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//设置布局
		jp1.setLayout(new GridLayout(7,1));
		jp2.setLayout(new GridLayout(7,1));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jtf1.setText("此项不需要添加");
		jp2.add(jtf1);
		jp2.add(jtf2);
		//jp2.add(jcb);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jtf7.setText(date.getdate());
		jp2.add(jtf7);
		
		jp3.add(jb1);
		jp3.add(jb2);
	
		//布局设置
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setLocation(500,400);
		this.setSize(500,350);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("queding")){
			////通过读取出来的是一个list集合,集合中其实嵌套了一个map集合;
			InStorageModel temp=new InStorageModel();
			String sql1="select id ,name from goods where 1=?";
			String[]paras={"1"};
			set=sHelp.queryExectue(sql1, paras);
			try {
				list=sHelp.RSToList(set);
				//System.out.println(list);
				//System.out.println(list.listIterator().next().toString());
				int flag=1;
				for(Iterator it=list.iterator();it.hasNext();){	
				if(("{name="+jtf3.getText()+", id="+jtf2.getText()+"}").equals(it.next().toString())){
					System.out.println("可以入库");
					//jtf5.setText(jtf4.getText()+sHelp.queryExectue("select amount from goods where 1=?" ,paras));
					String sql="insert into instorage(gid,name,incount,count,person,date) values(?,?,?,?,?,?)";
					String[] pares={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText()};
					if(temp.upInStorage(sql, pares)){
						JOptionPane.showMessageDialog(this, "入库成功");
						/*
						 * 相应的基本信息表只中的信息也要改变;
						 */
						String string=jtf5.getText();
						String st="'"+jtf2.getText()+"'";
						GoodsModel gM=new GoodsModel();
						String sql11="update  goods set amount =? where id="+st;
						String [] paras1={string};
						gM.upGoods(sql11, paras1);
					}else{
						JOptionPane.showMessageDialog(this, "入库失败");
						}
						this.dispose();
						break;
					}else {
						flag++;
						if(flag==list.size()){
						JOptionPane.showMessageDialog(this, "没有这类物品的基本信息,请返回添加");}
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("quxiao")){
			this.dispose();
		}
	}
}

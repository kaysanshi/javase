package com.zcib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.zcib.model.OutStorageModel;
import com.zcib.show.OutStorage;
import com.zcib.show.OutStorageAdd;
import com.zcib.show.Read;
//出库管理

public class OutStorageManage extends JDialog implements ActionListener{
/*
 * 1.首先的话出库的表应该与入库表和基本的表有关系,如果出库表能够和入库的基本表连系紧密就更好了;
 * 2.从基本表中的数据导入到出库表中的数据,而且还有和入库表中的数据一一对应;
 * 3.出库编号:由数据库中的自增控制;
 * 查询:模糊查询(未实现)
 */
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JScrollPane jsp;
	JTable jt;
	OutStorageModel osm=null;
	//初始化
	public OutStorageManage (){
		jp1=new JPanel();
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("请输入名称");
		jtf=new JTextField(10);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("添加出库单");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		jb3=new JButton("修改出库单");
		jb3.addActionListener(this);
		jb3.setActionCommand("chuku");
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jb5=new JButton("返回上一级");
		jb5.addActionListener(this);
		jb5.setActionCommand("return");
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		//对模型初始化
		osm=new OutStorageModel();
		/*
		 * 把基本表的信息读入到出库表{未实现}
		 */
		//OutStorageinput osi=new OutStorageinput();
		String[] paras={"1"};
		osm.queryOutStorage("select*from outstorage where 1=?", paras);
		jt=new JTable(osm);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("出库操作");
		this.setLocation(600, 200);
		this.setSize(650, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	//事件的回应;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("chaxun")){
			
			System.out.println("查询");
			//数据封装到模型中以后可以简单的查询了
			String name=this.jtf.getText().trim();
			//sql语句
			String sql="select * from outstorage where name like ?  order by id limit 0,5";
			//构建新的数据模型
			String[] paras={"%"+name+"%"};
			osm=new OutStorageModel();
			osm.queryOutStorage(sql, paras);
			jt.setModel(osm);
			if(osm.toString().equals("")){
				JOptionPane.showMessageDialog(this, "没有此类物品,请重新输入查询");
			}
		}else if(e.getActionCommand().equals("chuku")){
			System.out.println("出库");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//显示出库对话框
			OutStorage uv= new OutStorage(this,"出库",osm,true,rowNum);
			osm=new OutStorageModel();
			String []paras2={"1"};
			osm.queryOutStorage("select*from outstorage where 1=?", paras2);
			jt.setModel(osm);
		}else if(e.getActionCommand().equals("shanchu")){
			//删除整行;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			String Id=osm.getValueAt(rowNum, 0)+"";
			String sql="delete from outstorage where id= ?";
			String []paras={Id};
			OutStorageModel osm=new OutStorageModel();
			osm.upOutStorage(sql, paras);
			
			osm=new OutStorageModel();
			String []paras2={"1"};
			osm.queryOutStorage("select*from outstorage where 1=?", paras2);
			jt.setModel(osm);
		}else if(e.getActionCommand().equals("tianjia")){
			OutStorageAdd osA=new OutStorageAdd(this, "出库表增加", true);
			//构建新的数据模型
			osm=new OutStorageModel();
			String []paras2={"1"};
			osm.queryOutStorage("select*from outstorage where 1=?", paras2);
			jt.setModel(osm);
			 
		}else if(e.getActionCommand().equals("return")){
			jtf.setText("");
			this.dispose();
			new Manager();
		}
	}
	

}

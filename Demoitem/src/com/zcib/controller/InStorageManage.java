package com.zcib.controller;

import java.awt.RenderingHints;
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

import org.omg.CORBA.MARSHAL;

import com.zcib.model.InStorageModel;
import com.zcib.show.AmendInStorage;
import com.zcib.show.InStorage;
//基本物品的入库管理操作;
public class InStorageManage  extends JDialog implements ActionListener{
	/*
	 * 入库表的管理
	 * 查询:模糊查询(未实现)
	 * 1.入库:操作InStorageModel--->db
	 * 2.修改:操作InStorageModel--->db
	 * 3.删除:直接在这里操作数据库---->db
	 * 4.返回:
	 */
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb1_1;
	JScrollPane jsp;
	JTable jt;
	InStorageModel ism=null;
	//初始化
	public InStorageManage (){
		jp1=new JPanel();
		//jl1=new JLabel("现有入库信息");
		jb1=new JButton("查询");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jtf=new JTextField(10);
//		jb1_1=new JButton("刷新当前对象");
//		jb1_1.addActionListener(this);
//		jb1_1.setActionCommand("shuaxin");
		//jp1.add(jl1);
		
		jp1.add(jtf);
		jp1.add(jb1);
//		jp1.add(jb1_1);
		
		jp2=new JPanel();
		jb2=new JButton("入库");
		jb2.addActionListener(this);
		jb2.setActionCommand("ruku");
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
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
		
		ism=new InStorageModel();
		String[] paras={"1"};
		ism.queryInStorage("select * from instorage where 1=?", paras);
		jt=new JTable(ism);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("入库操作");
		this.setLocation(600, 200);
		this.setSize(650, 400);
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
			String sql="select * from instorage where name like ? order by id limit 1,5";
			
			//构建新的数据模型
			String[] paras={"%"+name+"%"};
			ism=new InStorageModel();
			ism.queryInStorage(sql, paras);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("修改");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//显示修改对话框
			AmendInStorage ais= new AmendInStorage(this,"修改",ism,true,rowNum);
			//更新model显示新数据
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("shanchu")){
			//删除整行;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			String Id=ism.getValueAt(rowNum, 0)+"";
			String sql="delete from instorage where id= ?";
			String []paras={Id};
			InStorageModel temp=new InStorageModel();
			temp.upInStorage(sql, paras);
			//更新model显示新数据
			ism=new InStorageModel(); 
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("ruku")){
			 InStorage as=new InStorage(this,"库存增加",true);
			//构建新的数据模型
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("shuaxin")){
			jtf.setText("");
			//构建新的数据模型
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
			
		}else if(e.getActionCommand().equals("return")){
			//返回主界面
			this.dispose();
			new Manager();
			
		}
	}
	

}

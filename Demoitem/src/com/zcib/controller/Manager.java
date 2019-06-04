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

import com.zcib.model.GoodsModel;
import com.zcib.model.InStorageModel;
import com.zcib.show.AddView;
import com.zcib.show.UpView;
//用管理各个层次初始化的为物品的总览表;
public class Manager extends JDialog implements ActionListener{
	/*查询:模糊查询(未实现)
	 * 1.基本信息表的增删改:
	 * 
	 * 2.入库表的调用:InStorageManage();--->model--->db
	 * 3.出库表的调用:OutStorageManage();--->	model--->db
	 */
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JScrollPane jsp;
	JTable jt;
	GoodsModel gm=null;
	//
	public Manager(){
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
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jb5=new JButton("刷新返回");
		jb5.addActionListener(this);
		jb5.setActionCommand("shuaxin");
		jb6=new JButton("入库操作");
		jb6.addActionListener(this);
		jb6.setActionCommand("ruku");
		jb7=new JButton("出库操作");
		jb7.addActionListener(this);
		jb7.setActionCommand("chuku");
		jp2.add(jb6);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb7);
		//进行对数据的初始化,不然会没有数据出现
		gm=new GoodsModel();
		String[] paras={"1"};
		gm.queryGoods("select * from goods where 1=?", paras);
		jt=new JTable(gm);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("信息操作");
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
			//sql语句 like @name 
			String sql="select * from goods where name like ? "; 
			//order by id limit 1,20
			//构建新的数据模型
			String[] paras={"%"+name+"%"};
			
			gm=new GoodsModel();
			gm.queryGoods(sql, paras);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("修改");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//显示修改对话框
			UpView uv= new UpView(this,"修改",gm,true,rowNum);
			gm=new GoodsModel();
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("shanchu")){
			//删除整行;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			String Id=(String)gm.getValueAt(rowNum, 0);
			String sql="delete from goods where id= ?";
			String []paras={Id};
			GoodsModel temp=new GoodsModel();
			temp.upGoods(sql, paras);
			//更新
			gm=new GoodsModel(); 
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("tianjia")){
			AddView aView=new AddView(this,"添加药品",true);
			//构建新的数据模型
			gm=new GoodsModel();
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("shuaxin")){
			jtf.setText("");
			gm=new GoodsModel(); 
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("ruku")){
			this.dispose();
			//入库的操作;
			new InStorageManage();		
		}else if(e.getActionCommand().equals("chuku")){
			this.dispose();
			//调用出库的操作;
			new OutStorageManage();
		}
	}
	

}
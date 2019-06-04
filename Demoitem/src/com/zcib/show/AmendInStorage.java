package com.zcib.show;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.zcib.controller.InStorageManage;
import com.zcib.model.GoodsModel;
import com.zcib.model.InStorageModel;
import com.zcib.model.OutStorageModel;
//修改入库操作,
public class AmendInStorage extends JDialog implements ActionListener{
	/*
	 * 修改入库的表中的数据,其中的主键和外间关联的不能修改;
	 * 修改时如果修改了物品数量这一栏则基本物品的数量一栏也会发生改变.
	 */

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	 public AmendInStorage(InStorageManage Manage,String title,InStorageModel ism,boolean modal,int rowNums){
		super(Manage,title,modal);

		jl1=new JLabel("出库号");
		jl2=new JLabel("物品编号");
		jl3=new JLabel("名称");
		jl4=new JLabel("入库量");
		jl5=new JLabel("总量");
		jl6=new JLabel("操作人");
		jl7=new JLabel("时间");
		//setTextField只能接受的是文本所以要转换为String类的;
		jtf1=new JTextField();
		jtf1.setText(ism.getValueAt(rowNums, 0)+"");
		//主键不能修改
		jtf1.setEditable(false);
		jtf2=new JTextField();
		//外键不可修改
		jtf2.setText((String)ism.getValueAt(rowNums,1));
		jtf2.setEditable(false);
		jtf3=new JTextField();
		jtf3.setText(ism.getValueAt(rowNums,2)+"");
		jtf4=new JTextField();
		jtf4.setText(ism.getValueAt(rowNums, 3)+"");
		jtf5=new JTextField();
		jtf5.setText(ism.getValueAt(rowNums,4)+"");
		jtf6=new JTextField();
		jtf6.setText(ism.getValueAt(rowNums, 5)+"");
		jtf7=new JTextField();
		jtf7.setText(ism.getValueAt(rowNums,6)+"");
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb1.setActionCommand("yes");
		
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jb2.setActionCommand("no");
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
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		
		jp3.add(jb1);
		jp3.add(jb2);
	
		
		this.add(jp1, BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setLocation(500,400);
		this.setSize(400,250);
		this.setVisible(true);
	}
	 //修改时由于id和gid不能修改所以不用进行添加;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("yes")){
			//进行对数据库的操作;
			String sql="update instorage set gid=?,"
					+ "name=?,incount=? ,count=?,person=?,date=? where id=?";
			String []paras={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf1.getText()};
			//model层调用
			InStorageModel om=new InStorageModel();
			om.upInStorage(sql, paras);
			this.dispose();
			//更新基本物品表
			String string=jtf5.getText();
			String st="'"+jtf2.getText()+"'";
			GoodsModel gM=new GoodsModel();
			String sql11="update  goods set amount =? where id="+st;
			String [] paras1={string};
			gM.upGoods(sql11, paras1);
		}else if(e.getActionCommand().equals("no")){
			this.dispose();
		}
		
	}

}

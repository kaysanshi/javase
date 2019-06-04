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

import com.zcib.controller.Manager;
import com.zcib.model.GoodsModel;

public class UpView extends JDialog implements ActionListener{

	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JButton jb1,jb2;
//	JTable jt;
	//JScrollPane jsp;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	public UpView(Manager Manage,String title,GoodsModel gm,boolean modal,int rowNums){
		super(Manage,title,modal);

		jl1=new JLabel("���");
		jl2=new JLabel("����");
		jl3=new JLabel("������");
		jl4=new JLabel("��������");
		jl5=new JLabel("����");
		jl6=new JLabel("ʱ��");
		jl7=new JLabel("������");
		
		jtf1=new JTextField();
		jtf1.setText((String)gm.getValueAt(rowNums, 0));
		//���������޸�
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText((String)gm.getValueAt(rowNums,1));
		jtf3=new JTextField();
		jtf3.setText(gm.getValueAt(rowNums,2)+"");
		jtf4=new JTextField();
		jtf4.setText(gm.getValueAt(rowNums, 3)+"");
		jtf5=new JTextField();
		jtf5.setText(gm.getValueAt(rowNums,4)+"");
		jtf6=new JTextField();
		jtf6.setText((String)gm.getValueAt(rowNums, 5));
		jtf7=new JTextField();
		jtf7.setText(gm.getValueAt(rowNums,6)+"");
		
		jb1=new JButton("�޸�");
		jb1.addActionListener(this);
		jb1.setActionCommand("xiugai");
		
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);
		jb2.setActionCommand("quxiao");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//���ò���
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="xiugai"){
			
			String sql="update goods set name=?,"
					+ "address=?,describle=? ,amount=?,date=? ,person=?where id=?";
			String []pares={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf1.getText()};
			GoodsModel gm=new GoodsModel();
			gm.upGoods(sql, pares);
			this.dispose();
		}else if(e.getActionCommand().equals("quxiao")){
			this.dispose();
		}
		
	}

}
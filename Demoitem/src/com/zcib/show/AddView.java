package com.zcib.show;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zcib.controller.Manager;
import com.zcib.model.GoodsModel;
import com.zcib.util.TDate;
//���ҩƷҳ��
public class AddView extends JDialog implements ActionListener{
	/*
	 * ������Ϣ������ҳ��
	 */
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JButton jb1,jb2;
	//JTable jt;
	//JScrollPane jsp;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	public AddView(Manager Manager,String title,boolean modal){
		
		super(Manager,title,modal);
		jl1=new JLabel("���:");
		jl2=new JLabel("����:");
		jl3=new JLabel("������:");
		jl4=new JLabel("��������:");
		jl5=new JLabel("����:");
		jl6=new JLabel("ʱ��:");
		jl7=new JLabel("������:");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);
		jtf6=new JTextField(10);
		jtf7=new JTextField(10);
		
		
		jb1=new JButton("���");
		jb2=new JButton("ȡ��");
		jb1.setActionCommand("tianjia");
		jb1.addActionListener(this);
		jb2.setActionCommand("quxiao");
		jb2.addActionListener(this);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		TDate date=new TDate();
		
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
		
		jtf1.setText("");
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jtf6.setText(date.getdate());
		jp2.add(jtf6);
		jp2.add(jtf7);
		
		jp3.add(jb1);
		jp3.add(jb2);
	
		
		this.add(jp1, BorderLayout.WEST);
		
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);
		this.setLocation(500,400);
		this.setSize(500,350);

		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("tianjia")){
			GoodsModel temp=new GoodsModel();
			String sql="insert into goods values(?,?,?,?,?,?,?)";
			String[] pares={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText()};
			if(temp.upGoods(sql, pares)){
				JOptionPane.showMessageDialog(this, "��ӳɹ�");
			}else{
				JOptionPane.showMessageDialog(this, "���ʧ��");
			}
				this.dispose();
			}else if(e.getActionCommand().equals("quxiao")){
				this.dispose();
			}
	}
}

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
//������Ʒ�����������;
public class InStorageManage  extends JDialog implements ActionListener{
	/*
	 * ����Ĺ���
	 * ��ѯ:ģ����ѯ(δʵ��)
	 * 1.���:����InStorageModel--->db
	 * 2.�޸�:����InStorageModel--->db
	 * 3.ɾ��:ֱ��������������ݿ�---->db
	 * 4.����:
	 */
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb1_1;
	JScrollPane jsp;
	JTable jt;
	InStorageModel ism=null;
	//��ʼ��
	public InStorageManage (){
		jp1=new JPanel();
		//jl1=new JLabel("���������Ϣ");
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jtf=new JTextField(10);
//		jb1_1=new JButton("ˢ�µ�ǰ����");
//		jb1_1.addActionListener(this);
//		jb1_1.setActionCommand("shuaxin");
		//jp1.add(jl1);
		
		jp1.add(jtf);
		jp1.add(jb1);
//		jp1.add(jb1_1);
		
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb2.setActionCommand("ruku");
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jb5=new JButton("������һ��");
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
		this.setTitle("������");
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
			System.out.println("��ѯ");
			//���ݷ�װ��ģ�����Ժ���Լ򵥵Ĳ�ѯ��
			String name=this.jtf.getText().trim();
			//sql���
			String sql="select * from instorage where name like ? order by id limit 1,5";
			
			//�����µ�����ģ��
			String[] paras={"%"+name+"%"};
			ism=new InStorageModel();
			ism.queryInStorage(sql, paras);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("�޸�");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			AmendInStorage ais= new AmendInStorage(this,"�޸�",ism,true,rowNum);
			//����model��ʾ������
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("shanchu")){
			//ɾ������;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			String Id=ism.getValueAt(rowNum, 0)+"";
			String sql="delete from instorage where id= ?";
			String []paras={Id};
			InStorageModel temp=new InStorageModel();
			temp.upInStorage(sql, paras);
			//����model��ʾ������
			ism=new InStorageModel(); 
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("ruku")){
			 InStorage as=new InStorage(this,"�������",true);
			//�����µ�����ģ��
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
		}else if(e.getActionCommand().equals("shuaxin")){
			jtf.setText("");
			//�����µ�����ģ��
			ism=new InStorageModel();
			String []paras2={"1"};
			ism.queryInStorage("select*from instorage where 1=?", paras2);
			jt.setModel(ism);
			
		}else if(e.getActionCommand().equals("return")){
			//����������
			this.dispose();
			new Manager();
			
		}
	}
	

}

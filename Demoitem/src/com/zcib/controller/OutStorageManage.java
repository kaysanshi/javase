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
//�������

public class OutStorageManage extends JDialog implements ActionListener{
/*
 * 1.���ȵĻ�����ı�Ӧ��������ͻ����ı��й�ϵ,���������ܹ������Ļ�������ϵ���ܾ͸�����;
 * 2.�ӻ������е����ݵ��뵽������е�����,���һ��к������е�����һһ��Ӧ;
 * 3.������:�����ݿ��е���������;
 * ��ѯ:ģ����ѯ(δʵ��)
 */
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JScrollPane jsp;
	JTable jt;
	OutStorageModel osm=null;
	//��ʼ��
	public OutStorageManage (){
		jp1=new JPanel();
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("����������");
		jtf=new JTextField(10);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("��ӳ��ⵥ");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		jb3=new JButton("�޸ĳ��ⵥ");
		jb3.addActionListener(this);
		jb3.setActionCommand("chuku");
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
		//��ģ�ͳ�ʼ��
		osm=new OutStorageModel();
		/*
		 * �ѻ��������Ϣ���뵽�����{δʵ��}
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
		this.setTitle("�������");
		this.setLocation(600, 200);
		this.setSize(650, 400);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	//�¼��Ļ�Ӧ;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("chaxun")){
			
			System.out.println("��ѯ");
			//���ݷ�װ��ģ�����Ժ���Լ򵥵Ĳ�ѯ��
			String name=this.jtf.getText().trim();
			//sql���
			String sql="select * from outstorage where name like ?  order by id limit 0,5";
			//�����µ�����ģ��
			String[] paras={"%"+name+"%"};
			osm=new OutStorageModel();
			osm.queryOutStorage(sql, paras);
			jt.setModel(osm);
			if(osm.toString().equals("")){
				JOptionPane.showMessageDialog(this, "û�д�����Ʒ,�����������ѯ");
			}
		}else if(e.getActionCommand().equals("chuku")){
			System.out.println("����");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//��ʾ����Ի���
			OutStorage uv= new OutStorage(this,"����",osm,true,rowNum);
			osm=new OutStorageModel();
			String []paras2={"1"};
			osm.queryOutStorage("select*from outstorage where 1=?", paras2);
			jt.setModel(osm);
		}else if(e.getActionCommand().equals("shanchu")){
			//ɾ������;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
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
			OutStorageAdd osA=new OutStorageAdd(this, "���������", true);
			//�����µ�����ģ��
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

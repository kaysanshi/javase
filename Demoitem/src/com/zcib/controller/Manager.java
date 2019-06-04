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
//�ù��������γ�ʼ����Ϊ��Ʒ��������;
public class Manager extends JDialog implements ActionListener{
	/*��ѯ:ģ����ѯ(δʵ��)
	 * 1.������Ϣ�����ɾ��:
	 * 
	 * 2.����ĵ���:InStorageManage();--->model--->db
	 * 3.�����ĵ���:OutStorageManage();--->	model--->db
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
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);
		jb1.setActionCommand("chaxun");
		jl1=new JLabel("����������");
		jtf=new JTextField(10);
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb2.setActionCommand("tianjia");
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb3.setActionCommand("xiugai");
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		jb4.setActionCommand("shanchu");
		jb5=new JButton("ˢ�·���");
		jb5.addActionListener(this);
		jb5.setActionCommand("shuaxin");
		jb6=new JButton("������");
		jb6.addActionListener(this);
		jb6.setActionCommand("ruku");
		jb7=new JButton("�������");
		jb7.addActionListener(this);
		jb7.setActionCommand("chuku");
		jp2.add(jb6);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb7);
		//���ж����ݵĳ�ʼ��,��Ȼ��û�����ݳ���
		gm=new GoodsModel();
		String[] paras={"1"};
		gm.queryGoods("select * from goods where 1=?", paras);
		jt=new JTable(gm);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("��Ϣ����");
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
			//sql��� like @name 
			String sql="select * from goods where name like ? "; 
			//order by id limit 1,20
			//�����µ�����ģ��
			String[] paras={"%"+name+"%"};
			
			gm=new GoodsModel();
			gm.queryGoods(sql, paras);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("�޸�");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			UpView uv= new UpView(this,"�޸�",gm,true,rowNum);
			gm=new GoodsModel();
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("shanchu")){
			//ɾ������;
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			String Id=(String)gm.getValueAt(rowNum, 0);
			String sql="delete from goods where id= ?";
			String []paras={Id};
			GoodsModel temp=new GoodsModel();
			temp.upGoods(sql, paras);
			//����
			gm=new GoodsModel(); 
			String []paras2={"1"};
			gm.queryGoods("select*from goods where 1=?", paras2);
			jt.setModel(gm);
		}else if(e.getActionCommand().equals("tianjia")){
			AddView aView=new AddView(this,"���ҩƷ",true);
			//�����µ�����ģ��
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
			//���Ĳ���;
			new InStorageManage();		
		}else if(e.getActionCommand().equals("chuku")){
			this.dispose();
			//���ó���Ĳ���;
			new OutStorageManage();
		}
	}
	

}
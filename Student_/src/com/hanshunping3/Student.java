package com.hanshunping3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hanshunping2.StudentAddDiolag;
import com.hanshunping2.StudentModel;
import com.hanshunping2.StudentUpDialog;
//model2ģʽ,��̨�Ͳ�������;
public class Student extends JFrame implements ActionListener{
	
	JPanel jp1,jp2;
	JLabel jl1;
	JTextField jtf;
	JButton jb1,jb2,jb3,jb4,jb5;
	JScrollPane jsp;
	JTable jt;
	StudentModel sm=null;
	//
	public Student(){
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
		jb5=new JButton("ˢ��");
		jb5.addActionListener(this);
		jb5.setActionCommand("shuaxin");
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		StudentModel sm=new StudentModel();
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setTitle("ѧ����Ϣ����");
		this.setSize(400, 300);
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
			String sql="select * from stu where stuName='"+name+"'";
			//�����µ�����ģ��
			sm=new StudentModel(sql);
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("xiugai")){
			System.out.println("�޸�");
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			//��ʾ�޸ĶԻ���
			stuUpdialog su= new stuUpdialog(this,"�޸�",true,sm,rowNum);
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("shanchu")){
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			String stuId=(String)sm.getValueAt(rowNum, 0);
			String sql="delete from stu where stuId= ?";
			String []pares={stuId};
			StuModel temp=new StuModel();
			temp.upStu(sql,pares);
			
			sm=new StudentModel(); 
			jt.setModel(sm);
		}else if(e.getActionCommand().equals("tianjia")){
			 StudentAddDiolag sa=new StudentAddDiolag(this,"���ѧ��",true);
				//�����µ�����ģ��
					sm=new StudentModel(); 
					jt.setModel(sm);
		}else if(e.getActionCommand().equals("shuaxin")){
			sm=new StudentModel(); 
			jt.setModel(sm);
		}
	}
	public static void main(String[] args) {
		Student s=new Student();
	}

}

package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JList_JSC extends JFrame{
//����������������������������������
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb;
	JList list;
	JScrollPane jsp1;
	public JList_JSC(){
		jp1=new JPanel();
		jp2=new JPanel();
		jlb1=new JLabel("��ļ���");
		jlb2=new JLabel("���εص�");
		//
		String[] jp={"����","�Ͻ�","����","�ӱ�","�Ϻ�"};
		jcb=new JComboBox(jp);
		//
		String[] jd={"����","�찲��","���ԭ","������","��������"};
		list=new JList(jd);
		list.setVisibleRowCount(4);
		jsp1=new JScrollPane(list);
		//���ò���
		this.setLayout(new GridLayout(3,1));
		//������
		jp1.add(jlb1);
		jp1.add(jcb);
		
		jp2.add(jlb2);
		jp2.add(jsp1);
		
		this.add(jp1);
		this.add(jp2);
		this.setTitle("�������ʾ");
		this.setSize(300, 350);
		this.setLocation(300, 400);
//		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//Ĭ�Ϲرգ�
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JList_JSC();
	}
	
}

package com.mingribook;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
//���Լ�ʵ�ֵı��ģ����ʵ��;
public class test extends JFrame{
	JTable jTable;
	JScrollPane jsp;
	////���жԱ�ģ�ͳ�ʼ��;
	public test() {
		Vector<String> columns = new Vector<String>();
		columns.add("����");
		columns.add("Ӫҵ��");// ���һ����Ӫҵ����
		String[] strings={"ʳƷ","����","����","ˮ��","����","�ɹ�","��ʳ","��Ů"};
		for (int i = 1; i < strings.length; i++){
			columns.add("��Ʒ��:" + strings[i]);
		}
		Vector<Vector<Object>> rowdata = new Vector<>();
		for (int row = 1; row < 30; row++) {
			Vector<Object> rowV = new Vector();
			rowV.add("��:"+row+"��");
			int sum = 0;//��Ӫҵ��
			for (int col = 0; col < 20; col++) {
				int value = (int) (Math.random() * 10);
				rowV.add(value);
				sum += value;// �ۼ���Ӫҵ��
			}
			rowV.insertElementAt(sum+"Ԫ", 1);// ������Ӫҵ������
			rowdata.add(rowV);
		}
		// TODO Auto-generated constructor stub
		testTable table=new testTable(columns, rowdata);
		jTable=new JTable(table);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ���������:
		//jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//ѡ��ģʽΪ��ѡģʽ
		jsp =new JScrollPane(jTable);
		this.add(jsp);
		this.setTitle("��ģ��");
		this.setSize(500, 375);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new test();
	}

}

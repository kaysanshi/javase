package com.mingribook;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ѡ���¼���ʹ�ã��ڲ���ķ���ʹ�á�
 */
public class ItemListener_test extends JFrame{
	JComboBox jcb;
	JPanel jp;
	public ItemListener_test(){
		jcb=new JComboBox();
		jp=new JPanel();
		for(int i=1;i<6;i++){
			jcb.addItem("ѡ��"+i);
		}
		//���ѡ���¼��ļ�����
		jcb.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//��ȡ���¼�������Ȼ�������뾲̬�����Աȣ�
				int stateChange=e.getStateChange();
				String item=e.getItem().toString();//��ô��¼���ѡ��
				if(stateChange==ItemEvent.SELECTED){
					System.out.println("���¼���  ѡ�� "+item+"����");
				}else if(stateChange==ItemEvent.DESELECTED){
					System.out.println("���¼���   ȡ��ѡ��   "+item+"����");
				}else{
					System.out.println("���¼�������ԭ�򴥷�");
				}
				
			}
			
		});
		//��ӵ�Jpanel��JFrame��
		jp.add(jcb);
		this.add(jp);
		this.setTitle("ѡ���¼�");
		this.setSize(500, 300);
		this.setLocation(200, 300);
		//���JFrame�еļ����¼����ڹر�JFrame���� ��
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
			ItemListener_test p=new ItemListener_test();
	
		}
}

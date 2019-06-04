package com.hansunping;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 1.�̳�JFrame;
 * 2.�������
 * 3.�������
 * ���ò��ֹ���
 * 4.��������
 * 5.��������
 * 6.��ʾ���壻
 */
public class GridLayOut_test extends JFrame{
	int size=9;
	JButton[] arr=new JButton[size];
	public GridLayOut_test(){
		//�������
		for(int i=0;i<size;i++){
			arr[i]=new JButton(String.valueOf(i));
		}
		//���ò��ֹ�����������ʽ�ģ�ǰ�������ǿ�����Ŀ���������Ƿָ�λ��
		this.setLayout(new GridLayout(3,3,10,10));
		//������
		for(int i=0;i<size;i++){
			this.add(arr[i]);
		}
		//��Ӵ���
		this.setTitle("���񲼾ֹ�����");
		this.setSize(400, 500);
		this.setLocation(400, 300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
		//���ò��ɱ���
		this.setResizable(false);
	}
	public static void main(String[] args) {
		new GridLayOut_test();
	}
}

package com.mingribook;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableModeEvent_test extends JFrame {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField aTextField;
	private JTextField bTextField;
	
	public TableModeEvent_test(){
		super();
		setTitle("���ģ���¼���ʵ��");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane=new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[]columnNames={"A","B"};
		String[][] rowValues={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"}};
		tableModel=new DefaultTableModel(rowValues,columnNames);
		//���ģ����Ӽ�������
		tableModel.addTableModelListener(new TableModelListener(){

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int type=e.getType();//��ȡ�¼�������
				int row=e.getFirstRow()+1;//����¼�����������
				int column=e.getColumn()+1;
				//�ж�
				if(type==TableModelEvent.INSERT){
					System.out.println("���¼��ɲ����д�����");
					System.out.println("�˴β������"+row+"��");
				}else if (type==TableModelEvent.UPDATE){
					System.out.println("���¼����޸��д���");
					System.out.println("�˴��޸ĵ���"+row+"�е�"+column+"��");
				}else if(type==TableModelEvent.DELETE){
					System.out.println("���¼���ɾ���д�����");
					System.out.println("�˴�ɾ�����¼��е�"+row+"��");
				}else {
					System.out.println("���¼�������ԭ�򴥷�");
				}
			}
			
		});
		///���ñ��ģ�ʹ���������
		table=new JTable(tableModel);
		scrollPane.setViewportView(table);
		final JPanel panel=new JPanel();
		getContentPane().add(panel,BorderLayout.SOUTH);
		final JLabel aLable=new JLabel("A: ");
		panel.add(aLable);
		aTextField=new JTextField(15);
		panel.add(aTextField);
		final JLabel bLable=new JLabel("B: ");
		panel.add(bLable);
		bTextField=new JTextField(15);
		panel.add(bTextField);
		
		final JButton addButton=new JButton("���");
		//������Ӱ�ť�¼�
		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] rowValues={aTextField.getText(),aTextField.getText()};
				//���������һ��
				tableModel.addRow(rowValues);
				aTextField.setText(null);
				bTextField.setText(null);
			}
		});
		panel.add(addButton);
		final JButton delButton=new JButton("ɾ��");
		//����ɾ����ť�¼�
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡѡ�е��в��Ƴ�����
				int[] selectedRows=table.getSelectedRows();
				for(int row=0;row<selectedRows.length;row++){
					tableModel.removeRow(selectedRows[row]-row);
				}
			}
			
		});
		panel.add(delButton);
	}
	public static void main(String[] args) {
		TableModeEvent_test a=new TableModeEvent_test();
		a.setVisible(true);
	}
}

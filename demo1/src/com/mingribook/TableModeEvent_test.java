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
		setTitle("表格模型事件的实例");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane=new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[]columnNames={"A","B"};
		String[][] rowValues={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"}};
		tableModel=new DefaultTableModel(rowValues,columnNames);
		//表格模型添加监听对象
		tableModel.addTableModelListener(new TableModelListener(){

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int type=e.getType();//获取事件的类型
				int row=e.getFirstRow()+1;//获得事件触发的索引
				int column=e.getColumn()+1;
				//判断
				if(type==TableModelEvent.INSERT){
					System.out.println("此事件由插入行触发的");
					System.out.println("此次插入的是"+row+"行");
				}else if (type==TableModelEvent.UPDATE){
					System.out.println("此事件由修改行触发");
					System.out.println("此次修改的是"+row+"行第"+column+"列");
				}else if(type==TableModelEvent.DELETE){
					System.out.println("此事件由删除行触发的");
					System.out.println("此次删除的事件有第"+row+"行");
				}else {
					System.out.println("此事件由其他原因触发");
				}
			}
			
		});
		///利用表格模型创建表格对象
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
		
		final JButton addButton=new JButton("添加");
		//监听添加按钮事件
		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] rowValues={aTextField.getText(),aTextField.getText()};
				//向表格中添加一行
				tableModel.addRow(rowValues);
				aTextField.setText(null);
				bTextField.setText(null);
			}
		});
		panel.add(addButton);
		final JButton delButton=new JButton("删除");
		//监听删除按钮事件
		delButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//获取选中的行并移除这行
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

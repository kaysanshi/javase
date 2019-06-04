package com.mingribook;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
//用自己实现的表格模型来实现;
public class test extends JFrame{
	JTable jTable;
	JScrollPane jsp;
	////进行对表模型初始化;
	public test() {
		Vector<String> columns = new Vector<String>();
		columns.add("日期");
		columns.add("营业额");// 添加一个日营业额列
		String[] strings={"食品","生疏","杂粮","水果","油类","仙姑","熟食","美女"};
		for (int i = 1; i < strings.length; i++){
			columns.add("商品名:" + strings[i]);
		}
		Vector<Vector<Object>> rowdata = new Vector<>();
		for (int row = 1; row < 30; row++) {
			Vector<Object> rowV = new Vector();
			rowV.add("第:"+row+"天");
			int sum = 0;//日营业额
			for (int col = 0; col < 20; col++) {
				int value = (int) (Math.random() * 10);
				rowV.add(value);
				sum += value;// 累计日营业额
			}
			rowV.insertElementAt(sum+"元", 1);// 插入日营业额数据
			rowdata.add(rowV);
		}
		// TODO Auto-generated constructor stub
		testTable table=new testTable(columns, rowdata);
		jTable=new JTable(table);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整功能:
		//jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//选择模式为单选模式
		jsp =new JScrollPane(jTable);
		this.add(jsp);
		this.setTitle("表模型");
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

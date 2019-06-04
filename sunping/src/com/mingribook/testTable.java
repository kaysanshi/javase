package com.mingribook;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
//表格模型测试:
/*
 * 表格模型的操作;要重写其中的方法;一般都是vector来进行传值;
 */
public class testTable extends AbstractTableModel{
	Vector<String>columns ;//列名
	Vector <Vector<Object>>rowdata;//行名
	public testTable(Vector<String> columnNameV,
			Vector<Vector<Object>> tableValueV) {
		// TODO Auto-generated constructor stub
		this.columns = columnNameV;
		this.rowdata = tableValueV;
	}

	//获得行数
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowdata.size();
	}
	//获得列总数;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.size();
	}
//单元格值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return  rowdata.get(rowIndex).get(columnIndex);
	}
	//获得列名;
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns.get(column);
	}
	
}

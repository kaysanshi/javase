package com.mingribook;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
//���ģ�Ͳ���:
/*
 * ���ģ�͵Ĳ���;Ҫ��д���еķ���;һ�㶼��vector�����д�ֵ;
 */
public class testTable extends AbstractTableModel{
	Vector<String>columns ;//����
	Vector <Vector<Object>>rowdata;//����
	public testTable(Vector<String> columnNameV,
			Vector<Vector<Object>> tableValueV) {
		// TODO Auto-generated constructor stub
		this.columns = columnNameV;
		this.rowdata = tableValueV;
	}

	//�������
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowdata.size();
	}
	//���������;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.size();
	}
//��Ԫ��ֵ
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return  rowdata.get(rowIndex).get(columnIndex);
	}
	//�������;
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns.get(column);
	}
	
}

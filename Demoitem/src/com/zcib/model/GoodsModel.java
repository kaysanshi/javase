package com.zcib.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import com.zcib.db.SqlHelp;
//��Ʒ��model��
public class GoodsModel extends AbstractTableModel{
	/*
	 * model����Ҫ��������db��control�������:
	 */
	//���������к���:
	Vector rowData,columnNames;
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	//����Ʒ��;��ɾ��
		public boolean upGoods(String sql,String []paras){
			//����
			SqlHelp sh=new SqlHelp();
			return sh.updExcetion(sql, paras);
		}
		//��ѯ���ʳ�ʼ��
		public void queryGoods(String sql,String []paras){
			SqlHelp sh=null;
			columnNames=new Vector<String>();
			columnNames.add("���");
			columnNames.add("����");
			columnNames.add("������");
			columnNames.add("��������");
			columnNames.add("����");
			columnNames.add("��ǰʱ��");
			columnNames.add("������");
			rowData=new Vector<String> ();
			try {
				sh=new SqlHelp();
				 rs=sh.queryExectue(sql,paras);
				while(rs.next()){
					Vector  hang=new Vector();
					hang.add(rs.getString("id"));																																																																																																																																																											 
					hang.add(rs.getString("name"));
					hang.add(rs.getString("address"));
					hang.add(rs.getString("describle"));
					hang.add(rs.getString("amount"));
					hang.add(rs.getString("date"));
					hang.add(rs.getString("person"));
					rowData.add(hang);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				sh.close();
			}
		}
	//��ȡ��:		
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}
	//��ȡ��
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}
	//��ȡ��ǰ�е��е�ֵ
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}
	//��ȡ����:
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}

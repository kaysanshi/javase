package com.zcib.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.zcib.db.SqlHelp;
//������ģ��:
public class OutStorageModel extends AbstractTableModel{
	/*
	 * ���������Ӳ�
	 */
	Vector rowData,columnNames;
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	//Ʒ��;��ɾ��
		public boolean upOutStorage(String sql,String []paras){
			//����
			SqlHelp sh=new SqlHelp();
			return sh.updExcetion(sql, paras);
		}
		//��ѯ���ʳ�ʼ��
		public void queryOutStorage(String sql,String []paras){
			SqlHelp sh=null;
			columnNames=new Vector<String> ();
			columnNames.add("������");
			columnNames.add("��Ʒ���");
			columnNames.add("��Ʒ����");
			columnNames.add("������");
			columnNames.add("����");
			columnNames.add("����ʱ��");
			columnNames.add("����Ա");
			
			rowData=new Vector<String> ();
			try {
				sh=new SqlHelp();
				 rs=sh.queryExectue(sql,paras);
				while(rs.next()){
					Vector  hang=new Vector();																																																																																																																																																										 
					hang.add(rs.getInt("id"));
					hang.add(rs.getString("gid"));
					hang.add(rs.getString("name"));
					hang.add(rs.getString("outcount"));
					hang.add(rs.getString("purplus"));
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
//�����ǻ�ȡ���е�ģ�Ͷ���Ĳ���;			
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
package com.hanshunping3;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
//�����Զ�������modelֻ��������һ�Ĳ������ݿ�
//�õ���Ĺ���ʱ���̳�AbstractTableModel�����
//����������ݿ��ͬʱҲ�Ա��������һЩ����;
public class Onemodel extends AbstractTableModel{
	
	public Vector row,column;
	
	//��ɾ��;
	public boolean UpdateModel(String sql,String []params){
		SqlHelper hp=new SqlHelper();
		return hp.upExcetion(sql,params);
	}
	//дһ����ʼ�����ݿ�ķ���:
	public void query(String sql,String[] paras){
		row=new Vector();
		column=new Vector();
		SqlHelper hp=new SqlHelper();
		ResultSet rs=hp.queryExcetion(sql, paras);
		try {
//�� �����ڻ�ȡ�й�ResultSet�������е����ͺ����Ե���Ϣ�Ķ��� 
//			���´���Ƭ�δ���ResultSet����rs������ResultSetMetaData����rsmd��
//			��ʹ��rsmd������rs���ж����У��Լ�rs�еĵ�һ���Ƿ������WHERE�Ӿ���ʹ�á� 
//			  ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
//			 ResultSetMetaData rsmd = rs.getMetaData();
//			 int numberOfColumns = rsmd.getColumnCount();
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++){
				//getColumnName(int column) ��ȡָ���е����ơ�
				this.column.add(rsmd.getColumnName(i+1));	
				
			}	
			while(rs.next()){
				Vector<String> temp=new Vector<String>();
				//��� 	���ش� ResultSet�����е�������
				for(int i=0;i<rsmd.getColumnCount();i++){
					temp.add(rs.getString(i+1));
				}
				row.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			hp.close();
		}
	}
	
	
	//����е�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	//����е�����;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	//���īһ�е�ĳһ��ֵ;
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)row.get(rowIndex)).get(columnIndex);
	}
	//��ñ��� �е�����;
	public String getColumnName(int column){
		return (String)this.column.get(column).toString();
		
	}
}

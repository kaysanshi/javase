/**
 * �������¹���Ĳ���
 */
package com.mhl.model;
import com.mhl.db.*;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;
public class EmpModel extends AbstractTableModel{
	public Vector<String> colums;
	public Vector<Vector>rows;
	//��ɾ�Ĳ���;
	public boolean UpdateModel(String sql,String []params)
	{
		SqlHelper hp=new SqlHelper();
		return hp.updateExecete(sql,params);
	}
	public int getNum(String sql)
	{
		SqlHelper hp=new SqlHelper();
		int sum=hp.queryExecute(sql);
		return sum;
	}
	public void query(String sql,String[]params)
	{
		//��ʼ��
		
		colums=new Vector<String>();
		rows=new Vector<Vector>();
//		this.colums.add("Ա����");
//		this.colums.add("����");
//		this.colums.add("�Ա�");
//		this.colums.add("ְλ");
		SqlHelper hp=new SqlHelper();
		ResultSet rs=hp.queryExecute(sql, params);
		try {
//�� �����ڻ�ȡ�й�ResultSet�������е����ͺ����Ե���Ϣ�Ķ��� 
//			���´���Ƭ�δ���ResultSet����rs������ResultSetMetaData����rsmd��
//			��ʹ��rsmd������rs���ж����У��Լ�rs�еĵ�һ���Ƿ������WHERE�Ӿ���ʹ�á� 
//			  ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
//			     ResultSetMetaData rsmd = rs.getMetaData();
//			     int numberOfColumns = rsmd.getColumnCount();
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				this.colums.add(rsmd.getColumnName(i+1));	
			}	
			while(rs.next())
			{
				Vector<String> temp=new Vector<String>();
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					temp.add(rs.getString(i+1));
				}
				rows.add(temp);
//				temp.add(rs.getString(1));
//				temp.add(rs.getString(2));
//				temp.add(rs.getString(3));
//				temp.add(rs.getString(4));	
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally
		{
			hp.close();
		}
	}
	


	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rows.size();
	}

	@Override
	public String getColumnName(int rowIndex) {
		// TODO �Զ����ɵķ������
		return this.colums.get(rowIndex).toString();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		return ((Vector)rows.get(rowIndex)).get(columnIndex);
	}

}

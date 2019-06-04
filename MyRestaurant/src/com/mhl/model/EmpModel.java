/**
 * 这是人事管理的操作
 */
package com.mhl.model;
import com.mhl.db.*;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;
public class EmpModel extends AbstractTableModel{
	public Vector<String> colums;
	public Vector<Vector>rows;
	///更新
	public boolean UpdateModel(String sql,String []params){
		SqlHelper hp=new SqlHelper();
		return hp.updateExecete(sql,params);
	}
	public int getNum(String sql){
		SqlHelper hp=new SqlHelper();
		int sum=hp.queryExecute(sql);
		return sum;
	}
	//查询
	public void query(String sql,String[]params){
		//初始化
		
		colums=new Vector<String>();
		rows=new Vector<Vector>();
		SqlHelper hp=new SqlHelper();
		ResultSet rs=hp.queryExecute(sql, params);
	try {
		//。 可用于获取有关ResultSet对象中列的类型和属性的信息的对象。 
//		以下代码片段创建ResultSet对象rs，创建ResultSetMetaData对象rsmd，
//		并使用rsmd来查找rs中有多少列，以及rs中的第一列是否可以在WHERE子句中使用。 
//		  ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
//		     ResultSetMetaData rsmd = rs.getMetaData();
//		     int numberOfColumns = rsmd.getColumnCount();
				ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++){
				this.colums.add(rsmd.getColumnName(i+1));	
			}	
		while(rs.next()){
			Vector<String> temp=new Vector<String>();
			for(int i=0;i<rsmd.getColumnCount();i++){
					temp.add(rs.getString(i+1));
				}
			rows.add(temp);	
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			hp.close();
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rows.size();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return this.colums.get(arg0).toString();
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO 自动生成的方法存根
		return ((Vector)rows.get(arg0)).get(arg1);
	}

}

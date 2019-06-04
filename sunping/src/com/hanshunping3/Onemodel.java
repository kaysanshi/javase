package com.hanshunping3;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
//还可以定义其他model只是用来单一的操作数据库
//用到表的功能时来继承AbstractTableModel这个类
//这个操作数据库的同时也对表格做出了一些定义;
public class Onemodel extends AbstractTableModel{
	
	public Vector row,column;
	
	//增删改;
	public boolean UpdateModel(String sql,String []params){
		SqlHelper hp=new SqlHelper();
		return hp.upExcetion(sql,params);
	}
	//写一个初始化数据库的方法:
	public void query(String sql,String[] paras){
		row=new Vector();
		column=new Vector();
		SqlHelper hp=new SqlHelper();
		ResultSet rs=hp.queryExcetion(sql, paras);
		try {
//。 可用于获取有关ResultSet对象中列的类型和属性的信息的对象。 
//			以下代码片段创建ResultSet对象rs，创建ResultSetMetaData对象rsmd，
//			并使用rsmd来查找rs中有多少列，以及rs中的第一列是否可以在WHERE子句中使用。 
//			  ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
//			 ResultSetMetaData rsmd = rs.getMetaData();
//			 int numberOfColumns = rsmd.getColumnCount();
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++){
				//getColumnName(int column) 获取指定列的名称。
				this.column.add(rsmd.getColumnName(i+1));	
				
			}	
			while(rs.next()){
				Vector<String> temp=new Vector<String>();
				//获得 	返回此 ResultSet对象中的列数。
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
	
	
	//获得行的总数
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}
	//获得列的总数;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.column.size();
	}
	//获得墨一行的某一个值;
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)row.get(rowIndex)).get(columnIndex);
	}
	//获得表格的 列的名称;
	public String getColumnName(int column){
		return (String)this.column.get(column).toString();
		
	}
}

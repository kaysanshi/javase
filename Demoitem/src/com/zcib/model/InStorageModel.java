package com.zcib.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.zcib.db.SqlHelp;
//物品入库的管理操作模型
public class InStorageModel extends AbstractTableModel{
	/*
	 * 入库表的连接层
	 */
	Vector rowData,columnNames;
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	//增加品种;增删改
		public boolean upInStorage(String sql,String []paras){
			//创建
			SqlHelp sh=new SqlHelp();
			return sh.updExcetion(sql, paras);
		}
		//查询本质初始化
		public void queryInStorage(String sql,String []paras){
			SqlHelp sh=null;
			columnNames=new Vector<String> ();
			columnNames.add("入库编号");
			columnNames.add("物品编号");
			columnNames.add("物品名称");
			columnNames.add("入库量");
			columnNames.add("余量");
			columnNames.add("操作员");
			columnNames.add("入库时间");
			rowData=new Vector<String> ();
			try {
				sh=new SqlHelp();
				 rs=sh.queryExectue(sql,paras);
				while(rs.next()){
					Vector  hang=new Vector();																																																																																																																																																										 
					hang.add(rs.getInt("id"));
					hang.add(rs.getString("gid"));
					hang.add(rs.getString("name"));
					hang.add(rs.getString("incount"));
					hang.add(rs.getString("count"));
					hang.add(rs.getString("person"));
					hang.add(rs.getString("date"));
					rowData.add(hang);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				sh.close();
			}
		}
			
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

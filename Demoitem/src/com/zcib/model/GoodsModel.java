package com.zcib.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import com.zcib.db.SqlHelp;
//物品的model类
public class GoodsModel extends AbstractTableModel{
	/*
	 * model层主要就是连接db与control层的连接:
	 */
	//向量储存列和行:
	Vector rowData,columnNames;
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	//增加品种;增删改
		public boolean upGoods(String sql,String []paras){
			//创建
			SqlHelp sh=new SqlHelp();
			return sh.updExcetion(sql, paras);
		}
		//查询本质初始化
		public void queryGoods(String sql,String []paras){
			SqlHelp sh=null;
			columnNames=new Vector<String>();
			columnNames.add("编号");
			columnNames.add("名称");
			columnNames.add("生产商");
			columnNames.add("具体描述");
			columnNames.add("余量");
			columnNames.add("当前时间");
			columnNames.add("操作人");
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
	//获取行:		
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}
	//获取列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}
	//获取当前行的列的值
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}
	//获取列名:
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}

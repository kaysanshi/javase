package com.hanshunping4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class StuModel extends AbstractTableModel{
	Vector rowData,columnNames;
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	
	//增加学生;增删改
	public boolean upStu(String sql,String []paras){
		//创建
		SqlHelper sh=new SqlHelper();
		return sh.updExcetion(sql, paras);
	}
	//查询本质初始化
	public void queryStu(String sql,String []paras){
		SqlHelper sh=null;
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("系别");
		columnNames.add("地址");
		rowData=new Vector();
		try {
			sh=new SqlHelper();
			ResultSet rs=sh.queryExectue(sql,paras);
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString("stuId"));
				hang.add(rs.getString("stuName"));
				hang.add(rs.getString("stuSex"));
				hang.add(rs.getInt("stuAge"));
				hang.add(rs.getString("stuDept"));
				hang.add(rs.getString("stuAddress"));
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

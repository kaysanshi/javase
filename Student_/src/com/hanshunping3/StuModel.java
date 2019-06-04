package com.hanshunping3;

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
	
	//增加学生;
	public boolean upStu(String sql,String []pares){
		boolean b=true;
		//加载数据库库的
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/student?user=root&password=root";
		conn=  DriverManager.getConnection(url);
		//创建一个对象
		stmt=conn.createStatement();
		
		pst=conn.prepareStatement(sql);
		//给参数?赋值：
		for(int i=0;i<pares.length;i++){
			pst.setString(i+1, pares[i]);
		}
		//执行Sql语句
		if(pst.executeUpdate()!=1){
			b=false;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				if(pst!=null){
				pst.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return b;
	}
	public void Iint(String sql){
		if(sql==""){
			sql="select * from stu";
		}
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("系别");
		columnNames.add("地址");
		rowData=new Vector();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student";
			String user="root";
			String passWard="root";
			conn=DriverManager.getConnection(url,user,passWard);
			//创建语句 预编译；
			st=conn.createStatement();
			//执行
			rs=st.executeQuery(sql);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
					rs.close();
					}
					if(st!=null){
						st.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	//通过传递的sql语句获得数据模型
		public StuModel(String sql){
			this.Iint(sql);
		}
		//初始化数据库操作
		public StuModel(){
			this.Iint("");
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

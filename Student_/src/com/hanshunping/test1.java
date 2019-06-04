package com.hanshunping;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/*
 * JTable的使用
 */
public class test1 extends JFrame{
	//行和列
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	//构造函数
	public test1(){
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
			String url="jdbc:mysql://localhost:3306/student?user=root&password=root";
			conn=DriverManager.getConnection(url);
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select*from stu");
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
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			
				try {
					if(rs!=null){
					rs.close();
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
		//初始化JTable
		jt=new JTable(rowData,columnNames);
		//
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.setSize(400,300);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	public static void main(String[] args) {
		 test1 t1=new test1();
	}

}

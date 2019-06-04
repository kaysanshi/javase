package com.hanshunping2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class StudentModel extends AbstractTableModel{
	Vector rowData,columnNames;
	//�������ݿ��֪ʶ
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;//������һ����ʱ����������ʱ�洢���ݿ��ѯ�Ľ������
	//ѡ�з���
	public void Iint(String sql){
		if(sql==""){
			sql="select * from stu";
		}
		columnNames=new Vector();
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("ϵ��");
		columnNames.add("��ַ");
		rowData=new Vector();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student?user=root&password=root";
			conn=DriverManager.getConnection(url);
			stmt=conn.prepareStatement(sql);
			//һ��������ѯ���������ݵ�ResultSet����;
			rs=stmt.executeQuery();
			//ָ������һ��
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
	}
	//ͨ�����ݵ�sql���������ģ��
	public StudentModel(String sql){
		this.Iint(sql);
	}
	//��ʼ�����ݿ����
	public StudentModel(){
		this.Iint("");
	}
	//�õ����ж�����
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
//		System.out.println("1");
		return this.rowData.size();
	}
	//������
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
	//�õ�ĳһ��
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		//�õ�ĳһ�У�ת����һ���������ڵĵ�ĳһ��
		return ((Vector)this.rowData.get(row)).get(column);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
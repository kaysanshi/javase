package com.mhl.model;
import java.sql.*;

import com.mhl.db.*;
/**
 * @param uid �û����
 * @param p �û�����
 * @return �û�ְλ
 * @author Administrator
 *�����û��� ����ģ�ͣ�������ɶ��û��ĸ��ֲ���
 */
public class UserModel {
	///У������;
public String checkUser(String uid,String p){
	String zhiwei = null;
	SqlHelper hp=null;
try{
	String sql="select * from userlogin where user=? and password=?";
	String []params={uid,p};
	hp=new SqlHelper();
	ResultSet rs=hp.queryExecute(sql, params);
	if(rs.next()){
		zhiwei=rs.getString(1);
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		hp.close();
	}
	return zhiwei;
}
//���name������ͨ��user�Ĳ�ͬ��ø�����Ϣ;
	public String getNameById(String uid){
		String empname = null;
		SqlHelper hp=null;
		try{
		String sql="select empname from rszl where empid=?";
		String []params={uid};
		hp=new SqlHelper();
		ResultSet rs=hp.queryExecute(sql, params);
		if(rs.next()){
			empname=rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			hp.close();
		}
		return empname;
	}
}

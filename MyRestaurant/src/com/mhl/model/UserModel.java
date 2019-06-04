package com.mhl.model;
import java.sql.*;

import com.mhl.db.*;
/**
 * @param uid 用户编号
 * @param p 用户密码
 * @return 用户职位
 * @author Administrator
 *这是用户表 数据模型，用它完成对用户的各种操作
 */
public class UserModel {
	///校对密码;
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
//获得name的属性通过user的不同获得个人信息;
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


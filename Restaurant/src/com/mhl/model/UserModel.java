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
public String checkUser(String uid,String p)
{
	String zhiwei = null;
	SqlHelper hp=null;
	try{
	String sql="select rszl.zhiwei from rszl,login where rszl.empid=login.empid and login.empid=? and login.passwd=?";
	String []params={uid,p};
	hp=new SqlHelper();
	ResultSet rs=hp.queryExecute(sql, params);
	if(rs.next())
	{
		zhiwei=rs.getString(1);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		hp.close();
	}
	return zhiwei;
}
	public String getNameById(String uid)
	{
		String empname = null;
		SqlHelper hp=null;
		try{
		String sql="select empname from rszl where empid=?";
		String []params={uid};
		hp=new SqlHelper();
		ResultSet rs=hp.queryExecute(sql, params);
		if(rs.next())
		{
			empname=rs.getString(1);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			hp.close();
		}
		return empname;
	}
}


package com.mhl.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import com.mhl.db.SqlHelper;

public class OrderModel {
	public String geStatusById(String deskid)
	{
		String deskstatus = null;
		SqlHelper hp=null;
		try{
		String sql="select deskstatus from status where deskid=?";
		String []params={deskid};
		hp=new SqlHelper();
		ResultSet rs=hp.queryExecute(sql, params);
		if(rs.next())
		{
			deskstatus=rs.getString(1);
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
		return deskstatus;
	}
	public boolean UpdateModel(String sql,String []params)
	{
		SqlHelper hp=new SqlHelper();
		return hp.updateExecete(sql,params);
	}
	public String query(String sql,String[]params)
	{
		
		String deskid="";
		SqlHelper hp=new SqlHelper();
		ResultSet rs= hp.queryExecute(sql, params);
		
		try
		{
		if(rs.next())
		
			{
				deskid=rs.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			hp.close();
		}
		return deskid;
	}
}

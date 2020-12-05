package com.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.server.sql.SqlHelper;
//这是服务器要操作的类,此类用于操作数据库的;
public class QQServerUser {
	//校对密码:
		public boolean checkUser(String userId,String userpd){
			boolean b=false;
			SqlHelper hp=null;
			String sql="select * from uerlogiin where userlogin=? and password=?";
			String []params={userId,userpd};
			hp=new SqlHelper();
			ResultSet rs=hp.queryExectue(sql, params);
			try {
				if (rs.next()){
					
					b=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
	
}

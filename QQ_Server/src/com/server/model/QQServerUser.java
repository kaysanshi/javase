package com.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.server.sql.SqlHelper;
//���Ƿ�����Ҫ��������,�������ڲ������ݿ��;
public class QQServerUser {
	//У������:
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

package com.zcib.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zcib.db.SqlHelp;
public class UserModel {
	//–£∂‘√‹¬Î:
			public boolean checkUser(String userId,String userpd){
				boolean b=false;
				SqlHelp hp=null;
				String sql="select * from user_login where user=? and password=?";
				String []params={userId,userpd};
				hp=new SqlHelp();
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
		public boolean  addUser(String useId,String password){
			boolean b=false;
			SqlHelp hp=new SqlHelp();
			String sql="insert into user_login values(?,?)";
			String []paras={useId,password};
			b=hp.updExcetion(sql, paras);	
			return b;
		}
}

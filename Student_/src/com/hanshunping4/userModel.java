package com.hanshunping4;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class userModel {
	//–£∂‘√‹¬Î:
		public boolean checkUser(String userId,String userpd){
			boolean b=false;
			SqlHelper hp=null;
			String sql="select * from user_login where user=? and passward=?";
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

package com.zcib.dao;

import java.util.List;
import java.util.Map;

import com.zcib.domain.Addmin;
import com.zcib.utils.DBUtils;

/**
 * 管理员操作数据
 * @author 555
 *@date 2018年5月8日
 */
public class AddminDao {
	/**
	 * 核对用户
	 * @param username
	 * @param password
	 * @return
	 */
	public Addmin cherUser(String username, String password) {
		// TODO Auto-generated method stub
		Addmin addmin=new Addmin();
		String sql="select id,username,password from addmin where username=? && password=?";
		String[] params={username,password};
		DBUtils dbUtils=new DBUtils();
		Map map=dbUtils.getMap(sql, params);
		if (map==null) {
			return addmin;
		}
		addmin.setUsername(map.get("username").toString());
		addmin.setPassword(map.get("password").toString());
		addmin.setId((int)map.get("id"));
		return addmin;
	}
	/**
	 * 注册用户
	 * @param addmin
	 * @return
	 */
	public boolean registAddmin(Addmin addmin) {
		// TODO Auto-generated method stub
		String sql="insert into addmin(id,username,password) values(?,?,?)";
		String[] params={
				null,addmin.getUsername(),addmin.getPassword()
		};
		DBUtils db=new DBUtils();
		int status=db.update(sql, params);
		if (status!=0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获得个人信息
	 * @param addmin
	 * @return
	 */
	public List<Map<String, Object>> getAddminInfoById(Addmin addmin) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		String sql="select * from addmin where id=?";
		String[] params={String.valueOf(addmin.getId())};
		list=new DBUtils().getList(sql, params);
		return list;
	}
	/**
	 * 修改管理员信息
	 * @param addmin
	 * @return
	 */
	public int updateAddmin(Addmin addmin) {
		// TODO Auto-generated method stub
		String sql="update addmin set password=? where id=?";
		String[] params={addmin.getPassword(),String.valueOf(addmin.getId())};
		int i=new DBUtils().update(sql, params);
		return i;
	}

}

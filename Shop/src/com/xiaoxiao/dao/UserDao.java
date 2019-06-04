package com.xiaoxiao.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.utils.JDBCUtils;

public class UserDao {
	// 添加一条记录
	public void add(User user) {
		String sql = "insert into users values(null,?,?,?,?,?,?,?,?,?,?)";
		Object params[] = { user.getUsername(), user.getPassword(),
				user.getSex(), user.getEmail(), user.getPhoto(),
				user.getScore(), user.getQuestion(), user.getAnswer(),
				user.getLastlogintime(),user.isStatus() };

		int id = ((Number) JDBCUtils.insert(sql, params)).intValue();
		user.setVipid(id);
	}

	// 查找用户名为username的记录
	public User findByUsername(String username) {
		String sql = "select * from users where username = ?";
		User user = JDBCUtils.selectToBean(User.class, sql, username);
//		List<Map<String, Object>> list = JDBCUtils.select(sql, username);
//		User user = null;
//		if (list.size() > 0) {
//			Map<String, Object> map = list.get(0);
//			user = new User();
//			user.setUsername(username);
//			user.setVipid((Integer) map.get("vipid"));
//			user.setAnswer((String) map.get("answer"));
//			user.setEmail((String) map.get("email"));
//			user.setLastlogintime((java.util.Date) map.get("lastlogintime"));
//			user.setPassword((String) map.get("password"));
//			user.setPhoto((String) map.get("photo"));
//			user.setQuestion((String) map.get("question"));
//			user.setScore((Integer) map.get("score"));
//			user.setSex((String) map.get("sex"));
//		}
		return user;

	}
	
	public boolean findStatus(int vipid){
		String sql = "select status from users where vipid=?";
		
		return JDBCUtils.selectScalar(sql, vipid);
	}

	public void updateStatus(int vipid) {
		//将状态改为激活状态
		String sql = "update users set status=true where vipid=?";
		JDBCUtils.update(sql, vipid);
	}
	
	public void updateLastLoginTime(int vipid,Date datetime) {
		//将状态改为激活状态
		String sql = "update users set lastlogintime=? where vipid=?";
		Object params[]={
			new java.sql.Timestamp(datetime.getTime()),vipid	
		};
		JDBCUtils.update(sql, params);
	}
	
	
	
}

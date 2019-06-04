package com.itheima.session.loginout;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	private UserDao() {
	}
	private static Map <String,String>map = new HashMap<String, String>();
	static{
		map.put("张三丰", "111");
		map.put("张翠山", "999");
		map.put("张无忌", "888");
		map.put("赵敏", "777");
	}
	public static boolean valiNamePsw(String username,String password){
		return map.containsKey(username) && map.get(username).equals(password);
	}
}

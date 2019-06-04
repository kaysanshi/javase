package com.xiaoxiao.dao;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.utils.JDBCUtils;

public class PCADao {
	// 读取所有的省
	public List<Map<String, Object>> getProvinces() {
		String sql = "select * from provinces";
		return JDBCUtils.select(sql);
	}

	// 根据省id获取所有的市
	public List<Map<String, Object>> getCities(String provinceid) {
		String sql = "select * from cities where provinceid=?";
		return JDBCUtils.select(sql, provinceid);
	}

	// 根据市id获取所有的区
	public List<Map<String, Object>> getAreas(String cityid) {
		String sql = "select * from areas where cityid=?";
		return JDBCUtils.select(sql, cityid);
	}

}

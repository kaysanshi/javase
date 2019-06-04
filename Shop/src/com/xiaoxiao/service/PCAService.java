package com.xiaoxiao.service;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.dao.PCADao;
import com.xiaoxiao.utils.JDBCUtils;

public class PCAService {
	private PCADao pcaDao = new PCADao();
	
	// 读取所有的省
		public List<Map<String, Object>> getProvinces() {
			return pcaDao.getProvinces();
		}

		// 根据省id获取所有的市
		public List<Map<String, Object>> getCities(String provinceid) {
			return pcaDao.getCities(provinceid);
		}

		// 根据市id获取所有的区
		public List<Map<String, Object>> getAreas(String cityid) {
			return pcaDao.getAreas(cityid);
		}
}

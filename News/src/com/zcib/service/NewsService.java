package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.NewsDao;
import com.zcib.domain.New;

public class NewsService {
	NewsDao newsDao = new NewsDao();
	
	public void deleteMore(String ids[]){
		newsDao.deleteMore(ids);
	}
	//根据New来修改一条记录
	public void update(New annew){
		newsDao.update(annew);
	}
	
	//根据id获取一条新闻记录
	public Map<String,Object> findById(String id){
		return newsDao.findById(id);
	}
	
	//删除一条新闻记录
	public void deleteById(String id){
		newsDao.deleteById(id);
	}
	
	/*
	 * 获取新闻列表
	 */
	public List<Map<String,Object>> findNewsList(){
		return newsDao.findAll();
	}
	
	public void addNew(New annew){

		newsDao.insert(annew);
	}
	
}

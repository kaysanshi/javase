package com.xiaoxiao.service;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.dao.CategoryDao;
import com.xiaoxiao.domain.Category;
import com.xiaoxiao.domain.Page;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	
	public List<Map<String,Object>> findAll(){
		return categoryDao.findAll();
	}
	
	public void deleteMore(String id[]){
		categoryDao.deleteMore(id);
	}
	
	public void deleteById(int id){
		categoryDao.deleteById(id);
	}
	
	public void add(Category category){
		//调用Dao层的方法，进行添加
		categoryDao.add(category);
	}
	
	public Page findAll(int currentPage){
		/*
		 * 1.获取总条数，调用dao层
		 * 2.创建Page对象
		 * 3.调用dao层获取数据
		 * 4.返回Page对象
		 */
		int totalSize = categoryDao.findCount();
		Page page = new Page(currentPage,totalSize);
		List<Map<String,Object>> list = categoryDao.findAll(page.getStartIndex(), page.getPageSize());
		page.setList(list);
		return page;
	}
}

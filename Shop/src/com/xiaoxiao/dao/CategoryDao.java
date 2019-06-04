package com.xiaoxiao.dao;

import java.util.List;
import java.util.Map;

import com.xiaoxiao.domain.Category;
import com.xiaoxiao.utils.JDBCUtils;

public class CategoryDao {
	
	public List<Map<String,Object>> findAll(){
		String sql = "select * from category order by sort asc";
		return JDBCUtils.select(sql);
	}
	
	//添加一条记录
	public void add(Category category){
		String sql = "insert into category values(null,?,?)";
		Object params[]={
				category.getName(),
				category.getSort(),
		};
		Number n = (Number)JDBCUtils.insert(sql, params);
		category.setCategoryid(n.intValue());
	}
	
	public List<Map<String,Object>> findAll(int start ,int end){
		String sql = "select * from category limit ?,?";
		return JDBCUtils.select(sql,start,end);
	}
	
	//获取总条数
	public int findCount(){
		String sql = "SELECT COUNT(*) FROM category";
		return ((Number)JDBCUtils.selectScalar(sql)).intValue();
	}
	
	//删除id的记录
	public void deleteById(int id){
		String sql = "delete from category where categoryid = ?";
		JDBCUtils.update(sql, id);
	}
	
	//删除所有id数组中的记录
	public void deleteMore(String id[]){
		String sql = "delete from category where categoryid in (";//?,?,?)
		StringBuilder str = new StringBuilder("");
		for(int i=0;i<id.length;i++){
			if(i==id.length-1)//表示为最后一个
				str.append("?)");
			else
				str.append("?,");
		}
		JDBCUtils.update(sql+str.toString(), id);
	}
	
}

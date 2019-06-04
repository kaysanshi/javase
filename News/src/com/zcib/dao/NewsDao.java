package com.zcib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zcib.domain.New;
import com.zcib.util.JDBCUtils;

public class NewsDao {
	//根据ids进行批量删除
	public void deleteMore(String []ids){
		StringBuilder sql = new StringBuilder("delete from tb_news where id in(");
		for(int i=0;i<ids.length;i++){
			if(i==ids.length-1){
				//如果参数是最后一个，拼接"?)"
				sql.append("?)");
			}else{
			//如果参数不是最后一个,拼接上"?,"
				sql.append("?,");
			}
		}
		JDBCUtils.update(sql.toString(), ids);
	}
	
	//根据New对象修改记录
	public void update(New annew){
		String sql = "update tb_news set title=?,author=?,content=?,publishedDate=? where id=?";
		Object []params={
				annew.getTitle(),annew.getAuthor(),
				annew.getContent(),
				new java.sql.Date(annew.getPublishedDate().getTime()),
				annew.getId()
		};
		JDBCUtils.update(sql, params);
	}
	
	//根据id读取一条新闻
	public Map<String,Object> findById(String id){
		String sql = "select * from tb_news where id=?";
		List<Map<String,Object>> list = JDBCUtils.find(sql, id);
		return list.get(0);
	}
	
	//根据id删除一条新闻
	public void deleteById(String id){
		String sql = "delete from tb_news where id=?";
		JDBCUtils.update(sql, id);
	}
	
	//获取新闻列表
	public List<Map<String,Object>> findAll(){
		
			String sql = "select * from tb_news";
			return JDBCUtils.find(sql);
	}
	
	public void insert(New annew){
		
			String sql = "insert into tb_news values(null,?,?,?,?)";
			Object params[]={
					annew.getTitle(),annew.getAuthor(),
					annew.getContent(),
					new java.sql.Date(annew.getPublishedDate().getTime()),
			};
			Object key = JDBCUtils.insert(sql, params);
			int id = Integer.parseInt(key.toString());
			annew.setId(id);
	}
}

package service;
//获得文件的上传下载文件的信息以及下载问件时更新文件下载的次数的通用方法

import java.util.Map;

import util.DButils;

public class CommonService {
	private DButils db=new DButils();
	//获取下载文件的map集合
	public  Map getDownLoadFile(String id){
		String sql="select filePath,fileName from files where id=?";
		return db.getMap(sql, new String[]{id});
	}
	//上传文件的次数；
	public void updateHits(String id){
		String sql="update files set hit=hits+1 where id=?";
		db.update(sql, new String[]{id});
	}
}

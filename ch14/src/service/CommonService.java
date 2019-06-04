package service;

import util.DBUtil;
import java.util.Map;

public class CommonService {
	
	private DBUtil db=new DBUtil();
	
	public Map getDownLoadFile(String id){
		String sql="select filePath,fileName from files where id=?";
		return db.getMap(sql, new String[]{id});
	}
	public void updateHits(String id){
		String sql="update files set hits=hits+1 where id=?";
		db.update(sql, new String[]{id});
	}
}
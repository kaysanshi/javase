package service;

import java.io.File;
import java.util.Map;

import util.DButils;

import util.PageBean;

public class AdminService {
	
	private DButils db=new DButils();
    //��֤��¼��Ϣ
	public boolean checkLogin(String username,String password){
		String sql="select * from admin where username=? and password=?";
		Map m=db.getMap(sql, new String[]{username,password});
		if(m==null)
			return false;
		else
			return true;
	}
    //�����Ϣ
	public int add(Map file,Map parameters){
		int result=0;
		String name=(String)parameters.get("name");
		String size=(String)file.get("size");
		String hits="0";
		String type=(String)parameters.get("type");
		String description=(String)parameters.get("description");
		String filePath=(String)file.get("filePath");
		String fileName=(String)file.get("fileName");
		String sql="insert into files values(null,?,now(),?,?,?,?,?,?)";
		result=db.update(sql, new String[]{name,size,hits,type,description,filePath,fileName});
		return result;
	}
    //���������Ϣ��PageBean����
	public PageBean list(int curPage){
		String sql="select id,name,lastModified,size,hits,description from files";
		return db.getPageBean(sql, new String[]{}, curPage);
	}
    //ͨ��id����������Ϣ
	public Map getById(String id){
		String sql="select * from files where id=?";
		return db.getMap(sql, new String[]{id});
	}
    //�����ϴ��ļ���Ϣ
	public int updateFile(String realPath,Map file,Map parameters){
		int result=0;
		File f=new File(realPath);
		f.delete();
		String sql="update files set size=?,hits=?,filePath=?,fileName=? where id=?";
		result=db.update(sql, new String[]{(String)file.get("size"),"0",(String)file.get("filePath"),(String)file.get("fileName"),(String)parameters.get("id")});
		return result;
	}
    //������Ϣ
	public int updateInfo(Map parameters){
		String id=(String)parameters.get("id");
		String name=(String)parameters.get("name");
		String type=(String)parameters.get("type");
		String description=(String)parameters.get("description");
		String sql="update files set name=?,lastModified=now(),type=?,description=? where id=?";
		return db.update(sql, new String[]{name,type,description,id});
	}
}
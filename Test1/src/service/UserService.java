package service;

import java.util.List;
import java.util.Map;

import util.DButils;

import util.PageBean;

public class UserService {
	private DButils db=new DButils();
	
    //���������Ϣ��PageBean����
	public PageBean listAll(int curPage){
		String sql="select * from files order by lastModified desc";
		return db.getPageBean(sql, new String[]{}, curPage);
	}
	//������ش�������ǰ10λ����Ϣ
	public List topList(){
		String sql="select id,name,hits from files where hits!=0 order by hits desc limit 0,10";
		return db.getList(sql, new String[]{});
	}
    //ͨ��id��õ���������Ϣ
	public Map getById(String id){
		String sql="select * from files where id=?";
		return db.getMap(sql, new String[]{id});
	}
    //���ָ�����͵�������Ϣ��PageBean����
	public PageBean listSort(String type, int curPage) {
		String sql=null;
		if(type==null || type.equals("")){
			sql="select * from files order by type";
			return db.getPageBean(sql, new String[]{}, curPage);
		}else{
			sql="select * from files where type=?";
			return db.getPageBean(sql, new String[]{type}, curPage);
		}
	}
    //���ָ�����ͺ�ָ�����Ƶ�������Ϣ��PageBean����
	public PageBean search(String type,String name,int curPage){
		String sql=null;
		if(type==null || type.equals("")){
			if(name==null || name.equals("")){
			   sql="select * from files order by type";
			   return db.getPageBean(sql, new String[]{}, curPage);
			}else{
			   sql="select * from files where name like ?";
			   return db.getPageBean(sql, new String[]{"%"+name+"%"}, curPage);
			}
		}else{
			if(name==null || name.equals("")){
			   sql="select * from files where type=?";
			   return db.getPageBean(sql, new String[]{type}, curPage);
			}else{
			   sql="select * from files where type=? and name like ?";
			   return db.getPageBean(sql, new String[]{type,"%"+name+"%"}, curPage);
			}
		}
	}
}

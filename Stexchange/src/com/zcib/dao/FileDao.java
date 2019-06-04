package com.zcib.dao;

import java.util.List;
import java.util.Map;

import com.zcib.domain.Files;
import com.zcib.utils.DBUtils;
import com.zcib.utils.PageBean;

/**
 * 文件操作
 * @author 555
 *@date 2018年5月13日
 */
public class FileDao {
	/**
	 *添加文件
	 * @param files
	 * @return
	 */
	public boolean addFile(Files files) {
		// TODO Auto-generated method stub
		String sql="insert into files values(?,?,?,?,?,?,?,?,?)";
		//由于储存的是id为int类型的所以要转成String类型、在后来的操作要变为int类型
		//或者用Integer.toString()的方法来转化成String类型的
		String[] params={null,files.getUuidname(),files.getFiletitle(),files.getRealname(),files.getUploadip(),files.getSavepath(),files.getDescription(),files.getUploadtime(),Integer.toString(files.getUploadteacherid())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		if (i>0) {
			System.out.println("db添加成功");
			return true;
		}else{
			System.out.println("添加失败");
			return false;
		}
		
	}
	/**
	 * 
	 * @return
	 */
	public List<Map<String,Object>> getListFile() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list=null;
		String sql="select * from files where 1=?";
		String[] params={"1"};
		DBUtils db=new DBUtils();
		list=db.getList(sql, params);
		return list;
	}
	/**
	 * 获得总的行数
	 * @return
	 */
//	public int getTotalRow() {
//		// TODO Auto-generated method stub
//		DBUtils dbUtils=new DBUtils();
//		String sql="files";
//		//有问题不能进行查询出来总的页数
//		//String[] params={"null"};
//		return dbUtils.getTotalRows(sql, params);
//	}
	/**
	 * 获得PageBean分页
	 * @param curPage
	 * @return
	 */
	public PageBean getPageBean(int curPage) {
		// TODO Auto-generated method stub
		//用于后面截取sql的操作
		String sql="select id,uuidname,filetitle,realname,uplaodip,savepath,description,uploadtime,uploadteacherid from files ";
		DBUtils db=new DBUtils();
//		String[] params={};
//		System.out.println(params);
		System.out.println();
		return db.getPageBean(sql,new String[]{}, curPage);
	}
	/**
	 * 查询的封装
	 * @param sql
	 * @param strings
	 * @param curPage
	 * @return
	 */
	public PageBean getSerachBean(String sql, String[] strings, int curPage) {
		// TODO Auto-generated method stub
		DBUtils dbUtils=new DBUtils();
		return dbUtils.getPageBean(sql, strings, curPage);
	}
	/**
	 * 删除id
	 * @param filesid
	 * @return
	 */
	public boolean deltefile(String filesid) {
		// TODO Auto-generated method stub
		String sql="delete from files where id=?";
		String[] params={filesid};
		DBUtils dbUtils=new DBUtils();
		int i=dbUtils.update(sql, params);
		if (i>0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getFileById(String id) {
		// TODO Auto-generated method stub
		String sql="select * from files where id=?";
		String[] params={id};
		DBUtils db=new DBUtils();
		return db.getList(sql, params);
	}
	/**
	 * 查询
	 * @param curPage
	 * @param filename
	 * @return
	 */
	public PageBean SearchPageBean(int curPage, String filename) {
		// TODO Auto-generated method stub
		String sql="select * from files where filetitle like ?";
		DBUtils db=new DBUtils();
		String[] params={"%"+filename+"%"};
//		System.out.println(params);
		System.out.println(params.toString());
		return db.getPageBean(sql,params, curPage);
	}
	/**
	 * 通过个人获取分页
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean getPageBean(int curPage, String teacherid) {
		// TODO Auto-generated method stub
		String sql="select id,uuidname,filetitle,realname,uplaodip,savepath,description,uploadtime,uploadteacherid from files where uploadteacherid=?";
		DBUtils db=new DBUtils();
		String[] params={teacherid};
//		System.out.println(params);
		System.out.println();
		return db.getPageBean(sql,params, curPage);
	}
	/**
	 * 获取全部
	 * @param curPage
	 * @return
	 */
	public PageBean getAllPageBean(int curPage) {
		// TODO Auto-generated method stub
		String sql="select id,uuidname,filetitle,realname,uplaodip,savepath,description,uploadtime,uploadteacherid from files ";
		DBUtils db=new DBUtils();
		return db.getPageBean(sql,new String[]{}, curPage);
	}
	/**
	 * 修改文件
	 * @param files
	 * @return
	 */
	public int updateSaveFile(Files files) {
		// TODO Auto-generated method stub
		String sql="update files set filetitle=?,description=? where id=?";
		DBUtils db=new DBUtils();
		String[] params={files.getFiletitle(),files.getDescription(),String.valueOf(files.getId())};
		return db.update(sql, params);
		
	}
	
}

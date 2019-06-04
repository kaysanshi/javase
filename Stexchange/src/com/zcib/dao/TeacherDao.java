package com.zcib.dao;

import java.util.List;
import java.util.Map;

import com.zcib.domain.Student;
import com.zcib.domain.Teacher;
import com.zcib.utils.DBUtils;
import com.zcib.utils.PageBean;
/**
 * 教师的操作
 * @author 555
 *@date 2018年5月12日
 */
public class TeacherDao {
	/**
	 * 检查用户名和密码
	 * @param username
	 * @param password
	 * @return
	 */
	public Teacher cherckUser(String username, String password) {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher();
		String sql="select id,username,password from teacher where username=? && password=?";
		String[] params={username,password};
		DBUtils dbUtils=new DBUtils();
		
		Map map=dbUtils.getMap(sql, params);
		if (map==null) {
			return teacher;
		}
		teacher.setUsername(map.get("username").toString());
		teacher.setPassword(map.get("password").toString());
		teacher.setId((int)(map.get("id")));
		return teacher;
	}
	/**
	 * 注册用户
	 * @param teacher
	 * @return
	 */
	public boolean registTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
		String sql="insert into teacher(id,username,password) values(?,?,?)";
		String[] params={
				null,teacher.getUsername(),teacher.getPassword()
		};
		DBUtils db=new DBUtils();
		int status=db.update(sql, params);
		if (status!=0) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取
	 * @return
	 */
	public List<Map<String, Object>> getAllTeacher() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		String sql="select * from teacher where 1=?";
		String[] params={"1"};
		DBUtils db=new DBUtils();
		list=db.getList(sql, params);
		return list;
	}
	/**
	 * 获取教师个人信息;
	 * @param teacherid
	 * @return
	 */
	public List<Map<String, Object>> getTeacherId(String teacherid) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=null;
		String sql="select * from teacher where id=?";
		String[] params={teacherid};
		list=new DBUtils().getList(sql, params);
		return list;
	}
	/**
	 * 
	 * @param teacher
	 * @return
	 */
	public boolean saveInfo(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="update teacher set realname=?,sex=?,age=?,email=?,addtime=? where id=?";
		System.out.println(teacher.getId());
		String[] params={teacher.getRealname(),teacher.getSex(),String.valueOf(teacher.getAge()),teacher.getEmail(),teacher.getAddtime(),String.valueOf(teacher.getId())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		System.out.println(i);
		if (i>0) {
			return true;
		}else{
			System.out.println("未能成功添加");
			return false;
		}
	}
	/**
	 * 修改
	 * @param teacher
	 * @return
	 */
	public boolean updateInfo(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="update student set realname=?,sex=?,age=?,email=?,addtime=? where id=?";
		System.out.println(teacher.getId());
		String[] params={teacher.getRealname(),teacher.getSex(),String.valueOf(teacher.getAge()),teacher.getEmail(),teacher.getAddtime(),String.valueOf(teacher.getId())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		System.out.println(i);
		if (i>0) {
			return true;
		}else{
			System.out.println("未能成功修改");
			return false;
		}
	}
	/**
	 * 所有教师
	 * @param curPage
	 * @return
	 */
	public PageBean getAllTeacherPageBean(int curPage) {
		// TODO Auto-generated method stub
		
		String sql="select id,username,password,realname,sex,age,email,addtime from teacher";
		DBUtils db=new DBUtils();
		return db.getPageBean(sql,new String[]{}, curPage);
	}
	/**
	 * 删除教师信息
	 * @param teacher
	 * @return
	 */
	public int deletTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="delete from teacher where id=?";
		DBUtils dbUtils=new DBUtils();
		String[] params={String.valueOf(teacher.getId())};
		int i=dbUtils.update(sql, params);	
		return i;
	}

}

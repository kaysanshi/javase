package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.StudentDao;
import com.zcib.domain.Student;
import com.zcib.utils.PageBean;
/**
 * 学生操作业务逻辑
 * @author 555
 *@date 2018年5月8日
 */
public class StudentService {
	private StudentDao  dao=new StudentDao();
	/**
	 * 注册用户
	 * @param student
	 * @return
	 */
	public boolean registStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.registStudent(student);
	}
	/**
	 * 核对用户
	 * @param username
	 * @param password
	 * @return
	 */
	public Student checkUser(String username, String password) {
		return dao.checkUser(username,password);
		// TODO Auto-generated method stub
		
	}
	/**
	 * 获得student
	 * @param student
	 * @return
	 */
	public List<Map<String, Object>> getInfoById(Student student) {
		// TODO Auto-generated method stub
		return dao.getInfoById(student);
	}
	/**
	 * 信息完善
	 * @param student
	 * @return
	 */
	public boolean saveInfo(Student student) {
		// TODO Auto-generated method stub
		return dao.saveInfo(student);
	}
	/**
	 * 修改信息
	 * @param student
	 * @return
	 */
	public boolean updateInfo(Student student) {
		// TODO Auto-generated method stub
		return dao.updateInfo(student);
	}
	/**
	 * 获取所有学生的列表
	 * @return
	 */
	public List<Map<String, Object>> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}
	/**
	 * 
	 * @param curPage
	 * @return
	 */
	public PageBean getAllStudentPageBean(int curPage) {
		// TODO Auto-generated method stub
		return dao.getAllStudentPageBean(curPage);
	}
	/**
	 * 删除学生
	 * @param student
	 * @return
	 */
	public int deletStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.deletStudent(student);
	}

}

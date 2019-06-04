package com.zcib.service;


import java.util.List;

import com.zcib.domain.Page;
import com.zcib.domain.Problem;
/**
 * 
 * @author 555
 *
 */
public interface ProblemService {
	/**
	 * 问题添加
	 * @param problem
	 * @return 
	 */
	Boolean addProblem(Problem problem);
	/**
	 * 问题列表
	 * @return
	 */
	List<Problem> getAllProblem();
	/**
	 * 获取问题信息
	 * @param id
	 */
	Problem getinfobyid(String id);
	/**
	 * 修改问题
	 * @param id
	 */
	void updateProblem(Problem problem);
	/**
	 * 删除问题
	 * @param problem
	 * @return 
	 */
	boolean delProblem(Problem problem);
	/**
	 * 查询
	 * @param problem
	 * @return
	 */
	List<Problem> findProblembyCheck(Problem problem);
	/**
	 * 获得个数
	 * @return
	 */
	int getAllProblemCount();
	/**
	 * 出题
	 * @return
	 */
	List<Problem> outProblem(int count);
	/**
	 * 获取行的id
	 * @return
	 */
	List<Object> getRowid();
	/**
	 * 获取响应的id的答案；
	 * @param title
	 * @return
	 */
	List<Object[]> serchAnswer(String title);
	/**
	 * 获取分页的
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page getPageProblem(int thispage, int rowperpage);
	/**
	 * 获得问题
	 * @param problem
	 * @return
	 */
	Problem getProblem(Problem problem);
	

}

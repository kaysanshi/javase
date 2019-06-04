package com.zcib.dao;

import java.sql.Connection;
import java.util.List;

import com.zcib.domain.News;
import com.zcib.domain.Problem;
/**
 * 
 * @author 555
 *
 */
public interface ProblemDao {
	/**
	 * 问题增加
	 * @param problem
	 * @return
	 */
	boolean addProblem(Problem problem,Connection conn);
	/**
	 * 问题列表
	 * @return
	 */
	List<Problem> getAllProblem();
	/**
	 * 获取是否有这个
	 * @param subjecttitle
	 * @param conn
	 * @return
	 */
	Problem findProblemByName(String subjecttitle, Connection conn);
	/**
	 * 获取信息通过id
	 * @param id
	 */
	Problem getinfobyid(String id);
	/**
	 * 修改信息
	 * @param problem
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
	 * 获得问题的个数
	 * @return
	 */
	int getAllProblemCount();
	/**
	 * 出题
	 * @param count
	 * @return
	 */
	List<Problem> outProblem(int count);
	/**
	 *获取行的id;
	 * @return
	 */
	List<Object> getRowid();
	/**
	 * 根据id搜索答案
	 * @param object
	 * @return
	 */
	List<Object[]> serchAnswer(String string);
	/**
	 * 获取多少行
	 * @return
	 */
	int getCountRow();
	/**
	 * 
	 * @param i
	 * @param rowperpage
	 * @return
	 */
	List<Problem> getPageProblem(int i, int rowperpage);
	/**
	 * 获得一条记录
	 * @param problem
	 * @return
	 */
	Problem getProblem(Problem problem);

}

package com.zcib.service;

import java.sql.Connection;
import java.util.List;

import com.zcib.dao.ProblemDao;
import com.zcib.domain.News;
import com.zcib.domain.Page;
import com.zcib.domain.Problem;
import com.zcib.domain.User;
import com.zcib.factory.BasicFactory;
import com.zcib.utils.DaoUtils;
/**
 * 
 * @author 555
 *
 */
public class ProblemServiceImpl implements ProblemService {
	ProblemDao dao=BasicFactory.getFactory().GetInstance(ProblemDao.class);
	@Override
	public Boolean addProblem(Problem problem) {
		// TODO Auto-generated method stub
		Connection conn = DaoUtils.getConnection();
		//1.
		if(dao.findProblemByName(problem.getSubjecttitle(),conn)!=null){
			throw new RuntimeException("已有这个问题!!");
		}
		//2.
		 return dao.addProblem(problem,conn);
	}
	@Override
	public List<Problem> getAllProblem() {
		// TODO Auto-generated method stub
		return dao.getAllProblem();
	}
	@Override
	public Problem getinfobyid(String id) {
		// TODO Auto-generated method stub
		return dao.getinfobyid(id);
	}
	@Override
	public void updateProblem(Problem problem) {
		// TODO Auto-generated method stub
		dao.updateProblem(problem);
	}
	@Override
	public boolean delProblem(Problem problem) {
		// TODO Auto-generated method stub
		return dao.delProblem(problem);
	}
	@Override
	public List<Problem> findProblembyCheck(Problem problem) {
		// TODO Auto-generated method stub
		return dao.findProblembyCheck(problem);
	}
	@Override
	public int getAllProblemCount() {
		// TODO Auto-generated method stub
		return dao.getAllProblemCount();
	}
	
	@Override
	public List<Problem> outProblem(int count) {
		// TODO Auto-generated method stub
		return dao.outProblem(count);
	}
	@Override
	public List<Object> getRowid() {
		// TODO Auto-generated method stub
		return dao.getRowid();
	}
	@Override
	public List<Object[]> serchAnswer(String a) {
		// TODO Auto-generated method stub
		return dao.serchAnswer(a);
	}
	@Override
	public Page getPageProblem(int thispage, int rowperpage) {
		// TODO Auto-generated method stub
		Page page=new Page();
		//--当前页
				page.setThispage(thispage);
				//--每页记录数
				page.setRowperpage(rowperpage);
				//--共有多少行
				int countrow = dao.getCountRow();
				page.setCountrow(countrow);
				//--共有多少页
				int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
				page.setCountpage(countpage);
				//--首页
				page.setFirstpage(1);
				//--尾页
				page.setLastpage(countpage);
				//--上一页
				page.setPrepage(thispage==1?1:thispage-1);
				//--下一页
				page.setNextpage(thispage == countpage ? countpage : thispage+1);
				//--当前页数据
				List<Problem> list = dao.getPageProblem((thispage-1)*rowperpage,rowperpage);
				page.setList(list);
				
				return page;
	}
	@Override
	public Problem getProblem(Problem problem) {
		// TODO Auto-generated method stub
		return dao.getProblem(problem);
	}


}

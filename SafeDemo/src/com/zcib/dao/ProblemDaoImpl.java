package com.zcib.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zcib.domain.Problem;
import com.zcib.domain.User;
import com.zcib.utils.DaoUtils;
import com.zcib.utils.SimpleDate;
/**
 * 
 * @author 555
 *
 */
public class ProblemDaoImpl implements ProblemDao {

	@Override
	public boolean addProblem(Problem problem,Connection conn) {
		// TODO Auto-generated method stub
		String sql = "insert into problem values(null,?,?,?,?,?,?,?,?,?,?,null)";
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
		try{
			int i=runner.update(conn,sql,problem.getSubjecttitle(),problem.getType(),problem.getSubjectOptionA(),problem.getSubjectOptionB(),problem.getSubjectOptionC(),problem.getSubjectOptionD(),problem.getSubjectAnswer(),problem.getSubjectParse(),problem.getUpid(),new SimpleDate().getdate());
			System.out.println(i);
			if (i>0) {
				return true;
			}else{
				return false;
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		}
	}

	@Override
	public List<Problem> getAllProblem() {
		// TODO Auto-generated method stub
		String sql="select * from problem ";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Problem>(Problem.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Problem findProblemByName(String subjecttitle, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select * from problem where subjecttitle = ?";
		try{
			QueryRunner runner = new QueryRunner();
			return runner.query(conn,sql, new BeanHandler<Problem>(Problem.class),subjecttitle);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Problem getinfobyid(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from problem where subjectid = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Problem>(Problem.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateProblem(Problem problem) {
		// TODO Auto-generated method stub
		String sql="update problem set subjectTitle=?, subjectOptionA=?,subjectOptionB=?,subjectOptionC=?,subjectOptionD=?,subjectAnswer=?,subjectParse=?,where id=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			runner.update(sql,problem.getSubjecttitle(),problem.getSubjectOptionA(),problem.getSubjectOptionB(),problem.getSubjectOptionC(),problem.getSubjectOptionD(),problem.getSubjectAnswer(),problem.getSubjectParse(),problem.getSubjectid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("未能修改");
		}
	}

	@Override
	public boolean delProblem(Problem problem){
		// TODO Auto-generated method stub
		String sql="delete from problem where subjectid=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			int i=runner.update(sql,problem.getSubjectid());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Problem> findProblembyCheck(Problem problem) {
		// TODO Auto-generated method stub
		String sql = "select * from problem where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(problem.getSubjecttitle()!=null && !"".equals(problem.getSubjecttitle())){
			sql += " and subjecttitle like ? ";
			list.add("%"+problem.getSubjecttitle()+"%");
		}
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<Problem>(Problem.class));
			}else{
				return runner.query(sql, new BeanListHandler<Problem>(Problem.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getAllProblemCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from problem";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Problem> outProblem(int count) {
		// TODO Auto-generated method stub
		//String sql = "select * from problem where subjectid = ?";
		String sql1="select * from problem  order by rand() limit 15";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return  runner.query(sql1, new BeanListHandler<Problem>(Problem.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/***
	 * 未用到
	 */
	@Override
	public List<Object> getRowid() {
		// TODO Auto-generated method stub
		String sql="select subjectid from problem ";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new ColumnListHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 查找这些答案
	 * @param string
	 * @return
	 */
	@Override
	public List<Object[]> serchAnswer(String string) {
		// TODO Auto-generated method stub
		String sql="select subjectAnswer from problem where subjectid= ? or subjectid=? or subjectid=? or subjectid=? or subjectid= ? or subjectid=? or subjectid=? or subjectid=?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new ArrayListHandler(),string.split(","));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		String sql="select count(*) from problem";
		QueryRunner runner=new QueryRunner(DaoUtils.getSource());
		try {
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Problem> getPageProblem(int i, int rowperpage) {
		// TODO Auto-generated method stub
		String sql="select * from problem limit ?,?";
		try {
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Problem>(Problem.class),i,rowperpage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Problem getProblem(Problem problem) {
		// TODO Auto-generated method stub
		String sql = "select * from problem where subjectid = ?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Problem>(Problem.class),problem.getSubjectid());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

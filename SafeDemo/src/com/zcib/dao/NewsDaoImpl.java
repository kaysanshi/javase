package com.zcib.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zcib.domain.News;
import com.zcib.domain.Video;
import com.zcib.utils.DaoUtils;
import com.zcib.utils.SimpleDate;
/**
 * 
 * @author 555
 *
 */
public class NewsDaoImpl implements NewsDao{

	@Override
	public News findNewsByName(String title, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "select * from news where title = ?";
		try{
			QueryRunner runner = new QueryRunner();
			return runner.query(conn,sql, new BeanHandler<News>(News.class),title);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean addNews(News news, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "insert into news values(null,?,?,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner();
			
			int i=runner.update(conn,sql,news.getTitle(),news.getAuthor(),news.getPicturename(),news.getPicturepath(),news.getType(),news.getContent(),news.getUpid(),new SimpleDate().getdate());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		String sql="select * from news";
		QueryRunner runner=new QueryRunner(DaoUtils.getSource());
		try {
			return runner.query(sql, new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		String sql="select count(*) from news";
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
	public List<News> getPageNews(int i, int rowperpage) {
		// TODO Auto-generated method stub
		String sql = "select * from news limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class),i,rowperpage);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Boolean deleteNews(News news) {
		// TODO Auto-generated method stub
		String sql = "delete from news where id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			
			int i=runner.update(sql,news.getId());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public News getNews(News news) {
		// TODO Auto-generated method stub
		String sql = "select * from news where id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<News>(News.class),news.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Boolean updateNews(News news) {
		// TODO Auto-generated method stub
		String sql = "update news set title=?,author=?,picturename=?,picturepath=?,type=?,content=?,upid=?,uptime=? where id=?&&upid=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			
			int i=runner.update(sql,news.getTitle(),news.getAuthor(),news.getPicturename(),news.getPicturepath(),news.getType(),news.getContent(),news.getUpid(),new SimpleDate().getdate(),news.getId(),news.getUpid());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

package com.zcib.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zcib.domain.Problem;
import com.zcib.domain.Video;
import com.zcib.domain.User;
import com.zcib.utils.DaoUtils;
/**
 * 
 * @author 555
 *
 */
public class VideoDaoImpl implements VideoDao {

	@Override
	public Boolean addVideo(Video video){
		// TODO Auto-generated method stub
		try {
			String sql="insert into video values(null,?,?,?,?,?,?,null,?,?)";
			QueryRunner runner=new QueryRunner(DaoUtils.getSource());
			int i=runner.update(sql,video.getUuidname(),video.getVideotitle(),video.getRealname(),video.getType(),video.getSavepath(),video.getIp(),video.getDiscription() ,video.getId());
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
	public List<Video> getAllVideo() {
		// TODO Auto-generated method stub
		String sql = "select * from video";
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		List<Video> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Video>(Video.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Video getVideo(String id) {
		// TODO Auto-generated method stub
		Video resource=null;
		String sql = "select * from video where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			resource= runner.query(sql, new BeanHandler<Video>(Video.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return resource;
		
	}

	@Override
	public boolean delVideo(Video video) {
		// TODO Auto-generated method stub
		String sql="delete from video where id=?";
		QueryRunner runner=new QueryRunner(DaoUtils.getSource());
		try {
			int i=runner.update(sql,video.getId());
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
	public List<Video> getRedomVideo() {
		// TODO Auto-generated method stub
		String sql1="select * from video  order by rand() limit 5";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return  runner.query(sql1, new BeanListHandler<Video>(Video.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Video> getPageVideo(int i,int rowperpage) {
		// TODO Auto-generated method stub
		String sql = "select * from video limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Video>(Video.class),i,rowperpage);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String sql = "select count(*) from video";
				try{
					QueryRunner runner = new QueryRunner(DaoUtils.getSource());
					return ((Long)runner.query(sql, new ScalarHandler())).intValue();
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
	}
	

}

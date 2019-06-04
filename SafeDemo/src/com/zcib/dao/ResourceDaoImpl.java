package com.zcib.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.zcib.domain.Resource;
import com.zcib.utils.DaoUtils;
/**
 * 
 * @author 555
 *@date 2018年7月3日
 */
public class ResourceDaoImpl implements ResourceDao{
	//new ScalarHandler();
	////ScalarHandler:获取结果集中第一行数据指定列的值,常用来进行单值查询
	@Override
	public int getCountRow() {
		// TODO Auto-generated method stub
				String sql="select count(*) from resource";
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
	public List<Resource> getPageResource(int i, int rowperpage) {
		// TODO Auto-generated method stub
		String sql = "select * from resource limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Resource>(Resource.class),i,rowperpage);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Boolean addResource(Resource resource,Connection conn) {
		// TODO Auto-generated method stub
		//资源添加：
		String sql="insert into resource values(null,?,?,?,?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner(DaoUtils.getSource());
		try {
			int i= runner.update(conn,sql,resource.getUuidname(),resource.getRealname(),resource.getResourcetitle(),resource.getType(),resource.getSavepath(),resource.getPicture(),resource.getDiscription(),resource.getUptime(),resource.getUpid());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Resource getResource(Resource resource) {
		// TODO Auto-generated method stub
		String sql = "select * from resource where id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Resource>(Resource.class),resource.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Boolean updateResource(Resource resource) {
		// TODO Auto-generated method stub
		//资源添加：
				String sql="update resource set  resourcetitle=?,type=?,savepath=?,picture=?,description=?,uptime=?,where id=?&& upid=?";
				QueryRunner runner=new QueryRunner(DaoUtils.getSource());
				try {
					int i= runner.update(sql,resource.getRealname(),resource.getResourcetitle(),resource.getType(),resource.getSavepath(),resource.getPicture(),resource.getDiscription(),resource.getUptime(),resource.getUpid());
					if (i>0) {
						return true;
					}else{
						return false;
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException();
				}
	}

	@Override
	public boolean deleteResource(Resource resource) {
		// TODO Auto-generated method stub
		String sql="delete from resource where id=?";
		QueryRunner runner=new QueryRunner(DaoUtils.getSource());
		try {
			int i= runner.update(sql,resource.getId());
			if (i>0) {
				return true;
			}else{
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}

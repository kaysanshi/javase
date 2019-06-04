package com.zcib.dao;

import java.util.List;
import java.util.Map;

import org.apache.catalina.util.ServerInfo;

import com.zcib.domain.Video;
import com.zcib.utils.DBUtils;
import com.zcib.utils.PageBean;

/**
 * 视频
 * @author 555
 *@date 2018年5月12日
 */
public class VideoDao {
	/**
	 * 获去listvideo
	 * @return
	 */
	public List getListvideo() {
		// TODO Auto-generated method stub
		List list=null;
		String sql="select * from video where 1=?";
		String[] params={"1"};
		DBUtils db=new DBUtils();
		list=db.getList(sql, params);
		return list;
	}
	/**
	 * 
	 * @param video
	 * @return 
	 */
	public boolean addvideo(Video video) {
		// TODO Auto-generated method stub
		String sql="insert into video values(?,?,?,?,?,?,?,?,?)";
		//由于储存的是id为int类型的所以要转成String类型、在后来的操作要变为int类型
		//或者用Integer.toString()的方法来转化成String类型的
		//这里的图片未能够添加
		String[] params={null,video.getUuidname(),video.getVideotitle(),null,video.getDescription(),video.getUploadip(),video.getSavepath(),video.getUplaodteime(),Integer.toString(video.getUploadteacherid())};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		if (i>0) {
			System.out.println("添加成功");
			return true;
		}else{
			System.out.println("添加失败");
			return false;
		}
	}
	/**
	 * 删除视频的
	 * @param id
	 * @return
	 */
	public boolean delteVideo(String id) {
		// TODO Auto-generated method stub
		String sql="delete from video where id=?";
		String[] params={id};
		DBUtils db=new DBUtils();
		int i=db.update(sql, params);
		if (i>0) {
			System.out.println("删除成功");
			return true;
		}else{
			System.out.println("删除失败");
			return false;
		}
	}
	/**
	 * 获得pagebean
	 * @return
	 */
	public PageBean getAllListPage(int curPage) {
		// TODO Auto-generated method stub
		String sql="select id,uuidname,videotitle,videopicture,description,uploadip,savepath,uploadtime,uploadteacherid from video";
		DBUtils db=new DBUtils();
		return db.getPageBean(sql, new String[]{}, curPage);
	}
	/**
	 * 获得视频的路径然后播放
	 * @param videoid
	 * @return
	 */
	public List<Map<String, Object>> getvideo(String videoid) {
		// TODO Auto-generated method stub
		String sql="select * from video where id = ?";
		String[] params={videoid};
		DBUtils db=new DBUtils();
		List<Map<String, Object>>  list=db.getList(sql, params);
		return list;
	}
	/**
	 * 
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean getListPageByTid(int curPage, String teacherid) {
		// TODO Auto-generated method stub
		String sql="select id,uuidname,videotitle,videopicture,description,uploadip,savepath,uploadtime,uploadteacherid from video where uploadteacherid=?";
		DBUtils db=new DBUtils();
		String[] params={teacherid};
		return db.getPageBean(sql, params, curPage);
	}
	/**
	 * 教师端搜索
	 * @param videotitle
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean searchVideoByTid(String videotitle, int curPage, String teacherid) {
		// TODO Auto-generated method stub
		String sql="select * from video where videotitle like ? && uploadteacherid=?";
		String[] params={"%"+videotitle+"%",teacherid};
		DBUtils db=new DBUtils();
		return db.getPageBean(sql, params, curPage);
	}

}

package com.zcib.service;

import java.util.List;
import java.util.Map;

import com.zcib.dao.VideoDao;
import com.zcib.domain.Video;
import com.zcib.utils.PageBean;

/**
 * 视频
 * @author 555
 *@date 2018年5月12日
 */
public class VideoService {
	VideoDao dao =new VideoDao();
	/**
	 *获取Video列表
	 * @return
	 */
	public List<Map<String, Object>> getListvideo() {
		// TODO Auto-generated method stub
		return dao.getListvideo();
	}
	/**
	 * video增加
	 * @param video
	 * @return 
	 */
	public boolean addvideo(Video video) {
		// TODO Auto-generated method stub
		return dao.addvideo(video);
	}
	/**
	 * Video删除
	 * @param id
	 * @return
	 */
	public boolean delteVideo(String id) {
		// TODO Auto-generated method stub
		return dao.delteVideo(id);
	}
	/**
	 * 获得pagebean
	 * @return
	 */
	public PageBean getAllListPage(int curpage) {
		// TODO Auto-generated method stub
		return dao.getAllListPage(curpage);
	}
	/**
	 * 获取视频的路径 
	 * @param videoid
	 * @return
	 */
	public List<Map<String, Object>> getVideo(String videoid) {
		// TODO Auto-generated method stub
		return dao.getvideo(videoid);
	}
	/**
	 * 通过教师的id来查询出自己上传的视频
	 * @param curPage
	 * @param teacherid
	 * @return
	 */
	public PageBean getListPageByTid(int curPage, String teacherid) {
		// TODO Auto-generated method stub
		return dao.getListPageByTid(curPage,teacherid);
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
		
		
		return dao.searchVideoByTid(videotitle,curPage,teacherid);
	}

}

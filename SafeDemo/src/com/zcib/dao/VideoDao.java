package com.zcib.dao;

import java.util.List;

import com.zcib.domain.Video;
/**
 * 
 * @author 555
 *	视频的操作
 */
public interface VideoDao {
	/**
	 * 增加
	 * @param resource
	 * @return 
	 */
	Boolean addVideo(Video video);
	/**
	 * 获得所有
	 * @return
	 */
	List<Video> getAllVideo();
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	Video getVideo(String id);
	/**
	 * 删除资源
	 * @param resourceid
	 * @return
	 */
	boolean delVideo(Video videoid);
	/**
	 * 随机获取视频
	 * @return
	 */
	List<Video> getRedomVideo();
	/**
	 * 获取分页的视频
	 * @return
	 */
	List<Video> getPageVideo(int i,int rowperpage);
	/**
	 * 获取总数
	 * @return
	 */
	int getCountRow();

}

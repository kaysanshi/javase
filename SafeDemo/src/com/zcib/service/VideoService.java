package com.zcib.service;

import java.util.List;

import com.zcib.domain.Page;
import com.zcib.domain.Video;
/**
 * 
 * @author 555
 *
 */
public interface VideoService {
	/**
	 * 
	 * @param resource
	 * @return 
	 */
	Boolean addVideo(Video video);
	/**
	 * @return 
	 * 
	 */
	List<Video> getAllVideo();
	/**
	 * 
	 * @param id 
	 * @return 
	 */
	Video getVideo(String id);
	/**
	 * 
	 * @param resourceid
	 * @return 
	 */
	boolean delVideo(Video videoid);
	/**
	 * 随机获取
	 * @return
	 */
	List<Video> getRedomVideo();
	/**
	 * 分页列表
	 * @return
	 */
	Page getPageVideo(int i,int rowperpage);
	
}

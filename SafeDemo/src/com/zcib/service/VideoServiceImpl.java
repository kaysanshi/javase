package com.zcib.service;

import java.util.List;
import com.zcib.dao.VideoDao;
import com.zcib.domain.Page;
import com.zcib.domain.Video;
import com.zcib.factory.BasicFactory;
import com.zcib.utils.PageBean;
/**
 * 
 * @author 555
 *
 */
public class VideoServiceImpl implements VideoService {
	VideoDao dao=BasicFactory.getFactory().GetInstance(VideoDao.class);
	@Override
	public Boolean addVideo(Video video) {
		// TODO Auto-generated method stub
		return dao.addVideo(video);
	}
	
	@Override
	public List<Video> getAllVideo() {
		// TODO Auto-generated method stub
		return dao.getAllVideo();
	}

	@Override
	public Video getVideo(String id) {
		// TODO Auto-generated method stub
		return dao.getVideo(id);
	}

	@Override
	public boolean delVideo(Video videoid) {
		// TODO Auto-generated method stub
		return dao.delVideo(videoid);
	}

	@Override
	public List<Video> getRedomVideo() {
		// TODO Auto-generated method stub
		return dao.getRedomVideo();
	}

	@Override
	public Page getPageVideo(int thispage,int rowperpage) {
		// TODO Auto-generated method stub
		Page page = new Page();
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
		List<Video> list = dao.getPageVideo((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}

	

}

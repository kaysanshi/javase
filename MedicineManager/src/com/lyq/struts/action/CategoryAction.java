package com.lyq.struts.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import com.lyq.dao.CategoryDao;
import com.lyq.persistence.Category;
import com.lyq.struts.form.CategoryForm;
import com.lyq.util.ChartUtil;
import com.sun.org.apache.commons.beanutils.BeanUtils;
/**
 * 药品类别Action类
 * @author Li Yong Qiang
 */
public class CategoryAction extends BaseAction {

	//添加或修改类别
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取类别信息
		CategoryForm cf = (CategoryForm)form;
		//创建Category对象
		Category c = new Category();
		c.setName(cf.getName());
		c.setDescription(cf.getDescription());
		c.setCreateTime(new Date());
		if(cf.getId() != 0){
			c.setId(cf.getId());
		}
		CategoryDao dao = new CategoryDao();
		dao.saveOrUpdate(c);
		return mapping.findForward("paging");
	}
	
	//查询类别
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List list = null;
		CategoryDao dao = new CategoryDao();
		list = dao.findByHQL("from Category");
		request.setAttribute("list", list);
		return mapping.findForward("findAllSuccess");
	}
	
	//编辑类别
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryForm cf = (CategoryForm)form;
		// 判断id是否有效
		if(cf.getId() > 0){
			CategoryDao dao = new CategoryDao();
			Category c = dao.loadCategory(cf.getId());
			BeanUtils.copyProperties(cf, c);
		}
		return mapping.findForward("edit");
	}
	//删除类别
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryForm cf = (CategoryForm)form;
		// 判断id是否有效
		if(cf.getId() > 0){
			CategoryDao dao = new CategoryDao();
			Category c = dao.loadCategory(cf.getId());
			dao.delete(c);	//删除类别
		}
		return mapping.findForward("paging");
	}
	
	//分页
	public ActionForward paging(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取当前页码
		String currPage = request.getParameter("currPage");
		String action = request.getContextPath()+"/baseData/category.do?command=paging";
		String hql = "from Category";
		//分页查询
		Map map = this.getPage(hql, recPerPage, currPage, action,null);
		//将结果集放到request中
		request.setAttribute("list", map.get("list"));
		//将结果集放到分页条中
		request.setAttribute("pagingBar", map.get("bar"));
		return mapping.findForward("findAllSuccess");
	}
	
	// 统计药品类别数量
	public ActionForward findCategoryAndCound(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 实例化CategoryDao对象
		CategoryDao dao = new CategoryDao();
		// 查询药品类别数量
		List list = dao.findCategoryAndCount();
		ChartUtil chartUtil = new ChartUtil();
		// 创建JFreeChart实例
		JFreeChart chart = chartUtil.categoryChart(list);
		if(chart != null){
			// 获取图片文件名
			String fileName = ServletUtilities.saveChartAsJPEG(chart,500,300,request.getSession());
	    	// 获取图片地址
			String graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
	    	// 将图片地址放置到request中
			request.setAttribute("graphURL", graphURL);
		}
		// 页面转发
		return mapping.findForward("categoryGraph");
	}
}

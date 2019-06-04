package com.xiaoxiao.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxiao.domain.Category;
import com.xiaoxiao.service.CategoryService;
//
public class AdminCategoryServlet extends HttpServlet {
	private CategoryService categoryService = new CategoryService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * 1.获取action的值，根据action值调用不同的方法
		 */
		String action = request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}else if("findAll".equals(action)){
			findAll(request,response);
		}else if("delete".equals(action)){
			deleteById(request,response);
		}else if("deleteMore".equals(action)){
			deleteMore(request,response);
		}
	}

	private void deleteMore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取要删除的id数组
		 * 2.判断id是否为空
		 * 3.调用Service层进行删除
		 * 4.调用findAll方法重新显示删除后的记录
		 */
		String []ids  = request.getParameterValues("sel");
		if(ids!=null){
			categoryService.deleteMore(ids);
			findAll(request,response);
		}
		
	}

	private void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取要删除的id
		 * 2.调用service层来deleteById进行删除
		 * 3.调用findAll方法显示新的列表
		 */
		String str = request.getParameter("id");
		categoryService.deleteById(Integer.parseInt(str));
		findAll(request,response);
		
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取当前页页码
		 * 1.调用Service层的方法获取记录，当前页页码
		 * 2.将list保存到request中
		 * 3.转发到categoryList.jsp页面
		 */
		//1.获取当前页页码
		String current = request.getParameter("current");
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(current);
		}catch(Exception e){
			currentPage = 1;
		}
		
		request.setAttribute("page", categoryService.findAll(currentPage));
		request.getRequestDispatcher("/admin/categoryList.jsp").forward(request,response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取表单数据
		 * 2.进行验证表单数据的正确
		 * 3.封装到Category对象中
		 * 4.调用Service层的方法进行添加
		 * 5.转到本身页面（以后再改）
		 */
		//1.获取表单数据
		String name = request.getParameter("name");
		String sort = request.getParameter("sort");
		//2.进行验证表单数据的正确
		if(name==null||name.trim().isEmpty()){
			//name为空
			request.setAttribute("msg", "分类名称不能为空！");
			request.getRequestDispatcher("/admin/addCategory.jsp").forward(request, response);
			return;
		}
		if(sort==null||sort.trim().isEmpty()){
			//sort为空
			request.setAttribute("msg", "分类排序号不能为空！");
			request.getRequestDispatcher("/admin/addCategory.jsp").forward(request, response);
			return;
		}
		String regex="^[1-9]+[0-9]*$";  
		Pattern p=Pattern.compile(regex);  
		Matcher m=p.matcher(sort);
		if(!m.find()){//返回true表示符合规则，false表示不符合规则
			request.setAttribute("msg", "分类排序号必须为正整数！");
			request.getRequestDispatcher("/admin/addCategory.jsp").forward(request, response);
			return;
		}
		
		//3.封装到Category对象中
		Category category = new Category();
		category.setName(name);
		category.setSort(Integer.parseInt(sort));
		// 4.调用Service层的方法进行添加
		categoryService.add(category);
		//5.转到本身页面（以后再改）
		
		request.setAttribute("msg", "<script>alert('添加成功！');window.location='"+request.getContextPath()+"/admin/addCategory.jsp'</script>");
		request.getRequestDispatcher("/admin/msg.jsp").forward(request, response);
		
	}

}

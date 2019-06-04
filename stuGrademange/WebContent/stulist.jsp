<%@page import="com.sun.glass.ui.Size"%>
<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@page import="com.utils.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//用于区分是查询还是用来显示的；
	//所有的liststudent写成tlist.jsp?action=liststudent;
		String action=request.getParameter("action");
		
		//分页：
				//如何获得这个
				int curpage=1;
					String curr=request.getParameter("curpage");
					if(curr!=null &&!curr.equals("")){
						 curpage=Integer.parseInt(curr);
					}
					String fsql=null;
						fsql="select count(*) from student";
					
					
					//z总记录数
					int totalSize=new JdbcUtils().queryExecute(fsql);
					Page pg=new Page(curpage,totalSize);
					//获取总页数
					int totalpage=pg.getTotalPage();
					//获取当前页码
					int currentpage=pg.getCurrentPage();
					if(currentpage<=1){
						curpage=1;
					}else if(currentpage>=totalpage){
						curpage=totalpage;
					}
					//开始记录的索引
					int startindex=pg.getStartIndex();
					int pagesize=pg.getPageSize();
					request.setAttribute("totalpage", totalpage);
					request.setAttribute("currentpage", currentpage);
					request.setAttribute("pagesize", pagesize);
					request.setAttribute("totalSize", totalSize);
		if(action.equals("liststudent")){
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from student where 1=? order by studentid limit "+startindex+","+pagesize;
			String[] params={"1"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			//request域把lis数据共享
			request.getRequestDispatcher("/liststudent.jsp").forward(request, response);
		}else if(action.equals("search")){
			//查询
			String text=request.getParameter("text");
			System.out.println(text);
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from student where name like ? ";
			String[] params={"%"+text+"%"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			request.getRequestDispatcher("/liststudent.jsp").forward(request, response);	
			
		}
		



%>
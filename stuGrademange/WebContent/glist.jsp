<%@page import="com.sun.glass.ui.Size"%>
<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@page import="com.utils.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//用于区分是查询还是用来显示的   
	//成绩列表
	//所有的listgrade写成glist.jsp?action=listgrade;
		String action=request.getParameter("action");
		//分页：
				
		if(action.equals("listgrade")){
			//如何获得这个
			int curpage=1;
				String curr=request.getParameter("curpage");
				if(curr!=null &&!curr.equals("")){
					 curpage=Integer.parseInt(curr);
				}
				String fsql="select count(*) from grade";
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
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from grade where 1=? order by gradeid limit "+startindex+","+pagesize;
			String[] params={"1"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			//request域把lis数据共享
			request.getRequestDispatcher("/listgrade.jsp").forward(request, response);
		}else if(action.equals("search")){
			String text=request.getParameter("text");
			//如何获得这个
			int curpage=1;
				String curr=request.getParameter("curpage");
				if(curr!=null &&!curr.equals("")){
					 curpage=Integer.parseInt(curr);
				}
				String fsql="select count(*) from grade where stuname like "+"'%'"+text+"'%'";
				
				//z总记录数
				int totalSize=new JdbcUtils().queryExecute(fsql);
				//模糊查询的总记录数得不到：？？？？
				System.out.print(totalSize);
				
				///
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
			//查询
			
			System.out.print("查询内容为："+text);
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from grade where stuname like ?order by gradeid limit "+startindex+","+pagesize;
			String[] params={"%"+text+"%"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			request.getRequestDispatcher("/listgrade.jsp").forward(request, response);	
			
		}if(action.equals("teachershowallListGrade")){
			//如何获得这个
			int curpage=1;
				String curr=request.getParameter("curpage");
				if(curr!=null &&!curr.equals("")){
					 curpage=Integer.parseInt(curr);
				}
				String fsql="select count(*) from grade";
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
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from grade where 1=? order by gradeid limit "+startindex+","+pagesize;
			String[] params={"1"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			//request域把lis数据共享
			request.getRequestDispatcher("/teachershowallListGrade.jsp").forward(request, response);
		
		}


%>
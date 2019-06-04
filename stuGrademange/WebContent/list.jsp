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
//所有listteacher.jsp全部都用list.jsp?action=listteacher;
		String action=request.getParameter("action");
		
		//分页：
		//如何获得这个
		int curpage=1;
			String curr=request.getParameter("curpage");
			if(curr!=null &&!curr.equals("")){
				 curpage=Integer.parseInt(curr);
			}
			
			String fsql="select count(*) from teacher";
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
		if(action.equals("listteacher")){
			
			///
		JdbcUtils jb=new JdbcUtils();
		String sql="select * from teacher where 1=? order by teacherid limit "+startindex+","+pagesize;
		String[] params={"1"};
		ResultSet rs=jb.queryExecute(sql, params);
		//获取所有的学生的所有信息表；
		List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
		request.setAttribute("data", data);
		//request域把lis数据共享
		request.getRequestDispatcher("/listteacher.jsp").forward(request, response);
		}else if(action.equals("search")){
			String text=request.getParameter("text");
			
			System.out.print("查询内容为："+text);
			////
			////
			JdbcUtils jb=new JdbcUtils();
			String sql="select * from teacher where gno like ?";
			String[] params={"%"+text+"%"};
			ResultSet rs=jb.queryExecute(sql, params);
			//获取所有的学生的所有信息表；
			List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
			request.setAttribute("data", data);
			request.getRequestDispatcher("/listteacher.jsp").forward(request, response);
		}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
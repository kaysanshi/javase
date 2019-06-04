<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	//1.接收数据：
	String gradeid=request.getParameter("gradeid");
   //列表教师的名字
   String teachname=request.getParameter("teachername");
   System.out.println("教师列表中的"+teachname);
 //登录的教师的姓名
 	String loginname=(String)session.getAttribute("name");
 	System.out.print("当前登录的："+loginname);
  	Map<String,Object> data=null;
  	boolean flag=false;
 	if(gradeid !=null && !gradeid.equals("")){
 		
 		
 			JdbcUtils jb=new JdbcUtils();
 	 		String sql="delete from grade where gradeid=?";
 	 		String[] params={gradeid};
 	 		flag=jb.upExecute(sql,params);
 	}
 	if(flag){
		out.println("<script>alert('删除成功');window.location.href='glist.jsp?action=listgrade'</script>");
	}else{
		out.println("<script>alert('删除失败');window.location.href='glist.jsp?action=listgrade'</script>");
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
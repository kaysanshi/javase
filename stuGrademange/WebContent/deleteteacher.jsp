<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	//1.接收数据：
	String teacherid=request.getParameter("teacherid");
  	Map<String,Object> data=null;
  	boolean flag=false;
 	if(teacherid !=null && !teacherid.equals("")){
 		JdbcUtils jb=new JdbcUtils();
 		String sql="delete from teacher where teacherid=?";
 		String[] params={teacherid};
 		flag=jb.upExecute(sql,params);	
 	}
 	if(flag){
		out.println("<script>alert('删除成功');window.location.href='list.jsp?action=listteacher'</script>");
	}else{
		out.println("<script>alert('删除失败');window.location.href='list.jsp?action=listteacher'</script>");
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
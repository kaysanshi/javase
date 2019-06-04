<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	//1.接收数据：
	String studentid=request.getParameter("studentid");
  	Map<String,Object> data=null;
  	boolean flag=false;
 	if(studentid !=null && !studentid.equals("")){
 		JdbcUtils jb=new JdbcUtils();
 		String sql="delete from student where studentid=?";
 		String[] params={studentid};
 		flag=jb.upExecute(sql,params);	
 	}
 	if(flag){
		out.println("<script>alert('删除成功');window.location.href='stulist.jsp?action=liststudent'</script>");
	}else{
		out.println("<script>alert('删除失败');window.location.href='stulist.jsp?action=liststudent'</script>");
	}
 %>
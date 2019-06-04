<%@page import="com.util.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!---逻辑处理--->
	<% 
	//对编码进行设置;
	request.setCharacterEncoding("UTF-8");
	//1.接收的数据
	String sno=request.getParameter("sno");
	String name=request.getParameter("name");
	String major=request.getParameter("major");
	String course=request.getParameter("course");
	String score=request.getParameter("score");
	String teacher=request.getParameter("teacher");
	//2.保存到数据库中
	String sql="insert into grade set sno='"+sno+"',name='"+name+"',major='"+major+"',course='"+course+"',score='"+score+"',teacher='"+teacher+"'";
	String[] param={"sno,name,major,course,score,teacher"};
	JdbcUtils jdbc=new JdbcUtils();
		boolean flag=jdbc.savegrade(sql,param);
		if(flag){
			out.println("<script>alert('录入成功');window.location.href='addgrade.jsp'</script>");
		}else{
			out.println("<script>alert('录入失败');window.location.href='addgrade.jsp'</script>");
		}
	%>

</body>
</html>
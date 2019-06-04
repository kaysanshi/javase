<%@page import="com.utils.JdbcUtils"%>
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
	//修改
	//对编码进行设置;
	request.setCharacterEncoding("UTF-8");
	//1.接收的数据
	String pwd=request.getParameter("passward");
	String studentid=request.getParameter("studentid");
	//2.保存到数据库中
	
	JdbcUtils jdbc=new JdbcUtils();
	boolean flag=false;
	
	if(studentid!=null && !studentid.equals("")){
		//修改
		String sql="update student set passward=? where studentid=?";
		String[] params={pwd,studentid};
		flag=jdbc.upExecute(sql,params);
	}
		
		if(flag){
			out.println("<script>alert('修改成功');window.location.href='MylistGrade.jsp?action=Mylistgrade'</script>");
		}else{
			if(studentid!=null && !studentid.equals("")){
				//修改失败
				out.println("<script>alert('修改失败');window.location.href='editstudentpwd.jsp?studentid="+studentid+"'</script>");
			}
		}
	%>

</body>
</html>
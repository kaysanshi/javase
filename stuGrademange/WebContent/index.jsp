<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中原工学院信息商务学院学生管理系统</title>
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main">
  <frameset cols="200,*" rows="90%,*" id="frame">
	<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main">
	<%
		String role=(String)session.getAttribute("role");
		String url="";
		if(role!=null){
				if(role.equals("student")){
					url="MylistGrade.jsp?action=Mylistgrade";
				}else if(role.equals("teacher")){
					url="teacherAddGrade.jsp";
				}else if(role.equals("admin")){
					url="list.jsp?action=listteacher";
				}
		}else{
			out.println("<script>window.parent.location.href='login.jsp'</script>");
			response.sendRedirect("login.jsp");
		}
			
	%>
	<frame src="<%=url %>" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self">
    
  </frameset>
</frameset>

</html>
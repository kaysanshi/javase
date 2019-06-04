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
	String username=request.getParameter("username");
	System.out.print(username);
	String name=request.getParameter("name");
	String pwd=request.getParameter("pd");
	String adminid=request.getParameter("adminid");
	//2.保存到数据库中
	
	JdbcUtils jdbc=new JdbcUtils();
	boolean flag=false;
	
	if(adminid!=null && !adminid.equals("")){
		//修改
		String sql="update admin set username=?,passward=?,name=? where adminid=?";
		String[] params={username,pwd,name,adminid};
		flag=jdbc.upExecute(sql,params);
	}else{
		//添加
		String sql="insert into admin(username,passward,name)values(?,?,?)";
		String[] param={username,pwd,name};
		flag=jdbc.upExecute(sql,param);
	}
		
		if(flag){
			out.println("<script>alert('录入成功');window.location.href='editAddmin.jsp?action=liststudent'</script>");
		}else{
			if(adminid!=null && !adminid.equals("")){
				//修改失败
				out.println("<script>alert('录入失败');window.location.href='editAddmin.jsp?adminid="+adminid+"'</script>");
			}else{
				//添加失败
				out.println("<script>alert('录入失败');window.location.href='editAddmin.jsp'</script>");
			}
		}
	%>

</body>
</html>
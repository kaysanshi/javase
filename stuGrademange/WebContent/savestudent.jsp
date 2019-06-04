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
	String sno=request.getParameter("sno");
	String name=request.getParameter("name");
	String sex=request.getParameter("sex");
	String pwd=request.getParameter("passward");
	String studentid=request.getParameter("studentid");
	//2.保存到数据库中
	
	JdbcUtils jdbc=new JdbcUtils();
	boolean flag=false;
	
	if(studentid!=null && !studentid.equals("")){
		//修改
		String sql="update student set sno=?,name=?,sex=?,passward=? where studentid=?";
		String[] params={sno,name,sex,pwd,studentid};
		flag=jdbc.upExecute(sql,params);
	}else{
		//添加
		String sql="insert into student(sno,name,sex,passward)values(?,?,?,?)";
		String[] param={sno,name,sex,pwd};
		flag=jdbc.upExecute(sql,param);
	}
		
		if(flag){
			out.println("<script>alert('录入成功');window.location.href='stulist.jsp?action=liststudent'</script>");
		}else{
			if(studentid!=null && !studentid.equals("")){
				//修改失败
				out.println("<script>alert('录入失败');window.location.href='editstudent.jsp?studentid="+studentid+"'</script>");
			}else{
				//添加失败
				out.println("<script>alert('录入失败');window.location.href='editstudent.jsp'</script>");
			}
		}
	%>

</body>
</html>
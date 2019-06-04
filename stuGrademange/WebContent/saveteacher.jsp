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
	//对编码进行设置;
	request.setCharacterEncoding("UTF-8");
	//1.接收的数据
	String gno=request.getParameter("gno");
	String teachername=request.getParameter("teachername");
	String sex=request.getParameter("sex");
	String pwd=request.getParameter("pwd");
	String teacherid=request.getParameter("teacherid");
	out.print(teachername);
	out.print(teacherid);
	//2.保存到数据库中
	
	JdbcUtils jdbc=new JdbcUtils();
	boolean flag=false;
	
	if(teacherid!=null && !teacherid.equals("")){
		//修改
		String sql="update teacher set gno=?,name=?,sex=?,passward=? where teacherid=?";
		String[] params={gno,teachername,sex,pwd,teacherid};
		flag=jdbc.upExecute(sql,params);
	}else{
		//添加
		String sql="insert into teacher(gno,name,sex,passward)values(?,?,?,?)";
		String[] param={gno,teachername,sex,pwd};
		flag=jdbc.upExecute(sql,param);
	}
		
		if(flag){
			out.println("<script>alert('录入成功');window.location.href='list.jsp?action=listteacher'</script>");
		}else{
			if(teacherid!=null && !teacherid.equals("")){
				//修改失败
				out.println("<script>alert('录入失败');window.location.href='editteacher.jsp?teacherid="+teacherid+"'</script>");
			}else{
				//添加失败
				out.println("<script>alert('录入失败');window.location.href='editteacher.jsp'</script>");
			}
		}
	%>

</body>
</html>
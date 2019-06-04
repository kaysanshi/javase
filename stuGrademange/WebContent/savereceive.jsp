<%@page import="com.utils.JdbcUtils"%>
<%@page import="com.utils.SimpleDate"%>
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
	
	
	
	//时间的格式化
			SimpleDate date=new SimpleDate();
			String datetime=date.getdate();
	//1.接收的数据
	String content=request.getParameter("content");
	String messageid=request.getParameter("messageid");
	System.out.println("这条信息的id："+messageid);
	//2.保存到数据库中
	
	JdbcUtils jdbc=new JdbcUtils();
	boolean flag=false;

		//添加
		String sql="update  message  set replycontent=?,replytime=? where messageid= ?";
		String[] param={content,datetime,messageid};
		flag=jdbc.upExecute(sql,param);
		
		if(flag){
			out.println("<script>alert('回复成功');window.location.href='listreceive.jsp'</script>");
		}else{
				//添加失败
				out.println("<script>alert('回复失败');window.location.href='receive.jsp'</script>");
		}
	%>

</body>
</html>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	//对编码进行设置;
	request.setCharacterEncoding("UTF-8");
	//1.接收的数据
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String role=request.getParameter("role");
	//1.检验验证码
	String checkcode = request.getParameter("checkcode");
	System.out.print(checkcode);
	String valistr2 = (String) request.getSession().getAttribute("valistr");
	System.out.print(valistr2);
	if(checkcode == null || valistr2==null || !checkcode.equals(valistr2)){
		request.setAttribute("msg", "验证码不正确!");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		return;
	}
	///测试：
	//System.out.println(username);
	//System.out.println(password);
	//System.out.println(role);
	///验证是否正确；
	boolean flag=false;
	String url="";
	if(role.equals("student")){
		JdbcUtils jdbc=new JdbcUtils();
		String sql="select* from student where sno=?and passward=?";
		String[] params={username,password};
		ResultSet rs=jdbc.queryExecute(sql, params);
		//
		//获取名学生的列表
		List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
		if(data.size()>0){
			flag=true;
			session.setAttribute("role", role);
			session.setAttribute("username", username);
			session.setAttribute("stuid", data.get(0).get("sno"));
			session.setAttribute("name", data.get(0).get("name"));
			session.setAttribute("studentid", data.get(0).get("studentid"));
		}
		url="index.jsp";
		
	}else if(role.equals("teacher")){
		JdbcUtils jdbc=new JdbcUtils();
		String sql="select* from teacher where gno=?and passward=?";
		String[] params={username,password};
		ResultSet rs=jdbc.queryExecute(sql, params);
		
		//获取名教师的列表
		List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
		if(data.size()>0){
			//把获取的信息获取
			flag=true;
			//session域：服务器端技术当前会话范围
			session.setAttribute("role", role);
			session.setAttribute("username", username);
			session.setAttribute("name", data.get(0).get("name"));
			session.setAttribute("teacherid", data.get(0).get("teacherid"));
			///测试：
			System.out.println(data.get(0).get("name"));
		}
		//教师能进行对学生的成绩的修改
		url="index.jsp";
	}else if(role.equals("admin")){
		JdbcUtils jdbc=new JdbcUtils();
		String sql="select* from admin where username=?and passward=?";
		String[] params={username,password};
		ResultSet rs=jdbc.queryExecute(sql, params);
		//
		//获取的列表
		List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
		if(data.size()>0){
			flag=true;
			session.setAttribute("role", role);
			session.setAttribute("username", username);
			session.setAttribute("id", data.get(0).get("adminid"));
			//获取个人姓名：
			//出错：不能够得到用户真实的名字
			//解决方法解决
			session.setAttribute("name", data.get(0).get("name"));
		}
		//管理能够对教师进行管理
		url="index.jsp";
	}else{
		url="login.jsp";
	}
	if(flag){
		out.println("<script>alert('登录成功');window.location.href='"+url+"'</script>");
	}else{
		out.println("<script>alert('登录失败');window.location.href='"+url+"'</script>");
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
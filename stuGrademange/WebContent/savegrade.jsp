<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@page import="com.utils.SimpleDate"%>
<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
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
		////
		System.out.println(datetime);
	//1.接收的数据
	String course=request.getParameter("course");
	String stuid=request.getParameter("studentid");
	System.out.print(stuid);
	//登录的教师的姓名
	String teachername=(String)session.getAttribute("name");
	String score=request.getParameter("score");
	//String addtime=request.getParameter("addtime");
	String gradeid=request.getParameter("gradeid");
	//当前成绩列表的教师的姓名
	///String techname=request.getParameter("teachername");
	//System.out.print("成绩列表中的教师的姓名"+techname);
	//System.out.println("登录的教师的姓名"+teachername);
	////
	//System.out.println(course);
	//System.out.println(stuname);
	//System.out.print(teachername);
	//System.out.println(score);
	//System.out.println(addtime);
	//System.out.println(course);
	
	//把姓名从学生的数据库中读出来
	//已解决
	JdbcUtils jdbc=new JdbcUtils();
	String sql1="select * from student where sno=?";
	String[] param={stuid};
	ResultSet rs=jdbc.queryExecute(sql1, param);
	/////////////问题代码：
	//获取所有的学生的所有信息表；
	List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
	Map<String,Object> d=null;
	for(int i=0;i<data.size();i++){
		 d=data.get(i);
		
	}
	String name=(String)d.get("name");
	////////////
	//2.保存到数据库中
	boolean flag=false;
	
	if(gradeid!=null && !gradeid.equals("")){
			//修改
			//出现问题：
			//解决方法：获得教师的名字然后传到sql语句中
			//已经解决
			String sql="update grade set course=?,stuname=?,teachername=?,score=?,addtime=? where gradeid=?";
			String[] params={course,name,teachername,score,datetime,gradeid};
			flag=jdbc.upExecute(sql,params);
		
	}else{
		//添加
		//	
		System.out.println(datetime);
				
		String sql="insert into grade(course,sno,stuname,teachername,score,addtime)values(?,?,?,?,?,?)";
		String[] params={course,stuid,name,teachername,score,datetime};
		flag=jdbc.upExecute(sql,params);
	}
		
		if(flag){
			out.println("<script>alert('录入成功');window.location.href='glist.jsp?action=listgrade'</script>");
		}else{
			if(gradeid!=null && !gradeid.equals("")){
				//修改失败
				out.println("<script>alert('录入失败');window.location.href='editgrade.jsp?gradeid="+gradeid+"'</script>");
			}else{
				//添加失败
				out.println("<script>alert('录入失败');window.location.href='editgrade.jsp'</script>");
			}
		}
	%>

</body>
</html>
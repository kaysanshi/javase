<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  String role=(String)session.getAttribute("role");
	String url="";
	if(role!=null){
			if(!role.equals("teacher")&&!role.equals("admin")){
				//重定向
				response.sendRedirect("login.jsp");
			}else{
				
			}
	}else{
		//重定向
		response.sendRedirect("login.jsp");
	}
  
  
  %>
  
  
 <%
	//1.接收数据：
	//读取所有数据用来编辑即 修改时进行操作语句；
	String gradeid=request.getParameter("gradeid");
 	String teachername=request.getParameter("teachername");
	String loginname=(String)session.getAttribute("name");
  	Map<String,Object> data=null;
 	if(gradeid !=null && !gradeid.equals("")){
 		JdbcUtils jb=new JdbcUtils();
 		String sql="select *from grade where gradeid=?";
 		String[] params={gradeid};
 		ResultSet rs=jb.queryExecute(sql,params);
 		 List<Map<String,Object>> list=JdbcUtils.RSToList(rs);
 		data=list.get(0);
 		
 	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑成绩</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/skin.css" rel="stylesheet" type="text/css">

</head>
<script>
		function savegrade(){
			var course=document.getElementById("course").value;
			if(course==""|| course==null){
				alert("请输入课程");
				course.focus();
				return false;
			}
			var stuname=document.getElementById("stuname").value;
			if(stuname==""|| stuname==null){
				alert("请选择学生姓名");
				stuname.focus();
				return false;
			}
			var score=document.getElementById("score").value;
			if(score==""|| score==null){
				alert("请输入成绩");
				score.focus();
				return false;
			}
			
			//用超链接提交表单；
			document.getElementById("form2").submit();
		}
</script>
<body marginwidth="0" marginheight="0">

<input type="hidden" name="operate" value="update">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tbody>
<!-- 表头  start-->
<tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif">
    <img src="images/left-top-right.gif" width="17" height="29">
    </td>
    <td valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     <tbody><tr>
        <td height="31"><div class="titlebt">添加成绩</div></td>
      </tr>
    </tbody></table>
    </td>
    <td width="16" valign="top" background="images/mail_rightbg.gif">
    <img src="images/nav-right-bg.gif" width="16" height="29">
    </td>
</tr>
<!-- 表头  end-->

<!-- 主体 start-->
<tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tbody>
		  <!-- 分割线 start-->
          <tr>
            <td height="20">
            <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
             <tbody><tr><td></td></tr>
            </tbody></table>
            </td>
          </tr>
		  <!-- 分割线 end-->
          
		  <!-- 内容 satrt-->
          <tr>
          	<td>
                   <!--表单 start/////
                   		用来提交到savegrade.jsp来操作
                   		
                   	-->
				   <form name="form2" id="form2" method="post" action="savegrade.jsp">
					<table class="admin_table font03">
					<tbody>
					<tr>
					  <td width="16%" id="td_align_right">科目</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="course" id="course" value="<%if(gradeid !=null && !gradeid.equals("")){out.print(data.get("course"));} %>" >
					  </td>
					</tr>
					<tr>
					  <td width="16%" id="td_align_right">学生</td>
					  <td id="td_align_left">
						<select id="studentid" name="studentid">
							<%
							JdbcUtils db=new JdbcUtils();
							String sql="select * from student where 1=?";
					 		String[] params={"1"};
					 		ResultSet rs=db.queryExecute(sql,params);
							 	List<Map<String,Object>> list=JdbcUtils.RSToList(rs);
							 	Map<String,Object> stu=null;
							 	/////
							 	System.out.print("size="+list.size());
							 	for(int i=0;i<list.size();i++){
							 		 stu=list.get(i);
							%>
								<option value="<%=stu.get("sno")%>"><%=stu.get("name")%></option>	
							<%
								}
							%>				
						</select>
					  
					  </td>
					</tr>
					<!-- 任职教师就在登录后显示 -->
					<tr>
					  <td width="16%" id="td_align_right">成绩</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="score" id="score" value="<%if(gradeid !=null && !gradeid.equals("")){out.print(data.get("score"));} %>" >
					  </td>
					</tr>
					<tr>
					  <td width="50px" colspan="2">
					  <input type="hidden" name="gradeid" value="<%if(gradeid !=null && !gradeid.equals("")){out.print(data.get("gradeid"));} %>">
					  
					  <input type="submit" value="保存" onclick="savegrade()" class="btn"> </td>
					</tr>
					</tbody>
				</table>
				</form>
				<!--表单 end-->

          	</td>
          </tr>
          <!-- 内容 end-->


    </tbody></table>   
    </td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
</tr>
<!-- 主体 end-->

<!-- 表尾 start-->
<tr>
    
	<td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17"></td>
  	<td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
  	<td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17">
	</td>
	
</tr>
<!-- 表尾 start-->

</tbody>
</table>




</body>
</html>
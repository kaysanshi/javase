<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@page import="com.utils.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
    
    //连接查询；获取两个表中的数据显示出来；
    JdbcUtils jb=new JdbcUtils();
    String teachername=(String)session.getAttribute("name");
    //
	String sql="select a.*,b.* from grade a,student b where a.sno=b.sno and teachername=?";
	String[] params={teachername};
	ResultSet rs=jb.queryExecute(sql, params);
	//获取所有的学生的所有信息表；
	List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>已录入成绩列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/skin.css" rel="stylesheet" type="text/css">
</head>
<script>
		function check(){
			var text=document.getElementById("username");
			if(text.value==""|| text.value==null){
				alert("请输入姓名");
				text.focus();
				return false;
			}
			window.location.href="list.jsp?action=search&text="+text.value;
		}
</script>
<body>
		
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tbody>

<!-- 表头 start-->
<tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif">
    <img src="images/left-top-right.gif" width="17" height="29">
    </td>
    <td valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="images/left_topbg" id="table2">
     <tbody><tr>
        <td height="31"><div class="titlebt">已录入列表</div></td>
      </tr>
    </tbody>
	</table>
    </td>
    <td width="16" valign="top" background="images/mail_rightbg.gif">
    <img src="images/nav-right-bg.gif" width="16" height="29">
    </td>
</tr>
<!-- 表头 end-->

<!-- 主体 start-->
<tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tbody>

		  <!-- 当前位置 
		  <tr>
            <td class="left_txt">当前位置：信息列表</td>
          </tr>
		  -->
		  <!-- 分割线 start-->
          <tr>
            <td height="20">
            <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
             <tbody><tr><td></td></tr>
            </tbody></table>
            </td>
          </tr>
		  <!-- 分割线 end-->
          
		  <!-- 内容 start-->
          <tr>
          	<td>
			<!-- 查询条件 start-->
			<!-- 查询条件 end -->
            
			<!-- 列表 start -->
          	<table class="admin_table font03">
          	<tbody>
				<tr>
				  <td align="left" background="images/23.jpg"><strong>学生</strong></td>
				  <td align="left" background="images/23.jpg"><strong>专业</strong></td>
				  <td align="left" background="images/23.jpg"><strong>课程</strong></td>
				  <td align="left" background="images/23.jpg"><strong>分数</strong></td>
				  <td align="left" background="images/23.jpg"><strong>录入时间</strong></td>
				  <td align="left" background="images/23.jpg"><strong>操作</strong></td>
				</tr>
	        <% 
					for(int i=0;i<data.size();i++){
						Map<String,Object> d=data.get(i);
				%>       
	        	<tr>
				<td><%=d.get("name") %></td>
				<td><%=d.get("major") %></td>
				<td><%=d.get("course") %></td>
				<td><%=d.get("score") %></td>
				<td><%=d.get("addtime") %></td>
				<td>
	        	<a href="editgrade.jsp?gradeid=<%=d.get("gradeid")%>">编辑</a><b>|</b>
	        	<a href="deletegrade.jsp?grade=<%=d.get("gradeid")%>">删除</a>
	        	</td>
	        </tr>
			<% 
				}
			%>
          	  </tbody>			
			</table>
            <!-- 列表 start -->

          	</td>
          </tr>
          <!-- 内容 end-->
          
		  <!-- 分页 start -->
          <tr>
          <td>
	     	 
		<form id="pageForm" method="post">
<table align="center" cellpadding="0" cellspacing="0" class="admin_table font03">
  <tr> 
    <td>		 
			 
   </td>
  </tr>
</table>
		   </td>
         </tr>
		 <!-- 分页 end -->

    </tbody>
	</table>   
    </td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
</tr>
<!-- 主体 start-->

<!-- 表尾 start-->
<tr>
	<td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17"></td>
  	<td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
  	<td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17"></td>
</tr>
<!-- 表尾 end-->

</tbody>
</table>
</body>
</html>
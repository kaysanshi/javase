<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%  
   		String stuid=(String)session.getAttribute("stuid");
   		JdbcUtils jb=new JdbcUtils();
   
		String sql="select * from message where stuid=?";
		String[] params={stuid};
		ResultSet rs=jb.queryExecute(sql, params);
		//获取所有的学生的所有信息表；
		List<Map<String,Object>> data=JdbcUtils.RSToList(rs);
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的留言</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/skin.css" rel="stylesheet" type="text/css">
</head>
<script>
		//查询jiancha
		function check(){
			var text=document.getElementById("textname").value;
			if(text==""|| text==null){
				alert("请输入学生的姓名");
				text.focus();
				return false;
			}
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
        <td height="31"><div class="titlebt">留言列表</div></td>
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
          	<table class="admin_table font03">			
          	<tbody><tr>
          	<td width="50">查询条件</td>
          	<td>标题：<input name="queryCondition.username" type="text" id="textname" value=""> </td>
          	<td>
          	<input type="button" value="查 询" class="btn"  onclick="check()"/> </td>
          	</tr>
          	</tbody>
			</table>
			<!-- 查询条件 end -->
            
			<!-- 列表 start -->
          	<table class="admin_table font03">
          	<tbody>
				<tr>
				  <td align="left" background="images/23.jpg"><strong>标题</strong></td>
				  <td align="left" background="images/23.jpg"><strong>教师</strong></td>
				  <td align="left" background="images/23.jpg"><strong>时间</strong></td>
				  <td align="left" background="images/23.jpg"><strong>是否回复</strong></td>
				  <td align="left" background="images/23.jpg"><strong>操作</strong></td>
				</tr>
	        	<% 
					for(int i=0;i<data.size();i++){
						Map<String,Object> d=data.get(i);
						
				//score未能读取原因是：eclipse它未找到这一列但是事实上是存在的，
				//解决方法：数据库中的sore字段从新设计保存可以运行；
				//是否解决：已解决
				%>       
	        	<tr onmousemove="this.style.background=&#39;#5CBB44&#39;;" onmouseout="this.style.background=&#39;#EEF2FB&#39;; " style="background-color: rgb(238, 242, 251); background-position: initial initial; background-repeat: initial initial; ">
				<td><%=d.get("title") %></td>
				<td><%=d.get("teachername")%></td>
				<td><%=d.get("addtime") %></td>
				
				<td><% if(d.get("replytime")!=null && !d.get("replytime").equals("") ){
					out.print("是");
				}else{
					out.print("否");
				}
				
				%></td>
				<td>
	        	<a href="showreply.jsp?messageid=<%=d.get("messageid")%>">查看详情</a><b>|</b>
	        	<a href="deletereply.jsp?messageid=<%=d.get("messageid")%>">删除</a>
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
<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
    	List<Map<String,Object>> data=(List<Map<String,Object>>)request.getAttribute("data");
 //共多少页
   int totalpage=(int) request.getAttribute("totalpage");
    //当前页
   int currentpage=(int)request.getAttribute("currentpage");
    //每页记录数
   int pagesize=(int)request.getAttribute("pagesize");
    //总共多少数据
   int totalSize=(int)request.getAttribute("totalSize");
   String action=request.getParameter("action");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成绩列表</title>
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
			//后续查询做相应的修改
			window.location.href="glist.jsp?action=search&text="+text;
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
        <td height="31"><div class="titlebt">成绩列表</div></td>
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
          	<td>姓名：<input name="queryCondition.username" type="text" id="textname" value=""> </td>
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
				  <td align="left" background="images/23.jpg"><strong>课程</strong></td>
				  <td align="left" background="images/23.jpg"><strong>学号</strong></td>
				  <td align="left" background="images/23.jpg"><strong>学生</strong></td>
				  <td align="left" background="images/23.jpg"><strong>教师</strong></td>
				  <td align="left" background="images/23.jpg"><strong>成绩</strong></td>
				  <td align="left" background="images/23.jpg"><strong>时间</strong></td>
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
				<td><%=d.get("course") %></td>
				<td><%=d.get("sno") %></td>
				<td><%=d.get("stuname") %></td>
				<td><%=d.get("teachername") %></td>
				<td><%=d.get("score") %></td>
				<td><%=d.get("addtime") %></td>
				<td>
	        	<a href="editgrade.jsp?gradeid=<%=d.get("gradeid")%>">编辑</a><b>|</b>
	        	<a href="deletegrade.jsp?grade=<%=d.get("gradeid")%>">删除</a>
	        	</td>
	        </tr>
			<% 
			///测试
					//System.out.println(d.get("course"));
					//System.out.println(d.get("stuname"));
					//System.out.println(d.get("teachername"));
					//System.out.println(d.get("score"));
					//System.out.println(d.get("addtime"));
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
			  	 
			  共找到<%=totalSize %>条记录，每页<%=pagesize %>条，分<%= totalpage%>页，当前第<%=currentpage %>页，
              <% 
              if(currentpage>1){
             %>
              <a href="glist.jsp?action=<%=action%>&curpage=1">首页</a>
             <% 
              }else{
              %>
                首页
             <% 
              }
             %>
             
            
             <% 
              if(currentpage!=1){
             %>
              <a href="glist.jsp?action=<%=action%>&currentpage=<%=currentpage-1 %>">上一页</a>
             <% 
              }else{
              %>
                上一页
             <% 
              }
             %>
			 
			 
			 <% 
              if(currentpage!=totalpage){
             %>
              <a href="glist.jsp?action=<%=action%>&curpage=<%=currentpage+1 %>">下一页</a>
             <% 
              }else{
              %>
               下一页
             <% 
              }
             %>
             
             
              <% 
              if(currentpage==totalpage){
             %>
                    尾页
             <% 
              }else{
              %>
                 <a href="glist.jsp?action=<%=action%>&curpage=<%=totalpage %>">尾页</a>
             <% 
              }
             %>	
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
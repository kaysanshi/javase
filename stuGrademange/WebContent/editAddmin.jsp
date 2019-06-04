<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//1.接收数据：
	//读取所有数据用来编辑即 修改时进行操作语句；
	String adminid=request.getParameter("adminid");
  	Map<String,Object> data=null;
 	if(adminid !=null && !adminid.equals("")){
 		JdbcUtils jb=new JdbcUtils();
 		String sql="select *from admin where adminid=?";
 		String[] params={adminid};
 		ResultSet rs=jb.queryExecute(sql,params);
 		 List<Map<String,Object>> list=JdbcUtils.RSToList(rs);
 		data=list.get(0);
 		
 	}
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人编辑</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/skin.css" rel="stylesheet" type="text/css">

</head>
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
        <td height="31"><div class="titlebt">个人编辑</div></td>
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
		  <!-- 当前位置 
		  <tr>
            <td class="left_txt">当前位置：添加</td>
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
          
		  <!-- 内容 satrt-->
          <tr>
          	<td>
                   <!--表单 start-->
				   <form name="form2" id="form2" method="post" action="saveAddmin.jsp">
					<table class="admin_table font03">
					<tbody>
					
					<tr>
					  <td width="16%" id="td_align_right">用户名</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="username" id="username" value="<%if(adminid !=null && !adminid.equals("")){out.print(data.get("username")); }%>" >
					  </td>
					</tr>
					
					<tr>
					  <td width="16%" id="td_align_right">密码</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="pwd" id="pwd" value="<%if(adminid !=null && !adminid.equals("")){out.print(data.get("passward")); }%>" >
					  </td>
					</tr>
					<tr>
					  <td width="16%" id="td_align_right">姓名</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="name" id="name" value="<%if(adminid !=null && !adminid.equals("")){out.print(data.get("name")); }%>" >
					  </td>
					</tr>
					<tr>
					  <td colspan="2"><input type="submit" value="保存" class="btn"> </td>
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
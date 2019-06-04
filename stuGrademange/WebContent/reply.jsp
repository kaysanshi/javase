<%@page import=" java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.utils.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我要留言</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="css/skin.css" rel="stylesheet" type="text/css">

</head>
<script>
		function savereply(){
			var teachername=document.getElementById("teachername");
			if(teachername.value==""|| teachername.value==null){
				alert("请选择老师姓名");
				sno.focus();
				return false;
			}
			var content=document.getElementById("content");
			if(content.value==""|| content.value==null){
				alert("请输入密码");
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
        <td height="31"><div class="titlebt">我要留言</div></td>
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
                   <!--表单 start-->
				   <form name="form2" id="form2" method="post" action="savereply.jsp">
					<table class="admin_table font03">
					<tbody>
					<tr>
					  <td width="16%" id="td_align_right">标题</td>
					  <td id="td_align_left">
					  <input type="text" style="width:300px" name="title" id="title" value=""/>
					  </td>
					</tr>
					<tr>
					  <td width="16%" id="td_align_right">老师</td>
					  <td id="td_align_left">
					  <select id="teacherid" name="teacherid">
							<%
							JdbcUtils db=new JdbcUtils();
							String sql="select * from teacher where 1=?";
					 		String[] params={"1"};
					 		ResultSet rs=db.queryExecute(sql,params);
							 	List<Map<String,Object>> list=JdbcUtils.RSToList(rs);
							 	Map<String,Object> teacher=null;
							 	System.out.print("size="+list.size());
							 	for(int i=0;i<list.size();i++){
							 		 teacher=list.get(i);
							%>
								<option value="<%=teacher.get("name")%>"><%=teacher.get("name")%></option>	
							<%
								}
							%>				
						</select>
						</td>
					</tr>
						<!-- 富文本编辑器  ckeditor,ueditor -->
					<tr>
					  <td width="16%" id="td_align_right">内容</td>
					  <td id="td_align_left">
						<textarea id="content" name="content"rows="10"cols="100"></textarea>
					  </td>
					</tr>
					<tr>
					  <td width="50px" colspan="2">
					  <input type="hidden" name="teacherid" value="">
					  <input type="submit" value="留言" onclick="savereply()" class="btn"> </td>
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
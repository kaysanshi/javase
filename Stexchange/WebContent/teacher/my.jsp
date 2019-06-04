<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
<title>个人中心-完善个人资料</title>
</head>
<script>
	$("#save").click(function(){
		//判断个人的数据是否填写完毕
		var realname=$("#realname").val();
		 	if($.trim(realname).length==0){
		 		$("#info").html("请输入真实姓名");
		 		$("#realname").focus();
				return;
		 	}
		var sex=$("#sex").val();
			 if($.trim(sex).length==0){
				 $("#info").html("请输入性别");
				 $("#sex").focus();
					return;
			 }
		var age=$("#age").val();
			if($.trim(age).length==0){
				$("#info").html("请输入年龄");
				$("#age").focus();
				return;
			}
		var address=$("#address").val();
			if($.trim(address).length==0){
				$("#info").html("请输入地址");
				$("#address").focus();
				return;
			}
		var email=$("#email").val();
			if($.trim(email).length==0){
				$("#info").html("请输入邮箱");
				$("#email").focus();
				return;
			}
		var id=$("#id").val();
		alert(id);
		/////
		$.ajax({
			type:'post',
			url:'SaveTeacherInfoServlet',
			data:{
				id:id,
				realname:realname,
				sex:sex,
				age:age,
				address:address,
				email:email
			},
			success:function(data){
				if(data=="1"){
					$("#info").html("信息完善成功");
				}else{
					$("#info").html("信息完善失败");
				}
				
			}
		});
		
	});
</script>
<body>
	<form id="form" action="">
	<table align="center" width="70%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
     <c:forEach var="r" items="${requestScope.list }">
	 <input  type="hidden" id="id" value="${r.id }">
	              <tr>
					<td class="biaotou">用户名</td>
					<td class="neirong" style="width:40%">${r.username}</td>
				</tr>
				<tr>
					
					<td class="biaotou">密码</td>
					<td class="neirong" style="width:40%">${r.password}</td>
				</tr>
				<tr>
					<td class="biaotou">真实名字</td>
					<td class="neirong"><input type="text"  id="realname" name="realname" value=""/></td>
					</tr>
					<tr>
					<td class="biaotou">性别</td>
					<td class="neirong"><input type="text" id="sex" name="sex" value=""/></td>
					</tr>
					<tr>
					<td class="biaotou">年龄</td>
					<td class="neirong"><input type="text"  id="age" name="age" value=""/></td>
					</tr>
	                <tr>
	                <td class="biaotou">邮箱</td>
	                <td class="neirong"><input type="text" id="email" name="email" value=""/></td>
	              </tr>
	              
				
	              <tr>
	              	<td class="neirong">
					   <input type="button" id="save" value="保存">
					</td>
					<td class="neirong"><div id="info"></div></td>
				</tr>
				 </c:forEach>
		</table>
		</form>
</body>
</html>
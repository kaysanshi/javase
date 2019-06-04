<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>修改用户</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    </head>
<script>
		$(function(){ 
			$("#updateUserBtn").bind("click",function(){  
			   var username=$("#username");
			   if($.trim(username.val()).length==0){
					$("#tipinfo").html("用户名不能为空！");
					problemtitle.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   
			   
			   //验证通过后，用AJAX提交请求
			   $.ajax({
					 type: 'POST',
					 url: 'SaveEditUserServlet',
					 data:$("#form1").serialize(),
					 success: function(data) {
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//添加成功
								//设置提示信息为绿色
								$("#tipinfo").css("color","green");
								$("#tipinfo").html("添加题目成功");      
						  }else{//添加失败
							   $("#tipinfo").html("添加题目失败");
						  }   
					 }
				});
		});  
}); 

		
		
		
		</script>
    <body>
	   <p class="biaoti">修改用户<p>
	   <form id="form1">
	   <table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">请输入用户名</td>
					<td class="neirong">
					   <input type="text" id="username" name="username" value="${requestScope.list.username }" />
					</td>
	              </tr>
	               <tr>
					<td class="biaotou">请输入密码</td>
					<td class="neirong">
					   <input type="text" id="password" name="password" value="${requestScope.list.password }" />
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">请输入真实姓名</td>
					<td class="neirong">
					    <input type="text" name="nickname" id="nickname" value="${requestScope.list.nickname }"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入性别</td>
					<td class="neirong">
					    <input type="text" name="gender" id="gender" value="${requestScope.list.gender }"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入证件号</td>
					<td class="neirong">
					    <input type="text" name="stunumber" id="stunumber" value="${requestScope.list.stunumber }"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入电话</td>
					<td class="neirong">
					   <input type="text" name="cellphone" id="cellphone" value="${requestScope.list.cellphone }"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入邮箱</td>
					<td class="neirong">
					 <input type="text" name="email" id="email" value="${requestScope.list.email }"/>
					</td>
	              </tr>    
				  <tr>
				  <td><input type="hidden" name="id" value="${requestScope.list.userid }"></td>
				<td class="neirong" colspan="2"><input type="button" id="updateUserBtn" name="submit" value="保存"></td>
	              </tr>	
		</table>
		</form>	
        <!-- 提示信息显示区 -->
        <div id="tipinfo"></div>		
    </body>
</html>
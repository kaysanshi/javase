<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js" ></script>
<title>管理员用户表</title>

<script  type="text/javaScript">
//编辑
function EditUser(url,method){
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#right").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
//查看
function ShowUser(url,method){
	alert("查看");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#right").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
//先删除
function DeleteUser(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			alert("删除成功")
			setTimeout('listUser()',2000);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
//分页
function getPage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#right").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
///
$("#userSearchBtn").bind("click",function(){  
	   $.ajax({
			 type: 'post',
			 url: 'SearchUserServlet' ,
			 data: $('#userSearchForm').serialize(),
			 success: function(data) {
				  //将“添加新闻”页面的内容插入到页面的“主区域”
				  $("#right").html(data);
			 }
		});
});
</script>
</head>
<body>
<form id="userSearchForm" method="post" action="">
	   <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
           <tr>
			 <td class="neirong">
			   用户名：<input type="text" name="username" value="${username}" style="width:30%">
			   
			   
			   <input type="hidden" name="thispage" value="">
			   
			   <a href="javascript:void(0);" id="userSearchBtn" class="btn-green">搜&nbsp;索</a>
			   
			 </td>                   
           </tr>                  
	   </table>
	   </form>
		<table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">用户名</td>
					<td class="biaotou">密码</td>
					<td class="biaotou">姓名</td>
					<td class="biaotou">性别</td>
					<td class="biaotou">学号</td>
					<td class="biaotou">电话</td>	
					<td class="biaotou">邮箱</td>
					<td class="biaotou">添加时间</td>
	                <td class="biaotou">操作</td>
	              </tr>
	              <c:forEach items="${requestScope.page.list }" var="user">
				  <tr>
					<td class="neirong">${user.username }</td>
					
					<td class="neirong">${user.password}</td>
					<td class="neirong">${user.nickname}</td>
					<td class="neirong">${user.gender}</td>
					<td class="neirong">${user.stunumber}</td>
					<td class="neirong">${user.cellphone}</td>
					<td class="neirong">${user.email}</td>
					<td class="neirong">${user.addtime}</td>
					<td class="neirong">
					   <a href="javascript:EditUser('EditorUserServlet?id=${user.userid }','post')">编辑</a>
					   <a href="javascript:DeleteUser('DelUserServlet?id=${user.userid}','post')">删除</a>
					   <a href="javascript:ShowUser('ShowUserServlet?id=${user.userid}','post')">查看</a>
	              </tr>
				 </c:forEach>
		</table>
<div align="center" style="font-size:14px">
<c:set var="url" value="${pageContext.request.contextPath}/addmin/ListUserServlet"/>		
	共${page.countrow }条记录
  	共${page.countpage }页
  	<a href="javascript:getPage('${ url}?thispage=${page.firstpage }','post')">首页</a>
  	<a href="javascript:getPage('${ url}?thispage=${page.prepage }','post')">上一页</a>
  	
  	<!-- 分页逻辑开始 -->
  	<c:if test="${page.countpage<=5}">
  		<c:set var="begin" value="1" scope="page"></c:set>
  		<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  	</c:if>
  	<c:if test="${page.countpage>5}">
		<c:choose>
			<c:when test="${page.thispage<=3}">
				<c:set var="begin" value="1" scope="page"></c:set>
  				<c:set var="end" value="5" scope="page"></c:set>
			</c:when>
			<c:when test="${page.thispage>=page.countpage-2}">
				<c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
  				<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  			</c:when>
  			<c:otherwise>
  				<c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
  				<c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
  			</c:otherwise>
		</c:choose>
  	</c:if>
  	
  	<c:forEach begin="${begin}" end="${end}" step="1" var="i">
  		<c:if test="${i == page.thispage}">
  			${i }
  		</c:if>
  		<c:if test="${i != page.thispage}">
  			<a href="${pageContext.request.contextPath }/addmin/ListUserServlet?thispage=${i}">${i }</a>
  		</c:if>
  	</c:forEach>
  	
  	<!-- 分页逻辑结束 -->
  	
  	<a href="javascript:getPage('${ url}?thispage=${page.nextpage }','post')">下一页</a>
  	<a href="javascript:getPage('${ url}?thispage=${page.lastpage }','post')">尾页</a>
		</div>
</body>
<script type="text/javascript">
  		
  	</script>
</html>
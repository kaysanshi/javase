<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
<title>学生列表</title>
<script>
$("#studentSearchBtn").click(function(){
		var name=$("#studname").val();
		alert(ame);
		if(($.trim(name)).length==0){
			alert("请输入学生名");
			return;
		}
		
		$.ajax({
			type:'post',
			url:'SearchStudentServlet',
			data:$("#StudentSearchForm").serialize(),
			success:function(data){
				$("#content").html(data);
			},
			error:function(data){
				alert("未能够查询到");
			}
			
			
			
		})
	
	
});
/////////////////
function getpage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#content").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
//
function Del(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			if(data=="1"){
				alert("删除成功");
			}else{
				alert("删除失败");
			}
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
//编辑
function Edit(url,method){
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#content").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
</script>
</head>
<body>
		 <!-- 搜素区域 --> 
	   <form id="studentSearchForm" method="post" action="">
	   <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
           <tr>
			 <td class="neirong">
			   学生名：<input type="text" name="name" id="stuname" value="${realname}" style="width:30%">
			   
			   <input type="hidden" name="curpage" value="">
			   
			   <a href="javascript:void(0);" id="studentSearchBtn" class="btn-green">搜&nbsp;索</a>
			   
			 </td>                   
           </tr>                  
	   </table>
	   </form>
	   
       <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">用户名</td>
					<td class="biaotou">密码</td>
					<td class="biaotou">真实名字</td>
					<td class="biaotou">性别</td>
					<td class="biaotou">年龄</td>
	                <td class="biaotou">地址</td>
	                <td class="biaotou">邮件</td>
	                <td class="biaotou">注册时间</td>
	              </tr>
	              <c:forEach var="r" items="${pageBean.data}">
				  <tr>
					<td class="neirong">${r.username}</td>
					<td class="neirong">${r.password}</td>
					<td class="neirong">${r.realname}</td>
					<td class="neirong">${r.sex}</td>
					<td class="neirong">${r.age}</td>
					<td class="neirong">${r.address}</td>
					<td class="neirong">${r.email}</td>
					<td class="neirong">${r.addtime}</td>
					<td class="neirong">
					   <a href="javascript:Del('DeleteStudentServlet?stuid=${r.id}','post')">删除</a>
						<a href="javascript:Edit('EditStudentServlet?stuid=${r.id}','post')">编辑</a>
					</td>
	              </tr>
				 </c:forEach>
		</table>
	<div align="center" style="font-size:14px">
		<c:set var="url" value="${pageContext.request.contextPath}/addmin/ListStudentServlet"/>
			每页${pageBean.pageSize}行  共${pageBean.totalRows}行  页数 ${pageBean.curPage}/${pageBean.totalPages}
			<c:choose>
				  <c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=1','post')">首页</a>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage-1}','post')">上一页</a>
				  </c:otherwise>
			   </c:choose>
			   <c:choose>
				  <c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页 尾页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage+1}','post')">下一页</a>
				  	<a href="javascript:getpage('${url}?page=${pageBean.totalPages}','post')">尾页</a>
				  </c:otherwise>
			</c:choose>
		</div>
</body>
</html>
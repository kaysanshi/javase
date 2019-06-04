<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/listvideo.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
<title>视频列表</title>
<script  type="text/javaScript">
function getAjaxvideoplay(url,method){
	$.ajax({
			 type: method,
			 url: url,
			 success: function(data) {
				$("#content").html(data);	
			 },
			 error:function(data){
				 alert('出现错误');
			 }
		});
	}
function getpage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#list").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}
/*$(function(){
	alert(111111);
function getAjaxvideoplay(url,method){
	$.ajax({
			 type: method,
			 url: url ,
			 success: function(data) {
				 if(data=="1"){//有这一个视频路径
						var src=${requestScope.filepath };
						alert(src);
					//
						$("#content").html(data);
					}
			 },
			 error:function(data){
				 alert('出现错误');
			 }
		});
	}
//使用ajax分页
function getpage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#list").html(data);
		},
		error:function(data){
			alert("未能够请求");
		}
	});
}

});*/
</script>
</head>
<body>
	<div id="list">
		<ul>
		<c:forEach items="${pageBean.data}" var="r">
	    <li><a href="javascript:getAjaxvideoplay('PlayVideoServlet?videoid=${r.id}','post')">${r.videotitle}</a></li>
	   </c:forEach>
	   </ul>
		<br>
	   <div id="page">
		<c:set var="url" value="${pageContext.request.contextPath}/student/ListAllVideoServlet"/>
			<!-- -每页${pageBean.pageSize}行  共${pageBean.totalRows}行  页数 ${pageBean.curPage}/${pageBean.totalPages} -->
			<c:choose>
				  <c:when test="${pageBean.curPage==1}">首页  上一页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=1','post')">首页</a>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage-1}','post')">上一页</a>
				  </c:otherwise>
			   </c:choose>
			   <c:choose>
				  <c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页 尾页</c:when>
				  <c:otherwise>
				  	<a href="javascript:getpage('${url}?page=${pageBean.curPage+1}','post')">下一页</a>
				  	<a href="${url}?page=${pageBean.totalPages}">尾页</a>
				  </c:otherwise>
			</c:choose>
	
		</div>
	</div>
	
</body>
</html>
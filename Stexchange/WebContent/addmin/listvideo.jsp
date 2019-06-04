<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
<title>管理员视频列表</title>
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
	
		<table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">视频名</td>
					<td class="biaotou">服务器中的名字</td>
					<td class="biaotou">上传者ip</td>
					<td class="biaotou">上传者id</td>
					<td class="biaotou">发布时间</td>
					<td class="biaotou">描述</td>
	                <td class="biaotou">操作</td>
	              </tr>
	              <c:forEach var="r" items="${pageBean.data }">
				  <tr>
					<td class="neirong">${r.videotitle}</td>
					<td class="neirong">${r.uuidname}</td>
					<td class="neirong">${r.uploadip}</td>
					<td class="neirong">${r.uploadteacherid}</td>
					<td class="neirong">${r.uploadtime}</td>
					<td class="neirong">${r.description}</td>
					<td class="neirong">
					   <a href="javascript:ajaxPlayVideo('PlayVideoServlet?videoid=${r.id }','post')">播放</a>
	              </tr>
				 </c:forEach>
		</table>
		<c:set var="url" value="${pageContext.request.contextPath}/addmin/ListVideoServlet"/>
		
		<div align="center" style="font-size:14px">
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
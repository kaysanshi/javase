<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"/></script>
<title>视频列表</title>
</head>
	<script type="text/javascript">
	//搜索
	$("#VideoSearchBtn").bind("click",function(){  
		   $.ajax({
				 type: 'post',
				 url: 'VideoSeachServlet' ,
				 data: $('#videoSearchForm').serialize(),
				 success: function(data) {
					  //将“添加新闻”页面的内容插入到页面的“主区域”
					  $("#content").html(data);
				 }
			});
	});
	
	//编辑
		function editorVideo(url,method){
			$.ajax({
				type:method,
				url:url,
				success:function(data){
					$("#content").html(data);
				}
			});
		}
		//删除方法
		function ajaxDelVideo(url,method){	
			if(confirm('你确认要删除吗？')){
				$.ajax({
					 type: method,
					 url: url ,
					 success: function(data) {
						  var msg="删除失败";
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//删除成功
							 msg='删除成功';
						  }
						  alert(msg); 
					 }
			    });
			}
		}
	//视频播放
		function ajaxPlayVideo(url,method){
			$.ajax({
				type:method,
				url:url,
				success:function(data){
					$("#content").html(data);
				}
			});
	}
	///
	function getpage(url,method){
	alert("1233");
	$.ajax({
		type:method,
		url:url,
		success:function(data){
			$("#content").html(data);
		}
		
	})
}
	</script>


<body>
	   <!-- 搜素区域 --> 
	   <form id="videoSearchForm" method="post" action="">
	   <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
           <tr>
			 <td class="neirong">
			 视频名：<input type="text" name="videotitle" value="${videotitle}" style="width:30%">
			   
			   <input type="hidden" name="curpage" value="">
			   
			   <a href="javascript:void(0);" id="VideoSearchBtn" class="btn-green">搜&nbsp;索</a>
			   
			 </td>                   
           </tr>                  
	   </table>
	   </form>
	   
       <table align="center" width="100%" border="0" cellpadding="0" 
                             cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">视频名</td>
					<td class="biaotou">发布时间</td>
					<td class="biaotou">描述</td>
					<td class="bioatou">发布者ip</td>
	                <td class="biaotou">操作</td>
	              </tr>
	              <c:forEach var="r" items="${pageBean.data}">
	              
				  <tr>
					<td class="neirong" style="width:40%">${r.videotitle}</td>
					<td class="neirong">${r.uploadtime}</td>
					<td class="neirong">${r.description}</td>
					<td class="neirong">${r.uploadip}</td>
					<td class="neirong">
					   <a href="javascript:editorVideo('editVideoServlet?videoid=${r.id }','post')">编辑</a>
					   <a href="javascript:ajaxDelVideo('DelVideoServlet?videoid=${r.id }','post')">删除</a>
					   <a href="javascript:ajaxPlayVideo('PlayVideoServlet?videoid=${r.id }','post')">播放</a>
					</td>
	              </tr>
				 </c:forEach>
		</table>
<c:set var="url" value="${pageContext.request.contextPath}/teacher/ListVideoServlet"/>
		
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
</body>
</html>
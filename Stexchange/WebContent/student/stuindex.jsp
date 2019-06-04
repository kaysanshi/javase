<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/stuindex.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" ></script>
</head>
<script>
$(function(){
	$("#list").hide();
})
function getAllVideo(){
	alert(1223);
		$.ajax({
			type:'get',
			url:'ListAllVideoServlet',
			success:function(data){
				$("#list").show();
				$("#list").html(data);
				$("#content").html("");
			}
		})
	}
function getAllListFile(){
	$.ajax({
		type:'get',
		url:'ListAllFilesServlet',
		success:function(data){
			$("#list").hide();
			$("#content").html(data);
		}
	
	})	
};
function changeaere(){
	$.ajax({
		type:'get',
		url:'ChangeTalkServlet',
		success:function(data){
			$("#list").hide();
			$("#content").html(data);
		}
	
	})	
}
function myhome(){
	$.ajax({
		type:'get',
		url:'MyHomeServlet',
		success:function(data){
			$("#list").hide();
			$("#content").html(data);
		}
	
	})
}
function getMessage(){
	$.ajax({
		type:'get',
		url:'MyMessageListServlet',
		success:function(data){
			$("#list").hide();
			$("#content").html(data);
		}
	
	})
	
}
</script>
<body>
	<div id="head">
    	<div id="left">
            <ul>
                <li>
                	<a href="#">视频列表</a>
                    <ul>
                        <li><a href="javascript:getAllVideo()">学习视频</a></li>
                        <li><a href="#">其他视频</a></li>
                    </ul>
                </li>
                <li><a href="javascript:getAllListFile()">文件列表</a></li>
                <li>
                	<a href="#">在线交流</a>
                	<ul>
                        <li><a href="javascript:getMessage()">信息列表</a></li>
                        <li><a href="javascript:changeaere()">发送消息</a></li>
                    </ul>
                
                </li>
            </ul>
        </div>
        <div id="right">
        	<ul>
        		<li><image src=""/>欢迎你${sessionScope.username}</li>
        		<li>
        			<a href="javascript:myhome()">个人中心</a>
        		</li>
        	</ul>
        	
        </div>
    </div>
    <div id="list">
    
    </div>
    <div id="content">
    	
    </div>
    <div id="bottom">
    	
   	</div>
	</body>
</html>

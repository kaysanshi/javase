<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>系统主页</title>
    <style type="text/css">
       body{
          font-family:'微软雅黑';
       }
       #top{
          padding-left:20px;
          overflow:hidden;
       }
       #title{
          float:left;
          font-size:30px;
          line-height:100px;
       }
       #status{
          float:right;
          line-height:100px;
       }
       #left{
          float:left;
          width:15%;
          padding-left:20px;
       }
       #right{
          float:right;
          width:80%;
       }
    </style>
    
    <script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function(){ 
			   //点击“添加新闻“链接的动作
			   $("#addNews").bind("click",function(){  
                       //用AJAX发送GET请求获取“添加新闻”页面
				       $.ajax({
						     type: 'GET',
						     url: 'AddNew.jsp',
						     success: function(data) {
						          $("#right").html(data);
						     }
						});
			   }); 
			  
			   $("#listNews").bind("click",function(){
					//用ajax发送GET请求获取“新闻列表”页面
					$.ajax({
						type:'GET',
						url:'ListNewsServlet',
						success:function(data){
						//将“新闻列表”页面的内容插入到页面的主区域
						$("#right").html(data);
					}
				 });
			 });
			  /////点击添加视频的
			  	 $("#addVideo").bind("click",function(){  
                       //用AJAX发送GET请求获取“添加新闻”页面
				       $.ajax({
						     type: 'GET',
						     url: 'AddVideo.jsp',
						     success: function(data) { 
						          $("#right").html(data);
						     }
						});
			   }); 
			  ////点击视频列表的
			  	
			   $("#listVideo").bind("click",function(){
					//用ajax发送GET请求获取“新闻列表”页面
					$.ajax({
						type:'GET',
						url:'ListVideoServlet',
						success:function(data){
						
						$("#right").html(data);
					}
				 });
			 });
			 ///点击资源上传时
			 $("#addResource").bind("click",function(){  
                       //用AJAX发送GET请求获取“添加新闻”页面
				       $.ajax({
						     type: 'GET',
						     url: 'AddResource.jsp',
						     success: function(data) {
						        
						          $("#right").html(data);
						     }
						});
			   }); 
			 //点击资源列表时
			  $("#listResource").bind("click",function(){
					
					$.ajax({
						type:'GET',
						url:'ListResourceServlet',
						success:function(data){
						$("#right").html(data);
					}
				 });
			 });
			 //点击试题上传时
			 	 $("#addProblem").bind("click",function(){  
                       //用AJAX发送GET请求获取“添加新闻”页面
				       $.ajax({
						     type: 'GET',
						     url: 'AddProblem.jsp',
						     success: function(data) {
						          $("#right").html(data);
						     }
						});
			   }); 
			 //点击试题列表时
			 	$("#listProblem").bind("click",function(){
					//用ajax发送GET请求获取“新闻列表”页面
					$.ajax({
						type:'GET',
						url:'ListProblemServlet',
						success:function(data){
						
						$("#right").html(data);
					}
				 });
			 });
			 ////
			 	//点击试题列表时
			 	$("#listuser").bind("click",function(){
					//用ajax发送GET请求获取“新闻列表”页面
					$.ajax({
						type:'GET',
						url:'ListUserServlet',
						success:function(data){
						
						$("#right").html(data);
					}
				 });
			 });
		});
		
		
        </script>
  </head>
  
  <body>
      <div id="top"> 
          <div id="title">校规校纪交流系统</div>
          <div id="status">
              <span style="color:red">${sessionScope.user}</span> 你好，欢迎登录！
              <a href="#">退出</a>
          </div>
      </div>
      <div id="left">
       <div style="font-weight:bold;line-height:30px">视频管理</div>
          <div style="line-height:30px"> <a id="addVideo"  href="javascript:void(0)">上传视频</a> </div>
          <div style="line-height:30px"> <a id="listVideo" href="javascript:void(0)">视频列表</a> </div>
           <div style="font-weight:bold;line-height:30px">资源管理</div>
          <div style="line-height:30px"> <a id="addResource"  href="javascript:void(0)">上传资源</a> </div>
          <div style="line-height:30px"> <a id="listResource" href="javascript:void(0)">资源列表</a> </div>
           <div style="font-weight:bold;line-height:30px">测评管理</div>
          <div style="line-height:30px"> <a id="addProblem"  href="javascript:void(0)">添加试题</a> </div>
          <div style="line-height:30px"> <a id="listProblem" href="javascript:void(0)">试题列表</a> </div>
          <div style="font-weight:bold;line-height:30px">新闻管理</div>
          <div style="line-height:30px"> <a id="addNews"  href="javascript:void(0)">添加新闻</a> </div>
          <div style="line-height:30px"> <a id="listNews" href="javascript:void(0)">新闻列表</a> </div>
          <div style="font-weight:bold;line-height:30px">用户管理</div>
          <div style="line-height:30px"> <a id="listuser" href="javascript:void(0)">用户列表</a> </div>
      </div> 
      <div id="right">
             这是内容显示主区域
      </div>
  </body>
</html>
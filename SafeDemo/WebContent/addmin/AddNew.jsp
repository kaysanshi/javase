<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>添加新闻</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    </head>
<script>
		$(function(){ 
		//添加新闻“保存”的单击动作
			$("#addNewsBtn").bind("click",function(){  
			   //验证新闻标题
			   var newstitle=$("#newstitle");
			   if($.trim(newstitle.val()).length==0){
					$("#tipinfo").html("新闻标题不能为空！");
					newstitle.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   //验证作者
			   var author=$("#author");
			   if($.trim(author.val()).length==0){
					$("#tipinfo").html("作者不能为空！");
					author.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   //验证内容
			   var content=$("#content");
			   if($.trim(content.val()).length==0){
					$("#tipinfo").html("新闻内容不能为空！");
					content.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   var fordata=new FormData($("#form1")[0]);
			   //验证通过后，用AJAX提交请求
			   $.ajax({
					 type: 'POST',
					 url: 'AddNewsServlet',
					 data:fordata,
					 cache: false,  
		             processData: false,  
		             contentType: false,
					 success: function(data) {
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//添加成功
								//设置提示信息为绿色
								$("#tipinfo").css("color","green");
								$("#tipinfo").html("添加新闻成功");      
								//等待3秒后，重新用AJAX加载“添加新闻”页面
								setTimeout('ajaxLoadAddNewsPage()',3000);
	
						  }else{//添加失败
							   $("#tipinfo").html("添加新闻失败");
						  }   
					 }
				});
		});  
}); 

//用AJAX加载“添加新闻”页面
function ajaxLoadAddNewsPage(){
		$.ajax({
			 type: 'GET',
			 url: 'AddNews.jsp' ,
			 success: function(data) {
				  $("#right").html(data);
			 }
		 });	
}		
</script>
<script>
$("#pic").change(function(){
    var objUrl = getObjectURL(this.files[0]) ;
    console.log("objUrl = "+objUrl) ;
    if (objUrl) {
        	 $("#img0").attr("src", objUrl) ;
    }
}) ;
function getObjectURL(file) {
    var url = null ; 
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}
</script>
    <body>
	   <p class="biaoti">添加新闻<p>
	   <form id="form1">
	   <table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">标题：</td>
					<td class="neirong">
					    <input id="newstitle" name="title" type="text"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">作者：</td>
					<td class="neirong">
					    <input id="author" name="author" type="text"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">发布时间：</td>
					<td class="neirong">
					<input type="text"  placeholder="请选择日期" id="addtime" name="uptime"/>  
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">板块：</td>
					<td class="neirong">
					    <select id="classname" name="type">
					        <option value="信商要闻">信商要闻</option>
					        <option value="通知公告">通知公告</option>
					        <option value="校园生活">校园生活</option>
					        <option value="人才招聘">人才招聘</option>
					    </select>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">新闻图片：</td>
					<td class="neirong">
					    <input type="file" name="file" value="" id="pic">
					    <img id="img0" src="" width="40" height="45">
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">新闻内容：</td>
					<td class="neirong">
					    <textarea id="content" name="content"></textarea>
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2"><input type="button" id="addNewsBtn" name="submit" value="保存"></td>
	              </tr>	
		</table>
		</form>	
        <!-- 提示信息显示区 -->
        <div id="tipinfo"></div>		
    </body>
</html>
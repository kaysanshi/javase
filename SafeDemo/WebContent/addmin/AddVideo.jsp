<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath }/laydate/laydate.js"></script> 
<title>视频上传</title>
</head>
<script>

	
	//执行一个laydate实例
	laydate.render({
		elem: '#addtime' ,//指定元素
		format:'yyyy-MM-dd'
	});
$(function(){
			$("#upvideo").bind("click",function(){ 
				alert("jkjkjk");
				//验证视频标题
			   var title=$("#videotitle");
			   if($.trim(title.val()).length==0){
					$("#tipinfo").html("标题不能为空！");
					title.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   //验证描述内容
			   var discription=$("#discription");
			   if($.trim(discription.val()).length==0){
					$("#tipinfo").html("视频描述不能为空！");
					content.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   var formData = new FormData($('#form1')[0]); 
			   //验证通过后，用AJAX提交请求
			   $.ajax({
					 type: 'POST',
					 url: 'AddVideoServlet',
					 data:formData,
					 cache: false,  
		             processData: false,  
		             contentType: false,
					 success: function(data) {
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//添加成功
								//设置提示信息为绿色
								$("#tipinfo").css("color","green");
								$("#tipinfo").html("上传成功");      
						  }else{//添加失败
							   $("#tipinfo").html("上传失败");
						  }   
					 }
				});
		});  
}); 
</script>
<script>
	
</script>
<body>
 <p class="biaoti">上传视频<p>
 <form id="form1"  enctype="multipart/form-data">
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">视频：</td>
					<td class="neirong">
					   <input type="file" name="file1">
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">视频标题：</td>
					<td class="neirong">
					    <input id="videotitle" name="videotitle" type="text"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">发布时间：</td>
					<td class="neirong">
					   <input type="text"  placeholder="请选择日期" id="addtime" name="addtime"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">视频类型：</td>
					<td class="neirong">
					    <select id="classname" name="type">
					        <option>新闻类</option>
					        <option>学习</option>
					        <option>生活</option>
					        <option>其他</option>
					    </select>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">视频描述：</td>
					<td class="neirong">
					    <textarea id="discription" name="discription"></textarea>
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2"><input type="button" id="upvideo" name="submit" value="上传"></td>
	              </tr>	
		</table>
		</form>	
        <!-- 提示信息显示区 -->
        <div id="tipinfo"></div>		
    </body>
</html>
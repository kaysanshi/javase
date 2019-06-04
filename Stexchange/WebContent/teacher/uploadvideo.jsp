<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<title>视频上传</title>
</head>
<body>
<script>
 		$(function(){
 	 		////触发change事件
 			////////
 			 $("#onsubmit").bind("click",function(){
 				//验证
 				var title=$("#videotitle");
			       if($.trim(title.val()).length==0){
			            $("#info").html("请添加视频的标题");
			            $("#info").css("color","red");
			            desc.focus();
			           	return;
			       }else{
			            $("#info").html("");
			       }
 				//验证视频的描述是否为空
			       var desc=$("#description");
			       if($.trim(desc.val()).length==0){
			            $("#info").html("请添加视频的描述信息");
			            $("#info").css("color","red");
			            desc.focus();
			            return;
			       }else{
			            $("#info").html("");
			       }
 				//验证图片
			      /* /*  var f=$("#picture").val();
	 	            if(f == null || f ==undefined || f == ''){
	 	                return false;
	 	            }
	 	            if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f))
	 	            {
	 	                alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
	 	                $(obj).val('');
	 	                return false;
	 	            }else{
	 	            	//$("#thumburlShow").attr("src",$("#picture").val());
	 	            }  */ 
 				///
 				var formData = new FormData($('#form')[0]); 
 					
 				$.ajax({
 					type:'Post',
 					url:'UploadVideoServlet',
 					data:formData,
					cache: false,  
	                processData: false,  
	                contentType: false,
	                success:function(data){
	                	if(data=="1"){
	                		alert("上传成功")
	                		$("#info").html("文件上传成功");
	                	}else if(data=="00"){
	                		$("#info").html("文件上传失败文件类型有误");
	                	}else{
	                		$("#info").html("文件上传失败");
	                	}
	                	
	                },
 					error:function(data){
 						$("#info").html("未能够上传");
 					}
 				})
 			});
 			//
 	           
 	            
 			/////
 			
 		})
 		
</script>
<form  id="form" action="" enctype="multipart/form-data">
      <div align="center">
            <h2>上传视频</h2>
            <table border="0" cellspacing="1" width="90%" bgcolor="#CCCCCC">
              <tr> 
                <td width="20%" align="right" bgcolor="#FFFFFF"><b>视频名称</b></td>
                <td bgcolor="#FFFFFF"> 
                  <input type="text" name="videotitle"  id="videotitle" size="90">
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#FFFFFF"><b>详细描述</b></td>
                <td bgcolor="#FFFFFF"> 
                  <textarea rows="6" name="description" id="description" cols="90"></textarea>
                </td>
              </tr>
              <tr>
                <td align="right" bgcolor="#FFFFFF"><b>上传视频</b></td>
                <td bgcolor="#FFFFFF"> 
                  <input type="file" name="file"  id="file">
                </td>
              </tr>
              <tr>
                <td align="right" bgcolor="#FFFFFF"><b>选择视频图片</b></td>
                <td bgcolor="#FFFFFF"> 
                  <input type="file" name="picture" id="picture"/>
                  <span><img id="thumburlShow" src="" width="120" height="120"/></span>
                </td>
              </tr>
              
            </table>
       </div>
       <div align="center">
            <p> 
               <input type="button" id="onsubmit" value="提交">
               <input type="reset" value="重填">
            </p>
            <div id="info"></div>
       </div>
</form>
</body>
</html>
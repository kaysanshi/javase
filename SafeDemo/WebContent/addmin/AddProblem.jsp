<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>添加问题</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath }/css/mystyle.css"  type="text/css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    </head>
<script>
		$(function(){ 
			$("#addproblemBtn").bind("click",function(){  
			   //验证新闻标题
			   var subjecttitle=$("#subjecttitle");
			   if($.trim(subjecttitle.val()).length==0){
					$("#tipinfo").html("标题不能为空！");
					problemtitle.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   
			   //验证发布时间
			   var adddate=$("#adddate");
			  // if($.trim(adddate.val()).length==0){
			//		$("#tipinfo").html("发布时间不能为空！");
					///adddate.focus();
					//return;
			  // }else{
				//	$("#tipinfo").html("");
			   //}
			   //验证内容
			   var content=$("#subjectOption");
			   if($.trim(content.val()).length==0){
					$("#tipinfo").html("答案不能为空！");
					content.focus();
					return;
			   }else{
					$("#tipinfo").html("");
			   }
			   //验证通过后，用AJAX提交请求
			   $.ajax({
					 type: 'POST',
					 url: 'AddSubjectServlet',
					 data:$("#form1").serialize(),
					 success: function(data) {
						  //data代表服务端返回的数据
						  if($.trim(data)=="1"){//添加成功
								//设置提示信息为绿色
								$("#tipinfo").css("color","green");
								$("#tipinfo").html("添加题目成功");      
						  }else{//添加失败
							   $("#tipinfo").html("添加题目失败");
						  }   
					 }
				});
		});  
}); 

		
		
		
		</script>
    <body>
	   <p class="biaoti">添加试题<p>
	   <form id="form1">
	   <table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaotou">请输入题目</td>
					<td class="neirong">
					   <input type="text" id="subjecttitle" name="subjecttitle" value="" />
					</td>
	              </tr>
	               <tr>
					<td class="biaotou">类型：</td>
					<td class="neirong">
					    <select id="classname" name="type">
					        <option>信商要闻</option>
					        <option>通知公告</option>
					        <option>校园生活</option>
					        <option>人才招聘</option>
					    </select>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">请输入选项A:</td>
					<td class="neirong">
					    <input type="text" name="subjectOptionA" id="subjectOption" />
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入选项B:</td>
					<td class="neirong">
					    <input type="text" name="subjectOptionB" id="subjectOption"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入选项C:</td>
					<td class="neirong">
					    <input type="text" name="subjectOptionC" id="subjectOption"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入选项D:</td>
					<td class="neirong">
					   <input type="text" name="subjectOptionD" id="subjectOption"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入答案</td>
					<td class="neirong">
					 <input type="text" name="subjectAnswer" id="subjectOption"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">请输入解析：</td>
					<td class="neirong">
					  <input type="text" name="subjectParse"id="subjectOption" />
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2"><input type="button" id="addproblemBtn" name="submit" value="添加"></td>
	              </tr>	
		</table>
		</form>	
        <!-- 提示信息显示区 -->
        <div id="tipinfo"></div>		
    </body>
</html>
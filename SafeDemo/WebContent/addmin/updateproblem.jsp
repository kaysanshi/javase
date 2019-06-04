<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateProblemServlet" method="post">
	<input type="hidden" name="subjectid" value="${problem.subjectid }"/>
	<table>
			<tr>
				<td>标题：</td>
				<td><input type="text" name="subjecttitle" value="${problem.subjecttitle}" readonly="readonly"/></td>
			</tr>
			<tr>
  				<td>请输入选项A:</td>
  				<td><input type="text" name="subjectOptionA" value="${problem.subjectOptionA}" /></td>
  			</tr>
			<tr>
  				<td>请输入选项B:</td>
  				<td><input type="text" name="subjectOptionB" value="${problem.subjectOptionB}" /></td>
  			</tr>
  			<tr>
  				<td>请输入选项C:</td>
  				<td><input type="text" name="subjectOptionC" value="${problem.subjectOptionC}" /></td>
  			</tr>
  			<tr>
  				<td>请输入选项D:</td>
  				<td><input type="text" name="subjectOptionD" value="${problem.subjectOptionD}" /></td>
  			</tr>
  			<tr>
  				<td>请输入答案:</td>
  				<td><input type="text" name="subjectAnswer" value="${problem.subjectAnswer}" /></td>
  			</tr>
  			<tr>
  				<td>请输入解析:</td>
  				<td><input type="text" name="subjectParse" value="${problem.subjectParse}" /></td>
  			</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="修改用户"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/AddCustomerServlet" method="post">
	<table>
		<tr>
			<td>客户姓名</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>客户性别</td>
			<td><input type="radio" name="gender" value="男">男
			<input type="radio" name="gender" value="女">女</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		<tr>
			<td>手机号码</td>
			<td><input type="text" name="cellphone"></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>爱好</td>
			<td>
				<input type="checkbox" name="preference" value="篮球">篮球
				<input type="checkbox" name="preference" value="足球">足球
				<input type="checkbox" name="preference" value="排球">排球
				<input type="checkbox" name="preference" value="棒球">棒球
				<input type="checkbox" name="preference" value="乒乓球">乒乓球
				<input type="checkbox" name="preference" value="羽毛球">羽毛球
				<input type="checkbox" name="preference" value="冰球">冰球
			
			</td>
		</tr>
		<tr>
			<td>客户类型</td>
			<td>
				<select name="type">
					<option value="砖石客户">砖石客户</option>
					<option value="白金客户">白金客户</option>
					<option value="黄金客户">黄金客户</option>
					<option value="白银客户">白银客户</option>
					<option value="青铜客户">青铜客户</option>
					<option value="红砖客户">红砖客户</option>
				
				</select>
			</td>
		</tr>
		<tr>
			<td>描述信息</td>
			<td>
				<textarea name="description" rows="20" cols="30"></textarea>
			</td>
		</tr>
		<tr>
			
			<td colspan="2">
				<input type="submit" value="添加客户"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
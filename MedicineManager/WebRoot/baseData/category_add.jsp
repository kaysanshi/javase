<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
<head>
	<title><bean:message key="system.category.category.add" />
	</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
	<script type="text/javascript">
		function add(){
			var form = document.forms["categoryForm"];
			if(form.elements["name"].value == ""){
				alert("<bean:message key="category.name.null"/>");
				form.elements["name"].focus();
				return false;
			}
			if(form.elements["description"].value == ""){
				alert("<bean:message key="category.description.null"/>");
				form.elements["description"].focus();
				return false;
			}
		}
	</script>
</head>
<body>
	<div class="div1">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"
			align="center">
			<tr>
				<td class="td_title1">
					¡¤
					<bean:message key="system.current.place" />
					£º
					<bean:message key="system.category.category" />
					&gt;&gt;
					<bean:message key="system.category.category.add" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
					<html:form action="baseData/category.do" method="post" focus="name"
						onsubmit="return add();">
						<input type="hidden" name="command" value="add" />
						<html:hidden property="id" />
						<table border="0" align="center" width="500">
							<tr>
								<td align="right">
									<bean:message key="category.name" />
									£º
								</td>
								<td align="left">
									<html:text property="name" />
								</td>
							</tr>
							<tr>
								<td align="right">
									<bean:message key="category.description" />
									£º
								</td>
								<td align="left">
									<html:textarea property="description" cols="30" rows="3"></html:textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<html:submit>
										<bean:message key="button.submit" />
									</html:submit>
								</td>
							</tr>
						</table>
					</html:form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html:html>

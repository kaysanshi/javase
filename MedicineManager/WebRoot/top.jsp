<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="images/styles.css">
	</head>
	<body>
		<table width="100%" border="0" align="center" cellspacing="0"
			cellpadding="0" height="140">
			<tr>
				<td colspan="2">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						height="140" background="images/top2.jpg">
						<tr>
							<td height="140" valign="top" width="556"><img src="images/top1.jpg" width="556" height="140" border="0"></td>
							<td width="100%"></td>
							<td width="245" height="140" valign="top"><img src="images/top3.jpg" width="245" height="140" border="0"
									usemap="#Map"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td background="images/top_bg1.jpg" width="" height="40" class="wel">
					<bean:write name="user" property="username"/>
					<bean:message key="system.welcome.word"/>
				</td>
				<td background="images/top_bg1.jpg" width="60" align="center">
					<a href="system/system.do?command=userExit" target="_top" class="exit">
						<bean:message key="system.category.manage.user.exit"/>
					</a>
				</td>
			</tr>
		</table>

		<map name="Map">
			<area shape="rect" coords="108,11,153,27"
				href="<html:rewrite page="/language.do?lan=zh"/>" target="_top">
			<area shape="rect" coords="179,11,235,27"
				href="<html:rewrite page="/language.do?lan=en"/>" target="_top">
		</map>
	</body>
</html>

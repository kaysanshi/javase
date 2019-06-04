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
	<title><bean:message key="category.all" />
	</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
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
					<bean:message key="system.category.category.view" />
					&gt;&gt;
					<bean:message key="category.all" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
					<table border="1" align="center" width="700" cellpadding="1"
						cellspacing="1" bgcolor="#036500" bordercolor="#FFFFF">
						<tr bgcolor="#FFFFFF">
							<td class="tb_tl">
								<bean:message key="category.id" />
							</td>
							<td class="tb_tl">
								<bean:message key="category.name" />
							</td>
							<td class="tb_tl">
								<bean:message key="category.description" />
							</td>
							<td class="tb_tl">
								<bean:message key="system.createTime" />
							</td>
							<td class="tb_tl">
								<bean:message key="system.operate" />
							</td>
						</tr>
						<logic:present name="list" scope="request">
							<logic:iterate id="ele" name="list" scope="request">
								<tr bgcolor="#FFFFFF">
									<td>
										<bean:write name="ele" property="id" />
									</td>
									<td>
										<html:link href="category.do?command=edit" paramId="id"
											paramName="ele" paramProperty="id">
											<bean:write name="ele" property="name" />
										</html:link>
									</td>
									<td>
										<bean:write name="ele" property="subDesc" />
									</td>
									<td>
										<bean:write name="ele" property="createTime"
											format="yyyy-MM-dd" />
									</td>
									<td>
										<html:link href="category.do?command=edit" paramId="id"
											paramName="ele" paramProperty="id">
											<bean:message key="system.modify" />
										</html:link>
										<html:link href="category.do?command=delete" paramId="id"
											paramName="ele" paramProperty="id">
											<bean:message key="system.delete" />
										</html:link>
									</td>
								</tr>
							</logic:iterate>
							<logic:present name="pagingBar" scope="request">
								<tr bgcolor="#FFFFFF">
									<td colspan="5" align="right">
										<bean:write name="pagingBar" filter="false" scope="request" />
									</td>
								</tr>
							</logic:present>
						</logic:present>
						<logic:notPresent name="list" scope="request">
							<tr bgcolor="#FFFFFF">
								<td colspan="5">
									<bean:message key="system.message.null" />
								</td>
							</tr>
						</logic:notPresent>
					</table>
					<br>
				</td>
			</tr>
		</table>
	</div>
</body>
</html:html>

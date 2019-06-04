<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.medicine.query" /></title>

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
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.medicine"/>
					&gt;&gt; <bean:message key="system.category.medicine.query" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <html:form action="baseData/med.do" method="post" focus="name">
    	<input type="hidden" name="command" value="query" />
      <table border="0" align="center" width="450">
        <tr>
          <td align="right"><bean:message key="medicine.id" />£º</td>
          <td align="left"><html:text property="id" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.medNo" />£º</td>
          <td align="left"><html:text property="medNo" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.name" />£º</td>
          <td align="left"><html:text property="name" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.factoryAdd" />£º</td>
          <td align="left"><html:textarea property="factoryAdd" cols="30" rows="3"></html:textarea></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.description" />£º</td>
          <td align="left"><html:textarea property="description" cols="30" rows="3"></html:textarea></td>
        </tr>
        <tr>
          <td colspan="2" align="center">
          	<html:submit><bean:message key="button.submit" /></html:submit>
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

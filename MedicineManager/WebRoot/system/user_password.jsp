<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.manage.user.modify"/></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
	<script type="text/javascript">
		function save(){
			var form = document.forms["userForm"];
			if(form.elements["oldPassword"].value == ""){
				alert("<bean:message key="user.oldpassword.null"/>");
				form.elements["oldPassword"].focus();
				return false;
			}
			if(form.elements["password"].value == ""){
				alert("<bean:message key="user.password.null"/>");
				form.elements["password"].focus();
				return false;
			}
			if(form.elements["rePassword"].value == ""){
				alert("<bean:message key="user.repassword.null"/>");
				form.elements["rePassword"].focus();
				return false;
			}
			if(form.elements["rePassword"].value != form.elements["password"].value){
				alert("<bean:message key="user.password.error"/>");
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
					¡¤<bean:message key="system.current.place"/>£º
					<bean:message key="system.category.manage"/>
					&gt;&gt; <bean:message key="system.category.manage.user.modify"/>
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <html:form action="system/system.do" method="post" focus="oldPassword">
      <table border="0" align="center" width="450">
        <tr>
          <td align="right"><bean:message key="user.oldpassword"/>£º</td>
          <td align="left">
          	<input type="hidden" name="command" value="modifyPassword" />
          	<html:hidden property="id"/>
          	<html:password property="oldPassword" />
          </td>
        </tr>
        <tr>
          <td align="right"><bean:message key="user.password"/>£º</td>
          <td align="left"><html:password property="password" /></td>
        </tr>
         <tr>
          <td align="right"><bean:message key="user.repassword"/>£º</td>
          <td align="left"><html:password property="rePassword" /></td>
        </tr>
        <tr>
          <td align="center" colspan="2">
			<html:submit><bean:message key="button.submit"/></html:submit>
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

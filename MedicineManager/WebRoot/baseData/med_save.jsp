<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <title><bean:message key="system.category.medicine.add" /></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../images/styles.css">
	<script type="text/javascript">
		function save(){
			var form = document.forms["medForm"];
			if(form.elements["medNo"].value == ""){
				alert("<bean:message key="medicine.medNo.null" />");
				form.elements["medNo"].focus();
				return false;
			}
			if(form.elements["name"].value == ""){
				alert("<bean:message key="medicine.name.null" />");
				form.elements["name"].focus();
				return false;
			}
			if(form.elements["price"].value == "" || form.elements["price"].value <= 0){
				alert("<bean:message key="medicine.price.null" />");
				form.elements["price"].focus();
				return false;
			}
			if(isNaN(form.elements["price"].value)){
				alert("<bean:message key="medicine.price.count.format" />");
				form.elements["price"].focus();
				return false;
			}
			if(form.elements["medCount"].value == "" || form.elements["medCount"].value <= 0){
				alert("<bean:message key="medicine.storage.count.null" />");
				form.elements["medCount"].focus();
				return false;
			}
			if(isNaN(form.elements["medCount"].value)){
				alert("<bean:message key="medicine.storage.count.format" />");
				form.elements["medCount"].focus();
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
					<bean:message key="system.category.medicine"/>
					&gt;&gt; <bean:message key="system.category.medicine.add" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" height="50">
					<br>
    <html:form action="baseData/med.do" method="post" focus="name" enctype="multipart/form-data" onsubmit="return save();">
    	<input type="hidden" name="command" value="add" />
    	<html:hidden property="id"/>
      <table border="0" align="center" width="450">
        <tr>
          <td align="right"><bean:message key="medicine.medNo" />£º</td>
          <td align="left"><html:text property="medNo" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.name" />£º</td>
          <td align="left"><html:text property="name" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.price" />£º</td>
          <td align="left"><html:text property="price" /></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.storage.count" />£º</td>
          <td align="left"><html:text property="medCount"/></td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.category" />£º</td>
          <td align="left">
          <logic:present name="cs" scope="request">
          	<select name="categoryId" id="categoryId">
	          	<logic:notEmpty name="cs" scope="request">
	          		<logic:iterate id="ele" name="cs" scope="request">
	          			<logic:equal value="${ele.id}" name="medForm" property="categoryId" >
		          			<option value="<bean:write name='ele' property='id' />" selected>
								<bean:write name="ele" property="name"/>
							</option>
						</logic:equal>
						<logic:notEqual value="${ele.id}" name="medForm" property="categoryId">
		          			<option value="<bean:write name='ele' property='id' />">
								<bean:write name="ele" property="name"/>
							</option>
						</logic:notEqual>
	          		</logic:iterate>
	          	</logic:notEmpty>
	          	<logic:empty name="cs" scope="request">
	          		<option value="-1" ><bean:message key="medicine.category.null" /></option>
	          	</logic:empty>
          	</select>
          </logic:present>
          </td>
        </tr>
        <tr>
          <td align="right"><bean:message key="medicine.photo" />£º</td>
          <td align="left">
          	<html:file property="photo" />
          	<html:hidden property="photoPath"/>
          </td>
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
          <td colspan="2" align="center"><html:submit><bean:message key="button.submit" /></html:submit></td>
        </tr>
      </table>
    </html:form>
    </td>
			</tr>
		</table>
	</div>
  </body>
</html:html>

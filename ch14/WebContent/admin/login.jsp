<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<script>
   function check(){
      username=document.f.username.value;
      password=document.f.password.value;
      if(username==""){
         alert("�û�������Ϊ�գ�");
         return false;
      }else if(password==""){
         alert("���벻��Ϊ�գ�");
         return false;
      }else{
         return true;
      }
   }
</script>
<c:if test="${!empty login && login=='ok'}">
    <c:redirect url="/as/list"/>
</c:if>
<center>
	<h2>
		����Ա��¼
	</h2>
	<form method="post" action="${pageContext.request.contextPath}/ls" name="f" onSubmit="return check()">
	<table border bordercolor="#0066FF">
	<tr>
		<td align="right">�û���</td><td><input type="text" name="username"></td>
	</tr>
	<tr>
	    <td align="right">����</td><td><input type="password" name="password"></td>
	</tr>
	<tr>
	    <td align="center" colspan="2">
	    <input type="submit" value="��¼">
	    </td>
	</tr>	
	</table>
	</form>
	<c:if test="${!empty param.error && param.error=='yes'}">
	  <hr>
	  �û��������벻��ȷ��
	</c:if>
</center>
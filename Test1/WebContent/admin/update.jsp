<%@ page pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<script>
   function check(){
      name=document.f.name.value;
      file=document.f.file.value;
      if(name==""){
         alert("软件名称不能为空！");
         return false;
      }else{
         return true;
      }
   }
</script>
<form method="post" action="${pageContext.request.contextPath}/as/dealUpdate" enctype="multipart/form-data" name="f" onSubmit="return check()">
      <input type="hidden" name="id" value="${file.id}">
      <input type="hidden" name="filePath" value="${file.filePath}">
      <div align="center">
            <h2>文件修改</h2>
            <table border="0" cellspacing="1" width="60%">
              <tr> 
                <td width="20%" align="right" bgcolor="#CCCCCC"><b>文件说明</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="text" name="name" size="50" value="${file.name}">
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>文件类型</b></td>
                <td bgcolor="#CCCCCC"> 
                  <select name="type">
                      <option value="1" <c:if test="${file.type==1}">selected</c:if>>图片</option>
                      <option value="2" <c:if test="${file.type==2}">selected</c:if>>Flash</option>
                      <option value="3" <c:if test="${file.type==3}">selected</c:if>>音乐</option>
                      <option value="4" <c:if test="${file.type==4}">selected</c:if>>小视频</option>
                      <option value="5" <c:if test="${file.type==5}">selected</c:if>>其他</option>
                  </select>
                </td>
              </tr>
              <tr> 
                <td align="right" bgcolor="#CCCCCC"><b>详细描述</b></td>
                <td bgcolor="#CCCCCC"> 
                  <textarea rows="6" name="description" cols="50">${file.description}</textarea>
                </td>
              </tr>
              <tr>
                <td align="right" bgcolor="#CCCCCC"><b>现有文件</b></td>
                <td><font size="2"><a href="${pageContext.request.contextPath}/dls?id=${file.id}">${file.fileName}</a></font>
              </tr>
              <tr>
                <td align="right" bgcolor="#CCCCCC"><b>重新上传</b></td>
                <td bgcolor="#CCCCCC"> 
                  <input type="file" name="file">
                </td>
              </tr>
            </table>
       </div>
       <div align="center">
            <p> 
               <input type="submit" value="提交">
               <input type="reset" value="重填">
            </p>
       </div>
</form>
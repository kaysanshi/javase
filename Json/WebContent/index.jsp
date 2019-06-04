<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   
String path = request.getContextPath();   
String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>"> 
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/json2.js" type="text/javascript"></script>
<script language="javascript">   
      
function addPerson(){ 
	//就是装载json数据的意思(装载的json数据的来源url,是否有附加参数null，载入成功后的回调函数)
    $.getJSON("demoServlet",null,function call(data){   
       //获取后台传入的数据后台代码：jsonObject.put("person", jsonArray);   
    	var list = data.person;   
        $.each(list, function(i, p){   
           var row =$("#tr").clone();//复制克隆"id=tr"的元素   
           row.find("#name").text(p.name);//匹配这个id然后设置文本值；   
           row.find("#age").text(p.age);   
           row.find("#sex").text(p.sex);   
           row.find("#address").text(p.address.province + p.address.city +p.address.country);   
           row.appendTo("#tbody");   
        });      
    });   
}      
</script> 
</head> 
<body> 
<input type="button" value="JsonView"onClick="addPerson();">      
<div id="dateMessage">      
    <table id="planTable"border="1">      
        <tr> 
           <td>Name</td> 
           <td>Sex</td> 
           <td>Age</td> 
           <td>Address</td> 
       </tr>      
        <tbody id="tbody"> 
            <tr id="tr"> 
               <td id="name"></td> 
               <td id="sex"></td> 
               <td id="age"></td> 
               <td id="address"></td> 
           </tr>      
        </tbody> 
    </table>      
</div> 
</body> 
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线学习</title>
<style type="text/css">
	p,span{
		margin:0px;
		padding:0px;
	}
	#top{
		top:0px;
		height:40px;
		width:300px;
	}
	#bottom{
	position:absolute;
	bottom:1px;
	}
	#bottom #robot{
		width:300px;
		height:30px;
	}
	#bottom #button{
		width:50px;
		height:30px;
	}
	#content p{
		height:40px;
		line-height:40px;
	}
	#mycontent{
		float:right;
	}
</style>
</head>
<script>

var xmlHttp;

function showHint(str){
            if (event.keyCode==13){
                    Send(str);
              document.getElementById("mytext").innerHTML=str;
             } 
}
function Send(str){

 if (str.length==0){

    document.getElementById("txtHint").innerHTML="";

    return;

    }
       xmlHttp=GetXmlHttpObject();

               if (xmlHttp==null){
                     alert ("您的浏览器不支持AJAX！");
                     return;
                    }
                     var url="http://www.tuling123.com/openapi/api?key=59439af071d140dba69c0e93a6bc9d9d";
                     url=url+"&info="+str;
                     url=url+"&userid=1234";
                     xmlHttp.onreadystatechange=stateChanged;
                     xmlHttp.open("GET",url,true);
                     xmlHttp.send(null);
                     document.getElementById("robot").value="";
}

function stateChanged(){
	if (xmlHttp.readyState==4){
		var msg=eval('(' + xmlHttp.responseText + ')'); 
		document.getElementById("txtHint").innerHTML=msg.text;
		}
	
}
function GetXmlHttpObject(){
  	var xmlHttp=null;
  try{
    // Firefox, Opera 8.0+, Safari
    	xmlHttp=new XMLHttpRequest();
    }catch(e){
    // Internet Explorer
  try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      }catch (e){
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
    }
	return xmlHttp;
}
</script>
<body>
	<div id="top">
		<img src="images/logo.jpg" width="430px" alt="图标">
		你好！你有什么问题需要我的帮忙?<br/>
		<br/>
		<br/>
	</div>
	<br/>
	<div id="mycontent">
		<p><span id="mytext"></span>:me</p>
	</div>
	<div id="content">
		<br/>
		<p><img src="images/replay.gif" height="40px" width="40px" alt="" />答: <span id="txtHint"></span></p>
	</div>
			
	
	<div id="bottom">
	<input type="text" id="robot" onkeypress="showHint(this.value)"/> 
	<input type="button" id="button" value="发送" onclick="Send(document.getElementById('robot').value)"/>
	</div>


 


</body>
</html>
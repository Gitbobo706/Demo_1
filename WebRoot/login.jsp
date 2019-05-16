<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String msg = (String)request.getAttribute("MSG");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function verify(){
			var username = document.getElementsByName("username")[0].value;
			var password = document.getElementsByName("password")[0].value;
			if(username.trim().length==0){
				alert("用户名不能为空");
				return false;
			}
			if(password==""){
				alert("密码不能为空");
				return false;
			}
			return true;
		}
		function finish(){
			var msg = "<%=msg%>";
			if(msg!="null"){
				alert(msg);
			}
		}
	</script>
  </head>
  
  <body onload="finish()">
    <form action="loginServlet" method="post" onsubmit="return verify()">
    	用户名：<input type="text" name="username">
    	密码：<input type="password" name="password">
    	<input type="submit" value="登录">
    	<a href="registerServlet">注册</a>
    </form>
	<form action="sessionServlet">
    	请输入信息：<input type="text" name="info">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>

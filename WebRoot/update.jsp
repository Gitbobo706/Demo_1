<%@ page language="java" import="java.util.*,com.bean.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Student s = (Student)request.getAttribute("student");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function finish(){
			var msg = "<%=s%>";
			if(msg!="null"){
				alert(msg);
			}
		}
	</script>
  </head>
  
  <body onload="finish()">
   <form action="updateStudentServlet" method="post">
 		<input type="hidden" name="id" value="<%=s.getId()%>">
   		姓名：<input type="text" name="name" value="<%=s.getName()%>">
   		性别：<input type="text" name="sex" value="<%=s.getSex()%>">
   		年龄：<input type="text" name="age" value="<%=s.getAge()%>">
   		分数：<input type="text" name=score value="<%=s.getScore()%>">
   		<input type="submit" value="提交">
   </form>
  </body>
</html>

 <%@ page language="java" import="java.util.*,com.bean.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Cookie[] cookie = request.getCookies();
String username = " ";
if(cookie!=null){
	for(Cookie c:cookie){
		if("username".equals(c.getName())){
			username = c.getValue();
		}
	}
}
ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
String msg = (String)request.getAttribute("MSG");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>列表页面</title>
    
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
			var msg = "<%=msg%>";
			if(msg!="null"){
				alert(msg);
			}
		}	
	</script>
  </head>
  
  <body onload="finish()">
  	<b><%=username %></b>,你好
    <form action="queryStudentServlet">
   		姓名：<input type="text" name="name">
   		男<input type="radio" name="sex" value="男">
   		女<input type="radio" name="sex" value="女">
   		年龄：<input type="text" name="age">
   		分数：<input type="text" name=score>
   		<input type="submit" value="查询">
   		<a href="addStudentServlet">增加</a>
   	</form>
    <table border="1" cellspacing="0px">
    	<caption>学生信息</caption>
    	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>年龄</th>
    		<th>分数</th>
    		<th colspan="2">操作</th>
    	</tr>
     	<%for(Student s:list){%>
    	<tr>
    		<td><%=s.getName()%></td>
    		<td><%=s.getSex()%></td>
    		<td><%=s.getAge()%></td>
    		<td><%=s.getScore()%></td>
    		<td><a href="deleteStudentServlet?id=<%=s.getId()%>">删除</a></td>
    		<td><a href="updateStudentServlet?id=<%=s.getId()%>">修改</a></td>
    	</tr>
    	<%}%>
    </table>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String prjName = "/JSP"; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>

	<a href="./simpleView.jsp">기존방식(상대경로)</a><br/>
	<a href="<%= prjName %>/07_mvc_class/1_mvcSimple/simpleView.jsp">기존방식(절대경로)</a><br/>
	<hr/>
	<a href="<%= prjName %>/SimpleControl">MVC패턴</a></br>
	<a href="<%= prjName %>/SimpleControl?type=first">MVC패턴2</a>
	<hr/>
	<a href="<%= prjName %>/(:3)~.do">MVC패턴</a></br>
	
</body>
</html>
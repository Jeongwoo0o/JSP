<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 선언 -->
<%!	String name; %>			

<!-- 코딩 -->
<%	name = "김승형 바보"; 		
	String msg = "맛점합시다.";
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>
			<!-- 출력 -->
	인사말 : <%= 	name %><hr/>		
	짝궁님 : <%=	msg %>
	
	<!-- HTML 주석 -->
	<% // 자바주석 %>
	<% /* 자바주석 */ %>
	<%-- JSP 주석 --%>
</body>
</html>
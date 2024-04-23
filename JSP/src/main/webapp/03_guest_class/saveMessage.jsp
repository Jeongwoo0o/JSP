<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.service.WriteMessageService"%>    
   
<!-- 0. 넘겨받는 데이타의 한글처리 -->
<% request.setCharacterEncoding("utf-8"); %> 

<!-- 1. 화면의 입력값을 Message 클래스로 전달 --> 
<jsp:useBean id="rec" class="guest.model.Message">
		<jsp:setProperty name="rec" property="*"></jsp:setProperty>
</jsp:useBean>
<% //System.out.println(rec.toString()); %>

<!-- 2. Service 클래스의 함수 호출 -->
<% 
	WriteMessageService  service =  WriteMessageService.getInstance();
	service.write(rec);
%>

<!-- 입력 후 목록보기 페이지 바꾸기 -->

<!-- (1) forward : 이 상황에서는 아님 -->
<%-- <jsp:forward page="listMessage.jsp"></jsp:forward> --%>
<!-- (2) redirect -->
<% response.sendRedirect("listMessage.jsp"); %>

<!-- 요즘은 아래처럼 입력 후 페이지를 보여주는 것이 추세 -->

<!-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 남김 </title>
</head>
<body>
	<font size="3" color="#bb44cc">
	방명록에 메세지를 남겼습니다. 
	</font><br/><br/><br/>
	<a href="listMessage.jsp">[ 목록보기 ]</a> 
</body>
</html> --> 
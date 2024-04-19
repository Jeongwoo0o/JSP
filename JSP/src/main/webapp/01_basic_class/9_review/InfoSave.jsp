<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="info.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력값 받아서 DB처리</title>
</head>
<body>
<%
	// 이전화면 폼에서 넘겨받는 값
	String user 		= request.getParameter("User");
	String pass 		= request.getParameter("Pass");
	String passcheck 	= request.getParameter("Passcheck");
	String name 		= request.getParameter("Name");
	String tel 			= request.getParameter("Tel");
	String addr 		= request.getParameter("Addr");
	
	InfoVO vo = new InfoVO(); 
	vo.setInfo_id(user);
	vo.setInfo_pw(pass);
	vo.setInfo_name(name);
	vo.setInfo_tel(tel);
	vo.setInfo_addr(addr);
	
	InfoDAO dao = InfoDAO.getInstance();
%>
</body>
</html>
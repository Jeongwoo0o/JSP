<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.beans.*" %>

<!-- 하나씩 천천히 도전합시다 -->
<jsp:useBean id="bean" class="member.beans.Member">
	<jsp:setProperty name="bean" property="*"/>
</jsp:useBean>

<%
	MemberDao dao = MemberDao.getInstance();
	dao.insertMember(bean);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입 확인  </title>
</head>
<body>
	아이디 : <%= bean.getId() %><br> 
	패스워드 : <%= bean.getPassword() %><br>
	이름 : <%= bean.getName() %><br>
	전화 : <%= bean.getTel() %><br>
	주소 : <%= bean.getAddr() %><br>
</body>
</html>
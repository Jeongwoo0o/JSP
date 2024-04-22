<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="member.beans.*" %>

<%
	String id 		= request.getParameter("userId");
	MemberDao dao 	= MemberDao.getInstance();
	boolean result 	= dao.isDuplicatedId(id);
	
	out.write(String.valueOf(result));
%>
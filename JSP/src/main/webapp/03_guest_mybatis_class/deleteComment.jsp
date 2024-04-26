<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybatis.guest.service.CommentService" %>  
 
<%
	int commentNo = Integer.parseInt(request.getParameter("commentNo"));
	CommentService service = CommentService.getInstance();
	service.deleteComment(commentNo);
	
	response.sendRedirect("listComment.jsp");
%>
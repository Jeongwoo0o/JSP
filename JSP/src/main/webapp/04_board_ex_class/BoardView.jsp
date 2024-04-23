<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="board_ex.service.*, board_ex.model.*" %>
<%
	// 게시글번호 넘겨받아
	
	// 서비스의 함수를 호출하여 해당 BoardVO를 넘겨받는다. 

	 
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 게시글 보기 </title>
</head>
<body>

	<h4> 게시판 글 보기 </h4><br/>
	<table border="1" bordercolor="red">
	<tr>
		<td> 제  목 : </td>
		<td></td>
	</tr>
	<tr>
		<td> 작성자 : </td>
		<td></td>
	</tr>
	<tr>
		<td> 작성일자 : </td>
		<td></td>
	</tr>
	<tr>
		<td> 내  용 : </td>
		<td></td>
	</tr>
	<tr>
		<td> 조회수 : </td>
		<td></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="BoardList.jsp"> 목록보기 </a>
			<a href=""> 수정하기 </a>
			<a href=""> 삭제하기 </a>		
		</td>
	</tr>
	</table>
	
	<hr/>
	
	<!-- 페이지 번호 출력 -->
	<a href="">&lt;이전</a>
	<% for(int i = 1; i <= totalPageCount; i++) { %> 
			<a href="listMessage.jsp?page=<%= i %>">[<%= i %>]</a>
			
	<% }	//end of for %>
	<a href="">다음&gt;</a>
	<hr/>


</body>
</html>
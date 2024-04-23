<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guest.model.*,guest.service.*" %>   
<%@ page import="java.util.List" %>
 
<%
	// 페이지 번호값 얻어오기
	String pNum = request.getParameter("page");
	
	ListMessageService service = ListMessageService.getInstance();
	// 전체 메세지 레코드 검색 
	List <Message> mList = service.getMessageList(pNum);

	// 전체 페이지 수 검색
	int totalPageCount = service.getTotalCount();
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 목록 </title>
</head>
<body>

	<% if( mList.isEmpty() ) { %>
		남겨진 메세지가 하나도~~없습니다. <br>
	<% } else { %>
	<table border="1">
	
		<% for(Message m : mList) { %>
		<tr>	
			<td> <%= m.getMessageId() %> </td> 
			<td> <%= m.getGuestName() %> </td> 	
			<td> <a href="deleteMessage.jsp?mId=<%= m.getMessageId() %>">[삭제]</a> </td>
		</tr>
		<tr>
			<td colspan='3'> 
			<textarea cols=35 rows=3 style="font-family: '돋움', '돋움체'; font-size: 10pt; font-style: normal; line-height: normal; color: #003399;background-color:#D4EBFF;border:1 solid #00009C;"><%= m.getMessage() %></textarea>
			</td>
		</tr>
		<% }	//end of for %>
	</table>
	
	<% } // end if-else %>
	
	<hr/>
	
	<!-- 페이지 번호 출력 -->
	<%
		int a = 1;
		String p = request.getParameter("page");
		if(p != null) {
			a = Integer.parseInt(p);
		}
		if(a > 1) {
	%>
	<a href="listMessage.jsp?page=<%= a-1 %>">&lt;이전</a>
	<% }	//end of if %>
	<% for(int i = 1; i <= totalPageCount; i++) { %>
			<a href="listMessage.jsp?page=<%= i %>">[<%= i %>]</a>
			
	<% }	//end of for 
		if(a < totalPageCount) {
	%>
	<a href="listMessage.jsp?page=<%= a+1 %>">다음&gt;</a>
	<% }	//end of if %>
	<hr/>
	
	<a href="insertMessage.jsp">글쓰기</a>
</body>
</html>
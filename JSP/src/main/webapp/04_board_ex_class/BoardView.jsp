<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="board_ex.service.*, board_ex.model.*" %>
<%
	// 게시글번호 넘겨받아
	String wNum = request.getParameter("wNum");;
	// 서비스의 함수를 호출하여 해당 BoardVO를 넘겨받는다. 
	ViewArticleService service = ViewArticleService.getInstance();
	BoardVO rec = service.getArticleById(wNum);
	 
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> 게시글 보기 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#replyBtn").click(function() {
				var param 	= {
						"seq"	: $("#seq").val(),
						"user"	: $("#user").val(),
						"reply"	: $("#reply").val()
				}
				
				$.ajax({
					type	: "get",
					url		: "ReplySave.jsp",
					data	: param,
					success : function() { 
						$("#user").val("");
						$("#reply").val("");
						/* 추후에 댓글목록 보여주기 */
						selectReply();
					},
					error	: function() { alert("댓글입력실패"); }
				});
			});	//end of #replyBtn
			
			selectReply();
			
			// 댓글 목록 가져오기
			function selectReply() {
				// ajax 처리
				
			}
		});
	</script>
</head>
<body>

	<h4> 게시판 글 보기 </h4><br/>
	<table border="1" bordercolor="red">
	<tr>
		<td> 제  목 :  </td>
		<td><%= rec.getTitle() %></td>
	</tr>
	<tr>
		<td> 작성자 :  </td>
		<td><%= rec.getWriter() %></td>
	</tr>
	<tr>
		<td> 작성일자 :  </td>
		<td><%= rec.getRegdate() %></td>
	</tr>
	<tr>
		<td> 내  용 :  </td>
		<td><%= rec.getContent() %></td>
	</tr>
	<tr>
		<td> 조회수 :  </td>
		<td><%= rec.getCnt() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="BoardList.jsp"> 목록보기 </a>
			<a href="BoardModifyForm.jsp?mNum=<%= rec.getSeq() %>"> 수정하기 </a>
			<a href="BoardDeleteForm.jsp?dNum=<%= rec.getSeq() %>"> 삭제하기 </a>		
		</td>
	</tr>
	</table>
	
	<br/>
	<hr/>
	<!-- 댓글추가 -->
	<h3>댓글 추가</h3>
	<form id="replyFrm" name="replyFrm">
		<input type="hidden" name="seq" id="seq" value="<%= rec.getSeq() %>"> 
		<input type="text" id="user" placeholder="사용자명"><br/>
		<input type="text" id="reply" placeholder="내용">
		<input type="button" id="replyBtn" value="댓글추가">
	</form>
	<br/>
	<!-- <!-- 댓글목록 띄우기 -->
	<h3>댓글 목록</h3>
	<table border="1" bordercolor="red" id="replyList">
		<tr>
			<th>글번호</th>
			<th>유저</th>
			<th>내용</th>
		</tr>
	</table> -->

</body>
</html>
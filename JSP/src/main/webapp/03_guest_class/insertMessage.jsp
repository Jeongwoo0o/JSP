<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[value='메세지 남기기']").click(function() {
			// 유효성검사[추가작업]
			
			$("form[name='frm']").submit();
		});
	});
</script>
</head>

<body>
	<form action="saveMessage.jsp" name="frm" method="post">
		<table>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="guestName" required /></td>
			</tr>
			<tr>
				<td>암호 : </td>
				<td><input type="password" name="password" required /></td>
			</tr>
			<tr>
				<td>메세지 : </td>
				<td><textarea name="message" rows="3" cols="30" required ></textarea></td>
			</tr>
			<tr>
				<td><input type="button" value="메세지 남기기"></td>
			</tr>
		</table>
	</form>
</body>
</html>
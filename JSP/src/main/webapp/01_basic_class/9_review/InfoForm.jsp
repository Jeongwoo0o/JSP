<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="./css/Info.css" rel="stylesheet">
<script src="../lib/jquery-3.7.1.min.js"></script>
<script src="./js/info.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면</title>
</head>
<body> 

<h3>회원가입서 작성하기 </h3> 

<form name="frm" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input name='User' type='text'  placeholder="5자~10자 영어와 숫자조합" pattern="[A-Za-z0-9]{5,10}" required></td>
		<td><input type="button" value="중복확인"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input name='Pass' type='password'  placeholder="4자이상 영어와 숫자조합" pattern="[A-Za-z0-9]{4,}" required></td>
	</tr>
	<tr>
		<td>비밀번호확인</td>
		<td><input name='Passcheck' type='password' required></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name='Name' type='text' placeholder="한글 5자 이내" pattern="[가-힣]{,5}" required></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input name='Tel' type='text'  placeholder="-없이 숫자조합" pattern="[0-9]{,11}" required></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input name='Addr' type='text' placeholder="20자 이내" maxlength="20" required></td>
	</tr>
	<tr>
		<td><input type='submit' value='회원가입'></td>
		<td><input type='button' value='취소'></td>
	</tr>
</table>


</form>

</body>
</html>
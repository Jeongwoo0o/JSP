<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입  </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		// "중복확인" 버튼이 클릭됐을 때
		$("#btnIdCheck").click(function() {
			// 예전방식
			let idInput = $("input[name='id']").val();
			// window.open("CheckId.jsp?userId="+ idInput, "창이름", "width=400, height=300");
			
			// [Ajax 방식]
			var param = { "userId" : idInput };
			
			$.ajax({
				type		: "get",
				url			: "CheckId.jsp",
				data		: param,
				success		: function(result) {
					//alert(result.trim());
					if(result.trim() == "true") {
						$("#result").text("이미 아이디가 존재합니다");
						$("#result").css({color : "red"});
					}else {
						$("#result").text("사용 가능한 아이디입니다");
						$("#result").css({color : "#9EF048"});
					}
				},
				error		: function(err) {
					alert("서버전송 실패");
					console.log(err);
				}
			});
		});
	});
</script>
</head>
<body>

<h1>회원가입서 작성하기</h1>
 
	<form action="InsertMember.jsp" method="post" name="frm">
		<table>
			<tr>
				<td width="100">
				<font color="blue">아이디</font>
				</td>
				<td width="100">
				<input type="text" name="id">
				<input type="button" value="중복확인" id="btnIdCheck"><br/>
				</td>
				<td>
				<!-- 결과출력 -->
				<div id="result"></div>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호</font>
				</td>
				<td width="100">
				<input type="password" name="password"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">비밀번호학인</font>
				</td>
				<td width="100">
				<input type="password" name="repassword"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">이름</font>
				</td>
				<td width="100">
				<input type="text" name="name"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">전화번호</font>
				</td>
				<td>
				<input type="text" size="15" name="tel"/>
				<br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				<font color="blue">주소</font>
				</td>
				<td>
				<input type="text" size="50" name="addr"/><br/>
				</td>
			</tr>
			<tr>
				<td width="100">
				 <!--로그인 버튼-->
				 <input type="submit" value="회원가입">
				</td>
				<td width="100">
				<input type="reset" name="cancel" value="취소"><br/>
				</td>
			</tr>
		</table>
	</form>



 </body>
</html>
    
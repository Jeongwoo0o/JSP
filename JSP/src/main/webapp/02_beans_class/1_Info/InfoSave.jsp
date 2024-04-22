<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

<%@ page import="info.beans.InfoBean" %>

<jsp:useBean id="bean" class="info.beans.InfoBean">
	<%-- <jsp:setProperty name="bean" property="name"/>	<!-- id와 name이 동일해야함 --> --%>
	<jsp:setProperty name="bean" property="*"/>		<!-- *로 작성하면 알아서 찾아감 -->
</jsp:useBean>

<%
	/* // 1. 이전 화면의 폼에서 데이터 받아오기
	String name = request.getParameter("name");
	// 2. InfoBean 객체 생성후 
	String id	= request.getParameter("id");
	// 1번 값을 멤버변수로 지정
	InfoBean bean = new InfoBean();
	bean.setName(name);
	bean.setId(id); */
%>

<!DOCTYPE html>
<html>
<body>
	<h2>  당신의 신상명세서 확인 </h2>
	이   름  : <jsp:getProperty property="name" name="bean"/><br/>
	주민번호 : <%= bean.getId() %><br/>
	성  별   : <jsp:getProperty property="gender" name="bean"/><br/>  
	맞습니까????
</body>
</html>
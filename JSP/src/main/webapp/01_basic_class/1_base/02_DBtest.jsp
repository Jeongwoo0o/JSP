<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%@ page errorPage="./02_NormalErrorPage.jsp" %>

<!-- JSP에서 절대로 데이터베이스 연동 X -->

<%
	//1. 드라이버 로딩
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("드라이버 로딩 성공");
	
	// 2. 연결객체 얻어오기
	String url	= "jdbc:mysql://localhost:3306/basic";
	String user	= "scott";
	String pass = "tiger";
	Connection con = DriverManager.getConnection(url, user, pass);
	System.out.println("DB 연결 성공");
	
	// 3. sql 문장
	String sql = "SELECT * FROM emp3";
	
	// 4. 전송 객체 얻어오기
	PreparedStatement ps = con.prepareStatement(sql);
	
	// 5. 전송
	ResultSet rs = ps.executeQuery();
%>


<!DOCTYPE html>
<html><head><title> 디비 테스트 </title>
</head>
<body>
 
<div align='center'>
<table border='2' cellSpacing='3'>

  <tr class="title">
    <td>사번</td>
    <td>사원명</td>
    <td>업무</td>
    <td>관리자사번</td>
    <td>입사일</td></tr>

	<!-- (6) 결과출력 -->
	<% while(rs.next()) { %>
	  <tr>
		<td><%= rs.getString("empno") %></td>
		<td><%= rs.getString("ename") %></td>
		<td><%= rs.getString("job") %></td>
		<td><%= rs.getString("mgr") %></td>
		<td><%= rs.getString("hiredate") %></td>
	  </tr>
	 <% } // end of while %>


</table>
</div>
</body>
</html>

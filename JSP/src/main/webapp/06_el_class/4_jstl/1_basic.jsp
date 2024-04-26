<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic.jsp</title>
</head>
<body>
	<!-- String gender = "male"; -->
	<!-- if -->
	<c:set var="gender" value="male" />
	<c:if test="${ gender eq 'male' }">
		당신은 남자입니다. <br/>
	</c:if>
	<c:if test="${ gender eq 'female' }">
		당신은 여자입니다. <br/>
	</c:if>
	
	<!-- case -->
	<c:set var="age" value="35" />
	<c:choose>
		<c:when test="${ age lt 10 }">어린이입니다.</c:when>
		<c:when test="${ age ge 10 and age lt 20 }">청소년입니다.</c:when>
		<c:otherwise>정민기입니다.</c:otherwise>
	</c:choose>

	<!-- for -->
	<c:set var="sum" value="0"/>
	<c:forEach var="i" begin="1" end="100">
		<c:set var="sum" value="${ sum+i }"/>
	</c:forEach>
	<hr/>
	1 ~ 100까지의 합 : ${ sum }
	<hr/>
	
	<!-- 1부터 100까지의 홀수의 합과 짝수의 합을 출력하기 -->
	
	
	<c:forEach var="i" begin="1" end="100">
		<c:choose>
			<c:when test="${ i mod 2 eq 0 }"><c:set var="even" value="${ even+i }"/></c:when>
			<c:when test="${ i mod 2 ne 0 }"><c:set var="odd" value="${ odd+i }"/></c:when>
		</c:choose>
	</c:forEach>
	<hr/>
	짝수 합 : ${ even }<br/>
	홀수 합 : ${ odd }
	<hr/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
<!-- 
		<h1>${loginUser==null? "비회원" : loginUser.name}님 환영합니다.</h1>
		<h1>${(empty loginUser)? "비회원" : loginUser.name}님 환영합니다.</h1>
 -->
		<c:if test="${empty loginUser}">
			<h1>로그인 후 진행 가능합니다.</h1>
			<a class="btn btn-dark mt-4" href="login.do">로그인</a>
			<a class="btn btn-dark mt-4 " href="join.do">회원가입</a>
		</c:if>
		<c:if test="${!empty loginUser}">
			<h1>${loginUser.name}님 환영합니다.</h1>
		</c:if>
	</div>
</body>
</html>
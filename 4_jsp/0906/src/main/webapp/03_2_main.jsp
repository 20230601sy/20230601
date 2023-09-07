<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty loginUser}">
	<jsp:forward page="login.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 전용 페이지</h1>
	
	<form action="logout.do">
		<p>${message}</p>
		<p>안녕하세요. ${loginUser.name}(${loginUser.userid})님</p>
		<input type="submit" value="로그아웃">
		<input type="button" value="회원정보변경" onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
		<input type="button" value="회원탈퇴" onclick="location.href='memberDelete.do'">
	</form>
	<script src="03_3_member.js"></script>
</body>
</html>
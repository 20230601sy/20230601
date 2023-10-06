<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자만 접근 가능</h1>
	<p>principal : <sec:authentication property="principal"/></p>
	<p>memberVO : <sec:authentication property="principal.member"/></p>
	<p>username : <sec:authentication property="principal.member.username"/></p>
	<p>아이디 : <sec:authentication property="principal.username"/></p>
	<p>아이디 : <sec:authentication property="principal.member.userid"/></p>
	<p>권한 : <sec:authentication property="principal.member.authList"/></p>
</body>
</html>
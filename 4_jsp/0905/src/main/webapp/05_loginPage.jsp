<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${param.lang}"/>
	<fmt:setBundle basename="bundle.03_loginBundle" var="bundle"/>
	<h1><fmt:message key="msg" bundle="${bundle}"></fmt:message></h1>
	
	<form action="#">
		<fmt:message key="id" bundle="${bundle}"/> : 
		<input type="text" name="id">
		<fmt:message key="pw" bundle="${bundle}"/> : 
		<input type="text" name="pw">
		<input type="submit" value='<fmt:message key="btn" bundle="${bundle}"/>' >
	</form>
	<hr>
	<a href="?lang=ko">한국어</a> <a href="?lang=en">English</a>
</body>
</html>
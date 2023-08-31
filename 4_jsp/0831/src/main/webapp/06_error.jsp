<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!-- 이걸 true로 하면 exceptio 객체 사용 가능해짐... -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러발생 페이지</h1>
	<%= exception.getMessage() %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="MethodServlet">
		<input type="submit" value="get요청">
	</form>
	<a href="/0830/MethodServlet">a 태그 요청</a>
	<form method="post" action="MethodServlet">
		<input type="submit" value="post요청">
	</form>
</body>
</html>
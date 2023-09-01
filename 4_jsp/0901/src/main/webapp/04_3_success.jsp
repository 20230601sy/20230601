<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
	%>
	<h1><%=userId %> 로그인 성공</h1>
	<h1><%=userName %>님 안녕하세요!</h1>
</body>
</html>
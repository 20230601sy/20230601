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
		Cookie c = new Cookie("id", "user");
		c.setMaxAge(365 * 24 * 60 * 60); // 유효기간, second 단위, 1년
		response.addCookie(c);
		response.addCookie(new Cookie("pwd", "1234"));
		response.addCookie(new Cookie("age", "20"));
	%>
</body>
</html>
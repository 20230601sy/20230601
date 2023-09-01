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
		Cookie c = new Cookie("id", "");
		c.setMaxAge(0);
		response.addCookie(c);
	%>
	<a href="10_2_getCookie.jsp">이동</a>
</body>
</html>
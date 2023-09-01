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
		Cookie[] cs = request.getCookies();
		for(Cookie c : cs)
			out.print(c.getName() + " : " + c.getValue() + "<br>");
	%>
</body>
</html>
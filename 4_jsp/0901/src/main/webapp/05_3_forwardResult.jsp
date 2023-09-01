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
		String name = (String)request.getAttribute("name");
		String age = request.getParameter("age");
	%>
	<h1><%=name %>(<%=age %>)님 입장 환영합니다~</h1>
</body>
</html>
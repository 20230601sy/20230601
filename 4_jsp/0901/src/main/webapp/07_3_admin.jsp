<%@page import="java.net.URLDecoder"%>
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
		String name = URLDecoder.decode(request.getParameter("name"));
	%>
	<h1>관리자 페이지입니다.</h1>
	<h2>관리자명 : <%=name %></h2>
</body>
</html>
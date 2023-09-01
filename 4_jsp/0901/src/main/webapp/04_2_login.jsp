<%@page import="java.net.URLEncoder"%>
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
		String id = "user";
		String pw = "1234";
		//String name = "user1234";
		String name = "홍길동";
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		if(id.equals(userId) && pw.equals(userPw))
			response.sendRedirect("04_3_success.jsp?id=" + id + "&name=" + URLEncoder.encode(name, "utf-8"));
			//한글은 url 보낼 때 변환 필요...
			//response.sendRedirect("04_3_success.jsp?id=" + id + "&name=" + name);
		else
			response.sendRedirect("04_1_test_login.jsp");
	%>
</body>
</html>
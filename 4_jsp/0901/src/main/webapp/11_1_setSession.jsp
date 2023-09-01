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
	session.setAttribute("id", "user");
	session.setAttribute("pw", "1234");
	session.setAttribute("age", 20); // 쿠키와는 달리 숫자도 넣을 수 있음 
%>
	<a href="11_2_getSession.jsp">세션 확인</a>
</body>
</html>
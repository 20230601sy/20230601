<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int sum=0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		sum += num;
	%>
	<h1>+<%=num %> → 누적 결과: <%=sum %></h1>
</body>
</html>
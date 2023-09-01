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
		// String id = request.getParameter("id"); trim해도 안되고 json형태로 출력되넹...
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==1)
			response.sendRedirect("http://www.google.com");
		else if(id==2)
			response.sendRedirect("http://www.naver.com");
		else
			response.sendRedirect("http://www.kakao.com");
	%>
</body>
</html>
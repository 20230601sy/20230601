<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		교재 594p 연습문제
		교재에는 없지만 포스터 다운로드 하는 것도 하신다심
		서버에는 저장할 때 중복을 피하기 위해서 처음 파일명이랑 많이 다른 이상한 형태로 한다심...
		그래서 poster랑 title을 세트로 한다심...
	--%>
	<%
		response.sendRedirect("movielist");
	%>
</body>
</html>
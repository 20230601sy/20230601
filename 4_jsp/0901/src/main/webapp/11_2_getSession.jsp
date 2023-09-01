<%@page import="java.util.Enumeration"%>
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
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		Integer age = (Integer)session.getAttribute("age"); // null 값을 가질 수 있기 때문에 Integer 사용
		int age2 = (int)session.getAttribute("age"); // null 값을 가질 수 없기 때문에 문제가 생길 수 있음
		
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			out.print("<p>" + name + " : " + session.getAttribute(name).toString() + "</p>"); // age는 자료형이 숫자였어서...오버라이딩된 toString이 대부분 클래스변수들 출력시키는 형태
		}
	%>
	<p> <%= id %> <%= pw %> <%= age %> <%= age2 %> </p>
</body>
</html>
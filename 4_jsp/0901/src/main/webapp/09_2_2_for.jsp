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
		int num = Integer.parseInt(request.getParameter("num"));
		String exp = "";
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
			exp += i + ((i!=num) ? "+" : ("=" + sum));
		}
	%>
	<h1>1부터 <%=num %>까지 자연수 합 구하기</h1>
	<p><%=exp %></p>
</body>
</html>
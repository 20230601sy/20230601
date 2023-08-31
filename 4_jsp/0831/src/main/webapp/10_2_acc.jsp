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
		int sum = 0;
		String str = ""; 
		for(int i=1; i<=num; i++){
			sum += i;
			str = str + i + ((i != num) ? " + " : " = ");
		}
	%>
	<h1><%=str+sum%></h1>
</body>
</html>
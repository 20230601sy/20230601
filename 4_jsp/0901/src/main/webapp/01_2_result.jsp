<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
		String category = request.getParameter("category");
		String[] colorArr = request.getParameterValues("color");
		String colors="";
		if(colorArr==null)
			colors = "선호하는 색상이 없습니다.";
		else
			colors = "선호하는 색상은 " + String.join(", ", colorArr)+"입니다.";
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements())
			out.print(names.nextElement());
	%>
	<h1><%=age %>세가 가장 많이 구매한 <%=category %>들을 조회합니다.</h1>
	<p><%= colors%></p>
</body>
</html>
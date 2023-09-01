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
	request.setAttribute("name", "request");
//	RequestDispatcher rd = request.getRequestDispatcher("06_3_second.jsp");
//	rd.forward(request, response);
%>
	<jsp:forward page="06_3_second.jsp">
		<jsp:param value="1234" name="num"/>
	</jsp:forward>
</body>
</html>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("user") && pw.equals("1234")){
			response.sendRedirect("02_3_loginSuccess.jsp");
			
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
		}
		else
			response.sendRedirect("02_1_loginForm.jsp");
	%>
</body>
</html>
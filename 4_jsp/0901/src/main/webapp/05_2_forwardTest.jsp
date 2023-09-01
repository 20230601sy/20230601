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
		int age = Integer.parseInt(request.getParameter("age"));
		String name = "홍길동";
		
		if(age>=20) {
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("05_3_forwardResult.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("05_1_forward.jsp");
	%>
</body>
</html>
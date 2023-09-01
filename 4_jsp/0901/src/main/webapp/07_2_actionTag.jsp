<%@page import="java.net.URLEncoder"%>
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
		String logincheck = request.getParameter("logincheck");
		
		if(logincheck.equals("관리자")) {
	%>
			<jsp:forward page="07_3_admin.jsp">
				<jsp:param value='<%=URLEncoder.encode("홍길동", "utf-8") %>' name="name"/>
			</jsp:forward>
	<%
		} else {
	%>
			<jsp:forward page="07_4_user.jsp">
				<jsp:param value='<%=URLEncoder.encode("홍길동", "utf-8") %>' name="name"/>
			</jsp:forward>		
	<%
		}
	%>
			
</body>
</html>
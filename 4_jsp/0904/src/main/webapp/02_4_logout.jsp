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
		session.invalidate();
	//	response.sendRedirect("02_1_loginForm.jsp");
	%>
	<script>
		alert("로그아웃 성공");
		location.href = "02_1_loginForm.jsp"; // script 태그 위치와는 상관 없이 sendRedirect가 먼저 작동되나봄 그래서 alert 발생 시키려면 sendRedirect 대신 alert 발생 시킨 다음 여기 script에서 위치 이동
	</script>
</body>
</html>
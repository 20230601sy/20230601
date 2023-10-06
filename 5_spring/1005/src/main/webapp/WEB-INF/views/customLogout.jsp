<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃 페이지</h1>
	<form action="/customLogout" method="post">
		<input type="submit" value="로그아웃">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> <!-- 로그아웃 필수는 아니지만 권장, 넣어두면 넘어가는 페이지가 이전 페이지가 아니라 로그인페이지로 넘어가면서 로그아웃 성공 메세지를 출력함 -->
	</form>
</body>
</html>
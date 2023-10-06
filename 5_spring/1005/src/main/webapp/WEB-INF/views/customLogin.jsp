<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<h1>${error}</h1>
	<h1>${logout}</h1>
	<form action="/login" method="post">
		id: <input name="username"> <br> <!-- id의 name이 username이어야 함! -->
		pw: <input type="password" name="password"> <br> <!-- pwd등 축약해서 사용불가! -->
		<input type="checkbox" name="remember-me">자동 로그인<br>
		<input type="submit" value="로그인">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> <!-- 다른 사용자가 Cross Site Request Forgery -->
	</form>
</body>
</html>
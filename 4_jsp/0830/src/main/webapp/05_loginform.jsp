<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="LoginServlet">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="get	로그인">
	</form>
	<hr>
	<form method="post" action="LoginServlet">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="post	로그인">
	</form>
</body>
</html>
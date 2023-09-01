<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="07_2_actionTag.jsp">
		id : <input type="text" name="id"><br>
		pw : <input type="text" name="pw"><br>
		<input type="radio" name="logincheck" value="사용자">사용자
		<input type="radio" name="logincheck" value="관리자">관리자<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 전송</h1>
	<form method="post" action="send">
		받는 사람 : <input name="to"> <br>
		제목 : <input name="subject"> <br>
		내용 : <textarea name="content"></textarea><br>
		<input type="submit" value="전송">
	</form>
	<p>${msg}</p>
</body>
</html>
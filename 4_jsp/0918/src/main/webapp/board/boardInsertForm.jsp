<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form action="board?command=insert" method="post">
		<table border="1" style="width:500px; border-collapse: collapse; text-align: center;">
			<tr>
				<td>이름 : </td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td><input name="title"></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="목록" onclick="location.href='board?command=listAll'">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
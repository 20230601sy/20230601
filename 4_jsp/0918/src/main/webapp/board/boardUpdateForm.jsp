<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="board?command=update&num=${board.num}" method="post">
		<table border="1" style="width:500px; border-collapse: collapse; text-align: center;">
			<tr>
				<td>이름 : </td>
				<td><input name="name" value="${board.name}"></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input name="email" value="${board.email}"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="pass" value="${board.pass}"></td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td><input name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="목록" onclick="location.href='board?command=listAll'">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
</head>
<body>
	<table border="1" style="width:500px; border-collapse: collapse; text-align: center;">
		<tr>
			<td>이름 : </td>
			<td>${board.name}</td>
		</tr>
		<tr>
			<td>이메일 : </td>
			<td>${board.email}</td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td>${board.pass}</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="목록" onclick="location.href='board?command=listAll'">
				<input type="button" value="수정" onclick="location.href='board?command=updateForm&num=${param.num}'">
				<input type="button" value="삭제" onclick="location.href='board?command=delete&num=${param.num}'">
			</td>
		</tr>
	</table>
</body>
</html>
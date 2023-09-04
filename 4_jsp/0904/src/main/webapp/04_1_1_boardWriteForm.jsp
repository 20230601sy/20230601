<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="04_1_1_boardWriteForm.css" type="text/css"> 
</head>
<body>
	<h1>게시판 글쓰기</h1>
	
	<form action="04_1_2_boardWrite.jsp" method="post">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pass"> (게시물 수정 삭제시 필요합니다.)</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
		</table>
		<br>
		<div>
			<input type="submit" value="등록">
			<input type="reset" value="다시 작성">
		</div>
	</form>
</body>
</html>
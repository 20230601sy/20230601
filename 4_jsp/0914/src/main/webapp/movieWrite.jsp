<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>정보 등록</h1>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input name="title"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input name="price">원</td>
			</tr>
			<tr>
				<th>감독</th>
				<td><input name="director"></td>
			</tr>
			<tr>
				<th>배우</th>
				<td><input name="actor"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea name="synopsis"></textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="poster"></td>
			</tr>
		</table>
		<br>
		<div class="text-center">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='movielist.do'">
		</div>		
	</form>
</body>
</html>
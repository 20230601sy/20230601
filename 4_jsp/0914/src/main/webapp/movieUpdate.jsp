<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 수정</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>정보 수정</h1>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<c:if test="${empty movie.poster}">
						<p>등록된 사진이 없습니다.</p>
					</c:if>
					<c:if test="${!empty movie.poster}">
						<img src="upload/${movie.poster}">
					</c:if>
				</td>
				<td>
					<table>
						<tr>
							<th>제목</th>
							<td><input name="title" value="${movie.title}"></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><input name="price" value="${movie.price}">원</td>
						</tr>
						<tr>
							<th>감독</th>
							<td><input name="director" value="${movie.director}"></td>
						</tr>
						<tr>
							<th>배우</th>
							<td><input name="actor" value="${movie.actor}"></td>
						</tr>
						<tr>
							<th>설명</th>
							<td><textarea name="synopsis">${movie.synopsis}</textarea></td>
						</tr>
						<tr>
							<th>사진</th>
							<td><input type="file" name="poster"></td>
						</tr>
					</table>
					<input type="hidden" name="originPoster" value="${movie.poster}">
				</td>
			</tr>
		</table>
		<br>
		<div class="text-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='movielist'">
		</div>
	</form>
</body>
</html>
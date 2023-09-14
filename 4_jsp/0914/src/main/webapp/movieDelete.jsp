<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 삭제</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>정보 삭제</h1>
	<form method="post">
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
							<td>${movie.title}</td>
						</tr>
						<tr>
							<th>가격</th>
							<td>${movie.price}</td>
						</tr>
						<tr>
							<th>감독</th>
							<td>${movie.director}</td>
						</tr>
						<tr>
							<th>배우</th>
							<td>${movie.actor}</td>
						</tr>
						<tr>
							<th>설명</th>
							<td>${movie.synopsis}</td>
						</tr>
						<tr>
							<th>사진</th>
							<td>${movie.poster}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br>
		<div class="text-center">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href='movielist.do'">	
		</div>
	</form>

</body>
</html>
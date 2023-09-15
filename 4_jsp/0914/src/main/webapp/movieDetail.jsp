<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>영화 정보</h1>
	
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
		<c:if test="${loginUser.lv=='a'}">
			<a class="btn btn-primary" href="movieupdate?code=${movie.code}">수정</a>
			<a class="btn btn-primary" href="moviedelete?code=${movie.code}">삭제</a>
		</c:if>
		<a class="btn btn-primary" href="movielist">목록</a>
	</div>
</body>
</html>
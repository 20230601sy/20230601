<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="text-center">리스트</h1>
	<table>
		<tr>
			<td colspan="6" class="text-right" style="border: none">
				&nbsp;
				<c:if test="${loginUser.lv=='a'}">
					<a href="moviewrite">정보 등록</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<th>감독</th>
			<th>배우</th>
			<th>가격</th>
			<c:if test="${loginUser.lv!='a'}">
				<th>다운로드</th>
			</c:if>
			<c:if test="${loginUser.lv=='a'}">
<!--			<th>수정</th>  -->
				<th>삭제</th>
			</c:if>
		</tr>
		<c:forEach items="${movieList}" var="movie">
			<tr>
				<td><a href="moviedetail?code=${movie.code}">${movie.title}</a></td>
				<td>${movie.director}</td>
				<td>${movie.actor}</td>
				<td>${movie.price}원</td>
				<c:if test="${loginUser.lv!='a'}">
					<td><a href="download?title=${movie.title}&poster=${movie.poster}">다운로드</a></td>
				</c:if>
				<c:if test="${loginUser.lv=='a'}">
<!-- 				<td><a href="movieupdate?code=${movie.code}">정보 수정</a></td>  -->
					<td><a href="moviedelete?code=${movie.code}">정보 삭제</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
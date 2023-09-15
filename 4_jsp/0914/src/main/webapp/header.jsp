<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header class="container mb-5">
		<ul class="nav">
			<li class="nav-item">
			    <a class="nav-link" href="movielist">목록</a>
  			</li>
			<li class="nav-item me-auto">
			    <c:if test="${loginUser.lv=='a'}">
				    <a class="nav-link" href="admin">회원 관리</a>
				</c:if>
  			</li>
			
			<c:if test="${empty loginUser}">
				<li class="nav-item">
				    <a class="nav-link" href="join">회원가입</a>
				</li>
				<li class="nav-item">
				    <a class="nav-link" href="login">로그인</a>
				</li>
			</c:if>
			<c:if test="${!empty loginUser}">
				<li class="nav-item">
				    <a class="nav-link" href="logout">${loginUser.id}님 로그아웃</a>
 	 			</li>
			</c:if>
		</ul>	
	</header>
</body>
</html>
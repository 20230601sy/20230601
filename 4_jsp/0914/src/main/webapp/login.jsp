<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="container">
		<form method="post">
			<div class="mb-3 row">
				<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-6">
					<input class="form-control" id="id" name="id">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="pw" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="pw" name="pw">
				</div>
				<div class="col-sm-2">
					<button type="submit" class="btn btn-primary mb-3">로그인</button>
				</div>
			</div>
		</form>
		<a href="join">회원가입</a>
		<c:if test="${!empty msg}">
			<div class="alert alert-danger">${msg}</div>
		</c:if>
	</div>
</body>
</html>
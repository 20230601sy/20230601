<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mx-auto p-5">
		<form method="post" action="join.do">
			<div class="mb-3">
				<label class="form-label">아이디</label> <input type="text" class="form-control" name="id">
			</div>
			<button type="button" class="btn btn-dark mb-3">중복확인</button>
			${idCheck==null? "중복확인 필요" : "사용가능한 아이디입니다."}
			<div class="mb-3">
				<label class="form-label">비밀번호</label> <input type="password" class="form-control" name="pw">
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호 확인</label> <input type="password" class="form-control" name="pwChk">
			</div>
			<div class="mb-3">
				<label class="form-label">이름</label> <input type="text" class="form-control" name="name">
			</div>
			<button type="submit" class="btn btn-dark">회원가입</button>
		</form>
	</div>

</body>
</html>
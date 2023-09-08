<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="01_3_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.login-table td {
		padding: 10px;
	}
</style>
</head>
<body>
	<form action="login.do" method="post">
		<table class="login-table">
			<tr>
				<td colspan="2">로그인</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input name="id">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass">
				</td>
			</tr>
			<tr>
				<td>레벨</td>
				<td>
					<select name="lev">
						<option value="B">일반회원</option>
						<option value="A">운영자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<p>${msg}</p>
</body>
</html>
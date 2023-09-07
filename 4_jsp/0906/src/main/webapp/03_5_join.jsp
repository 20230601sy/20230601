<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="join.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input name="name">*</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input name="userid">*
					<input name="reid" type="hidden">
					<input type="button" value="중복체크" onclick="idCheck()">
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd">*</td>
			</tr>
			<tr>
				<td>암호 확인</td>
				<td><input type="password" name="pwd_check">*</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="phone"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type="radio" name="admin" value="0"> 일반회원
					<input type="radio" name="admin" value="1"> 관리자
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입" onclick="return joinCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					${message}
				</td>
			</tr>
		</table>
	</form>
	<br>
	<script src="03_3_member.js"></script>
</body>
</html>
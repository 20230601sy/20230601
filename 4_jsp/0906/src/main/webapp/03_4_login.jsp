<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login.do" method="post" name="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input name="userid" value="${userid}"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" onclick="return loginCheck()">
					<input type="reset" value="취소">
					<input type="button" value="회원 가입" onclick="location.href='join.do'">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<span>${message}</span>
	<script src="03_3_member.js"></script>
	<!-- <script src="script/member.js"></script> 애초에 처음 index 페이지를 생성하면 경로 가능 -->
	<!-- <script src="../script/member.js"></script> -->
</body>
</html>
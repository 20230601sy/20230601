<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="01_3_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="custom.do" method="post">
		<table>
			<tr>
				<td colspan="2">사원등록</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="lev">
						<option value="B">일반회원</option>
						<option value="A">운영자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
				</td>
			</tr>			
			<tr>
				<td>전화번호</td>
				<td><input name="phone"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
					<a href="01_4_main.jsp"><input type="button" value="메인 페이지로 이동"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
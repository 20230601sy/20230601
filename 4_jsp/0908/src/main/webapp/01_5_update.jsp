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
	<form action="mypage.do" method="post">
		<table>
			<tr>
				<td colspan="2">마이페이지</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input name="id" value="${vo.id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" value="${vo.pass}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="name" value="${vo.name}"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="lev">
						<option value="B" ${vo.lev=="B" ? "selected" : ""}>일반회원</option>
						<option value="A" ${vo.lev=="A" ? "selected" : ""}>운영자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<option value="1" ${vo.gender=="1" ? "selected" : ""}>남자</option>
						<option value="2" ${vo.gender=="2" ? "selected" : ""}>여자</option>
					</select>
				</td>
			</tr>			
			<tr>
				<td>전화번호</td>
				<td><input name="phone" value="${vo.phone}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
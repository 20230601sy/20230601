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
	<table>
		<tr>
			<td colspan="2">
				<h1>사원정보</h1>
				<p>${msg}</p>
			</td>
		</tr>
<!-- 		<tr>
			<td>아이디</td>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${vo.pass}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<td>권한</td>
			<td>${vo.lev=="A" ? "관리자" : "일반회원"}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${vo.gender=="1" ? "남자" : "여자"}</td>
		</tr>			
		<tr>
			<td>전화번호</td>
			<td>${vo.phone}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="01_4_main.jsp"><input type="button" value="메인 페이지로 이동"></a>
			</td>
		</tr> -->
	</table>
</body>
</html>
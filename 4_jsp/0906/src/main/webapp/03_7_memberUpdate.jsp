<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="memberUpdate.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td>
					<input name="name" value="${vo.name}" disabled>*
					<input name="name" value="${vo.name}" type="hidden">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input name="userid" value="${vo.userid}" disabled>*
					<input name="userid" value="${vo.userid}" type="hidden">
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
				<td><input name="email" value="${vo.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="phone" value="${vo.phone}"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
				<!-- 
					<c:choose>
						<c:when test="${vo.admin == 1}">
							<input type="radio" name="admin" value="0"> 일반회원
							<input type="radio" name="admin" value="1" checked> 관리자
						</c:when>
						<c:otherwise>
							<input type="radio" name="admin" value="0" checked> 일반회원
							<input type="radio" name="admin" value="1"> 관리자
						</c:otherwise>
					</c:choose>
				 -->
					<input type="radio" name="admin" value="0" checked="${vo.admin == 0}"> 일반회원
					<input type="radio" name="admin" value="1" checked="${vo.admin == 1}"> 관리자
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" onclick="return joinCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<script src="03_3_member.js"></script>
</body>
</html>
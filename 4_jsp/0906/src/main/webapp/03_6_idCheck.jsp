<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="idcheck.do" name="frm">
		아이디 <input name="userid" value="${userid}">
		<input type="submit" value="중복체크">
	</form>
	<c:if test="${result == 1}">
		<script>
			opener.document.frm.userid.value = "";
		</script>
		<p>${userid}는 이미 사용중인 아이디입니다.</p>
	</c:if>
	<c:if test="${result == -1}">
		<p>
			${userid}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idok()">
		</p>
	</c:if>
	<script src="03_3_member.js"></script>
</body>
</html>
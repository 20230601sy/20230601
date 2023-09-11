<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="01_3_header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.empList-table {
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<table class="empList-table">
		<c:if test="${!empty empList}">
			<tr>
				<th>ID</th>
				<th>PASS</th>
				<th>NAME</th>
				<th>LEV</th>
				<th>ENTER</th>
				<th>GENDER</th>
				<th>PHONE</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.pass}</td>
					<td>${emp.name}</td>
					<td>${emp.lev=="A"? "관리자" : "일반회원"}</td>
					<td>${emp.enter}</td>
					<td>${emp.gender=="1"? "남자" : "여자"}</td>
					<td>${emp.phone}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>
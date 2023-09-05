<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<fmt:setLocale value="${param.lang}"/>
	<fmt:bundle basename="bundle.06_sampleBundle">
		<fmt:message key="page" var="page"/>
		<fmt:message key="name" var="name"/>
		<fmt:message key="id" var="id"/>
		<fmt:message key="pw" var="pw"/>
		<fmt:message key="java" var="java"/>
		<fmt:message key="js" var="js"/>
		<fmt:message key="jsp" var="jsp"/>
		<fmt:message key="male" var="male"/>
		<fmt:message key="female" var="female"/>
		<fmt:message key="join" var="join"/>
	</fmt:bundle>
	<div class="alert alert-secondary fs-3" role="alert">${page}</div>

	<div class="container mt-3">
		<div class="text-end">
			<a class="btn btn-primary me-md-2" href="?lang=ko">한국어</a> 
			<a class="btn btn-primary" href="?lang=en">English</a>
		</div>

		<form>
			<div class="mb-3">
				<label for="name" class="form-label">${name}</label> <input type="text"
					class="form-control" id="name">
			</div>

			<div class="mb-3">
				<label for="id" class="form-label">${id}</label> <input type="text"
					class="form-control" id="id">
			</div>

			<div class="mb-3">
				<label for="pw" class="form-label">${pw}</label> <input
					type="password" class="form-control" id="pw">
			</div>

			<div class="mb-3">
				<select class="form-select">
					<option value="1">${java}</option>
					<option value="2">${js}</option>
					<option value="3">${jsp}</option>
				</select>
			</div>

			<div class="mb-3">
				<input type="radio" name="gender" value="male">${male} <input
					type="radio" name="gender" value="female">${female}
			</div>

			<button type="submit" class="btn btn-primary">${join}</button>
		</form>
	</div>
</body>
</html>
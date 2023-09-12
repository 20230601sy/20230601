<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-3">
		<div class="mb-3">
			<label class="form-label">글 제목</label>
			<div class="form-control">${detailBoard.title}</div>
		</div>
		<div class="mb-3">
			<label class="form-label">내용</label>
			<div class="form-control">
				<pre>${detailBoard.content}</pre>
			</div>
		</div>
		<c:if test="${detailBoard.id==loginUser.id}">
			<button class="btn btn-dark" type="button" onClick="location.href='updateboard.do?no=${detailBoard.no}'">수정</button>
			<button class="btn btn-dark" type="button" onClick="location.href='deleteboard.do?no=${detailBoard.no}'">삭제</button>		
		</c:if>
		<button class="btn btn-dark" type="button" onClick="location.href='boardlist.do'">목록</button>
	</div>
</body>
</html>
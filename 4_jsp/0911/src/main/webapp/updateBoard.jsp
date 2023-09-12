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
		<form method="post" action="updateboard.do?no=${param.no}" name="frm">
			<div class="mb-3">
				<label class="form-label">글 제목</label>
				<input type="text" class="form-control" name="title" value="${detailBoard.title}">
			</div>
			<div class="mb-3">
				<label class="form-label">내용</label>
				<textarea class="form-control" rows="5" name="content" >${detailBoard.content}</textarea>
			</div>
			<button class="btn btn-dark" type="submit" onclick="return boardCheck()">수정</button>
			<button class="btn btn-dark" type="reset">재입력</button>
			<a class="btn btn-dark" href="boardlist.do">목록</a>
		</form>
	</div>
	<script>
		function boardCheck() {
			if(document.frm.title.value == "") {
				alert("제목을 입력해주세요.");
				document.frm.title.focus();
				return false;
			}
			if(document.frm.content.value == "") {
				alert("내용을 입력해주세요.");
				document.frm.content.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
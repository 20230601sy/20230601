<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>

			<div class="panel-body">

				<div class="form-group">
					<label>No</label> <input class="form-control" name="bno" readonly value="${board.bno}">
				</div>
				
				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title" readonly value="${board.title}">
				</div>

				<div class="form-group">
					<label>Text Area</label>
					<textarea class="form-control" rows="3" name="content" readonly>${board.content}</textarea>
				</div>

				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer" readonly value="${board.writer}">
				</div>
				
				<button type="button" class="btn btn-default" data-oper="modify">게시글 수정</button>
				<button type="button" class="btn btn-default" data-oper="list">게시글 목록</button>
				
				<form id="actionForm" action="/board/modify">
					<input name="bno" value="${board.bno}" type="hidden">
					<input name="pageNum" value="${paging.pageNum}" type="hidden">
					<input name="amount" value="${paging.amount}" type="hidden">
					<input name="type" value="${paging.type}" type="hidden">
					<input name="keyword" value="${paging.keyword}" type="hidden">
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	const actionForm = $('#actionForm');
	$('button[data-oper="modify"]').on('click', function() {
		actionForm.attr('action', '/board/modify').submit();
	});
	$('button[data-oper="list"]').on('click', function() {
		actionForm.attr('action', '/board/list').submit();
	});
</script>
<%@ include file="../includes/footer.jsp"%>
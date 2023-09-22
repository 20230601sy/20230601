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
				<!-- <form role="form" action="/board/modify" method="post"> -->
				<form role="form" action="" method="">
					<div class="form-group">
						<label>No</label> <input class="form-control" name="bno" readonly value="${board.bno}">
					</div>
					
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title" value="${board.title}">
					</div>
	
					<div class="form-group">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
					</div>
	
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}">
					</div>
					
					<%-- <button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-danger" onclick='location.href="/board/remove?bno=${board.bno}"'>삭제</button> --%>
 					<button data-oper="modify" class="btn btn-primary">수정</button>
					<button data-oper="remove" class="btn btn-danger">삭제</button>
					<button type="button" class="btn btn-default" onclick='location.href="/board/list"'>목록</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$('button').on('click', function(e) { // legacy 는 버전이 낮아서 화살표 함수, 백틱...안된다심ㅋㅋㅋ
//	$('button').on('click', (e) => {
//		console.log(e.target.dataset["oper"]); // 되긴 하던데 뭔가 좋지 않다...
		const op = $(this).data('oper');
//		console.log(op);
		if(op == null)
			return false;
//		if(op == "list") {
//			location.href="/board/list";
//			return;
//		}
		
		e.preventDefault();
		const formTag = $('form');
		
		formTag.attr('action', '/board/' + op);
		if(op =="remove")
			formTag.attr('method', 'get');
		else if(op =="modify")
			formTag.attr('method', 'post');
		formTag.submit();
	});
</script>
<%@ include file="../includes/footer.jsp"%>
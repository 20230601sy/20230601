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

<div class='row'>
	<div class='col-lg-12'>
		<div class='panel panel-default'>
			<div class='panel-heading'>
				<i class='fa fa-comments fa-fw'></i> 댓글
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글달기</button>
			</div>

			<div class='panel-body'>
				<ul class='chat'>
<!--
					<li class='left clearfix' data-rno='12'>
						<div>
							<div class='header'>
								<strong class='primary-font'>댓글작성자</strong>
								<small class='pull-right text-muted'>댓글작성일자</small>
							</div>
							<p>댓글 내용</p>
						</div>
					</li>
-->
				</ul>
			</div>
		</div>
	</div>
</div>

<div class='modal fade' id='myModal' tabindex='-1' role='dialog'
	aria-labelledby='myModalLabel' aria-hidden='true'>
	<div class='modal-dialog'>
		<div class='modal-content'>
			<div class='modal-header'>
				<button type='button' class='close' data-dismiss='modal'
					aria-hidden='true'>&times;</button>
				<h4 class='modal-title' id='myModalLabel'>댓글 작성창</h4>
			</div>

			<div class='modal-body'>
				<div class='form-group'>
					<label>댓글</label> <input class='form-control' name='reply' value=''>
				</div>
				<div class='form-group'>
					<label>댓글 작성자</label> <input class='form-control' name='replyer' value=''>
				</div>
				<div class='form-group'>
					<label>작성일자</label> <input class='form-control' name='replyDate' value=''>
				</div>
			</div>
			<div class='modal-footer'>
				<button id='modalModBtn' type='button' class='btn btn-warning'>수정하기</button>
				<button id='modalRemoveBtn' type='button' class='btn btn-danger'>삭제하기</button>
				<button id='modalRegisterBtn' type='button' class='btn btn-primary' data-dismiss='modal'>댓글달기</button>
				<button id='modalCloseBtn' type='button' class='btn btn-default' data-dismiss='modal'>닫기</button>
			</div>
		</div>
	</div>
</div>

<script src="/resources/js/reply.js"></script>
<script>
	const bnoValue = '<c:out value="${board.bno}"/>';
	const replyUL = $('.chat');

	function showList(page) {
		replyService
				.getList(
						{
							bno : bnoValue,
							page : page || 1
						},
						function(list) {
							let str = '';
							if (list == null || list.length == 0) {
								replyUL.html('');
								return;
							}
							for (let i = 0; i < list.length; i++) {
								str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>"
										+ "	<div class='header'>"
										+ "		<strong class='primary-font'>"
										+ list[i].replyer
										+ "</strong>"
										+ "		<small class='pull-right text-muted'>"
										+ replyService.displayTime(list[i].updateDate)
										+ "</small>"
										+ "	</div>"
										+ "	<p>"
										+ list[i].reply + "</p>" + "</li>";
							}
							replyUL.html(str);
						});
	}
	showList(1);
	// console.log("bnoValue : ", bnoValue);
	/*	
	 replyService.add(
	 {
	 reply : 'js test',
	 replyer : 'js',
	 bno : bnoValue
	 },
	
	 function(result) {
	 alert('결과 : ' + result);
	 },
	
	 null
	 );
	 replyService.getList(
	 {
	 bno : bnoValue,
	 page : 1
	 },
	 function(data) {
	 for(let i=0; i<data.length; i++){ 				
	 console.log(data[i]);
	 }
	 }
	 );
	 replyService.remove(
	 8,
	 function(result) {
	 alert('결과 : ' + result);
	 },
	 function(e) {
	 alert('실패');
	 }
	 );
	 replyService.modify(
	 {
	 reply : 'js test 수정',
	 rno : 5
	 },
	 function(result) {
	 alert('결과 : ' + result);
	 },
	 null
	 );
	 replyService.get(21, function(data) {
	 console.log(data);
	 });
	 */
	const actionForm = $('#actionForm');
	$('button[data-oper="modify"]').on('click', function() {
		actionForm.attr('action', '/board/modify').submit();
	});
	$('button[data-oper="list"]').on('click', function() {
		actionForm.attr('action', '/board/list').submit();
	});
	
	const modal = $('#myModal');
	const modalInputReply = modal.find('input[name="reply"]');
	const modalInputReplyer = modal.find('input[name="replyer"]');
	const modalInputReplyDate = modal.find('input[name="replyDate"]');
	
	const modalModBtn = $('#modalModBtn');
	const modalRemoveBtn = $('#modalRemoveBtn');
	const modalRegisterBtn = $('#modalRegisterBtn');
	
	$('#addReplyBtn').on('click', function() {
		modal.find('input').val('');
		modalInputReplyDate.closest('div').hide();
		modal.find('button[id!="modalCloseBtn"]').hide();
		modalRegisterBtn.show();
		modal.modal('show');
	})
	
	modalRegisterBtn.on('click', function(){
		let reply = {
						bno : bnoValue,
						reply : modalInputReply.val(),
						replyer : modalInputReplyer.val()
		};
		// console.log(reply);
		replyService.add(reply, function(result) {
				 									alert('결과 : ' + result);
				 									modal.find('input').val('');
				 									showList(1);
				 				}, null);
	})
	
	// li에 이벤트를 걸어주고 싶지만 처음 dom에는 없기 때문에 이벤트 위임을 시켜주기로 함... 대체로 이벤트 위임 대상은 부모 태그에...
	// 버블링이랑은 반대 개념...
	$('.chat').on('click', 'li', function(){
		let rno = $(this).data('rno');
		// console.log(rno);
		replyService.get(rno, function(result) {
			 modalInputReply.val(result.reply);
			 modalInputReplyer.val(result.replyer);
			 modalInputReplyDate.val(replyService.displayTime(result.updateDate));
			 modalInputReplyDate.attr('readonly', 'readonly');
			 modal.find('button[id!="modalCloseBtn"]').show();
			 modalRegisterBtn.hide();
			 modalInputReplyDate.closest('div').show();
			 modal.data('rno', rno);
			 
			 modal.modal('show');
		});
	})
	modalRemoveBtn.on('click', function(){
		replyService.remove(modal.data('rno'), function(result) {
																	alert('결과 : ' + result);
																	modal.modal('hide');
																	showList(1);
							}, null);
	})
	
	modalModBtn.on('click', function(){
		replyService.modify({
								reply : modalInputReply.val(),
				 				rno : modal.data('rno')
				 			},
				 			function(result) {
				 				alert('결과 : ' + result);
				 				modal.modal('hide');
								showList(1);
				 			}, null);
	})
</script>
<%@ include file="../includes/footer.jsp"%>
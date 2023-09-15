<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<form method="post">
			<div class="mb-3 row">
				<label for="id" class="col-sm-2 col-form-label">아이디</label>
				<div class="col-sm-6">
					<input class="form-control id-input" id="id" name="id">
				</div>
 				<div class="col-sm-2">
					<button type="button" class="btn btn-primary mb-3 chk-id-btn">중복체크</button>
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-6">
					<span class="chk-id-result"></span>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="pw" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="pw" name="pw">
				</div>
				<div class="col-sm-2">
					<button type="submit" class="btn btn-primary mb-3">회원가입</button>
				</div>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script>
		// 제이쿼리
		$('.chk-id-btn').on('click', ()=> {
			const id = $('.id-input').val();
			//alert(id);
//			$.get('check'); // get 요청, 매개변수에는 요청주소
//			$.get('check?id='+id); // 1. 쿼리스트링으로 보내는 방법
//			$.get('check', {id:id}); // 2. object형태로 보내는 방법

			$.get('check', {id:id})
				.done(function(data){ //서버에서 응답한 값이 data로 들어감
//					alert(data);
					$('.chk-id-result').html(data);
				})
				.fail(function(error){
					alert(error);
				})
		});
	</script>
</body>
</html>
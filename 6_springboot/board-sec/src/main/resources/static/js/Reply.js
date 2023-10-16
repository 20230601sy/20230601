const replyObject = {
	init : function() {
		$('#btn-save-reply').on('click', (e) => {
			e.preventDefault();
			this.insertReply();
		})
		
		$('.btn-delete').on('click', (e) => {
			let replyId = e.target.dataset.id;
			this.deleteReply(replyId);
		})
		
		$('.btn-update').on('click', (e) => {
			let updateValue = e.target.previousElementSibling.value;
			let replyId = e.target.dataset.id;
			this.updateRely(updateValue, replyId);
		})
	},
	
	insertReply : function() {
		alert('댓글 작성 요청');
		
		let postId = $('#id').val();
		
		let reply = {
			content: $('#reply-content').val()
		}
		
		$.ajax({
			url: '/reply/' + postId,
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(reply)
		}).done(function(response) {
			alert(response.data);
			
			location = '/post/' + postId;
		}).fail(function(error) {
			console.log(error);
		})
		
	},
	
	deleteReply: function(replyId) {
		alert('댓글 삭제 요청');
		
		let postId = $('#id').val();
		
		$.ajax({
			url: '/reply/' + replyId,
			type: 'delete',
		}).done(function(response) {
			alert(response.data);
			
			location = '/post/' + postId;
		}).fail(function(error) {
			console.log(error);
		})
	},
	
	updateReply: function(updateValue, replyId) {
		alert('댓글 수정 요청');
		
		let postId = $('#id').val();
		
		$.ajax({
			url: '/reply/' + replyId,
			type: 'put',
		}).done(function(response) {
			alert(response.data);
			
			location = '/post/' + postId;
		}).fail(function(error) {
			console.log(error);
		})
	}
	
	
}

replyObject.init();
const replyObject = {
	init: function() {
		$('#btn-save-reply').on('click', ()=>{
			this.insertReply();
		})
		$('.btn-reply-delete').on('click', (e)=>{
			this.deleteReply(e.target.dataset.replyid);
		})
		$('.btn-reply-update').on('click', (e)=>{
			this.updateReply(e.target.dataset.replyid);
		})
	},
	insertReply: function() {
		let postId = $('#id').val();
		let reply = {
			content: $('#reply-content').val()
		};
		$.ajax({
			url: '/reply/'+ postId,
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(reply)
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = '/post/'+ postId;
		}).fail(function(error){
			console.log(error);
		})
	},
	deleteReply: function(replyId) {
		$.ajax({
			url: '/reply/'+ replyId,
			type: 'delete',
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = '/post/'+ $('#id').val();
		}).fail(function(error){
			console.log(error);
		})
	},
	updateReply: function(replyId) {
		let reply = {
			id: replyId,
			content: $(`.input-reply-update-${replyId}`).val() // 강사님은 e.target.previousElementSibling.value로 설명해주심 1. previousElementSibling vs previousSibling : Element가 없으면 태그 이외의 것도 감지하는 거. 2. .val() vs .value jQuery vs javascript 
		};
		$.ajax({
			url: '/reply',
			type: 'put',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(reply)
		}).done(function(response){
			alert(response.data);
			if(response.status == 200)
				location = '/post/'+ $('#id').val();
		}).fail(function(error){
			console.log(error);
		})
	}
	
}

replyObject.init();
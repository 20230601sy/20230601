// console.log('js파일 링크 테스트');
let replyService = (function(){
	// console.log('즉시 실행 함수 테스트');
	
	function add(reply, callback, error) {
		// console.log('댓글 등록');
		$.ajax({
			type: 'post',
			url: '/replies/new',
			data: JSON.stringify(reply),
			contentType: 'application/json; charset=utf-8',
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, e) {
				if(error) {
					error(e);
				}
			}
		})
	}
	
	function getList(param, callback, error) {
		const bno = param.bno;
		const page = param.page || 1;
		$.getJSON('/replies/pages/' + bno + '/' + page + '.json', 
			function(result){
				if(callback) {
					callback(result);
				}
			}
		);
	}

	function remove(rno, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/replies/' + rno,
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, e) {
				if(error) {
					error(e);
				}
			}
		})
	}

	function modify(reply, callback, error) {
		$.ajax({
			type: 'put',
			url: '/replies/' + reply.rno,
			data: JSON.stringify(reply),
			contentType: 'application/json; charset=utf-8',
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, e) {
				if(error) {
					error(e);
				}
			}
		})
	}

	function get(rno, callback, error) {
		$.getJSON('/replies/' + rno + '.json', 
			function(result){
				if(callback) {
					callback(result);
				}
			}
		);
	}
	
	function displayTime(timeValue) {
		let today = new Date();
		let gap = (today.getTime() - timeValue) / 1000 / 60 / 60;
		if(gap < 12)
			return (new Date(timeValue)).toLocaleTimeString();
		let offset = today.getTimezoneOffset() * 60000;
		return (new Date(timeValue - offset)).toISOString().substring(0, 10);
	}
	return {
		add : add,
		getList : getList,
		remove : remove,
		modify : modify,
		get : get,
		displayTime : displayTime
	}
})(); // 즉시 실행 함수, replyService()는 더이상 호출 불가
// replyService.add() 같은 형식은 호출 가능
// 댓글 관련 함수를 다 replyService에 넣어서 모듈화할 거라심

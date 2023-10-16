const userObject = {
	init: function() {
		$('#btn-save').on('click', (e)=>{
			e.preventDefault();
			this.insertUser();
		})
		$('#btn-update').on('click', (e)=>{
			e.preventDefault();
			this.updateUser();
		})
	},
	insertUser: function() {
//		alert('회원가입요청');
		let user = {
			username: $('#username').val(), 
			password: $('#password').val(), 
			email: $('#email').val() 
		}
		$.ajax({
			url: '/auth/insertUser',
			type: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(user)
		}).done(function(response){
//			console.log(response);
			// 위 코드 동작 확인 후 완료 후 다른 페이지로 이동하는 코드 필요
			if(response.status == 200) {
				alert(response.data);
				location = "/";				
			} else {
				let msg = '';
				const errorMsg = response.data;
				if(errorMsg.username != null)
					msg += errorMsg.username + '\n';
				if(errorMsg.password != null)
					msg += errorMsg.password + '\n';
				if(errorMsg.email != null)
					msg += errorMsg.email;
				alert(msg);
			}
		}).fail(function(error){
			console.log(error);
		})
	},
	updateUser: function() {
		alert('회원정보 수정 요청');
		let user = {
			id: $('#id').val(), 
			username: $('#username').val(), 
			password: $('#password').val(), 
			email: $('#email').val() 
		}
		$.ajax({
			url: '/user',
			type: 'put',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(user)
		}).done(function(response){
			alert(response.data);
			location = "/";				

		}).fail(function(error){
			console.log(error);
		})
	}
}

userObject.init();
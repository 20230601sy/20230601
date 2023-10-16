const userObject = {
	init: function() {
		$('#btn-save').on('click', (e) => {
			e.preventDefault();
			
			this.insertUser();
		})
		
		$('#btn-update').on('click', (e) => {
			e.preventDefault();
			
			this.updateUser();
		})
	},
	
	insertUser: function() {
		alert('회원가입요청');
		
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
		}).done(function(response) {
			
			if(response.status == 200)
				location = "/"
			else {
				let msg = '';
				const errorMsg = response.data;
				
				if(errorMsg.username != null)
					msg += errorMsg.username + '\n';
				if(errorMsg.email != null)
					msg += errorMsg.email + '\n';
				if(errorMsg.password != null)
					msg += errorMsg.password + '\n';
					
				alert(msg);
			}
				
				
			// 완료후 다른페이지로 이동하는 코드가 필요함
		}).fail(function(error) {
			console.log(error)
		})
		
	},
	
	updateUser : function() {
		alert('회원정보 수정 요청');
		
		const user = {
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
		}).done(function(response) {
			alert(response.data);
			location = '/';
		}).fail(function(error) {
			console.log(error)
		})
	}
}

userObject.init();
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="JoinServlet">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="societyId1"> - <input type="password" name="societyId2"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="chk_pw"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="mailId"> @ <input type="text" class="mail_input" name="mailDomain1">
					<select class="mail_select" onchange="aa()" name="mailDomain2">
						<option value="nate.com">nate.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="kakao.com">kakao.com</option>
						<option value="naver.com">naver.com</option>
					</select></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zip"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address1"> <input type="text" name="address2"></td>
			</tr>
						<tr>
				<td>핸드폰 번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><select name="job" size="4">
						<option value="학생">학생</option>
						<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
						<option value="언론">언론</option>
						<option value="공무원">공무원</option>
					</select></td>
			</tr>
			<tr>
				<td>메일/SMS 정보 수신</td>
				<td>	<input type="radio" name="chk_mail" value="yes"> 수신
						<input type="radio" name="chk_mail" value="no"> 수신거부 </td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td><input type="checkbox" name="interests" value="생두"> 생두
					<input type="checkbox" name="interests" value="원두"> 원두
					<input type="checkbox" name="interests" value="로스팅"> 로스팅
					<input type="checkbox" name="interests" value="핸드드립"> 핸드드립
					<input type="checkbox" name="interests" value="에스프레소"> 에스프레소 
					<input type="checkbox" name="interests" value="창업"> 창업 </td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="회원가입">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		const input = document.querySelector('.mail_input');
		const select = document.querySelector('.mail_select');
		function aa() {
			input.value = select.value;
		}
	</script>
</body>
</html>
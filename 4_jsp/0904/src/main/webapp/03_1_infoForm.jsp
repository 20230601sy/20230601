<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 03_2_bean.jsp에서 member에 액션태그로 한 방에 받아오려면 input의 name이 C03_1_MemberBean의 멤버변수 이름과 같아야 함. --%>
	<form method="post" action="03_2_bean.jsp">
		이름 <input type="text" name="name"> <br>
		아이디 <input type="text" name="userid"> <br>
		별명 <input type="text" name="nickname"> <br>
		비밀번호 <input type="password" name="pwd"> <br>
		이메일 <input type="text" name="email"> <br>
		전화번호 <input type="text" name="phone"> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>
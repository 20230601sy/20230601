<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="RadioServlet">
		성별 : 
    	<input id="m" type="radio" name="gender" value="남자">
    	<label for="m">남자</label>
    	<input id="f" type="radio" name="gender" value="여자">
    	<label for="f">여자</label>
    	<br><br>
    	메일 정보 수신 여부 : 
    	<input id="y" type="radio" name="chk_mail" value="yes">
    	<label for="y">수신</label>
    	<input id="n" type="radio" name="chk_mail" value="no">
    	<label for="n">거부</label>
    	<br><br>
    	<label for="content">간단한 가입 인사를 적어주세요^o^<br></label>
      	<textarea name="content" id="content" rows=3 cols=40></textarea>
    	<br>
    	<input type="submit" value="전송">
	</form>
</body>
</html>
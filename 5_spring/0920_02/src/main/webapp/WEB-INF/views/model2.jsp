<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${name}</h1>
	<h1>${boardVO}</h1> <!-- 스프링 컨테이너에 생성된 규칙에 의해 객체명을 쓰면 불러와짐...(클래스명에서 앞글자만 소문자로 바꾼 거) -->
</body>
</html>
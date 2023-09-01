<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색 엔진 정보 페이지</h1>
	<p>검색 엔진을 선택하세요.</p>
	<form action="09_1_2_searchResult.jsp">
		<select name="search">
			<option value="naver.com">네이버</option>
			<option value="daum.net">다음</option>
			<option value="nate.com">네이트</option>
			<option value="google.com">구글</option>			
		</select>
		<input type="submit" value="확인">
	</form>
</body>
</html>
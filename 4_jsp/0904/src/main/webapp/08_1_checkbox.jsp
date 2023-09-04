<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>악세사리</h1>
	<p>관심항목을 선택하세요</p>
	<form method="get" action="08_2_paramValues.jsp">
		<input type="checkbox" name="items" id="shoe" value="신발">
		<label for="shoe">신발</label>
		<input type="checkbox" name="items" id="bag" value="가방">
		<label for="bag">가방</label>
		<input type="checkbox" name="items" id="belt" value="벨트">
		<label for="belt">벨트</label> <br>
		<input type="checkbox" name="items" id="cap" value="모자">
		<label for="cap">모자</label>
		<input type="checkbox" name="items" id="watch" value="시계">
		<label for="watch">시계</label>
		<input type="checkbox" name="items" id="jewelry" value="쥬얼리">
		<label for="jewelry">쥬얼리</label> <br>
		<input type="submit" value="선택">
	</form>
</body>
</html>